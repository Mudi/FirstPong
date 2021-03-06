package javagraphicstesti1;

import java.awt.*;
import javax.swing.*;

public class Naytto extends JPanel {

    private int x;
    private int y;
    private int ovalWidth;
    private int ovalHeight;
    private int vasenPalikkaY;
    private int oikeaPalikkaY;
    private boolean tormannyt;



    //konstruktori jossa annetaan haluttu koko pack(); metodille
    public Naytto() {
        setPreferredSize(new Dimension(400, 200));
        x = 200;
        y = 100;
        oikeaPalikkaY = 30;
        vasenPalikkaY = 30;
        ovalWidth = 20;
        ovalHeight = 20;
        tormannyt = false;
    }

    public static void main(String[] args) {
        UI ui = new UI();
    }
    
    //Jos pallo osuu johonkin rajoista, palautetaan false
    public boolean tarkistaRajat() {
        //Seinien tarkastus
        if (this.x <= 0 || this.y <= 0 || this.x >= this.getWidth() || this.y >= this.getHeight()) {
            this.x = (int) this.getWidth() / 2;
            this.y = (int) this.getHeight() / 2;
            setTormannyt();
            return false;
        } //Tarkistetaan osuuko pelaaja oikean puoleiseen "mailaan"
        //TODO: pallon täytyy kimmota oikeaan suuntaan
        else if ((this.x >= this.getWidth() - 66) && this.y + 10 >= oikeaPalikkaY - 15 && this.y - 10 <= oikeaPalikkaY + 22) {
//            this.x = (int) this.getWidth() / 2;
//            this.y = (int) this.getHeight() / 2;
            setTormannyt();
            return false;

        } else if ((this.x <= 45) && this.y + 10 >= vasenPalikkaY - 12 && this.y - 10 <= vasenPalikkaY + 20) {
//            this.x = (int) this.getWidth() / 2;
//            this.y = (int) this.getHeight() / 2;
            setTormannyt();
            return false;
        }
        return true;
    }

    void siirra(int x, int y) {
       if (tarkistaRajat()) {
            this.x += x;
            this.y += y;
        }
        repaint();
    }

    //itse kuvan piirto
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setDoubleBuffered(true);

        g.setColor(Color.BLUE);
        g.fillRect(30, vasenPalikkaY, 15, 30);
        //oikeain puoleinen palikka joka on aina oikeasta reunasta 30 pixeliä
        g.fillRect((getWidth() - ((15) + 30)), oikeaPalikkaY, 15, 30);
        g.fillOval(x, y, ovalWidth, ovalHeight);
    }

    void uusiPaikka(int x, int y) {
      if (tarkistaRajat()) {
            this.x = x;
            this.y = y;
        }
        repaint();
    }

    //Toggle tormannyt
    public void setTormannyt() {
        if(tormannyt){
         tormannyt = false;
        }
        else{
            tormannyt = true;
        }
    }

//    public void kasvataPintaAlaa() {
//        if (ovalHeight <= this.getHeight() - 2 && ovalWidth <= this.getWidth() - 2) {
//            ovalWidth += 1;
//            ovalHeight += 1;
//        } else {
//            ovalWidth = this.getWidth() - 1;
//            ovalHeight = this.getHeight() - 1;
//        }
//        repaint();
//    }
//Testilisäys

//    public void pienennnaPintaAlaa() {
//        if (ovalHeight >= 2 && ovalWidth >= 2) {
//            ovalWidth -= 1;
//            ovalHeight -= 1;
//        } else {
//            ovalWidth = 1;
//            ovalHeight = 1;
//        }
//        repaint();
//    }

    public void siirraPalikoita(int vasenY, int oikeaY) {
           if (tarkistaRajat()) {   
        }
        oikeaPalikkaY = oikeaY;
        vasenPalikkaY = vasenY;
        repaint();
    }
    
        public boolean isTormannyt() {
        return tormannyt;
    }
}