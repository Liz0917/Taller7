package uniandes.dpoo.taller7.interfaz4;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelTablero extends JPanel {
    private int tamano;
    private Tablero tablero;
    private MainView mainView;
    private static final Color COLOR_CELDA = new Color(255, 182, 193);  

    public PanelTablero(int tamano, MainView mainView) {
        this.tamano = tamano;
        this.tablero = new Tablero(tamano);
        this.mainView = mainView;
        setPreferredSize(new Dimension(tamano * 50, tamano * 50));
        addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	    int cellWidth = getWidth() / tamano;
        	    int cellHeight = getHeight() / tamano;
        	    int col = e.getX() / cellWidth;
        	    int row = e.getY() / cellHeight;

        	    tablero.jugar(row, col);
        	    mainView.actualizarJugadas(tablero.darJugadas());
        	    repaint();
        	    if (tablero.tableroIluminado()) {
        	        mainView.finalizarJuego(tablero.darJugadas());
        	    }
        	    cambiarCasillasVecinas(row, col);
        	}
        });
    }

    private void cambiarCasillasVecinas(int row, int col) {
        int[][] vecinos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] vecino : vecinos) {
            int newRow = row + vecino[0];
            int newCol = col + vecino[1];

            if (newRow >= 0 && newRow < tamano && newCol >= 0 && newCol < tamano) {
                tablero.jugar(newRow, newCol);
            }
        }
        mainView.actualizarJugadas(tablero.darJugadas());
        repaint();

        if (tablero.tableroIluminado()) {
            mainView.finalizarJuego(tablero.darJugadas());
        }
    }


    public void desordenar(int dificultad) {
        tablero.desordenar(dificultad);
        repaint();
    }

    public void reiniciar() {
        tablero.reiniciar();
        repaint();
    }

    public int getTamano() {
        return tamano;
    }

    public Tablero getTablero() {
        return tablero;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int cellWidth = panelWidth / tamano;
        int cellHeight = panelHeight / tamano;
        int cellSize = Math.min(cellWidth, cellHeight);
        int boardWidth = tamano * cellSize;
        int boardHeight = tamano * cellSize;
        int startX = (panelWidth - boardWidth) / 2;
        int startY = (panelHeight - boardHeight) / 2;

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                int x = startX + j * cellSize;
                int y = startY + i * cellSize;
                g2d.setColor(tablero.darTablero()[i][j] ? Color.WHITE : COLOR_CELDA);
                g2d.fillRect(x, y, cellSize, cellSize);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, cellSize, cellSize);
            }
        }
    }
}