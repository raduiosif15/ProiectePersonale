package model;

import java.util.ArrayList;

public class Integrate extends Polinom {

    protected ArrayList<Integer> numitori;

    public Integrate() {
        super();
    }

    public void integrare() {
        int gradAux = this.gradPolinom;
        gradAux++;
        ArrayList<Integer> rezultatNumarator = new ArrayList<>();
        ArrayList<Integer> rezultatNumitor = new ArrayList<>();
        while (gradAux >= 0) {
            rezultatNumarator.add(0);
            rezultatNumitor.add(0);
            gradAux--;
        }

        int index = 0;
        for (Integer coeficient : this.coeficientiPolinom) {
            rezultatNumarator.set(index + 1, coeficient);
            rezultatNumitor.set(index + 1, index + 1);
            index++;
        }
        this.gradPolinom++;
        this.coeficientiPolinom = rezultatNumarator;
        this.numitori = rezultatNumitor;
    }

    public int abs(int a) {
        if (a < 0) {
            return -1;
        }
        return a;
    }

    public String polinomToString() {
        String rezultat = new String();

        int index = 0;
        for (Integer coeficienti : this.coeficientiPolinom) {
            if (index == 0) {
                rezultat = "+C, C apartine lui R";
            }
            else if (index == 1) {
                if (coeficienti.equals(this.numitori.get(index))) {
                    rezultat = "x" + rezultat;
                }
                else if (coeficienti.equals(-this.numitori.get(index))) {
                    rezultat = "-x" + rezultat;
                }
                else if (coeficienti * this.numitori.get(index) < 0) {
                    rezultat = "-(" + abs(coeficienti) + '/' + abs(this.numitori.get(index)) + ')' + "*x" + rezultat;
                }
                else if (coeficienti * this.numitori.get(index) > 0) {
                    rezultat = '+' + '(' + abs(coeficienti) + '/' + abs(this.numitori.get(index)) + ')' + "*x" + rezultat;
                }
            }
            else {
                if (coeficienti.equals(this.numitori.get(index))) {
                    rezultat = "x^" + index + rezultat;
                }
                else if (coeficienti.equals(-this.numitori.get(index))) {
                    rezultat = "-x^" + index + rezultat;
                }
                else if (coeficienti * this.numitori.get(index) < 0) {
                    rezultat = '(' + abs(coeficienti) + '/' + abs(this.numitori.get(index)) + ')' + "*x^" + index + rezultat;
                }
                else if (coeficienti * this.numitori.get(index) > 0) {
                    rezultat = "+(" + abs(coeficienti) + '/' + abs(this.numitori.get(index)) + ')' + "*x^" + index + rezultat;
                }
            }
            index++;
        }

        return rezultat;
    }
}
