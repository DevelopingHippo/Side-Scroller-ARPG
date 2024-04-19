package engine.io;

import engine.helpers.ReferenceList;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserControls implements KeyListener {

    private final ReferenceList ref;
    public UserControls(ReferenceList ref) {
        this.ref = ref;
    }



    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(ref.settings.gameState == ref.settings.playState) {
            playStateKeyPressed(code);
        }
        else if(ref.settings.gameState == ref.settings.titleState) {
            titleStateKeyPressed(code);
        }
    }
    private void titleStateKeyPressed(int code) {
        if(code == KeyEvent.VK_W) {
            ref.ui.commandNum--;
            if(ref.ui.commandNum < 0){
                ref.ui.commandNum = 2;
            }
        }
        if(code == KeyEvent.VK_S) {
            ref.ui.commandNum++;
            if(ref.ui.commandNum > 2){
                ref.ui.commandNum = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER) {
            if(ref.ui.commandNum == 0){
                ref.settings.gameState = ref.settings.playState;
            }
            if(ref.ui.commandNum == 1){
                System.exit(0);
            }
            if(ref.ui.commandNum == 2) {
                System.exit(0);
            }
        }
    }

    private void playStateKeyPressed(int code) {

        if(code == KeyEvent.VK_E) {
            ref.ePressed = true;
        }
        if(code == KeyEvent.VK_F) {
            ref.fPressed = true;
        }

        if(code == KeyEvent.VK_W) {
            ref.upPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            ref.leftPressed = true;
        }
        if(code == KeyEvent.VK_S) {
            ref.downPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            ref.rightPressed = true;
        }
        if(code == KeyEvent.VK_SHIFT) {
            ref.shiftPressed = true;
        }
        if(code == KeyEvent.VK_F1) {
            ref.settings.debug = !ref.settings.debug;
        }
        if(code == KeyEvent.VK_SPACE) {
            if(!ref.spacePressed){
                ref.spacePressed = true;
            }
        }
        if(code == KeyEvent.VK_ENTER) {
            ref.enterPressed = true;
        }

    }



    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_E) {
            ref.ePressed = false;
        }
        if(code == KeyEvent.VK_F) {
            ref.fPressed = false;
        }
        if(code == KeyEvent.VK_W) {
            ref.upPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            ref.leftPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            ref.downPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            ref.rightPressed = false;
        }
        if(code == KeyEvent.VK_SHIFT) {
            ref.shiftPressed = false;
        }
        if(code == KeyEvent.VK_SPACE) {
            ref.spacePressed = false;
        }
        if(code == KeyEvent.VK_ENTER) {
            ref.enterPressed = false;
        }

    }





    @Override
    public void keyTyped(KeyEvent e) {}
}

