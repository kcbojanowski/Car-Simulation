public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg;
    private final int iloscBiegow;
    private double aktualnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(int waga, String nazwa, int cena, int iloscBiegow) {
        super(waga, nazwa, cena);
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 1;
        this.aktualnePrzelozenie = 0.45;
    }

    public void zwiekszBieg(){
        int pom = this.aktualnyBieg + 1;
            if (pom > this.iloscBiegow) {
                System.out.println("maksymalny bieg!");
            } else {
                this.aktualnyBieg = this.aktualnyBieg + 1;
                this.aktualnePrzelozenie += 0.25;
            }
    }

    public void zmniejszBieg(){
        int pom = this.aktualnyBieg - 1;
            if (this.aktualnyBieg-- < 0) {
                System.out.println("minimalny bieg!");
            } else {
                this.aktualnyBieg--;
                this.aktualnePrzelozenie -= 0.15;
            }
        }

    public int getAktBieg() {return aktualnyBieg;}

    public double getAktPrzelozenie() {return aktualnePrzelozenie;}

    public int getIloscBiegow() {return iloscBiegow;}

    public void setAktualnyBieg(int aktualnyBieg) {this.aktualnyBieg = aktualnyBieg;}

    public void setAktualnePrzelozenie(int aktualnePrzelozenie) {this.aktualnePrzelozenie = aktualnePrzelozenie;}
}
