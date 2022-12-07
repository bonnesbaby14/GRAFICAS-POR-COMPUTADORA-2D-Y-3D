package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MiVentana extends JFrame implements Runnable {

    private Image fondo;
    private Image buffer;
    int [] proyecion={50,20,30};

    int [][] resultado;

    private BufferedImage bufferImage;
    private Graphics graPixel;
    public ArrayList<String> puntos_dibujados;

    int [][] puntos={

            new  int [] {100,100,100},
            new  int [] {200,100,100},
            new  int [] {200,200,100},
            new  int [] {100,200,100},
            new  int [] {100,200,200},
            new  int [] {200,200,200},
            new  int [] {200,100,200},
            new  int [] {100,100,200}
    };
    int[] punto1={50,50};
    int[] punto2={100,50};

    int incZ=0;
    int[] punto3={100,100};
    int[] punto4={50,100};
    boolean firstime=true;

    int maxX=5;
    int mayY=10;
    int incX=0;
    int incY=0;



    public MiVentana(){
        setTitle("Escalar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
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
    public void cubo (int [] proyecion, int [][] puntos, Graphics g) {
        int [][] finales= new int[puntos.length][2];

        for (int i=0;i<puntos.length;i++){
            int x=puntos[i][0]+(proyecion[0]*(-puntos[i][2]/proyecion[2]));
            int y=puntos[i][1]+(proyecion[1]*(-puntos[i][2]/proyecion[2]));
            finales[i]=new int [] {x,y};

        }

        /*
        for (int y=0;y<finales.length-1;y++){
            System.out.println(finales[y][0]+","+finales[y][0]);
            Bresenham(finales[y][0]+300,finales[y][1]+300,finales[y+1][0]+300,finales[y+1][1]+300,g);
        }
        Bresenham(finales[0][0]+300,finales[0][1]+300,finales[7][0]+300,finales[7][1]+300,g);
*/
        Bresenham(finales[0][0]+300,finales[0][1]+300,finales[1][0]+300,finales[1][1]+300,g);
        Bresenham(finales[1][0]+300,finales[1][1]+300,finales[2][0]+300,finales[2][1]+300,g);
        Bresenham(finales[2][0]+300,finales[2][1]+300,finales[3][0]+300,finales[3][1]+300,g);
        Bresenham(finales[3][0]+300,finales[3][1]+300,finales[0][0]+300,finales[0][1]+300,g);
        Bresenham(finales[3][0]+300,finales[3][1]+300,finales[4][0]+300,finales[4][1]+300,g);
        Bresenham(finales[4][0]+300,finales[4][1]+300,finales[5][0]+300,finales[5][1]+300,g);
        Bresenham(finales[5][0]+300,finales[5][1]+300,finales[6][0]+300,finales[6][1]+300,g);
        Bresenham(finales[6][0]+300,finales[6][1]+300,finales[7][0]+300,finales[7][1]+300,g);
        Bresenham(finales[5][0]+300,finales[5][1]+300,finales[2][0]+300,finales[2][1]+300,g);
        Bresenham(finales[7][0]+300,finales[7][1]+300,finales[6][0]+300,finales[6][1]+300,g);
        Bresenham(finales[0][0]+300,finales[0][1]+300,finales[7][0]+300,finales[7][1]+300,g);
        Bresenham(finales[4][0]+300,finales[4][1]+300,finales[7][0]+300,finales[7][1]+300,g);
        Bresenham(finales[1][0]+300,finales[1][1]+300,finales[6][0]+300,finales[6][1]+300,g);


    }
    @Override
    public void update(Graphics g) {
        g.setClip(0,0,getWidth(),getHeight());
        buffer=createImage(getWidth(),getHeight());
        Graphics gbufer=buffer.getGraphics();
        gbufer.setClip(0,0,getWidth(),getHeight());
        gbufer.drawImage(fondo,0,0,this);

        if(firstime){

            cubo(proyecion,puntos,g);
            firstime=false;

            resultado=puntos;
        }
        resultado=  escalar(incX,incY, incZ,puntos);






        cubo(proyecion,resultado,g);
        g.drawImage(buffer,0,0,this);











        System.out.println("[");
        for (int x=0;x<resultado.length;x++){
            for(int y=0;y<resultado[x].length;y++){
                System.out.print(resultado[x][y]);
                System.out.print(",");
            }
            System.out.println("");
        }
        System.out.println("]");




        g.drawImage(buffer,0,0,this);

    }



    public int [][]  escalar(int incX, int incY,  int incZ, int [][] puntos) {



        int [][] resultado=multiply(new int[][]{
                {incX,0,0,0},
                {0,incY,0,0},
                {0,0,incZ,0},
                {0,0,0,1}
        },new int[][]{
                {puntos[0][0],puntos[0][1],puntos[0][2],1}
                ,{puntos[1][0],puntos[1][1],puntos[1][2],1}
                ,{puntos[2][0],puntos[2][1],puntos[2][2],1}
                ,{puntos[3][0],puntos[3][1],puntos[3][2],1}
                ,{puntos[4][0],puntos[4][1],puntos[4][2],1}
                ,{puntos[5][0],puntos[5][1],puntos[5][2],1}
                ,{puntos[6][0],puntos[6][1],puntos[6][2],1}
                ,{puntos[7][0],puntos[7][1],puntos[7][2],1}
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

      //  while (incX<maxX || incY<mayY){
        while (incX<maxX){

            try {
                incX+=1;
                incY+=1;
                incZ=1;

                repaint();
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

