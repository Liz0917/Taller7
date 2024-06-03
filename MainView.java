package uniandes.dpoo.taller7.interfaz4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uniandes.dpoo.taller7.modelo.Top10;
import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class MainView extends JFrame implements ActionListener {

    private PanelSuperior panelSuperior;
    private PanelDerecha panelDerecha;
    private PanelInferior panelInferior;
    private PanelTablero panelTablero;
    private JPanel panelCentral;
    private Top10 top10;
    private String jugador;

    public MainView() {
        setTitle("Juego de LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(152, 251, 255)); 

        this.panelSuperior = new PanelSuperior();
        this.panelDerecha = new PanelDerecha();
        this.panelInferior = new PanelInferior();
        this.panelTablero = new PanelTablero(5, this);
        this.top10 = new Top10();
        this.jugador = "AAA";

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);

        panelCentral = new JPanel(new GridLayout(1, 1));
        panelCentral.add(panelTablero);
        add(panelCentral, BorderLayout.CENTER);

        panelDerecha.getBtnNuevo().addActionListener(this);
        panelDerecha.getBtnReiniciar().addActionListener(this);
        panelDerecha.getBtnTop10().addActionListener(this);
        panelDerecha.getBtnCambiarJugador().addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelDerecha.getBtnNuevo()) {
            handleNuevoButton();
        } else if (e.getSource() == panelDerecha.getBtnReiniciar()) {
            handleReiniciarButton();
        } else if (e.getSource() == panelDerecha.getBtnTop10()) {
            handleTop10Button();
        } else if (e.getSource() == panelDerecha.getBtnCambiarJugador()) {
            handleCambiarJugadorButton();
        }
    }

    public void handleNuevoButton() {
        String tamano = (String) panelSuperior.getComboTamano().getSelectedItem();
        int tam = Integer.parseInt(tamano.substring(0, tamano.indexOf("x")));
        int dificultad = 0;
        if (panelSuperior.getRadioFacil().isSelected()) {
            dificultad = 10;  
        } else if (panelSuperior.getRadioMedio().isSelected()) {
            dificultad = 20;
        } else if (panelSuperior.getRadioDificil().isSelected()) {
            dificultad = 30;
        }

        panelTablero = new PanelTablero(tam, this);
        panelTablero.desordenar(dificultad);

        panelCentral.removeAll();
        panelCentral.add(panelTablero);
        panelCentral.revalidate();
        panelCentral.repaint();
    }

    public void handleReiniciarButton() {
        panelTablero.reiniciar();
    }

    public void handleTop10Button() {
        JDialog dialog = new JDialog(this, "Top 10 Puntajes", true);
        dialog.setSize(300, 400);
        dialog.setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);
        StringBuilder sb = new StringBuilder();
        for (RegistroTop10 registro : top10.darRegistros()) {
            sb.append(registro.toString()).append("\n");
        }
        area.setText(sb.toString());

        dialog.add(new JScrollPane(area), BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    public void handleCambiarJugadorButton() {
        String nuevoJugador = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:");
        if (nuevoJugador != null && !nuevoJugador.trim().isEmpty()) {
            this.jugador = nuevoJugador.trim().toUpperCase();
            panelInferior.getTxtJugador().setText(jugador);
        }
    }

    public void actualizarJugadas(int jugadas) {
        panelInferior.getTxtJugadas().setText(String.valueOf(jugadas));
    }

    public void finalizarJuego(int jugadas) {
        int puntaje = calcularPuntaje(jugadas, panelTablero.getTamano());
        if (top10.esTop10(puntaje)) {
            top10.agregarRegistro(jugador, puntaje);
            JOptionPane.showMessageDialog(this, "Nuevo récord: " + puntaje + " puntos!");
        }
    }

    private int calcularPuntaje(int jugadas, int tamano) {
        return (tamano * tamano) * 1000 - jugadas * 100;
    }

    public static void main(String[] args) {
        new MainView();
    }
}