package uniandes.dpoo.taller7.interfaz4;

import java.awt.*;

import javax.swing.*;

public class PanelInferior extends JPanel {
    private JLabel lblJugadas;
    private JTextField txtJugadas;
    private JLabel lblJugador;
    private JTextField txtJugador;

    public PanelInferior() {
        setLayout(new FlowLayout());

        this.lblJugadas = new JLabel("Jugadas:");
        this.txtJugadas = new JTextField(5);
        txtJugadas.setEditable(false);

        this.lblJugador = new JLabel("Jugador:");
        this.txtJugador = new JTextField(15);
        txtJugador.setEditable(false);
        
        add(lblJugadas);
        add(txtJugadas);
        add(lblJugador);
        add(txtJugador);
    }

    public JTextField getTxtJugador() {
        return txtJugador;
    }
    public JTextField getTxtJugadas() {
        return txtJugadas;
    }
}