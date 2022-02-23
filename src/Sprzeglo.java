public class Sprzeglo extends Komponent{
    private boolean stanSprzegla;

    public Sprzeglo(int waga, String nazwa, int cena) {
        super(waga, nazwa, cena);
    }

    public void wcisnijSprzeglo(){
        this.stanSprzegla = true;
    }
    public void zwolnijSprzeglo(){
        this.stanSprzegla = false;
    }

    public boolean getStanSprzegla() {return stanSprzegla;}

    public void setStanSprzegla(boolean stanSprzegla) {this.stanSprzegla = stanSprzegla;}
}
