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


   int [] proyecion={0,0,1};

   int [][] puntos={

           new  int [] {100,100,100},//0-A
           new  int [] {200,100,100},//1-B
           new  int [] {200,400,100},//2-C
           new  int [] {100,400,100},//3-D
           new  int [] {100,400,200},//4-E
           new  int [] {200,400,200},//5-F
           new  int [] {200,100,200},//6-G
           new  int [] {100,100,200},//7-H
           new  int [] {200,200,200},//8-I
           new  int [] {200,300,200},//9-J
           new  int [] {300,200,200},//10-K
           new  int [] {300,300,200},//11-L
           new  int [] {300,300,100},//12-M
           new  int [] {300,200,100},//13-N
           new  int [] {200,300,100},//14-O
           new  int [] {200,200,100},//15-P
   };

    int factor=2;
    public MiVentana() {
        this.setTitle("Malla");
        this.setDefaultCloseOperation(3);
        this.setSize(700, 700);
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


        cubo(proyecion,puntos,g);





    }

    public void cubo (int [] proyecion, int [][] puntos, Graphics g) {
        int [][] finales= new int[puntos.length][2];

        for (int i=0;i<puntos.length;i++){
            int x=puntos[i][0]+(proyecion[0]*(-puntos[i][2]/proyecion[2]));
            int y=puntos[i][1]+(proyecion[1]*(-puntos[i][2]/proyecion[2]));
            x+=400;
            y+=200;
            finales[i]=new int [] {x,y};
            this.putPixel(x+1, y, Color.red, g);
            this.putPixel(x-1, y, Color.red, g);
            this.putPixel(x, y+1, Color.red, g);
            this.putPixel(x, y-1, Color.red, g);
            this.putPixel(x+1, y+1, Color.red, g);
            this.putPixel(x-1, y-1, Color.red, g);
            this.putPixel(x+1, y+1, Color.red, g);
            this.putPixel(x-1, y-1, Color.red, g);

        }

        //a->d
        Bresenham(finales[0][0],finales[0][1],finales[3][0],finales[3][1],g);
        //b->p
        Bresenham(finales[1][0],finales[1][1],finales[15][0],finales[15][1],g);
        //g->i
        Bresenham(finales[6][0],finales[6][1],finales[8][0],finales[8][1],g);
        //h->e
        Bresenham(finales[7][0],finales[7][1],finales[4][0],finales[4][1],g);
        //h->g
        Bresenham(finales[7][0],finales[7][1],finales[6][0],finales[6][1],g);
        //a->b
        Bresenham(finales[0][0],finales[0][1],finales[1][0],finales[1][1],g);
        //b->g
        Bresenham(finales[1][0],finales[1][1],finales[6][0],finales[6][1],g);
        //a->h
        Bresenham(finales[0][0],finales[0][1],finales[7][0],finales[7][1],g);

        //f->e
        Bresenham(finales[4][0],finales[4][1],finales[5][0],finales[5][1],g);
        //c->d
        Bresenham(finales[2][0],finales[2][1],finales[3][0],finales[3][1],g);
        //e->d
        Bresenham(finales[3][0],finales[3][1],finales[4][0],finales[4][1],g);
        //f->c
        Bresenham(finales[5][0],finales[5][1],finales[2][0],finales[2][1],g);

        //j->f
        Bresenham(finales[9][0],finales[9][1],finales[5][0],finales[5][1],g);
        //c->o
        Bresenham(finales[2][0],finales[2][1],finales[14][0],finales[14][1],g);

        //k->l
        Bresenham(finales[10][0],finales[10][1],finales[11][0],finales[11][1],g);
        //n->k
        Bresenham(finales[13][0],finales[13][1],finales[10][0],finales[10][1],g);
        //n->m
        Bresenham(finales[12][0],finales[12][1],finales[13][0],finales[13][1],g);
        //m->l
        Bresenham(finales[12][0],finales[12][1],finales[11][0],finales[11][1],g);
        //i->k
        Bresenham(finales[10][0],finales[10][1],finales[8][0],finales[8][1],g);
        //l->j
        Bresenham(finales[11][0],finales[11][1],finales[9][0],finales[9][1],g);
        //m->o
        Bresenham(finales[12][0],finales[12][1],finales[14][0],finales[14][1],g);
        //n->p
        Bresenham(finales[13][0],finales[13][1],finales[15][0],finales[15][1],g);



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