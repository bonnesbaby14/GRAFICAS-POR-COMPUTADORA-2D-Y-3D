package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.red;

public class MiVentana extends JFrame implements Runnable {

    private BufferedImage buffer;
    private Graphics graPixel;

    int[] punto1={100,100};
    int[] punto2={300,100};
    int[] punto3={300,300};
    int[] punto4={100,300};
    boolean firstime=true;

    int maxX=600;
    int mayY=400;
    int incX=3;
    int incY=1;


    public MiVentana(){
        setTitle("Traslacion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
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

        if(firstime){
            Bresenham(punto1[0],punto1[1],punto2[0],punto2[1]);
            Bresenham(punto2[0],punto2[1],punto3[0],punto3[1]);
            Bresenham(punto3[0],punto3[1],punto4[0],punto4[1]);
            Bresenham(punto4[0],punto4[1],punto1[0],punto1[1]);
            firstime=false;
        }

        int [][] resultado= tralacion(incX,incY, new int[][] {punto1,punto2,punto3,punto4});
        Bresenham(resultado[0][0],resultado[0][1],resultado[1][0],resultado[1][1]);
        Bresenham(resultado[1][0],resultado[1][1],resultado[2][0],resultado[2][1]);
        Bresenham(resultado[2][0],resultado[2][1],resultado[3][0],resultado[3][1]);
        Bresenham(resultado[3][0],resultado[3][1],resultado[0][0],resultado[0][1]);


    }


    public void Bresenham(int x0, int y0,int x1,int y1){
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

            }
        }


    }

    public int [][]  tralacion(int incX, int incY, int [][] puntos) {



        int [][] resultado=multiply(new int[][]{{1,0,incX},{0,1,incY},{0,0,1}},new int[][]{{puntos[0][0],puntos[0][1],1},{puntos[1][0],puntos[1][1],1},{puntos[2][0],puntos[2][1],1},{puntos[3][0],puntos[3][1],1}});


        return resultado;

    }


    public static int[][] multiply(int[][] a, int[][] b) {
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

        while (incX<maxX || incY<mayY){

            try {
                incX+=10;
                incY+=10;

                repaint();
                System.out.println("entre");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

