package application;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Game Engine");
        Application app = new Application();
        window.add(app);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        app.setup();
        app.startThread();
    }

}

