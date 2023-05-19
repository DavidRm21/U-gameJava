package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel{

    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;
    private int xDelta = 100, yDelta = 100;

    public GamePanel() {
        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs(this);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changexDelta(int value){
        this.xDelta += value;
        repaint();
    }

    public void changeyDelta(int value){
        this.yDelta += value;
        repaint();
    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(xDelta, yDelta,50,50);
    }

}
