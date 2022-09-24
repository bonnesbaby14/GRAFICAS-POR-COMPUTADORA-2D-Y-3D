package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MiVentana extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    int [] centro={300,300};

    int radio=200;



    public MiVentana(){
        setTitle("Circulo Basico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);
        buffer= new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);
        graPixel=(Graphics2D)buffer.createGraphics();

    }


    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());

        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void paint (Graphics g) {
        super.paint(g);

        circulo_punto_medio(centro,radio);

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






}

