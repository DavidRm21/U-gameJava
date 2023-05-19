package main;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame jFrame;
    private int SCREEN_WIDTH = 800;
    private int SCREEN_HEIGHT = 400;

    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();

        jFrame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);


    }
}
