//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MiVentana extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;


    int x1=100;
    int y1=300;

    int factor=2;
    public MiVentana() {
        this.setTitle("Malla");
        this.setDefaultCloseOperation(3);
        this.setSize(600, 600);
        this.setLayout((LayoutManager)null);
        this.buffer = new BufferedImage(1, 1, 1);
        this.graPixel = this.buffer.createGraphics();
    }

    public void putPixel(int x, int y, Color c, Graphics g) {
        this.buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(this.buffer, x, y, this);
    }

    public void paint(Graphics g) {
        super.paint(g);


        curva(g,202,1000,300,300);





    }

    public void curva( Graphics g, double radio, int grosor,int x, int y){
        double _x, _y;

        for (int t = 0; t < grosor; t++) {

            _x = radio * Math.sin(t) / (1 + Math.pow(Math.cos(t),2) ) + x;
            _y = radio * Math.sin(t) * Math.cos(t) / (1 + Math.pow(Math.cos(t),2)) + y;

            putPixel((int) _x, (int) _y, Color.black,g);

        }
    }

}
