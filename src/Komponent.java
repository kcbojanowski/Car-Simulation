public class Komponent {
    private int waga;
    private String nazwa;
    private int cena;

    public Komponent(int waga, String nazwa, int cena) {
        this.waga = waga;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public int getWaga() {return waga;}

    public String getNazwa() {return nazwa;}

    public int getCena() {return cena;}
}
