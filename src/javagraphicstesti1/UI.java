/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstesti1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Olli
 */
public class UI extends JFrame {

    private Naytto naytto;
    private PalloSaie saie = null;

    public UI() {
        naytto = new Naytto();

        naytto.addMouseListener(new HiiriKuuntelija());
        addKeyListener(new LiikeTunnistin());

        setLocation(((int) Toolkit.getDefaultToolkit().getScreenSize().width / 2), ((int) Toolkit.getDefaultToolkit().getScreenSize().height / 2));
        //Keskitetään paneeli
        add(naytto, BorderLayout.CENTER);
        //pakataan haluttuun kokoon näyttö
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class LiikeTunnistin extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent ke) {
            int keyCode = ke.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                naytto.siirra(0, -3);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                naytto.siirra(0, 3);
            } else if (keyCode == KeyEvent.VK_ENTER) {
                if (saie == null) {
                    try {
                        saie = new PalloSaie(naytto);
                        saie.start();
                    } catch (Exception e) {
                    }
                }
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                naytto.siirra(3, 0);
            } else if (keyCode == KeyEvent.VK_LEFT) {
                naytto.siirra(-3, 0);
            }

        }
    }

    private class HiiriKuuntelija extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (saie != null) {
                saie.lopeta();
            }
            saie = null;
            naytto.uusiPaikka(e.getX(), e.getY());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            naytto.uusiPaikka(e.getX(), e.getY());
        }
    }
}
