package application;

import engine.helpers.ReferenceList;

import javax.swing.*;
import java.awt.*;


public class Application extends JPanel implements Runnable  {
    public ReferenceList ref = new ReferenceList();
    private Thread applicationThread;

    public Application() {
        this.setPreferredSize(new Dimension(ref.settings.screenWidth, ref.settings.screenHeight));
        this.setBackground(Color.decode(ref.settings.backgroundColor));
        this.setDoubleBuffered(true);

        this.addKeyListener(ref.userControls);
        this.setFocusable(true);
    }

    public void setup() {
        System.out.println("STARTING APPLICATION");
    }

    public void startThread() {
        applicationThread = new Thread(this);
        applicationThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / ref.settings.fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(applicationThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1) {
                ref.engine.update();
                repaint();
                delta--;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ref.renderer.render(g2);
    }


}

