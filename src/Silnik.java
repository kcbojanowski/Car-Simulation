public class Silnik extends Komponent{
    private int obroty;
    private int maxObroty;

    public Silnik(int waga, String nazwa, int cena, int maxObroty) {
        super(waga, nazwa, cena);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }
    public void uruchom() {
        this.obroty = 1000;
    }

    public void zatrzymaj() {
        this.obroty = 0;
    }

    public void zwiekszObroty() {
        if (this.obroty + 500 < this.maxObroty) {
            this.obroty += 500;
        } else {
            this.obroty = this.maxObroty;
        }
    }

    public void zmniejszObroty() {
        if(this.obroty - 500 > 1000)
            this.obroty -= 500;
        else{
            zatrzymaj();
            System.out.println("Auto Ci Zgasło :(");
        }
    }

    public int getMaxObroty() {
        return maxObroty;
    }

    public int getObroty() {return obroty;}

    public void setObroty(int obroty) {
        this.obroty = obroty;
    }
}
