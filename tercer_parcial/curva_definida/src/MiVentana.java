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


        curva(g);





    }

    public void curva( Graphics g){
        double inc = Math.PI / 500;
        double y = 0, ya = 0, yb = 0;
        double x = 0, xa = 0, xb = 0;
        int cont = 1;

        for (float i = 0; i < 4 * Math.PI; i += inc) {
            x = i * Math.cos(4 * i) * 20 + 350;
            y = i * 20 + 100;
            putPixel((int) x+1, (int) y, Color.red,g);
            putPixel((int) x-1, (int) y, Color.red,g);
            putPixel((int) x, (int) y+1, Color.red,g);
            putPixel((int) x, (int) y-1, Color.red,g);

            if (cont % 2 == 1) {
                if (cont != 1) {
                    Bresenham((int) x, (int) y, (int) xb, (int) yb,g);
                }
                ya = y;
                xa = x;

            } else {
                Bresenham((int) x, (int) y, (int) xa, (int) ya,g);
                xb = x;
                yb = y;

            }
            cont++;
        }
    }
    public void Bresenham(int x0, int y0, int x1, int y1, Graphics g) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        byte stepy;
        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        } else {
            stepy = 1;
        }

        byte stepx;
        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        } else {
            stepx = 1;
        }

        int x = x0;
        int y = y0;
        this.putPixel(x0, y0, Color.red, g);
        int p;
        int incE;
        int incNE;
        if (dx > dy) {
            p = 2 * dy - dx;
            incE = 2 * dy;

            for(incNE = 2 * (dy - dx); x != x1; this.putPixel(x, y, Color.green, g)) {
                x += stepx;
                if (p < 0) {
                    p += incE;
                } else {
                    y += stepy;
                    p += incNE;
                }
            }
        } else {
            p = 2 * dx - dy;
            incE = 2 * dx;

            for(incNE = 2 * (dx - dy); y != y1; this.putPixel(x, y, Color.green, g)) {
                y += stepy;
                if (p < 0) {
                    p += incE;
                } else {
                    x += stepx;
                    p += incNE;
                }
            }
        }

    }
}
