package uniandes.dpoo.taller7.interfaz4;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelSuperior extends JPanel implements ActionListener{
    private JLabel lblTamano;
    private JComboBox<String> comboTamano;
    private JLabel lblDificultad;
    private JRadioButton radioFacil;
    private JRadioButton radioMedio;
    private JRadioButton radioDificil;
    private ButtonGroup grupoDificultad;

    public PanelSuperior() {
        setLayout(new FlowLayout());

        this.lblTamano = new JLabel("Tamano");
        this.comboTamano = new JComboBox<>(new String[]{"5x5", "7x7", "9x9"});

        this.lblDificultad = new JLabel("Dificultad");
        this.radioFacil = new JRadioButton("Facil");
        this.radioMedio = new JRadioButton("Medio");
        this.radioDificil = new JRadioButton("Dificil");

        this.grupoDificultad = new ButtonGroup();
        grupoDificultad.add(radioFacil);
        grupoDificultad.add(radioMedio);
        grupoDificultad.add(radioDificil);

        add(lblTamano);
        add(comboTamano);
        add(lblDificultad);
        add(radioFacil);
        add(radioMedio);
        add(radioDificil);

    }

    public JComboBox<String> getComboTamano() {
        return comboTamano;
    }
    
    public JRadioButton getRadioFacil() {
        return radioFacil;
    }

    public JRadioButton getRadioMedio() {
        return radioMedio;
    }

    public JRadioButton getRadioDificil() {
        return radioDificil;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
    
