package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MiVentana extends JFrame implements Runnable {

    private Image fondo;
    private Image buffer;
    public int sizeElipse1;
    public int sizeElipse2;

    public int indice1;
    public int indice2;
    public int indice3;
    public int indice4;
    public int radio1;
    public int radio2;
    public int radio1max;
    public int radio2max;
    public boolean incremento;






    private BufferedImage bufferImage;


    public MiVentana(){
        setTitle("proyecto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 600);
        setLayout(null);

        bufferImage= new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);
        sizeElipse1=2002;
        sizeElipse2=2002;

        indice1=400;
        indice2=1700;
        indice3=1000;
        indice4=300;
        radio1=300;
        radio2=100;
        incremento=true;


    }




    public void paint (Graphics g) {


        update(g);
    }

    @Override
    public void update(Graphics g) {

        g.setClip(0,0,getWidth(),getHeight());
        buffer=createImage(getWidth(),getHeight());
        Graphics gbufer=buffer.getGraphics();
        gbufer.setClip(0,0,getWidth(),getHeight());
        gbufer.drawImage(fondo,0,0,this);





        Elipse elipse1 =new Elipse(buffer,radio1,radio2,new int[]{500,450},g,gbufer,bufferImage);
        elipse1.dibujar();
        Elipse elipse2=new Elipse(buffer,radio2,radio1,new int[]{500,450},g,gbufer,bufferImage);
        elipse2.dibujar();




        Circulo centro=new Circulo(bufferImage,15,new int []{485,435},gbufer,buffer,  g,Color.green);
        centro.dibujar();
        centro.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));
        Circulo centro2=new Circulo(bufferImage,15,new int []{510,435},gbufer,buffer,  g,Color.blue);
        centro2.dibujar();
        centro2.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));
        Circulo centro3=new Circulo(bufferImage,15,new int []{485,460},gbufer,buffer,  g,Color.blue);
        centro3.dibujar();
        centro3.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));
        Circulo centro4=new Circulo(bufferImage,15,new int []{510,460},gbufer,buffer,  g,Color.red);
        centro4.dibujar();
        centro4.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));
        Circulo centro5=new Circulo(bufferImage,15,new int []{497,448},gbufer,buffer,  g,Color.yellow);
        centro5.dibujar();
        centro5.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));



        int [] newcentro=new int[]{Integer.parseInt(elipse1.puntos_dibujados.get(indice1).split(",")[0]), Integer.parseInt(elipse1.puntos_dibujados.get(indice1).split(",")[1])};
        Circulo circulo1=new Circulo(bufferImage,10,newcentro,gbufer,buffer,  g,Color.cyan);
        circulo1.dibujar();
        circulo1.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));
        int [] newcentro2=new int[]{Integer.parseInt(elipse1.puntos_dibujados.get(indice2).split(",")[0]), Integer.parseInt(elipse1.puntos_dibujados.get(indice2).split(",")[1])};
        Circulo circulo2=new Circulo(bufferImage,10,newcentro2,gbufer,buffer,  g,Color.cyan);
        circulo2.dibujar();
        circulo2.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));


        int [] newcentro3=new int[]{Integer.parseInt(elipse2.puntos_dibujados.get(indice3).split(",")[0]), Integer.parseInt(elipse2.puntos_dibujados.get(indice3).split(",")[1])};
        Circulo circulo3=new Circulo(bufferImage,10,newcentro3,gbufer,buffer,  g,Color.cyan);
        circulo3.dibujar();
        circulo3.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));

        int [] newcentro4=new int[]{Integer.parseInt(elipse2.puntos_dibujados.get(indice4).split(",")[0]), Integer.parseInt(elipse2.puntos_dibujados.get(indice4).split(",")[1])};
        Circulo circulo4=new Circulo(bufferImage,10,newcentro4,gbufer,buffer,  g,Color.cyan);
        circulo4.dibujar();
        circulo4.relleno();
        this.setBackground(new java.awt.Color(12, 22, 56));
        g.drawImage(buffer,0,0,null);


        sizeElipse1=elipse1.puntos_dibujados.size();
        sizeElipse2=elipse2.puntos_dibujados.size();


        indice1+=10;
        if(indice1>=sizeElipse1){
            indice1=0;
        }
        indice2+=10;
        if(indice2>=sizeElipse1){
            indice2=0;
        }
        indice3+=10;
        if(indice3>=sizeElipse2){
            indice3=0;
        }
        indice4+=10;
        if(indice4>=sizeElipse2){
            indice4=0;
        }


        if(radio1==radio1max){
            incremento=false;

        }
        if(radio1==295){
            incremento=true;
        }
        if(incremento) {

            radio1-=5;
            radio2-=5;

        }else{
            radio1+=5;
            radio2+=5;


        }





    }





    @Override
    public void run() {

      //  while (incX<maxX || incY<mayY){
        while (true){

            try {


                repaint();




                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){
                System.out.println("ERROR GENERAL");
            }
        }
    }
}

