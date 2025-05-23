package Game.Panels;

import Game.Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class DeathPanel extends JPanel implements ActionListener, KeyListener {

    private final Timer timer;
    private long score;
    public DeathPanel(long score) {

        this.score=score;
            setFocusable(true);
            addKeyListener(this);

            timer = new Timer(16, this);
            timer.start();
        }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScore(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


    private void drawScore(Graphics g) {
        String scoreText = "Score: " + score;
        Font font = new Font("SansSerif", Font.BOLD, 60); 

        g.setFont(font);
        g.setColor(Color.RED);

            //was es für lustige methoden gibt
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeX - metrics.stringWidth(scoreText)) / 2;
        int y = metrics.getAscent()+ Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeY/2;

            g.drawString(scoreText, x, y);

        String lostText = "Leider hast du verloren";
        Font lostFont = new Font("SansSerif", Font.PLAIN, 40); 
            g.setFont(lostFont);
            g.setColor(Color.WHITE); 

        FontMetrics lostMetrics = g.getFontMetrics(lostFont);
        int xLost = (Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeX - lostMetrics.stringWidth(lostText)) / 2;
        int yLost = y + 50; // unter den score

            g.drawString(lostText, xLost, yLost);
    
}

     @Override public void keyPressed(KeyEvent e) {

     }
    @Override public void keyReleased(KeyEvent e) {
        
    }
    @Override public void keyTyped(KeyEvent e) {
        
    }
}
