/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstesti1;

/**
 *
 * @author Olli
 */
public class PalloSaie extends Thread {

    private Naytto naytto = null;
    private volatile boolean kaynnissa = true;

    public PalloSaie(Naytto naytto) {
        this.naytto = naytto;
    }

    @Override
    public void run() {
        while (kaynnissa) {
            if (Math.random() < 0.5) {
                naytto.siirra(1, 0);
            } else {
                naytto.siirra(-1, 0);
            }

//            try {
//                sleep(2);
//            } catch (InterruptedException e) {
//            }
        }
    }

    public void lopeta() {
        kaynnissa = false;
    }
}
