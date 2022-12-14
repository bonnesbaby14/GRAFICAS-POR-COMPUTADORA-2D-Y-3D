package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MiVentana extends JFrame implements Runnable {

    private Image fondo;
    private Image buffer;

    private BufferedImage bufferImage;
    private Graphics graPixel;


    int[] punto1={900,100};
    int[] punto2={950,100};
    int[] punto3={950,150};
    int[] punto4={900,150};
    boolean firstime=true;



    int angulo=1;
    int anguloMax=90;


    public MiVentana(){
        setTitle("Rotacion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLayout(null);
        bufferImage= new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);






    }


    public void putPixel(int x, int y, Color c,Graphics g) {
        bufferImage.setRGB(0, 0, c.getRGB());

        g.drawImage(bufferImage, x, y, this);
    }

    public void paint (Graphics g) {
        if(fondo==null){
            fondo=createImage(getWidth(),getHeight());
            Graphics gfondo=fondo.getGraphics();
            gfondo.setClip(0,0,getWidth(),getHeight());
        }

        update(g);
    }

    @Override
    public void update(Graphics g) {
        g.setClip(0,0,getWidth(),getHeight());
        buffer=createImage(getWidth(),getHeight());
        Graphics gbufer=buffer.getGraphics();
        gbufer.setClip(0,0,getWidth(),getHeight());
        gbufer.drawImage(fondo,0,0,this);

        if(firstime){
            Bresenham(punto1[0],punto1[1],punto2[0],punto2[1],gbufer);
            Bresenham(punto2[0],punto2[1],punto3[0],punto3[1],gbufer);
            Bresenham(punto3[0],punto3[1],punto4[0],punto4[1],gbufer);
            Bresenham(punto4[0],punto4[1],punto1[0],punto1[1],gbufer);

            firstime=false;

        }





        int [][] resultado=rotacion(angulo,new int[][]{punto1,punto2,punto3,punto4});





        /*
        System.out.println("[");
        for (int x=0;x<resultado.length;x++){
            for(int y=0;y<resultado[x].length;y++){
                System.out.print(resultado[x][y]);
                System.out.print(",");
            }
            System.out.println("");
        }
        System.out.println("]");
*/




        Bresenham(resultado[0][0],resultado[0][1],resultado[1][0],resultado[1][1],gbufer);
        Bresenham(resultado[1][0],resultado[1][1],resultado[2][0],resultado[2][1],gbufer);
        Bresenham(resultado[2][0],resultado[2][1],resultado[3][0],resultado[3][1],gbufer);
        Bresenham(resultado[3][0],resultado[3][1],resultado[0][0],resultado[0][1],gbufer);


        g.drawImage(buffer,0,0,this);

    }



    public int [][]  rotacion(int angulo, int [][] puntos) {



        int [][] resultado=multiply(new double[][]{
                {Math.cos(Math.toRadians(angulo)),  -Math.sin(Math.toRadians(angulo)),0},
                { Math.sin(Math.toRadians(angulo)),Math.cos(Math.toRadians(angulo)),0},
                {0,0,1}
        },new int[][]{
                {puntos[0][0],puntos[0][1],1}
                ,{puntos[1][0],puntos[1][1],1}
                ,{puntos[2][0],puntos[2][1],1}
                ,{puntos[3][0],puntos[3][1],1}
        });


        return resultado;

    }


    public void Bresenham(int x0, int y0, int x1, int y1,Graphics g){
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

        putPixel(x,y,Color.red,g);

        /* se cicla hasta llegar al extremo de la l??nea */
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
                putPixel(x,y,Color.red,g);

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
                putPixel(x,y,Color.red,g);


            }
        }


    }



    public static int[][] multiply(double[][] a, int[][] b) {
        int[][] c = new int[b.length][a[0].length];
        // se comprueba si las matrices se pueden multiplicar

        if (a[0].length == b[0].length) {

            for (int i=0;i<b.length;i++){

                for(int z=0;z<a.length;z++){
                    int aux=0;
                    for(int j=0;j<b[0].length;j++){
                        aux+=b[i][j]*a[z][j];
                    }

                    c[i][z]=aux;
                }
            }
        }
        return c;
    }

    @Override
    public void run() {

      //  while (incX<maxX || incY<mayY){
        while (angulo<anguloMax){

            try {

                angulo+=1;


                repaint();
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

