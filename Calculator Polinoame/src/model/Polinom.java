package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    protected int gradPolinom;
    protected ArrayList<Integer> coeficientiPolinom;

    public Polinom(int gradPolinom, ArrayList<Integer> coeficientiPolinom) {
        this.gradPolinom = gradPolinom;
        this.coeficientiPolinom = coeficientiPolinom;
    }

    public Polinom(){

    }

    public void crearePolinom(String polinomString) {
        Pattern pattern = Pattern.compile("([+-]?(?:(?:x\\^\\d+)|(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(polinomString);
        ArrayList<Monom> monoame = new ArrayList<>();
        int gradPolinomCreat = 0;
        while (matcher.find()) {
            String monomString = matcher.group(1);
            Monom monom = new Monom();
            monom.creareMonom(monomString);
            if (monom.getPutere() > gradPolinomCreat) {
                gradPolinomCreat = monom.getPutere();
            }

            monoame.add(monom);
        }
        
        this.gradPolinom = gradPolinomCreat;
        ArrayList<Integer> initializare = new ArrayList<>();
        while (gradPolinomCreat >= 0) {
            initializare.add(this.gradPolinom - gradPolinomCreat, 0);
            gradPolinomCreat--;
        }

        this.coeficientiPolinom = initializare;

        for (Monom index: monoame) {
            this.coeficientiPolinom.set(index.putere, index.coeficient);
        }
    }

    public String polinomToString() {
        StringBuilder rezultat = new StringBuilder(new String());

        int index = 0;
        for (Integer coeficienti : this.coeficientiPolinom) {
            if (index == 0) {
                if (coeficienti < 0) {
                    rezultat = new StringBuilder(coeficienti.toString());
                }
                else if (coeficienti > 0) {
                    rezultat = new StringBuilder('+' + coeficienti.toString());
                }
            }
            else if (index == 1) {
                if (coeficienti == 1) {
                    rezultat.insert(0, 'x');
                }
                else if (coeficienti == -1) {
                    rezultat.insert(0, "-x");
                }
                else if (coeficienti < 0) {
                    rezultat.insert(0, coeficienti.toString() + "*x");
                }
                else if (coeficienti > 0) {
                    rezultat.insert(0, '+' + coeficienti.toString() + "*x");
                }
            }
            else {
                if (coeficienti == 1) {
                    rezultat.insert(0, "x^" + index);
                }
                else if (coeficienti == -1) {
                    rezultat.insert(0, "-x^" + index);
                }
                else if (coeficienti < 0) {
                    rezultat.insert(0, coeficienti.toString() + "*x^" + index);
                }
                else if (coeficienti > 0) {
                    rezultat.insert(0, '+' + coeficienti.toString() + "*x^" + index);
                }
            }
            index++;
        }

        return rezultat.toString();
    }

    public void adunare(Polinom polinom) {

        ArrayList<Integer> rezultat = new ArrayList<>();
        if (this.gradPolinom >= polinom.gradPolinom) {
            int gradAux = this.gradPolinom;
            while (gradAux >= 0) {
                rezultat.add(this.gradPolinom - gradAux, this.coeficientiPolinom.get(this.gradPolinom - gradAux));
                gradAux--;
            }
            int indexPutere = 0;
            for (Integer coeficient: polinom.coeficientiPolinom) {
                rezultat.set(indexPutere, coeficient + this.coeficientiPolinom.get(indexPutere));
                indexPutere++;
            }
            this.coeficientiPolinom = rezultat;
        }
        else {
            int gradAux = polinom.gradPolinom;
            while (gradAux >= 0) {
                rezultat.add(polinom.gradPolinom - gradAux, polinom.coeficientiPolinom.get(polinom.gradPolinom - gradAux));
                gradAux--;
            }
            int indexPutere = 0;
            for (Integer coeficient : this.coeficientiPolinom) {
                rezultat.set(indexPutere, coeficient + polinom.coeficientiPolinom.get(indexPutere));
                indexPutere++;
            }
            this.gradPolinom = polinom.gradPolinom;
            this.coeficientiPolinom = rezultat;
        }
    }

    public void scadere(Polinom polinom) {

        ArrayList<Integer> rezultat = new ArrayList<>();
        if (this.gradPolinom >= polinom.gradPolinom) {
            int gradAux = this.gradPolinom;
            while (gradAux >= 0) {
                rezultat.add(this.gradPolinom - gradAux, this.coeficientiPolinom.get(this.gradPolinom - gradAux));
                gradAux--;
            }
            int indexPutere = 0;
            for (Integer coeficient: polinom.coeficientiPolinom) {
                rezultat.set(indexPutere, this.coeficientiPolinom.get(indexPutere) - coeficient);
                indexPutere++;
            }
            this.coeficientiPolinom = rezultat;
        }
        else {
            int gradAux = polinom.gradPolinom;
            while (gradAux >= 0) {
                rezultat.add(polinom.gradPolinom - gradAux, -polinom.coeficientiPolinom.get(polinom.gradPolinom - gradAux));
                gradAux--;
            }
            int indexPutere = 0;
            for (Integer coeficient : this.coeficientiPolinom) {
                rezultat.set(indexPutere, coeficient - polinom.coeficientiPolinom.get(indexPutere));
                indexPutere++;
            }
            this.gradPolinom = polinom.gradPolinom;
            this.coeficientiPolinom = rezultat;
        }
    }

    public void inmultire(Polinom polinom) {
        ArrayList<Integer> rezultat = new ArrayList<>();
        int gradRezultat = this.gradPolinom + polinom.gradPolinom;
        int gradAux = 0;
        while (gradAux <= gradRezultat) {
            rezultat.add(gradAux, 0);
            gradAux++;
        }

        int indexThis = 0;
        for (Integer coeficientThis : this.coeficientiPolinom) {
            int indexPolinom = 0;
            for (Integer coeficientPolinom : polinom.coeficientiPolinom) {
                int initialValue = rezultat.get(indexPolinom + indexThis);
                rezultat.set(indexPolinom + indexThis, initialValue + coeficientPolinom * coeficientThis);
                indexPolinom++;
            }
            indexThis++;
        }

        this.gradPolinom = gradRezultat;
        this.coeficientiPolinom = rezultat;
    }

    public void derivare() {
        int gradAux = this.gradPolinom;
        ArrayList<Integer> rezultat = new ArrayList<>();
        while (gradAux > 0) {
            rezultat.add(this.gradPolinom - gradAux, 0);
            gradAux--;
        }

        int index = 0;
        for (Integer coeficient : this.coeficientiPolinom) {
            if (index > 0) {
                rezultat.set(index - 1, index * coeficient);
            }
            index++;
        }
        this.gradPolinom--;
        this.coeficientiPolinom = rezultat;
    }

}
