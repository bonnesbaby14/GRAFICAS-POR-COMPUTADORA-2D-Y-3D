package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Calendar;

import static java.awt.Color.red;

public class Reloj extends JFrame implements Runnable {

    private BufferedImage buffer;
    private BufferedImage bufferSeconds;
    private BufferedImage bufferMinutes;
    private BufferedImage bufferHours;

    private Graphics fondo;
    private Graphics gsecond;
    private Graphics gminute;
    private Graphics ghour;





    public int radioHora = 100;
    public int radioMinuto = 150;
    public int radioSegundo = 200;

    private int hora =12;
    private int minuto = 15;
    private int segundo = 1;


    private boolean newMinuete=true;
    private boolean newHour=true;

    private boolean fondoReady=false;


    @Override
    public void run() {

        while(true) {
            try {

                Thread.sleep(1000);
                segundo++;
                if(segundo>60){
                    segundo=1;
                    minuto++;
                    newMinuete=true;

                }
                if(minuto>60){
                    minuto=1;
                    hora++;
                    newHour=true;
                }
                if(hora>12){
                    hora=1;
                    newHour=true;
                }
                repaint();
            }catch(InterruptedException e) {}
        }

    }

    Reloj() {
        setTitle("Reloj");
        setSize(500, 500);
        setLayout(null);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        fondo= (Graphics2D) buffer.createGraphics();
        bufferSeconds = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        gsecond=(Graphics2D) bufferSeconds.createGraphics();
        bufferMinutes = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        gminute=(Graphics2D) bufferMinutes.createGraphics();
        bufferHours= new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        ghour=(Graphics2D) bufferHours.createGraphics();

        Calendar calendar=Calendar.getInstance();
        hora=calendar.get(Calendar.HOUR);
        segundo=calendar.get(Calendar.SECOND);
        minuto=calendar.get(Calendar.MINUTE);



    }

    public void putPixel(int x, int y, Color c, BufferedImage buffer,Graphics graphics) {
        buffer.setRGB(0, 0, c.getRGB());

        graphics=this.getGraphics();
        graphics.drawImage(buffer, x, y, this);
    }

    public void paint(Graphics g) {
        super.paint(g);


          if(true){
              ImageIcon fondoImage=new ImageIcon("/home/bonnesbaby14/Escritorio/CETI/GRAFICASPORCOMPUTADORA2DY3D/primer_parcial/relog/src/com/company/reloj.jpg");

              fondo=this.getGraphics();
              fondo.drawImage(fondoImage.getImage(),50,50,400,400,this);
              fondoReady=true;

          }

        int[] aux = getCordHora(hora, new int[]{250, 250});

        if(true) {
            Bresenham(250, 250, aux[0], aux[1], bufferHours,ghour);
            newHour=false;

        }
        aux = getCordMinuto(minuto, new int[]{250, 250});

        if(true) {
            Bresenham(250, 250, aux[0], aux[1], bufferMinutes,gminute);
            newMinuete=false;
        }
        aux = getCordSegundo(segundo, new int[]{250, 250});

        Bresenham(250, 250, aux[0], aux[1],bufferSeconds,gsecond);


    }

    public void Bresenham(int x0, int y0, int x1, int y1, BufferedImage buffer, Graphics graphics) {
        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = (x1 - x0);
        dy = (y1 - y0);
        /* determinar que punto usar para empezar, cual para terminar */
        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        } else
            stepy = 1;
        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        } else
            stepx = 1;
        x = x0;
        y = y0;
        putPixel(x, y, red, buffer,graphics);
        /* se cicla hasta llegar al extremo de la línea */
        if (dx > dy) {
            p = 2 * dy - dx;
            incE = 2 * dy;
            incNE = 2 * (dy - dx);
            while (x != x1) {
                x = x + stepx;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepy;
                    p = p + incNE;
                }
                putPixel(x, y, red, buffer,graphics);
            }
        } else {
            p = 2 * dx - dy;
            incE = 2 * dx;
            incNE = 2 * (dx - dy);
            while (y != y1) {
                y = y + stepy;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepx;
                    p = p + incNE;
                }
                putPixel(x, y, red,buffer,graphics);
                // System.out.println("x:"+x+" y:"+y);
            }
        }


    }

    public int[] getCordHora(int hora, int[] inicial) {

        int x = 0;
        int y = 0;

        int angulo2 = 30;

        if (hora <= 3) {
            //cuadrante 1 x+;y-
            int maxHora = 3;
            int anguloAux = (maxHora - hora) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioHora * Math.cos(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioHora * Math.sin(Math.toRadians(anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] + subX);
            y = Math.round(inicial[1] - subY);

            System.out.println("x: " + x + " y: " + y);


        } else if (hora <= 6) {
            //cuadrante 2 x+;y+


            int maxHora = 6;
            int anguloAux = (maxHora - hora) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioHora * Math.sin(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioHora * Math.cos(Math.toRadians(anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] + subX);
            y = Math.round(inicial[1] + subY);

            System.out.println("x: " + x + " y: " + y);

        } else if (hora <= 9) {
            //cuadrante 3 x-;y+
            int maxHora = 9;
            int anguloAux = (maxHora - hora) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioHora * Math.cos(Math.toRadians(360 - anguloAux)));
            float subY = (float) ((float) radioHora * Math.sin(Math.toRadians(360 - anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] - subX);
            y = Math.round(inicial[1] - subY);

            System.out.println("x: " + x + " y: " + y);

        } else {
            //cuadrante 4 x-;y-
            int maxHora = 12;
            int anguloAux = (maxHora - hora) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioHora * Math.sin(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioHora * Math.cos(Math.toRadians(anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] - subX);
            y = Math.round(inicial[1] - subY);

            System.out.println("x: " + x + " y: " + y);


        }


        return new int[]{x, y};
    }

    public int[] getCordMinuto(int minuto, int[] inicial) {

        int x = 0;
        int y = 0;
        int angulo2 = 6;

        if (minuto <= 3) {
            //cuadrante 1 x+;y-
            int maxMinuto = 15;
            int anguloAux = (maxMinuto - minuto) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioMinuto * Math.cos(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioMinuto * Math.sin(Math.toRadians(anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] + subX);
            y = Math.round(inicial[1] - subY);

            System.out.println("x: " + x + " y: " + y);


        } else if (minuto <= 6) {
            //cuadrante 2 x+;y+


            int maxMinuto = 30;
            int anguloAux = (maxMinuto - minuto) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioMinuto * Math.sin(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioMinuto * Math.cos(Math.toRadians(anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] + subX);
            y = Math.round(inicial[1] + subY);

            System.out.println("x: " + x + " y: " + y);

        } else if (minuto <= 9) {
            //cuadrante 3 x-;y+
            int maxMinuto = 45;
            int anguloAux = (maxMinuto - minuto) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioMinuto * Math.cos(Math.toRadians(360 - anguloAux)));
            float subY = (float) ((float) radioMinuto * Math.sin(Math.toRadians(360 - anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] - subX);
            y = Math.round(inicial[1] - subY);

            System.out.println("x: " + x + " y: " + y);

        } else {
            //cuadrante 4 x-;y-
            int maxMinuto = 60;
            int anguloAux = (maxMinuto - minuto) * (angulo2);
            System.out.println("angulo: " + anguloAux);
            System.out.println("cos: " + Math.cos(Math.toRadians(anguloAux)));
            System.out.println("sin: " + Math.sin(Math.toRadians(anguloAux)));

            float subX = (float) ((float) radioMinuto * Math.sin(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioMinuto * Math.cos(Math.toRadians(anguloAux)));
            System.out.println("subX: " + subX);
            System.out.println("suby: " + subY);
            x = Math.round(inicial[0] - subX);
            y = Math.round(inicial[1] - subY);

            System.out.println("x: " + x + " y: " + y);


        }


        return new int[]{x, y};
    }

    public int[] getCordSegundo(int segundo, int[] inicial) {

        int x = 0;
        int y = 0;
        int angulo2 = 6;

        if (segundo <= 3) {
            //cuadrante 1 x+;y-
            int maxSegundo = 15;
            int anguloAux = (maxSegundo - segundo) * (angulo2);

            float subX = (float) ((float) radioSegundo * Math.cos(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioSegundo * Math.sin(Math.toRadians(anguloAux)));
            x = Math.round(inicial[0] + subX);
            y = Math.round(inicial[1] - subY);


        } else if (segundo <= 6) {
            //cuadrante 2 x+;y+


            int maxSegundo = 30;
            int anguloAux = (maxSegundo - segundo) * (angulo2);

            float subX = (float) ((float) radioSegundo * Math.sin(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioSegundo * Math.cos(Math.toRadians(anguloAux)));
            x = Math.round(inicial[0] + subX);
            y = Math.round(inicial[1] + subY);


        } else if (segundo <= 9) {
            //cuadrante 3 x-;y+
            int maxSegundo = 45;
            int anguloAux = (maxSegundo - segundo) * (angulo2);

            float subX = (float) ((float) radioSegundo * Math.cos(Math.toRadians(360 - anguloAux)));
            float subY = (float) ((float) radioSegundo * Math.sin(Math.toRadians(360 - anguloAux)));
            x = Math.round(inicial[0] - subX);
            y = Math.round(inicial[1] - subY);

        } else {
            //cuadrante 4 x-;y-
            int maxSegundo = 60;
            int anguloAux = (maxSegundo - segundo) * (angulo2);

            float subX = (float) ((float) radioSegundo * Math.sin(Math.toRadians(anguloAux)));
            float subY = (float) ((float) radioSegundo * Math.cos(Math.toRadians(anguloAux)));
            x = Math.round(inicial[0] - subX);
            y = Math.round(inicial[1] - subY);

        }
        return new int[]{x, y};
    }

}