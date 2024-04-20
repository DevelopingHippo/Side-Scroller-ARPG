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
        double renderDrawInterval = (double) 1000000000 / ref.settings.renderFPS;
        double engineDrawInterval = (double) 1000000000 / ref.settings.engineFPS;
        double engineDelta = 0;
        double renderDelta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(applicationThread != null) {
            currentTime = System.nanoTime();
            renderDelta += (currentTime - lastTime) / renderDrawInterval;
            engineDelta += (currentTime - lastTime) / engineDrawInterval;
            lastTime = currentTime;
            if(renderDelta >= 1) {
                repaint();
                renderDelta--;
            }
            if(engineDelta >= 1) {
                ref.engine.update();
                engineDelta--;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ref.renderer.render(g2);
    }


}

