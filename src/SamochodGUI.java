import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread {
    private JButton wlaczButton;
    private JButton wylaczButton;
    private JTextField txtNrRej;
    private JTextField txtWagaAuta;
    private JTextField txtPredkosc;
    private JTextField txtModelAuta;
    private JComboBox<Samochod> listaAut;
    private JButton dodajNowyButton;
    private JButton usunButton;
    private JTextField txtCenaSilnik;
    private JLabel Waga;
    private JLabel ModelAuta;
    private JLabel Bieg;
    private JTextField txtWagaSilnik;
    private JTextField txtObroty;
    private JTextField txtNazwaSilnika;
    private JTextField txtNazwaSkrzyni;
    private JTextField txtBieg;
    private JTextField txtWagaSkrzyni;
    private JTextField txtCenaSkrzyni;
    private JTextField txtNazwaSprzegla;
    private JTextField txtStanS;
    private JTextField txtWagaSprzegla;
    private JTextField txtCenaSprzegla;
    private JButton PrzyspieszButton;
    private JButton ZwolnijButton;
    private JButton zwiekszBiegButton;
    private JButton zmniejszBiegButton;
    private JButton wcisnijSprzegloButton;
    private JButton zwolnijSprzegloButton;
    private JPanel Mapa;
    private JLabel RedBolt;
    private JPanel panel1;
    private Samochod sam;

    public void clearTextFields(){
        txtNrRej.setText("");
        txtWagaAuta.setText("");
        txtPredkosc.setText("");
        txtModelAuta.setText("");
        txtCenaSilnik.setText("");
        txtWagaSilnik.setText("");
        txtObroty.setText("");
        txtNazwaSilnika.setText("");
        txtNazwaSkrzyni.setText("");
        txtBieg.setText("");
        txtWagaSkrzyni.setText("");
        txtCenaSkrzyni.setText("");
        txtNazwaSprzegla.setText("");
        txtStanS.setText("");
        txtWagaSprzegla.setText("");
        txtCenaSprzegla.setText("");
        RedBolt.hide();
    }

    public SamochodGUI(Samochod s) {
        sam = s;
        start();
        wlaczButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                System.out.println("-wlacz-");
                sam.wlacz();
                refresh();
            }
        });

        wylaczButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                System.out.println("-wyłacz-");
                sam.wylacz();
                refresh();
            }
        });

        PrzyspieszButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0){
                System.out.println("+");
                sam.silnik.zwiekszObroty();
                refresh();
            }
        });

        ZwolnijButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                System.out.println("-");
                sam.silnik.zmniejszObroty();
                refresh();
            }
        });

        zwiekszBiegButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                if (sam.sprzeglo.getStanSprzegla()) {
                    System.out.println("-zwiekszono bieg-");
                    sam.skrzynia.zwiekszBieg();
                }
                else System.out.println("wcisnij sprzeglo");
                    refresh();
            }
        });

        zmniejszBiegButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                if (sam.sprzeglo.getStanSprzegla()) {
                    System.out.println("-zmiejszono bieg-");
                    sam.skrzynia.zmniejszBieg();
                } else System.out.println("wcisnij sprzeglo");
                refresh();
            }
        });
        wcisnijSprzegloButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                System.out.println("-wcisnieto sprzeglo-");
                sam.sprzeglo.wcisnijSprzeglo();
                refresh();
            }
        });
        zwolnijSprzegloButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                System.out.println("-zwolniono sprzeglo-");
                sam.sprzeglo.zwolnijSprzeglo();
                refresh();
            }
        });

        dodajNowyButton.addActionListener(e -> {
            JFrame f = new NowySamochodGUI(listaAut);
            f.pack();
            f.setVisible(true);
        });

        usunButton.addActionListener(e -> {
            if(listaAut.getItemCount() != 0) {
                listaAut.removeItem(sam);
                sam.interrupt();
            }
        });

        Mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(listaAut.getItemCount() != 0){
                    super.mousePressed(e);
                    if (sam.getStanWlaczenia()) {
                        sam.jedzDo(new Pozycja(e.getX(), e.getY()));
                    }
                }
            }
        });

        listaAut.addActionListener(e -> sam = (Samochod) listaAut.getSelectedItem());
    }

    public void run() {
        while (true) {
            refresh();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
    }

    public void refresh() {
        if(listaAut.getItemCount() != 0) {
            txtNrRej.setText(sam.getNrRejest());
            txtWagaAuta.setText(String.valueOf(sam.getWaga()));
            txtPredkosc.setText(String.valueOf(sam.getAktPredkosc()));
            txtModelAuta.setText(sam.getModel());
            txtWagaSilnik.setText(String.valueOf(sam.getWaga()));
            txtObroty.setText(String.valueOf(sam.silnik.getObroty()));
            txtNazwaSilnika.setText(sam.silnik.getNazwa());
            txtCenaSilnik.setText(String.valueOf(sam.silnik.getCena()));
            txtNazwaSkrzyni.setText(sam.skrzynia.getNazwa());
            txtBieg.setText(String.valueOf(sam.skrzynia.getAktBieg()));
            txtWagaSkrzyni.setText(String.valueOf(sam.skrzynia.getWaga()));
            txtCenaSkrzyni.setText(String.valueOf(sam.skrzynia.getCena()));
            txtNazwaSprzegla.setText(sam.sprzeglo.getNazwa());
            txtStanS.setText(String.valueOf(sam.sprzeglo.getStanSprzegla()));
            txtWagaSprzegla.setText(String.valueOf(sam.sprzeglo.getWaga()));
            txtCenaSprzegla.setText(String.valueOf(sam.sprzeglo.getCena()));
            RedBolt.setLocation((int) sam.getAktPozycja().getX(), (int) sam.getAktPozycja().getY());
            RedBolt.show();
        }
        else {
            clearTextFields();
        }

    }

    public static void main(String[] args) {
        Silnik silnik_test = new Silnik(1000, "benzyna", 20000, 7000);
        SkrzyniaBiegow skrzynia_test = new SkrzyniaBiegow(100, "6 biegow", 3000, 6);
        Sprzeglo sprzeglo_test = new Sprzeglo(1000, "sprzeglo_test", 3000);
        Pozycja pozycja_test = new Pozycja();
        Samochod sam_test = new Samochod("KRA2115", "Citroen C2", 230, pozycja_test, silnik_test, skrzynia_test, sprzeglo_test);
        JFrame f = new JFrame("Samochod GUI");
        f.setContentPane(new SamochodGUI(sam_test).panel1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}