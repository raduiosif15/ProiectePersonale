package model;

public class Monom {

    protected int putere;
    protected int coeficient;

    public Monom() {

    }

    public int getPutere() {
        return this.putere;
    }

    public void creareMonom(String monomString) {

        if (monomString.indexOf('x') >= 0) {
            if (monomString.indexOf('^') > 0) {
                if (monomString.indexOf('x') == 0) {
                    this.coeficient = 1;
                } else {
                    this.coeficient = Integer.parseInt(monomString.substring(0, monomString.indexOf('x')));
                }
                this.putere = Integer.parseInt(monomString.substring(monomString.indexOf('^') + 1));
            } else {
                if (monomString.indexOf('x') == 0) {
                    this.coeficient = 1;
                } else {
                    String coeficientString = monomString.substring(0, monomString.indexOf('x'));
                    if (coeficientString.length() == 1) {
                        if (coeficientString.indexOf('+') == 0) {
                            this.coeficient = 1;
                        }
                        else if (coeficientString.indexOf('-') == 0) {
                            this.coeficient = -1;
                        }
                        else {
                            this.coeficient = Integer.parseInt(coeficientString);
                        }
                    }
                    else {
                        this.coeficient = Integer.parseInt(coeficientString);
                    }
                }
                this.putere = 1;
            }
        } else {
            this.coeficient = Integer.parseInt(monomString);
            this.putere = 0;
        }
    }
}
