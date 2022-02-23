import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame{
    private JTextField newNrRej;
    private JTextField newModel;
    private JTextField newMarka;
    private JTextField newPredkoscMax;
    private JButton dodajAutoButton;
    private JButton anulujButton;
    private JPanel panel2;
    private JRadioButton benzynaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton a5BiegowRadioButton;
    private JRadioButton a6BiegowRadioButton;
    private String NazwaSilnika;
    private String NazwaSkrzyni;
    private int LiczbaBiegow;
    public Samochod nowySamochod;

    public NowySamochodGUI(JComboBox<Samochod> comboBox){
        setContentPane(panel2);

        ButtonGroup SilnikGroup = new ButtonGroup();
        SilnikGroup.add(benzynaRadioButton);
        SilnikGroup.add(dieselRadioButton);

        ButtonGroup SkrzyniaGroup = new ButtonGroup();
        SkrzyniaGroup.add(a5BiegowRadioButton);
        SkrzyniaGroup.add(a6BiegowRadioButton);


        dodajAutoButton.addActionListener(e -> {
            if (benzynaRadioButton.isSelected()){
                NazwaSilnika = "benzyna";
            }
            else if(dieselRadioButton.isSelected()){
                NazwaSilnika = "diesel";
            }

            if (a5BiegowRadioButton.isSelected()){
                NazwaSkrzyni = "5 biegow";
                LiczbaBiegow = 5;
            }
            else if(a6BiegowRadioButton.isSelected()){
                NazwaSkrzyni = "6 biegow";
                LiczbaBiegow = 6;
            }

            Silnik silnik = new Silnik(1000, NazwaSilnika, 5000, 8000);
            SkrzyniaBiegow skrzynia = new SkrzyniaBiegow(100, NazwaSkrzyni, 2000, LiczbaBiegow);
            Sprzeglo sprzeglo = new Sprzeglo(200, "Nowe Sprzeglo", 1000);
            Pozycja pozycja = new Pozycja();
            String NrRej = newNrRej.getText();
            String Model = newModel.getText();
            double PredkoscMax = Double.parseDouble(newPredkoscMax.getText());
            nowySamochod = new Samochod(NrRej, Model, PredkoscMax, pozycja, silnik, skrzynia, sprzeglo);

            comboBox.addItem(nowySamochod);
           ComboBoxRenderer renderer = new ComboBoxRenderer();
            comboBox.setRenderer(renderer);
            dispose();
        });

        anulujButton.addActionListener(e -> dispose());

    }
}


class ComboBoxRenderer extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        if (value instanceof Samochod) {
            value = ((Samochod)value).getNrRejest();
            
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
}