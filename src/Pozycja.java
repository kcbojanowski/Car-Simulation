import static java.lang.Math.*;

public class Pozycja{
    private double x;
    private double y;

    public Pozycja(){
        this.x = 0;
        this.y = 0;
    }
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void przemiesc(double v,double dt, Pozycja Cel){
        double DystansX = Cel.x - x;
        double DystansY = Cel.y - y;
        double odleglosc = sqrt(pow(DystansX, 2) + pow(DystansY, 2));

        if(odleglosc != 0){
            double dx = v * dt * DystansX / odleglosc;
            double dy = v * dt * DystansY / odleglosc;

        if (Math.abs(Cel.getX() - this.x) < dx)
            this.x = Cel.getX();
        else
            this.x = this.x + dx;

        if (Math.abs(Cel.getY() - this.y) < dy)
            this.y = Cel.getY();
        else
            this.y = this.y + dy;
       }
    }

    public double getX() {return x;}

    public double getY() {return y;}

    public void setX(double x) {this.x = x;}

    public void setY(double y) {this.y = y;}

}
