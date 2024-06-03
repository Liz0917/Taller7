package uniandes.dpoo.taller7.interfaz4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelDerecha extends JPanel implements ActionListener {
    private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJugador;


    public PanelDerecha() {
        setLayout(new GridLayout(4, 1, 10, 10));
        

        this.btnNuevo = new JButton("NUEVO");
        this.btnReiniciar = new JButton("REINICIAR");
        this.btnTop10 = new JButton("TOP-10");
        this.btnCambiarJugador = new JButton("CAMBIAR JUGADOR");

        btnNuevo.setBackground(Color.YELLOW);
        btnReiniciar.setBackground(Color.GREEN);
        btnTop10.setBackground(Color.YELLOW);
        btnCambiarJugador.setBackground(Color.GREEN);

        add(btnNuevo);
        add(btnReiniciar);
        add(btnTop10);
        add(btnCambiarJugador);

        btnNuevo.addActionListener(this);
        btnReiniciar.addActionListener(this);
        btnTop10.addActionListener(this);
        btnCambiarJugador.addActionListener(this);
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public JButton getBtnReiniciar() {
        return btnReiniciar;
    }

    public JButton getBtnTop10() {
        return btnTop10;
    }

    public JButton getBtnCambiarJugador() {
        return btnCambiarJugador;
    }

    public void actionPerformed(ActionEvent e) {
    }
}