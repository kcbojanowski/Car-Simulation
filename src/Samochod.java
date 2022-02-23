
public class Samochod extends Thread {
    private static final double obwodKola = 1.95;
    private static final double dt = 0.1;
    private boolean stanWlaczenia;
    private final String nrRejest;
    private final String model;
    private final double predkoscMax;
    public SkrzyniaBiegow skrzynia;
    public Pozycja AktPozycja;
    public Silnik silnik;
    public Pozycja cel;
    public Sprzeglo sprzeglo;

    public Samochod(String nrRejest, String model, double predkoscMax, Pozycja AktPozycja, Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo) {
        stanWlaczenia = true;
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.AktPozycja = AktPozycja;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        cel = AktPozycja;
        start();
    }

    public void wlacz() {
        setStanWlaczenia(true);
        silnik.uruchom();
    }
    public void wylacz() {
        setStanWlaczenia(false);
        silnik.zatrzymaj();
    }

    public void run() {
        if(stanWlaczenia) {
            while (true) {
                double V = getAktPredkosc();
                this.AktPozycja.przemiesc(V, dt, cel);

                //Wyswietlanie kolejnych koordynatow auta
                /*
                if (this.AktPozycja.getX() != this.cel.getX() || this.AktPozycja.getY() != this.cel.getY()) {
                    System.out.printf("(%f, %f)%n", this.AktPozycja.getX(), this.AktPozycja.getY());
                }
                */

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else
            System.out.println("Najpierw wlacz auto");
    }

    public void jedzDo(Pozycja cel) {
        System.out.printf("Trasa: (%f,%f) ---> (%f,%f)%n", AktPozycja.getX(), AktPozycja.getY(),
                cel.getX(), cel.getY());
        this.cel = cel;
    }

    public double getAktPredkosc(){
        double V = silnik.getObroty() * skrzynia.getAktPrzelozenie() * obwodKola / 100;

        if(V > this.predkoscMax){
            V = this.predkoscMax;
        }
        if(this.AktPozycja.getX() == this.cel.getX() && this.AktPozycja.getY() == this.cel.getY()){
            V = 0;
        }
        return V;
    }

    public int getWaga(){
        return silnik.getWaga() + skrzynia.getWaga();
    }

    public Pozycja getAktPozycja(){
        return this.AktPozycja;
    }

    public boolean getStanWlaczenia() {return stanWlaczenia;}

    public String getNrRejest() {return nrRejest;}

    public String getModel() {return model;}

    public double getPredkoscMax() {return predkoscMax;}

    public void setStanWlaczenia(boolean stanWlaczenia) {this.stanWlaczenia = stanWlaczenia;}


}