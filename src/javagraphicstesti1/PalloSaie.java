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
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {}
            if(naytto.isTormannyt()){
                naytto.siirra(-3, -1);
            }
            else{
                 naytto.siirra(3, 1);
            }
           }
        }


    public void lopeta() {
        kaynnissa = false;
    }
}

