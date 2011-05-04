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
            for (int i = 0; i < naytto.getHeight()-30 + 1; i++) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {}
                naytto.siirraPalikoita(i, i);
            }
            for (int i = naytto.getHeight(); i > 0; i--) {
                  try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {}
                naytto.siirraPalikoita(i, i);
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
