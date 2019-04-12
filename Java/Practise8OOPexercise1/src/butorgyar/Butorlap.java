package butorgyar;



public class Butorlap {



    private double hossz;

    private double szelesseg;

    private boolean isTartolap;

    final int mhossz=5000;

    final int mszelesseg=500;



    public Butorlap(double hossz, double szelesseg, boolean isTartolap) {

        this.hossz = hossz/100;

        this.szelesseg = szelesseg/100;

        this.isTartolap=isTartolap;





    }

    public Butorlap() {

        this.hossz = 0;

        this.szelesseg = 0;

        this.isTartolap= false;



    }



    public double getHossz() {

        return hossz;

    }



    public void setHossz(double hossz) {

        this.hossz = hossz;

    }



    public double getSzelesseg() {

        return szelesseg;

    }



    public void setSzelesseg(double szelesseg) {

        this.szelesseg = szelesseg;

    }



    public boolean getisTartolap() {

        return this.isTartolap;

    }



    public void setisTartolap(boolean isTartolap) {

        this.isTartolap = isTartolap;

    }

    public double ArSzamol() {

        if (this.isTartolap) {

            return (hossz*szelesseg)*mhossz;

        } else {

            return (hossz*szelesseg)*mszelesseg;



        }

    }



}