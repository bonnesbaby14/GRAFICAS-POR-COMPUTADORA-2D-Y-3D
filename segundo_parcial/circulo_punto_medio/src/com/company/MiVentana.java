package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MiVentana extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    int [] centro={300,300};

    int radio=200;

    public ArrayList<String> puntos_dibujados;




    public MiVentana(){
        setTitle("Circulo Basico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);
        buffer= new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);
        graPixel=(Graphics2D)buffer.createGraphics();
        puntos_dibujados= new ArrayList<>();


    }


    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());

        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void paint (Graphics g) {
        super.paint(g);


        circulo_punto_medio(centro,radio);
        System.out.println("uno");



    }

     void circulo_punto_medio(int [] centro, int radio)
    {

        int x = radio;
        int y = 0;

        putPixel(x + centro[0],y + centro[1],Color.red);

        int incremento = 1 - radio;
        while (x > y) {
            y++;
            if (incremento <= 0)
                incremento = incremento + 2 * y + 1;
            else {
                x--;
                incremento = incremento + 2 * y - 2 * x + 1;
            }

            //CUADRANTE C
            putPixel(x+centro[0],y+centro[1],Color.red);
            //CUADRANTE F
            putPixel(-x+centro[0],y+centro[1],Color.red);
            //CUADRANTE B
            putPixel(x+centro[0],-y+centro[1],Color.red);
            //CUADRANTE G
            putPixel(-x+centro[0],-y+centro[1],Color.red);


            if (x != y) {

                //CUADRANTE A
                putPixel(y+centro[0],-x+centro[1],Color.red);

                //CUADRANTE D
                putPixel(y+centro[0],x+centro[1],Color.red);
                //CUADRANTE E
                putPixel(-y+centro[0],x+centro[1],Color.red);
                //CUADRANTE H
                putPixel(-y+centro[0],-x+centro[1],Color.red);


            }
        }
    }

    public void Bresenham(int x0, int y0, int x1, int y1){
        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = (x1 - x0);
        dy = (y1 - y0);
        /* determinar que punto usar para empezar, cual para terminar */
        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        }
        else
            stepy = 1;
        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        }
        else
            stepx = 1;
        x = x0;
        y = y0;
        putPixel(x,y,Color.red);
        puntos_dibujados.add(String.valueOf(x)+","+String.valueOf(y));
        /* se cicla hasta llegar al extremo de la línea */
        if(dx>dy){
            p = 2*dy - dx;
            incE = 2*dy;
            incNE = 2*(dy-dx);
            while (x != x1){
                x = x + stepx;
                if (p < 0){
                    p = p + incE;
                }
                else {
                    y = y + stepy;
                    p = p + incNE;
                }
                putPixel(x,y,Color.red);
                puntos_dibujados.add(String.valueOf(x)+","+String.valueOf(y));
            }
        }
        else{
            p = 2*dx - dy;
            incE = 2*dx;
            incNE = 2*(dx-dy);
            while (y != y1){
                y = y + stepy;
                if (p < 0){
                    p = p + incE;
                }
                else {
                    x = x + stepx;
                    p = p + incNE;
                }
                putPixel(x,y,Color.red);
                puntos_dibujados.add(String.valueOf(x)+","+String.valueOf(y));

            }
        }


    }

    public void llenado_uno( int [] punto) throws InterruptedException {









    }






}

