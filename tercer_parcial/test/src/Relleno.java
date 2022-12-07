/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Clau
 */
public class Relleno extends JFrame implements Runnable{
    private BufferedImage bufferPixel, imagenCompleta, fondo;
    private Graphics graPixel;
    private Color miColor, miRosa, unknown, miCielo, miMar, miArena, LGorro, LCabello, LPiel, LPiel2, LTraje, LHebilla, LCuero, LCubos, miSol, rocaTop, rocaBot;
    private Thread hilo;
    private String nombreClase = "Proyecto Final";
    private int ancho = 900, alto = 600;
    private float[][] roca1A, roca1B, roca2, roca3A, roca3B, roca3C;
    private float[][] roca1A_3D, roca1B_3D, roca2_3D, roca3A_3D, roca3B_3D, roca3C_3D;
    private float[][] roca1A_2D, roca1B_2D, roca2_2D, roca3A_2D, roca3B_2D, roca3C_2D;
    private float[][] ojoIzq_F, ojoDer_F, rostro_F, gorro_F, cabello_F;
    private float[][] ojoIzq_F_3D, ojoDer_F_3D, rostro_F_3D, gorro_F_3D, cabello_F_3D;
    private float[][] ojoIzq_F_2D, ojoDer_F_2D, rostro_F_2D, gorro_F_2D, cabello_F_2D;
    private float[][] manoIzq_F, manoDer_F, brazoIzq_F, brazoDer_F, cuello_F, hebilla_F, cintoIzq_F, cintoDer_F;
    private float[][] manoIzq_F_3D, manoDer_F_3D, brazoIzq_F_3D, brazoDer_F_3D,cuello_F_3D, hebilla_F_3D, cintoIzq_F_3D, cintoDer_F_3D;
    private float[][] manoIzq_F_2D, manoDer_F_2D, brazoIzq_F_2D, brazoDer_F_2D,cuello_F_2D, hebilla_F_2D, cintoIzq_F_2D, cintoDer_F_2D;
    private float[][] cuerpo, pieIzq, pieDer, cuerpo_2D, pieIzq_2D, pieDer_2D, cuerpo_3D, pieIzq_3D, pieDer_3D, pieIzq2, pieDer2, pieIzq2_2D, pieDer2_2D, pieIzq2_3D, pieDer2_3D;
    private float[][] pieIzqG, pieDerG, pieIzqG_2D, pieDerG_2D, pieIzqG_3D, pieDerG_3D, pieIzqO_3D, pieDerO_3D;
    private float[][] corazon, corazon_2D, corazon_3D,corazonB, corazonB_2D, corazonB_3D;
    private float[][] pcRelleno, pcRelleno2D, pcRelleno3D,pbRelleno, pbRelleno2D, pbRelleno3D, pfRelleno, pfRelleno2D, pfRelleno3D, pfRelleno2, pfRelleno2_2D, pfRelleno2_3D,pRellenoRoca;
    private Color[] pcColor, pbColor, pfColor, cabezaL, cuerpoL, rocas, manosColor;
    private float [][][] corazones3D, corazones2D, corazonesB3D, corazonesB2D;
    private float [][][] corazones3D_2, corazones2D_2, corazonesB3D_2, corazonesB2D_2;
    private float[][] orejaIzq, orejaDer, cabeza, orejaIzq_3D, orejaDer_3D, cabeza_3D, orejaIzq_2D, orejaDer_2D, cabeza_2D;
    private float[][][] cabezaT, cuerpoT, cabezaT2, cuerpoT2;
    private float[][] bIzq, bDer, bIzq3D, bDer3D, bIzq2D, bDer2D, mIzq, mDer, mIzq3D, mDer3D, mIzq2D, mDer2D;
    private float cuboT[][], carasT[][], centrosT[][], printCuboT[][], printCentrosT[][];
    private float figX[], figY[], fig2X[], fig2Y[];
    private final int X = 0, Y = 1, Z = 2;
    private int contPies = 0, cA1 = 0, cA2 = 0, cA3 ;
    public boolean bFlag = true, f1 = true, f2 = true, corazonVisible = true, corazonVisible2 = false, corazonVisible3 = false, pasoIzq=false, f3 = true, delay = true;

    public Relleno(){

        setTitle(nombreClase);
        setSize(ancho,alto);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        this.bufferPixel = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        this.imagenCompleta = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        this.fondo = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        this.hilo = new Thread(this);
        this.hilo.start();
        this.asignarColores();
        this.crearFiguras();
        setVisible(true);
    }

    public void paint(Graphics g){
        imagenCompleta = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);

        if(cA2 > 50){
            Graphics2D ig2 = imagenCompleta.createGraphics();
            ig2.setBackground(miArena);
            ig2.clearRect(0, 0, this.getWidth(),this.getHeight());
            ig2.setBackground(miMar);
            ig2.clearRect(0, 200, this.getWidth(),100);
            ig2.setBackground(miMar);
            ig2.clearRect(600, 200, this.getWidth(),200);
            ig2.setBackground(miCielo);
            ig2.clearRect(0, 0, this.getWidth(),this.getHeight()/3);
            Curva(100,500,25,Color.red);
            Linea(-1,200,901,200, miMar);
            relleno(10,255,miMar,miArena);
            relleno(590,320,miArena,miMar);
            relleno(680,390, miMar, miArena);
            relleno(850,420, miArena, miMar);
            //Punto(new float[]{850,420},0,0,Color.red);
            Curva(100,500,25,miArena);
        /*float minZ, punto = 0;

        minZ = cuboE[0][Z];
        for(int i = 0; i < cuboE.length; i++){
            if(minZ>cuboE[i][Z]){
                minZ = cuboE[i][Z];
                punto = i;
            }
        }*/
            int solX = 150, solY = 100;
            Curva3(0, 14*Math.PI, solX, solY, 2,200, miSol);
            Circulo( solX-1,  solY, 15,miSol);
            relleno(solX-1,solY, miCielo, miSol);

            //roca1A_2D = fuga(roca1A_3D,roca1_f);
            roca1A_2D = fuga(roca1A_3D,new float[]{80,80,30});
            imprimirFigura(roca1A_2D,roca1A_3D,570,100,(float)0.4,(float)0.4,rocaTop);
            roca1B_2D = fuga(roca1B_3D,new float[]{80,50,30});
        /*imprimirFigura(roca1B_2D,roca1B_3D, 600,150,(float)0.5,(float)0.5,rocaBot);
        roca2_2D = fuga(roca2_3D,new float[]{70,-0,30});*/
            imprimirFiguraO(roca1B_2D,0,3, 600,150,(float)0.5,(float)0.5,rocaBot);
            roca2_2D = fuga(roca2_3D,new float[]{70,-0,30});
                imprimirFigura(roca2_2D,roca2_3D,700,200,(float)0.4,(float)0.4,rocaBot);
            roca3A_2D = fuga(roca3A_3D,new float[]{80,80,30});
            //imprimirFigura(roca3A_2D,570,100,(float)0.4,(float)0.4,Color.red);
            roca3B_2D = fuga(roca3B_3D,new float[]{150, 80,40});
            imprimirFigura(roca3B_2D,roca3B_3D,850,120,(float)0.5,(float)0.5,rocaTop);
            roca3C_2D = fuga(roca3C_3D,new float[]{150,-0,30});
            imprimirFigura(roca3C_2D,3,850,150,(float)0.4,(float)0.4,rocaBot);

            for(int i = 0; i <pRellenoRoca[X].length; i++){
                if(((i == 3)||(i == 4)||(i == 11)||(i == 12))){
                    relleno((int)pRellenoRoca[X][i],(int)pRellenoRoca[Y][i], miCielo, rocaTop,miMar, rocas[i]);
                }else{
                    relleno((int)pRellenoRoca[X][i],(int)pRellenoRoca[Y][i], miCielo, miMar, rocas[i]);
                }

                //Punto(new float[]{pRellenoRoca[0][i], pRellenoRoca[1][i]},0,0,Color.red);

            }





            int[] proyeccion = new int[]{1,2,1};
            int[] traslacion = new int[]{5,1,0};
            int[] trasCour = new int[]{0,-1,0};
            double[] esCour = new double[]{1.05,1.05,1};
            int desCuerpoY = 10;
            int desCoraY = 0, desCoraX = -225;



        /*if(feet&&feetFlag){
           pieIzq_3D =  pieIzqG_3D;
           pieIzq_2D = puntos3Da2D(pieIzq_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
           imprimirFigura(pieIzq_2D,6,0,desCuerpoY,(float)1.5,(float)1.5,Color.darkGray);
           pieDer_2D = puntos3Da2D(pieDer_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
           imprimirFigura(pieDer_2D,6,0,desCuerpoY,(float)1,(float)1,Color.darkGray);
           contPies=contPies+1;
           if(contPies>500){
               feet = false;
               pieIzq_3D =  pieIzqO_3D;
           }
        }else if(!feet && feetFlag){
           pieIzq_2D = puntos3Da2D(pieIzq_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
           imprimirFigura(pieIzq_2D,6,0,desCuerpoY,(float)1,(float)1,Color.darkGray);
           pieDer_2D = puntos3Da2D(pieDer_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
           imprimirFigura(pieDer_2D,6,0,desCuerpoY,(float)1,(float)1,Color.darkGray);

           contPies=contPies-1;
           if(contPies<=0){
               feet = true;
           }

        }  */




        /*
        cabello_F_2D = puntos3Da2D(cabello_F_3D,1,2,1);
        imprimirFigura2(cabello_F_2D,0,0,(float)1,(float)1,Color.yellow);
        gorro_F_2D = puntos3Da2D(gorro_F_3D,1,2,1);
        imprimirFigura2(gorro_F_2D,0,0,(float)1,(float)1,Color.green);
        ojoIzq_F_2D = puntos3Da2D(ojoIzq_F_3D,1,02,1);
        imprimirFigura2(ojoIzq_F_2D,0,0,(float)1,(float)1,Color.white);
        ojoDer_F_2D = puntos3Da2D(ojoDer_F_3D,1,2,1);
        imprimirFigura2(ojoDer_F_2D,0,0,(float)1,(float)1,Color.white);
        rostro_F_2D = puntos3Da2D(rostro_F_3D,1,2,1);
        imprimirFigura2(rostro_F_2D,0,0,(float)1,(float)1,Color.pink);
        orejaIzq_2D = puntos3Da2D(orejaIzq_3D,1,2,1);
        imprimirFigura(orejaIzq_3D,0,0,(float)1,(float)1,Color.pink);
        orejaDer_2D = puntos3Da2D(orejaDer_3D,1,2,1);
        imprimirFigura(orejaDer_3D,0,0,(float)1,(float)1,Color.pink);*/


            if(cA1 > 55){
                traslacion[X] = 0;
                traslacion[Y] = 0;
                traslacion[Z] = 0;
                proyeccion[X] = 0;
                proyeccion[Y] = 0;
                proyeccion[Z] = 1;
                f1 = false;
                desCuerpoY = 0;
            }

            if(cA1 > 70){
                f2 = false;
                corazonVisible = false;
            }

            if(cA1 > 100){
                corazonVisible2 = true;
                desCoraY = -110;
                desCoraX = -305;
            }

            if(cA1 > 110){
                esCour[X] = 1;
                esCour[Y] = 1;
                esCour[Z] = 1;
                trasCour[Y] = 0;
                corazonVisible2 = false;
                corazonVisible3 = true;
                f3 = false;
            }

            if(cA1 > 120){
                esCour[X] = 1;
                esCour[Y] = 1;
                esCour[Z] = 1;
                trasCour[Y] = 0;
            }

            cabeza_3D = Trasladar3D(cabeza_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            cabeza_2D = puntos3Da2D(cabeza_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            imprimirFigura(cabeza_2D,6,0,0,(float)1,(float)1,LCubos);

            orejaIzq_3D = Trasladar3D(orejaIzq_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            orejaIzq_2D = puntos3Da2D(orejaIzq_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            imprimirFigura(orejaIzq_3D,0,0,(float)1,(float)1,Color.pink);
            orejaDer_3D = Trasladar3D(orejaDer_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            orejaDer_2D = puntos3Da2D(orejaDer_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            imprimirFigura(orejaDer_3D,0,0,(float)1,(float)1,Color.pink);

            pieIzq2_3D = Trasladar3D(pieIzq2_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            pieIzq2_2D = puntos3Da2D(pieIzq2_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            //imprimirFigura(pieIzq2_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);

            pieIzq_3D = Trasladar3D(pieIzq_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            pieIzq_2D = puntos3Da2D(pieIzq_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            //imprimirFigura(pieIzq_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);

            pieDer2_3D = Trasladar3D(pieDer2_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            pieDer2_2D = puntos3Da2D(pieDer2_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            //imprimirFigura(pieDer2_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);

            pieDer_3D = Trasladar3D(pieDer_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            pieDer_2D = puntos3Da2D(pieDer_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            //imprimirFigura(pieDer_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);

            if(cA1<55){
                if(contPies>=4){
                    if(pasoIzq){
                        pasoIzq=false;
                    }else{
                        pasoIzq=true;
                    }
                    contPies=0;
                }
                if(pasoIzq){
                    imprimirFigura(pieIzq2_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);
                    imprimirFigura(pieDer_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);
                }else{
                    imprimirFigura(pieIzq_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);
                    imprimirFigura(pieDer2_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);
                }

                contPies++;
            }else{
                imprimirFigura(pieIzq_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);
                imprimirFigura(pieDer_2D,6,0,desCuerpoY,(float)1,(float)1,Color.black);
            }



            cuerpo_3D = Trasladar3D(cuerpo_3D,traslacion[X],traslacion[Y],traslacion[Z]);
            cuerpo_2D = puntos3Da2D(cuerpo_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            imprimirFigura(cuerpo_2D,6,0,desCuerpoY,(float)1,(float)1,LCubos);

            for(int i = 0; i<cabezaT.length; i++){
                cabezaT[i] = Trasladar3D(cabezaT[i],traslacion[X],traslacion[Y],traslacion[Z]);
                cabezaT2[i] = puntos3Da2D(cabezaT[i],proyeccion[X],proyeccion[Y],proyeccion[Z]);
                imprimirFigura2(cabezaT2[i],0,0,(float)1,(float)1,cabezaL[i]);
            }

            for(int i = 0; i<cuerpoT.length; i++){
                if(((i == 4)||(i == 5)||(i == 6)||(i == 7))&&!f2){
                    if(((i == 4)||(i == 5))&&!f2){
                        cuerpoT2[i] = puntos3Da2D(cuerpoT[i],proyeccion[X],proyeccion[Y],proyeccion[Z]);
                        imprimirFigura2(cuerpoT2[i],0,desCuerpoY,(float)1,(float)1,Color.gray);
                    }
                }else{
                    cuerpoT[i] = Trasladar3D(cuerpoT[i],traslacion[X],traslacion[Y],traslacion[Z]);
                    cuerpoT2[i] = puntos3Da2D(cuerpoT[i],proyeccion[X],proyeccion[Y],proyeccion[Z]);
                    imprimirFigura2(cuerpoT2[i],0,desCuerpoY,(float)1,(float)1,cuerpoL[i]);
                }

            }

            pcRelleno3D = Trasladar3D(pcRelleno3D,traslacion[X],traslacion[Y],traslacion[Z]);
            pbRelleno3D = Trasladar3D(pbRelleno3D,traslacion[X],traslacion[Y],traslacion[Z]);
            pfRelleno3D = Trasladar3D(pfRelleno3D,traslacion[X],traslacion[Y],traslacion[Z]);
            pfRelleno2_3D = Trasladar3D(pfRelleno2_3D,traslacion[X],traslacion[Y],traslacion[Z]);

            pcRelleno2D = puntos3Da2D(pcRelleno3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            pbRelleno2D = puntos3Da2D(pbRelleno3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            pfRelleno2D = puntos3Da2D(pfRelleno3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
            pfRelleno2_2D = puntos3Da2D(pfRelleno2_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);

            for(int i = 0; i<pbRelleno2D.length/2;i++){//pbRelleno2D.length/2
                //Punto(pbRelleno2D[i],0,desCuerpoY,Color.red);
                if(i == 3){
                    relleno((int)pbRelleno2D[i][X], (int)pbRelleno2D[i][Y]+desCuerpoY, miArena, Color.black, pbColor[i]);
                }else{
                    if(((i == 4)||(i == 5)||(i == 6)||(i == 7))&&!f2){
                        if(((i == 6)||(i == 7))&&!f2){
                            relleno((int)pbRelleno2D[i][X], (int)pbRelleno2D[i][Y]+desCuerpoY, miArena, LCuero);
                        }
                    }else{
                        relleno((int)pbRelleno2D[i][X], (int)pbRelleno2D[i][Y]+desCuerpoY, miArena, pbColor[i]);
                    }

                }


            }

            for(int i = 0; i<pcRelleno2D.length/2;i++){
                //Punto(pcRelleno2D[i],0,0,Color.red);
                relleno((int)pcRelleno2D[i][X], (int)pcRelleno2D[i][Y], miArena, LCubos, pcColor[i]);
            }

            if(f1){
                if(pasoIzq&&cA1<55){
                    for(int i = 0; i<pfRelleno2_2D.length/2;i++){
                        //Punto(pfRelleno2_2D[i],0,0,Color.red);
                        //relleno((int)pfRelleno2_2D[i][X], (int)pfRelleno2_2D[i][Y], miArena, miMar, pfColor[i]);

                        if(i == 3){
                            relleno((int)pfRelleno2_2D[i][X], (int)pfRelleno2_2D[i][Y], miArena, miMar, Color.black, pfColor[i]);
                        }else{
                            relleno((int)pfRelleno2_2D[i][X], (int)pfRelleno2_2D[i][Y], miArena, miMar, pfColor[i]);
                        }

                    }
                }else{
                    for(int i = 0; i<pfRelleno2D.length/2;i++){
                        //Punto(pfRelleno2D[i],0,0,Color.red);
                        relleno((int)pfRelleno2D[i][X], (int)pfRelleno2D[i][Y], miArena, miMar, pfColor[i]);
                    }
                }

            }




            if(corazonVisible){
                corazon_3D = rotacionYO(corazon_3D,5);
                corazonB_3D = rotacionYO(corazonB_3D,5);
                corazon_2D = puntos3Da2D(corazon_3D,0,0,1);
                corazonB_2D = puntos3Da2D(corazonB_3D,0,0,1);
                imprimirCorazon(corazon_2D,desCoraX,desCoraY,(float)1,(float)1,Color.pink);
                imprimirCorazon(corazonB_2D,desCoraX,desCoraY,(float)1,(float)1,Color.red);

                for(int i = 0; i<corazones3D.length;i++){
                    corazones3D[i] = rotacionYO(corazones3D[i],5);
                    corazones2D[i] = puntos3Da2D(corazones3D[i],0,0,1);
                    imprimirCorazon(corazones2D[i],desCoraX,desCoraY,(float)1,(float)1,Color.pink);
                }

                for(int i = 0; i<corazonesB3D.length;i++){
                    corazonesB3D[i] = rotacionYO(corazonesB3D[i],5);
                    corazonesB2D[i] = puntos3Da2D(corazonesB3D[i],0,0,1);
                    imprimirCorazon(corazonesB2D[i],desCoraX,desCoraY,(float)1,(float)1,Color.red);
                }

                relleno(724+desCoraX,436+desCoraY, miArena, LPiel, Color.pink, Color.red);
            }

            if(corazonVisible2){

                for(int i = 0; i<corazones3D.length;i++){
                    corazones3D_2[i] = Trasladar3D(corazones3D_2[i],trasCour[X],trasCour[Y],trasCour[Z]);
                    corazones3D_2[i] = Escalar3D(corazones3D_2[i],esCour[X],esCour[Y],esCour[Z]);
                    corazones3D_2[i] = rotacionYO(corazones3D_2[i],5);
                    corazones2D_2[i] = puntos3Da2D(corazones3D_2[i],0,0,1);
                    imprimirCorazon(corazones2D_2[i],desCoraX,desCoraY,(float)1,(float)1,Color.pink);
                }

                for(int i = 0; i<corazonesB3D.length;i++){
                    corazonesB3D_2[i] = Trasladar3D(corazonesB3D_2[i],trasCour[X],trasCour[Y],trasCour[Z]);
                    corazonesB3D_2[i] = Escalar3D(corazonesB3D_2[i],esCour[X],esCour[Y],esCour[Z]);
                    corazonesB3D_2[i] = rotacionYO(corazonesB3D_2[i],5);
                    corazonesB2D_2[i] = puntos3Da2D(corazonesB3D_2[i],0,0,1);
                    imprimirCorazon(corazonesB2D_2[i],desCoraX,desCoraY,(float)1,(float)1,Color.red);
                }

                relleno4(724+desCoraX+trasCour[X],436+desCoraY+trasCour[Y], miArena, miMar, Color.green, LTraje, Color.red);
            }

            if(corazonVisible3){

                for(int i = 0; i<corazones3D_2.length;i++){
                    corazones3D_2[i] = rotacionYO(corazones3D_2[i],5);
                    corazones2D_2[i] = puntos3Da2D(corazones3D_2[i],0,0,1);
                    imprimirCorazon(corazones2D_2[i],desCoraX,desCoraY,(float)1,(float)1,Color.pink);
                }

                for(int i = 0; i<corazonesB3D.length;i++){
                    corazonesB3D_2[i] = rotacionYO(corazonesB3D_2[i],5);
                    corazonesB2D_2[i] = puntos3Da2D(corazonesB3D_2[i],0,0,1);
                    imprimirCorazon(corazonesB2D_2[i],desCoraX,desCoraY,(float)1,(float)1,Color.red);
                }

                relleno(724+desCoraX,436+desCoraY, miArena, miMar, LTraje, Color.red);
            }

            if(!f2&&f3){
                bIzq3D = rotacionZO(bIzq3D,4);
                bDer3D = rotacionZO(bDer3D,-4);

                mIzq3D = rotacionZO(mIzq3D, 4,bIzq3D[0][X], bIzq3D[0][Y], bIzq3D[0][Z]);
                mDer3D = rotacionZO(mDer3D,-4,bDer3D[0][X], bDer3D[0][Y], bDer3D[0][Z]);

                bIzq2D = puntos3Da2D(bIzq3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
                imprimirFigura3(bIzq2D,0,desCuerpoY,(float)1,(float)1,2,5,Color.green);
                mIzq2D = puntos3Da2D(mIzq3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);

                bDer2D = puntos3Da2D(bDer3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
                imprimirFigura3(bDer2D,0,desCuerpoY,(float)1,(float)1,1,4,Color.green);
                mDer2D = puntos3Da2D(mDer3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);

                /*Punto(new float[]{mDer2D[0][0], mDer2D[0][1]},0,0,Color.red);
                Punto(new float[]{mDer2D[1][0], mDer2D[1][1]},0,0,Color.red);
                Punto(new float[]{mIzq2D[0][0], mIzq2D[0][1]},0,0,Color.red);
                Punto(new float[]{mIzq2D[1][0], mIzq2D[1][1]},0,0,Color.red);*/
                //Punto(new float[]{bIzq[0][bIzq[0].length-2], bDer[1][bIzq[0].length-2]},0,0,Color.red);

                for(int i = 0; i<2;i++){
                    relleno((int)mIzq2D[i][0],(int)mIzq2D[i][1], miArena,LTraje, LPiel, LCabello, Color.pink, LCubos, Color.yellow, LCuero, Color.gray, manosColor[i]);
                    relleno((int)mDer2D[i][0],(int)mDer2D[i][1], miArena,LTraje, LPiel, LCabello, Color.pink, LCubos, Color.yellow, LCuero, Color.gray, manosColor[i]);
                }

            }

            if(!f2&&!f3){
                bIzq2D = puntos3Da2D(bIzq3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
                imprimirFigura3(bIzq2D,0,desCuerpoY,(float)1,(float)1,2,5,Color.green);

                bDer2D = puntos3Da2D(bDer3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
                imprimirFigura3(bDer2D,0,desCuerpoY,(float)1,(float)1,1,4,Color.green);

                for(int i = 0; i<2;i++){
                    relleno((int)mIzq2D[i][0],(int)mIzq2D[i][1], miArena,LTraje, LPiel, LCabello, Color.pink, LCubos, Color.yellow, LCuero, Color.gray, manosColor[i]);
                    relleno((int)mDer2D[i][0],(int)mDer2D[i][1], miArena,LTraje, LPiel, LCabello, Color.pink, LCubos, Color.yellow, LCuero, Color.gray, manosColor[i]);
                }
            }


        /*
        cuello_F_2D = puntos3Da2D(cuello_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(cuello_F_2D,0,desCuerpoY,(float)1,(float)1,Color.pink);
        hebilla_F_2D = puntos3Da2D(hebilla_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(hebilla_F_2D, 0,desCuerpoY,(float)1,(float)1,Color.yellow);
        manoIzq_F_2D = puntos3Da2D(manoIzq_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(manoIzq_F_2D,0,desCuerpoY,(float)1,(float)1,Color.pink);
        manoDer_F_2D = puntos3Da2D(manoDer_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(manoDer_F_2D,0,desCuerpoY,(float)1,(float)1,Color.pink);
        brazoIzq_F_2D = puntos3Da2D(brazoIzq_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(brazoIzq_F_2D,0,desCuerpoY,(float)1,(float)1,Color.green);
        brazoDer_F_2D = puntos3Da2D(brazoDer_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(brazoDer_F_2D,0,desCuerpoY,(float)1,(float)1,Color.green);
        cintoIzq_F_2D = puntos3Da2D(cintoIzq_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(cintoIzq_F_2D,0,desCuerpoY,(float)1,(float)1,Color.gray);
        cintoDer_F_2D = puntos3Da2D(cintoDer_F_3D,proyeccion[X],proyeccion[Y],proyeccion[Z]);
        imprimirFigura(cintoDer_F_2D,0,desCuerpoY,(float)1,(float)1,Color.gray); */


            cA1 = cA1+1;
        }
        cA2 = cA2+1;
        g.drawImage(imagenCompleta,0,0,null);

    }

    public void imprimirCorazon(float[][] fig2D, int desX, int desY, float ampX, float ampY, Color c){
        int n = fig2D.length/2;
        int nn = n;
        for(int i = 0; i<n-1;i++){
            Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            Linea((fig2D[n+i][X]*ampX)+desX, (fig2D[n+i][Y]*ampY)+desY, (fig2D[n+i+1][X]*ampX)+desX, (fig2D[n+i+1][Y]*ampY)+desY, c);
        }
        Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);
        Linea((fig2D[fig2D.length-1][X]*ampX)+desX, (fig2D[fig2D.length-1][Y]*ampY)+desY, (fig2D[nn][X]*ampX)+desX, (fig2D[nn][Y]*ampY)+desY, c);

        Linea((fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, (fig2D[0+n][X]*ampX)+desX, (fig2D[0+n][Y]*ampY)+desY, c);
        Linea((fig2D[8][X]*ampX)+desX, (fig2D[8][Y]*ampY)+desY, (fig2D[8+n][X]*ampX)+desX, (fig2D[8+n][Y]*ampY)+desY, c);
        Linea((fig2D[5][X]*ampX)+desX, (fig2D[5][Y]*ampY)+desY, (fig2D[5+n][X]*ampX)+desX, (fig2D[5+n][Y]*ampY)+desY, c);
        Linea((fig2D[11][X]*ampX)+desX, (fig2D[11][Y]*ampY)+desY, (fig2D[11+n][X]*ampX)+desX, (fig2D[11+n][Y]*ampY)+desY, c);


    }

    public void Curva( int cantPuntos, int ancho, int alto, Color c){
        double inicioR = -Math.PI, finR = 2*Math.PI;
        int posInicialX = 0, posInicialY = 240;
        int posFinalX;
        int[] puntosX = new int[cantPuntos];
        int[] puntosY = new int[cantPuntos];
        double[] puntosXgrados = new double[cantPuntos];

        double temp = 0;

        posFinalX = posInicialX+(2*ancho);
        int interPuntos= (2*ancho)/(cantPuntos-1); //
        double interGrados= (finR-inicioR)/(cantPuntos-1);//(PI-0)/7
        //System.out.println("interGrados:"+interGrados);

        puntosX[0] = posInicialX;//200
        puntosX[cantPuntos-1] = posFinalX;
        puntosXgrados[0] = inicioR; //0
        puntosXgrados[cantPuntos-1] = finR; //PI
        puntosY[0] = posInicialY;
        puntosY[cantPuntos-1] = posInicialY;

        //System.out.println("Coordenadas: X["+0+"]:"+puntosX[0]+" Y["+0+"]:"+puntosY[0]+" gradosX:"+puntosXgrados[0]);
        for(int i = 1; i<cantPuntos-1; i++){
            puntosX[i] = puntosX[i-1]+interPuntos;
            puntosXgrados[i] = puntosXgrados[i-1]+interGrados;
            temp = - Math.sin(puntosXgrados[i]);
            puntosY[i] = (int) (temp*alto)+posInicialY+(i*2);
            //System.out.println("Coordenadas: X["+i+"]:"+puntosX[i]+" Y["+i+"]:"+puntosY[i]+" temp:"+temp+" gradosX:"+puntosXgrados[i]);
        }

        puntosY[cantPuntos-1] =(int) (temp*alto)+posInicialY+(cantPuntos*2);

        //System.out.println("Coordenadas: X["+(cantPuntos-1)+"]:"+puntosX[cantPuntos-1]+" Y["+(cantPuntos-1)+"]:"+puntosY[cantPuntos-1]+" gradosX:"+puntosXgrados[cantPuntos-1]);

        for(int i = 0; i<puntosX.length-2;i++){
            Linea(puntosX[i], puntosY[i], puntosX[i+1], puntosY[i+1], c);
            //Linea(puntosX[i]-1, puntosY[i]-1, puntosX[i+1]+1, puntosY[i+1]+1, c);
        }
    }
    public void Curva3(double inicioR, double finR, int posInicialX, int posInicialY, int radio, int t, Color c){
        double interGrados= Math.abs(finR-inicioR)/(t-1);
        int[] puntosX = new int[t];
        int[] puntosY = new int[t];
        double gradTemp = inicioR;
        double temp = 0;

        puntosX[0] = posInicialX;
        puntosY[0] = posInicialY;
        //System.out.println("Coordenadas: X["+0+"]:"+puntosX[0]+" Y["+0+"]:"+puntosY[0]);
        for(int i = 0; i<t; i++){
            temp = -funcionY3_7(gradTemp);
            puntosY[i] = (int)(temp*radio)+posInicialY;
            temp = funcionX3_7(gradTemp);
            puntosX[i] = (int)(temp*radio)+posInicialX;
            gradTemp += interGrados;
            //System.out.println("Coordenadas: X["+i+"]:"+puntosX[i]+" Y["+i+"]:"+puntosY[i]+" temp:"+temp);
        }
        for(int i = 0; i<puntosX.length-2;i++){
            Linea(puntosX[i], puntosY[i], puntosX[i+1], puntosY[i+1], c);
            //Linea(puntosX[i]-1, puntosY[i]-1, puntosX[i+1]+1, puntosY[i+1]+1, c);
        }
    }
    public double funcionX3_7(double a){ //x debe estar en radianes
        double frac = ((double)17/(double)7)*a;
        double x = 17*(Math.cos(a));
        double y = 7*(Math.cos(frac));

        return  x+y;
    }
    public double funcionY3_7(double a){ //x debe estar en radianes
        double frac = ((double)17/(double)7)*a;
        double x = 17*(Math.sin(a));
        double y = 7*(Math.sin(frac));

        return  x-y;
    }

    public void RellenarCubo(float[][] centros, float[][] caras, float omitir, int desX, int desY, int ampX, int ampY, Color[] c){
        for(int i = caras.length-1; i >= 0 ; i--){
            if(caras[i][0]==omitir||caras[i][1]==omitir||caras[i][2]==omitir||caras[i][3]==omitir){

            }else{
                //Punto(new float[]{centros[i][X]*ampX,centros[i][Y]*ampY},desX, desY, Color.red);
                rellenar((int)(centros[i][X]*ampX)+desX, (int)(centros[i][Y]*ampY)+desY, unknown, c[i]);
            }
        }
    }

    public void Punto(float [] p, int desX, int desY,Color c){

        int x = (int)p[X], y = (int)p[Y];

        putPixel(x+desX,y+desY,c);
        putPixel(x+1+desX,y+desY,c);
        putPixel(x-1+desX,y+desY,c);
        putPixel(x+desX,y+1+desY,c);
        putPixel(x+desX,y-1+desY,c);

    }

    public float [][] Trasladar3D(float[][] fig3D, float dx, float dy, float dz){
        float temp [] = new float[3];
        float fig [][] = new float[fig3D.length][3];

        for(int i = 0; i<fig3D.length; i++){
            temp = trasladarPunto(fig3D[i][X], fig3D[i][Y], fig3D[i][Z], dx, dy, dz);
            fig[i][X] = temp[X];
            fig[i][Y] = temp[Y];
            fig[i][Z] = temp[Z];

        }

        return fig;
    }

    public void rellenar(int x,int y, Color fondo, Color cambio){
        if(fondo.getRGB()==imagenCompleta.getRGB(x, y)){
            this.putPixel(x, y, cambio);
            this.rellenar(x-1,y,fondo,cambio);
            this.rellenar(x+1,y,fondo, cambio);
            this.rellenar(x,y-1,fondo,cambio);
            this.rellenar(x,y+1,fondo,cambio);
        }
    }

    public void relleno(int x,int y, Color fondo, Color relleno){
        Color color=null;
        if((x<this.getWidth()&&y<this.getHeight())&&(x>0&&y>0)){
            color=getPixel(x,y);
            //pPint++;
            if(color.equals(fondo)){
                //System.out.println("hi");
                this.putPixel(x, y,relleno);
                this.relleno(x-1,y,fondo,relleno);
                this.relleno(x+1,y,fondo,relleno);
                this.relleno(x,y-1,fondo,relleno);
                this.relleno(x,y+1,fondo,relleno);
            }
        }
    }
    public void relleno(int x,int y, Color fondo, Color op2, Color relleno){
        Color color=null;
        if((x<this.getWidth()&&y<this.getHeight())&&(x>0&&y>0)){
            color=getPixel(x,y);
            //pPint++;
            if(color.equals(fondo)||color.equals(op2)){
                //System.out.println("hi");
                this.putPixel(x, y,relleno);
                this.relleno(x-1,y,fondo,op2,relleno);
                this.relleno(x+1,y,fondo,op2,relleno);
                this.relleno(x,y-1,fondo,op2,relleno);
                this.relleno(x,y+1,fondo,op2,relleno);
            }
        }
    }
    public void relleno(int x,int y, Color fondo, Color op2, Color op3, Color relleno){
        Color color=null;
        if((x<this.getWidth()&&y<this.getHeight())&&(x>0&&y>0)){
            color=getPixel(x,y);
            //pPint++;
            if(color.equals(fondo)||color.equals(op2)||color.equals(op3)){
                //System.out.println("hi");
                this.putPixel(x, y,relleno);
                this.relleno(x-1,y,fondo,op2,op3,relleno);
                this.relleno(x+1,y,fondo,op2,op3,relleno);
                this.relleno(x,y-1,fondo,op2,op3,relleno);
                this.relleno(x,y+1,fondo,op2,op3,relleno);
            }
        }
    }
    public void relleno4(int x,int y, Color fondo, Color op2, Color op3, Color op4, Color relleno){
        Color color=null;
        if((x<this.getWidth()&&y<this.getHeight())&&(x>0&&y>0)){
            color=getPixel(x,y);
            //pPint++;
            if(color.equals(fondo)||color.equals(op2)){
                //System.out.println("hi");
                this.putPixel(x, y,relleno);
                this.relleno4(x-1,y,fondo,op2,op3,op4,relleno);
                this.relleno4(x+1,y,fondo,op2,op3,op4,relleno);
                this.relleno4(x,y-1,fondo,op2,op3,op4,relleno);
                this.relleno4(x,y+1,fondo,op2,op3,op4,relleno);
            }
        }
    }

    public void relleno(int x,int y, Color fondo, Color op2, Color op3, Color op4, Color op5,Color relleno){
        Color color=null;
        if((x<this.getWidth()&&y<this.getHeight())&&(x>0&&y>0)){
            color=getPixel(x,y);
            //pPint++;
            if(color.equals(fondo)||color.equals(op2)||color.equals(op3)||color.equals(op4)||color.equals(op5)){
                //System.out.println("hi");
                this.putPixel(x, y,relleno);
                this.relleno(x-1,y,fondo,op2,op3,op4,op5,relleno);
                this.relleno(x+1,y,fondo,op2,op3,op4,op5,relleno);
                this.relleno(x,y-1,fondo,op2,op3,op4,op5,relleno);
                this.relleno(x,y+1,fondo,op2,op3,op4,op5,relleno);
            }
        }
    }

    public void relleno(int x,int y, Color fondo, Color op2, Color op3, Color op4, Color op5, Color op6, Color op7, Color op8, Color op9,Color relleno){
        Color color=null;
        if((x<this.getWidth()&&y<this.getHeight())&&(x>0&&y>0)){
            color=getPixel(x,y);
            //pPint++;
            if(color.equals(fondo)||color.equals(op2)||color.equals(op3)||color.equals(op4)||color.equals(op5)||color.equals(op6)||color.equals(op7)||color.equals(op8)||color.equals(op9)){
                //System.out.println("hi");
                this.putPixel(x, y,relleno);
                this.relleno(x-1,y,fondo,op2,op3,op4,op5,op6,op7,op8,op9,relleno);
                this.relleno(x+1,y,fondo,op2,op3,op4,op5,op6,op7,op8,op9,relleno);
                this.relleno(x,y-1,fondo,op2,op3,op4,op5,op6,op7,op8,op9,relleno);
                this.relleno(x,y+1,fondo,op2,op3,op4,op5,op6,op7,op8,op9,relleno);
            }
        }
    }

    public float[] trasladarPunto(float x, float y, float z, float dx, float dy, float dz){ //Arreglo puntos, movimiento en x, movimiento en y
        float[] P={x, y, z, 1};

        float[][] T={
                {1,0,0,dx},
                {0,1,0,dy},
                {0,0,1,dz},
                {0,0,0,1}
        };

        P[0]=P[0]*T[0][0]+P[1]*T[0][1]+P[2]*T[0][2]+P[3]*T[0][3];
        P[1]=P[0]*T[1][0]+P[1]*T[1][1]+P[2]*T[1][2]+P[3]*T[1][3];
        P[2]=P[0]*T[2][0]+P[1]*T[2][1]+P[2]*T[2][2]+P[3]*T[2][3];
        P[3]=P[0]*T[3][0]+P[1]*T[3][1]+P[3]*T[3][2]+P[3]*T[3][3];
        //System.out.println("P[0]:"+P[0]+" P[1]:"+P[1]+"P[2]:"+P[2]);
        float end[]={(float)P[0],(float)P[1],(float)P[2]};

        return end;

    }
    public float [][] Escalar3D(float[][] figu3D, double sx, double sy, double sz){
        float[][] fig3D = new float[figu3D.length][3];
        float valX = figu3D[0][X], valY = figu3D[0][Y], valZ = figu3D[0][Z];
        for(int i = 0; i<fig3D.length; i++){
            fig3D[i][X]= figu3D[i][X]-valX;
            fig3D[i][Y]= figu3D[i][Y]-valY;
            fig3D[i][Z]= figu3D[i][Z]-valZ;
        }

        float temp [] = new float[3];
        float fig [][] = new float[fig3D.length][3];

        for(int i = 0; i<fig3D.length; i++){
            temp = escalarPunto(fig3D[i][X], fig3D[i][Y], fig3D[i][Z], sx, sy, sz);
            fig[i][X] = temp[X]+valX;
            fig[i][Y] = temp[Y]+valY;
            fig[i][Z] = temp[Z]+valZ;

        }

        return fig;
    }


    public float [][] Escalar3DH(float[][] figu3D, double sx, double sy, double sz){
        float[][] fig3D = new float[figu3D.length][3];
        float valX = 724, valY = 436, valZ = 10;
        for(int i = 0; i<fig3D.length; i++){
            fig3D[i][X]= figu3D[i][X]-valX;
            fig3D[i][Y]= figu3D[i][Y]-valY;
            fig3D[i][Z]= figu3D[i][Z]-valZ;
        }

        float temp [] = new float[3];
        float fig [][] = new float[fig3D.length][3];

        for(int i = 0; i<fig3D.length; i++){
            temp = escalarPunto(fig3D[i][X], fig3D[i][Y], fig3D[i][Z], sx, sy, sz);
            fig[i][X] = temp[X]+valX;
            fig[i][Y] = temp[Y]+valY;
            fig[i][Z] = temp[Z]+valZ;

        }

        return fig;
    }

    public float[] escalarPunto(float x, float y, float z, double sx, double sy, double sz){ //Arreglo puntos, movimiento en x, movimiento en y
        double[] P={x, y, z, 1};

        double[][] T={
                {sx,0,0,0},
                {0,sy,0,0},
                {0,0,sz,0},
                {0,0,0,1}
        };

        P[0]=Math.ceil(P[0]*T[0][0]+P[1]*T[0][1]+P[2]*T[0][2]+P[3]*T[0][3]);
        P[1]=Math.ceil(P[0]*T[1][0]+P[1]*T[1][1]+P[2]*T[1][2]+P[3]*T[1][3]);
        P[2]=Math.ceil(P[0]*T[2][0]+P[1]*T[2][1]+P[2]*T[2][2]+P[3]*T[2][3]);
        P[3]=P[0]*T[3][0]+P[1]*T[3][1]+P[3]*T[3][2]+P[3]*T[3][3];
        //System.out.println("P[0]:"+P[0]+" P[1]:"+P[1]);
        float end[]={(float)P[0],(float)P[1],(float)P[2]};

        return end;

    }


    public float [][] rotacionX(float fig3D[][], int angulo){
        float[][] fig = new float[fig3D.length][3];


        for(int i = 0; i<fig3D.length; i++){

            fig[i][X] = fig3D[i][X];
            fig[i][Y] = (float)((fig3D[i][Y]*Math.cos(Math.toRadians(angulo)))-(fig3D[i][Z]*(Math.sin(Math.toRadians(angulo)))));
            fig[i][Z] = (float)((fig3D[i][Y]*Math.sin(Math.toRadians(angulo)))+(fig3D[i][Z]*(Math.cos(Math.toRadians(angulo)))));
        }

        return fig;
    }

    public float [][] rotacionYO(float figu3D[][], int angulo){
        float[][] fig = new float[figu3D.length][3];
        float[][] fig3D = new float[figu3D.length][3];
        float valX = 724, valY = 436, valZ = 10;
        for(int i = 0; i<fig3D.length; i++){
            fig3D[i][X]= figu3D[i][X]-valX;
            fig3D[i][Y]= figu3D[i][Y]-valY;
            fig3D[i][Z]= figu3D[i][Z]-valZ;
        }

        for(int i = 0; i<fig3D.length; i++){

            fig[i][X] = valX+(float)((fig3D[i][X]*Math.cos(Math.toRadians(angulo)))+(fig3D[i][Z]*(Math.sin(Math.toRadians(angulo)))));
            fig[i][Y] = valY+fig3D[i][Y];
            fig[i][Z] = valZ+(float)((-fig3D[i][X]*Math.sin(Math.toRadians(angulo)))+(fig3D[i][Z]*(Math.cos(Math.toRadians(angulo)))));
        }

        return fig;
    }

    public float [][] rotacionY(float fig3D[][], int angulo){
        float[][] fig = new float[fig3D.length][3];


        for(int i = 0; i<fig3D.length; i++){

            fig[i][X] = (float)((fig3D[i][X]*Math.cos(Math.toRadians(angulo)))+(fig3D[i][Z]*(Math.sin(Math.toRadians(angulo)))));
            fig[i][Y] = fig3D[i][Y];
            fig[i][Z] = (float)((-fig3D[i][X]*Math.sin(Math.toRadians(angulo)))+(fig3D[i][Z]*(Math.cos(Math.toRadians(angulo)))));
        }

        return fig;
    }

    public float [][] rotacionZ(float fig3D[][], int angulo){
        float[][] fig = new float[fig3D.length][3];


        for(int i = 0; i<fig3D.length; i++){

            fig[i][Z] = fig3D[i][Z];
            fig[i][X] = (float)((fig3D[i][X]*Math.cos(Math.toRadians(angulo)))-(fig3D[i][Y]*(Math.sin(Math.toRadians(angulo)))));
            fig[i][Y] = (float)((fig3D[i][X]*Math.sin(Math.toRadians(angulo)))+(fig3D[i][Y]*(Math.cos(Math.toRadians(angulo)))));
        }

        return fig;
    }

    public float [][] rotacionZO(float figu3D[][], int angulo){
        float[][] fig = new float[figu3D.length][3];
        float[][] fig3D = new float[figu3D.length][3];
        float valX = figu3D[0][X], valY = figu3D[0][Y], valZ = figu3D[0][Z];
        for(int i = 0; i<fig3D.length; i++){
            fig3D[i][X]= figu3D[i][X]-valX;
            fig3D[i][Y]= figu3D[i][Y]-valY;
            fig3D[i][Z]= figu3D[i][Z]-valZ;
        }

        for(int i = 0; i<fig3D.length; i++){

            fig[i][Z] = valZ+fig3D[i][Z];
            fig[i][X] = (float)((fig3D[i][X]*Math.cos(Math.toRadians(angulo)))-(fig3D[i][Y]*(Math.sin(Math.toRadians(angulo)))))+valX;
            fig[i][Y] = (float)((fig3D[i][X]*Math.sin(Math.toRadians(angulo)))+(fig3D[i][Y]*(Math.cos(Math.toRadians(angulo)))))+valY;
        }

        return fig;
    }

    public float [][] rotacionZO(float figu3D[][], int angulo, float valX, float valY, float valZ){
        float[][] fig = new float[figu3D.length][3];
        float[][] fig3D = new float[figu3D.length][3];
        for(int i = 0; i<fig3D.length; i++){
            fig3D[i][X]= figu3D[i][X]-valX;
            fig3D[i][Y]= figu3D[i][Y]-valY;
            fig3D[i][Z]= figu3D[i][Z]-valZ;
        }

        for(int i = 0; i<fig3D.length; i++){

            fig[i][Z] = valZ+fig3D[i][Z];
            fig[i][X] = (float)((fig3D[i][X]*Math.cos(Math.toRadians(angulo)))-(fig3D[i][Y]*(Math.sin(Math.toRadians(angulo)))))+valX;
            fig[i][Y] = (float)((fig3D[i][X]*Math.sin(Math.toRadians(angulo)))+(fig3D[i][Y]*(Math.cos(Math.toRadians(angulo)))))+valY;
        }

        return fig;
    }

    public float [][] fuga(float figu3D[][], float [] fuga1){
        float[][] fig3D = new float[figu3D.length][3];
        float valX = figu3D[0][X], valY = figu3D[0][Y], valZ = figu3D[0][Z];
        for(int i = 0; i<fig3D.length; i++){
            fig3D[i][X]= figu3D[i][X]-valX;
            fig3D[i][Y]= figu3D[i][Y]-valY;
            fig3D[i][Z]= figu3D[i][Z]-valZ;
        }
        float[][] fig2D = new float[fig3D.length][2];
        float[] temp = new float[2];

        for(int i = 0; i<fig3D.length; i++){
            fig2D[i][0]=+((fig3D[i][0]*fuga1[2])-(fig3D[i][2]*fuga1[0]))/(fuga1[Z]-fig3D[i][2]);
            fig2D[i][1]=((fig3D[i][1]*fuga1[2])-(fig3D[i][2]*fuga1[1]))/(fuga1[Z]-fig3D[i][2]);
        }

        return fig2D;
    }
    public float [][] fuga1(float fig3D[][], float cx, float cy, float cz){
        float[][] fig2D = new float[fig3D.length][2];
        float[] temp = new float[2];

        for(int i = 0; i<fig3D.length; i++){
            temp = fugaPuntos(fig3D[i], cx, cy, cz);
            fig2D[i][X] = temp[X]*3;
            fig2D[i][Y] = temp[Y]*3;
            System.out.println("x:"+fig2D[i][X]+" y:"+fig2D[i][Y]);
        }

        return fig2D;
    }
    public float [] fugaPuntos(float puntos3D[], float cx, float cy, float cz){

        float[] puntos2D = new float[2];
        int neg = 1;
        /*if(cz >= 0){
            neg = 1;
        }else{
            neg = -1;
        }*/


        //puntos2D[X]=puntos3D[X]+((puntos3D[X]-cx)*(puntos3D[Z]/(cz-puntos3D[Z])));
        //puntos2D[Y]=puntos3D[Y]+((puntos3D[Y]-cy)*(puntos3D[Z]/(cz-puntos3D[Z])));
        puntos2D[X]=(((cz*puntos3D[X])-(cx*puntos3D[Z]))/(cz-puntos3D[Z]));
        puntos2D[Y]=neg*((cz*puntos3D[Y])-(cy*puntos3D[Z]))/(cz-puntos3D[Z]);


        return puntos2D;
    }

    public float [][] formulaRara1(float fig3D[][], float d){ //coordenada observadro (0,0,0)
        float[][] fig2D = new float[fig3D.length][2];
        float[] temp = new float[2];

        for(int i = 0; i<fig3D.length; i++){
            fig2D[i][X] = fig3D[i][X]*((float)d/(float)(fig3D[i][Z]+d));
            fig2D[i][Y] = fig3D[i][Y]*((float)d/(float)(fig3D[i][Z]+d));
            System.out.println("x:"+fig2D[i][X]+" y:"+fig2D[i][Y]);
        }

        return fig2D;
    }


    public float [][] puntos3Da2D(float fig3D[][], int dx, int dy, int dz){
        float[][] fig2D = new float[fig3D.length][2];

        for(int i = 0; i<fig3D.length; i++){
            fig2D[i][X] = (fig3D[i][X]-((dx/dz)*fig3D[i][Z]));
            fig2D[i][Y] = (fig3D[i][Y]-((dy/dz)*fig3D[i][Z]));
            //System.out.println("x:"+fig2D[i][X]+" y:"+fig2D[i][Y]);
        }

        return fig2D;
    }

    public void imprimirFigura2(float[][] fig2D, int desX, int desY, float ampX, float ampY, Color c){
        int n = fig2D.length/2;
        int nn = n;
        for(int i = 0; i<n-1;i++){
            Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            //System.out.println("Rotación"+i);
        }
        Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

    }

    public void imprimirFigura(float[][] fig2D, int desX, int desY, float ampX, float ampY, Color c){
        int n = fig2D.length/2;
        int nn = n;
        for(int i = 0; i<n-1;i++){
            Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            //System.out.println("Rotación"+i);
        }
        Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

        for(int i = nn; i<fig2D.length-1;i++){
            Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            //System.out.println("Rotación"+i);
        }
        Linea((fig2D[fig2D.length-1][X]*ampX)+desX, (fig2D[fig2D.length-1][Y]*ampY)+desY, (fig2D[nn][X]*ampX)+desX, (fig2D[nn][Y]*ampY)+desY, c);

        for(int i = 0; i <n;i++){
            Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, c);
        }
    }
    public void imprimirFigura(float[][] fig2D, float[][] fig3D, int desX, int desY, float ampX, float ampY, Color c){
        int n = fig2D.length/2;
        int nn = n;

        float minZ, omitir = 0;

        minZ = fig3D[0][Z];
        for(int i = 0; i < fig3D.length; i++){
            if(minZ>fig3D[i][Z]){
                minZ = fig3D[i][Z];
                omitir = i;
            }
        }


        for(int i = 0; i<n-1;i++){
            if(i!=omitir&&i+1!=omitir){
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            }
            //System.out.println("Rotación"+i);
        }
        if(n-1!=omitir&&0!=omitir)
            Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

        for(int i = nn; i<fig2D.length-1;i++){
            if(i!=omitir&&i+1!=omitir)
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            //System.out.println("Rotación"+i);
        }
        if(fig2D.length-1!=omitir&&nn!=omitir)
            Linea((fig2D[fig2D.length-1][X]*ampX)+desX, (fig2D[fig2D.length-1][Y]*ampY)+desY, (fig2D[nn][X]*ampX)+desX, (fig2D[nn][Y]*ampY)+desY, c);

        for(int i = 0; i<n;i++){
            if(i!=omitir&&i+n!=omitir)
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, c);
        }
    }
    public void imprimirFigura(float[][] fig2D, int omitir, int desX, int desY, float ampX, float ampY, Color c){
        int n = fig2D.length/2;
        int nn = n;

        for(int i = 0; i<n-1;i++){
            if(i!=omitir&&i+1!=omitir){
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            }
            //System.out.println("Rotación"+i);
        }
        if(n-1!=omitir&&0!=omitir)
            Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

        for(int i = nn; i<fig2D.length-1;i++){
            if(i!=omitir&&i+1!=omitir)
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            //System.out.println("Rotación"+i);
        }
        if(fig2D.length-1!=omitir&&nn!=omitir)
            Linea((fig2D[fig2D.length-1][X]*ampX)+desX, (fig2D[fig2D.length-1][Y]*ampY)+desY, (fig2D[nn][X]*ampX)+desX, (fig2D[nn][Y]*ampY)+desY, c);

        for(int i = 0; i<n;i++){
            if(i!=omitir&&i+n!=omitir)
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, c);
        }
    }
    public void imprimirFigura(float[][] fig2D, int omitir, int omitir2, int desX, int desY, float ampX, float ampY, Color c){
        int n = fig2D.length/2;
        int nn = n;

        for(int i = 0; i<n-1;i++){
            if((i!=omitir&&i+1!=omitir)&&(i!=omitir2&&i+1!=omitir2)){
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
                Linea((fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, (fig2D[i+n+1][X]*ampX)+desX, (fig2D[i+n+1][Y]*ampY)+desY, c);
            }
            //System.out.println("Rotación"+i);
        }
        if((n-1!=omitir&&0!=omitir)&&(n-1!=omitir2&&0!=omitir2))
            Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

        if((fig2D.length-1!=omitir&&nn!=omitir)&&(fig2D.length-1!=omitir2&&nn!=omitir2))
            Linea((fig2D[fig2D.length-1][X]*ampX)+desX, (fig2D[fig2D.length-1][Y]*ampY)+desY, (fig2D[nn][X]*ampX)+desX, (fig2D[nn][Y]*ampY)+desY, c);

        for(int i = 0; i<n;i++){
            if((i!=omitir&&i+n!=omitir)&&(i!=omitir2&&i+n!=omitir2))
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, c);
        }
    }

    public void imprimirFiguraO(float[][] fig2D, int omitir, int omitir2, int desX, int desY, float ampX, float ampY, Color c){
        int n = fig2D.length/2;
        int nn = n;

        for(int i = 0; i<n-1;i++){
            if((i==omitir||i+1==omitir)||(i==omitir2||i+1==omitir2)){}else{
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            }
            //System.out.println("Rotación"+i);
        }
        for(int i = n; i<fig2D.length-1;i++){
            if((i==omitir||i+1==omitir)||(i==omitir2||i+1==omitir2)){}else{
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
            }
            //System.out.println("Rotación"+i);
        }
        if((n-1==omitir||0==omitir)||(n-1==omitir2||0==omitir2)){

        }else
            Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

        if((fig2D.length-1==omitir||nn==omitir)||(fig2D.length-1==omitir2||nn==omitir2)){}else
            Linea((fig2D[fig2D.length-1][X]*ampX)+desX, (fig2D[fig2D.length-1][Y]*ampY)+desY, (fig2D[nn][X]*ampX)+desX, (fig2D[nn][Y]*ampY)+desY, c);

        for(int i = 0; i<n;i++){
            if((i==omitir||i+n==omitir)||(i==omitir2||i+n==omitir2)){}else
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, c);
        }
    }

    public void imprimirFiguraH(float[][] figu2D, int omitir, int desX, int desY, float ampX, float ampY, Color c){
        int n = figu2D.length/2;
        int nn = n;

        float[][] fig2D = new float[figu2D.length][3];
        float valX = figu2D[0][X], valY = figu2D[0][Y];
        for(int i = 0; i<fig2D.length; i++){
            figu2D[i][X]= fig2D[i][X]-valX;
            figu2D[i][Y]= fig2D[i][Y]-valY;
        }

        desX = desX+(int)valX;
        desY = desY+(int)valY;

        for(int i = 0; i<n-1;i++){
            if((i!=omitir&&i+1!=omitir)){
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);
                Linea((fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, (fig2D[i+n+1][X]*ampX)+desX, (fig2D[i+n+1][Y]*ampY)+desY, c);
            }
            //System.out.println("Rotación"+i);
        }
        if((n-1!=omitir&&0!=omitir))
            Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

        if((fig2D.length-1!=omitir&&nn!=omitir))
            Linea((fig2D[fig2D.length-1][X]*ampX)+desX, (fig2D[fig2D.length-1][Y]*ampY)+desY, (fig2D[nn][X]*ampX)+desX, (fig2D[nn][Y]*ampY)+desY, c);

        for(int i = 0; i<n;i++){
            if((i!=omitir&&i+n!=omitir))
                Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+n][X]*ampX)+desX, (fig2D[i+n][Y]*ampY)+desY, c);
        }
    }

    public void imprimirFigura3(float[][] fig2D, int desX, int desY, float ampX, float ampY, int m1, int m2, Color c){
        int n = fig2D.length/2;
        int nn = n;
        for(int i = 0; i<n-1;i++){
            Linea((fig2D[i][X]*ampX)+desX, (fig2D[i][Y]*ampY)+desY, (fig2D[i+1][X]*ampX)+desX, (fig2D[i+1][Y]*ampY)+desY, c);;
        }
        Linea((fig2D[n-1][X]*ampX)+desX, (fig2D[n-1][Y]*ampY)+desY, (fig2D[0][X]*ampX)+desX, (fig2D[0][Y]*ampY)+desY, c);

        Linea((fig2D[m1][X]*ampX)+desX, (fig2D[m1][Y]*ampY)+desY, (fig2D[m2][X]*ampX)+desX, (fig2D[m2][Y]*ampY)+desY, c);

    }

    public float [][] PoliProfundo(float[] x, float[] y, float[] z){
        float[][] fig3D = new float[(x.length)*2][3];
        int n = x.length;

        for(int i = 0; i<x.length; i++){
            fig3D[i][X] = x[i];
            fig3D[i+n][X] = x[i];
            fig3D[i][Y] = y[i];
            fig3D[i+n][Y] = y[i];
            fig3D[i][Z] = z[0];
            fig3D[i+n][Z] = z[1];
        }

        return fig3D;
    }
    public float [][] PoliCaras(float[][] fig3D){
        return new float[][]{
                {0,1,2,3},
                {4,5,6,7},
                {0,1,5,4},
                {3,2,6,7},
                {0,3,7,4},
                {1,2,6,5}
        };
    }
    public float [][] PoliCentro(float[][] fig3D, float z){
        float n = z/(float)2;
        return new float[][]{
                {fig3D[0][X]+n,fig3D[0][Y]+n,fig3D[0][Z]},
                {fig3D[4][X]+n,fig3D[4][Y]+n,fig3D[4][Z]},
                {fig3D[0][X]+n,fig3D[0][Y], fig3D[0][Z]+n},
                {fig3D[3][X]+n,fig3D[3][Y], fig3D[3][Z]+n},
                {fig3D[0][X],fig3D[0][Y]+n, fig3D[0][Z]+n},
                {fig3D[1][X],fig3D[0][Y]+n, fig3D[0][Z]+n},
        };
    }

    public void putPixel(int x, int y, Color c){
        bufferPixel.setRGB(0, 0, c.getRGB());
        imagenCompleta.getGraphics().drawImage(bufferPixel, x, y, this);

    }
    public Color getPixel(int x, int y){
        return new Color(imagenCompleta.getRGB(x, y));
    }
    public void Poligono(float[] x, float[] y, Color c){
        if(x.length != y.length){
            //System.out.println("Error");
        }else{
            //System.out.println("Iniciar Dibujo x");
            int nVertices = x.length;
            for(int i = 0; i<nVertices-1;i++){
                Linea(x[i], y[i], x[i+1], y[i+1], c);
                //System.out.println("Rotación"+i);
            }
            Linea(x[nVertices-1], y[nVertices-1], x[0], y[0], c);
        }
    }
    public void Rectangulo(float x1,float y1, float x2, float y2, Color c){
        float[] rectX= {x1,x1,x2,x2};
        float[] rectY= {y1,y2,y2,y1};

        Poligono(rectX, rectY, c);
    }
    public void Circulo(float centroX, float centroY, float radio,Color c){
        Elipse(centroX, centroY, radio, radio, c);
    }
    public void Elipse(float centroX, float centroY,float radioX, float radioY, Color color){
        putPixel(Math.round(centroX),Math.round(centroY+radioY),color);
        putPixel(Math.round(centroX),Math.round(centroY-radioY),color);

        float tempRadioX,tempRadioY,p1,p2;

        float x=0;
        float y=radioY;

        tempRadioX=(float) Math.pow(radioX,2);
        tempRadioY=(float) Math.pow(radioY,2);

        p1=(float) (tempRadioY-(tempRadioX*radioY)+(0.25*tempRadioX));

        while((tempRadioY*x)<(tempRadioX*y)){
            if(p1<0){
                x++;
                p1=p1+(2*tempRadioY*x)+tempRadioY;
            }else{
                x++;
                y--;
                p1=p1+(2*tempRadioY*x)-(2*tempRadioX*y)+tempRadioY;
            }
            seccionElipse(centroX,centroY,x,y,color);
        }
        p2=(float) ((tempRadioY)*Math.pow((x+0.5),2)+(tempRadioX)*Math.pow((y-1),2)-(tempRadioX*tempRadioY));
        while(y>0){
            if (p2>0){
                y--;
                p2=p2-(2*tempRadioX*y) +tempRadioX;
            }else{
                x++;
                y--;
                p2=p2+ (2*tempRadioY*x)-(2*tempRadioX*y)+tempRadioX;
            }
            seccionElipse(centroX,centroY,x,y,color);
        }
    }
    public void seccionElipse(float centroX, float centroY,float x, float y, Color c){
        putPixel(Math.round(centroX+x),Math.round(centroY+y),c);
        putPixel(Math.round(centroX-x),Math.round(centroY+y),c);
        putPixel(Math.round(centroX+x),Math.round(centroY-y),c);
        putPixel(Math.round(centroX-x),Math.round(centroY-y),c);
    }
    public void Linea(float x1, float y1, float x2, float y2, Color c){
        //LINEA DDA
        float dx = dif(x1, x2), dy = dif(y1,y2), steps;
        float xinc, yinc, x,y;

        if(Math.abs(dx)>Math.abs(dy)){
            steps = Math.abs(dx);
        }else{
            steps = Math.abs(dy);
        }

        xinc = dx/steps;
        yinc = dy/steps;
        x = x1;
        y = y1;
        putPixel(Math.round(x),Math.round(y), c);
        for(int k = 1; k<=steps; k++){
            x+=xinc;
            y+=yinc;
            putPixel(Math.round(x),Math.round(y), c);
        }

    }
    public float dif(float a1, float a2){
        return a2-a1;
    }
    private void asignarColores(){
        int colorDesconocido = imagenCompleta.getRGB(0, 0);
        unknown = new Color(colorDesconocido);
        miColor = Color.red;
        miCielo = new Color(123,245,255);
        miMar= new Color(0,125,211);
        miArena = new Color(255,241,170);
        LGorro = new Color(193,217,70);
        LCabello = new Color(242,203,7);
        LPiel = new Color(242,212,155);
        LPiel2 = new Color(245,212,155);
        LCubos = new Color(46,113,33);
        LHebilla = new Color(226,192,0);
        LCuero = new Color(89,44,9);
        LTraje = new Color(33,81,24);
        miSol = new Color(235,142,0);
        rocaBot = Color.gray;
        rocaTop = Color.lightGray;

        Color caraA, caraB, caraC, caraAA, caraBB;
        caraA = new Color(154,184,204);
        caraB = new Color(90,108,120);
        caraAA = new Color(83,99,106);
        caraBB = new Color(63,75,84);

        rocas = new Color[]{
                caraA,caraB,new Color(119,142,158),caraAA,caraAA,caraBB,caraBB,new Color(96,115,128),caraBB,caraA,caraB, caraAA, caraBB
        };


    }
    private void crearFiguras(){
        roca1A = new float[][]{
                {569,597,597,569},
                {33,33,78,78}
        };

        roca1B = new float[][]{
                {573,622,622,573},
                {79,79,155,155}
        };

        roca2 = new float[][]{
                {655,678,701},
                {155,112,156}
        };

        roca3A = new float[][]{
                {789,828,828,789},
                {14,14,31,31}
        };

        roca3B = new float[][]{
                {793,840,840,793},
                {32,32,101,101}
        };

        roca3C = new float[][]{
                {744,870,870,744},
                {102,102,156,156}
        };

        roca1A_3D = PoliProfundo(roca1A[X], roca1A[Y],new float[]{0,20});
        roca1B_3D = PoliProfundo(roca1B[X], roca1B[Y],new float[]{0,20});
        roca2_3D = PoliProfundo(roca2[X], roca2[Y],new float[]{0,20});
        roca3A_3D = PoliProfundo(roca3A[X], roca3A[Y],new float[]{0,20});
        roca3B_3D = PoliProfundo(roca3B[X], roca3B[Y],new float[]{0,20});
        roca3C_3D = PoliProfundo(roca3C[X], roca3C[Y],new float[]{0,20});

        ojoIzq_F = new float[][]{
                {106,121,121,106},
                {363,363,377,377}
        };
        ojoDer_F = new float[][]{
                {157,172,172,157},
                {363,363,377,377}
        };
        rostro_F = new float[][]{
                {89,122,122,156,156,189,189,89},
                {378,378,363,363,378,378,403,403}
        };
        gorro_F = new float[][]{
                {89,189,189,89},
                {303,303,335,335}
        };
        cabello_F = new float[][]{
                {105,89,89,189,189,173,173,105},
                {377,377,336,336,377,377,362,362},
        };

        orejaIzq  = new float[][]{
                {71,88,88,71},
                {337,337,353,353}
        };

        orejaDer= new float[][]{
                {190,205,205,190},
                {336,336,351,351}
        };

        cabeza = new float[][]{
                {89,189,189,89},
                {303,303,403,403}
        };

        int anguloCuerpoX = 10;
        int anguloCuerpoY = -10;
        int anguloCuerpoZ = 0;

        float[] zCara = new float[]{0,00};

        cabeza_3D = ini(cabeza, new float[]{0,10}, anguloCuerpoX,anguloCuerpoY);
        cabello_F_3D = ini(cabello_F,zCara,anguloCuerpoX,anguloCuerpoY);
        gorro_F_3D = ini(gorro_F, zCara,anguloCuerpoX,anguloCuerpoY);
        ojoIzq_F_3D = ini(ojoIzq_F, zCara,anguloCuerpoX,anguloCuerpoY);
        ojoDer_F_3D = ini(ojoDer_F, zCara,anguloCuerpoX,anguloCuerpoY);
        rostro_F_3D = ini(rostro_F, zCara,anguloCuerpoX,anguloCuerpoY);

        orejaIzq_3D = ini(orejaIzq,  new float[]{30,46},anguloCuerpoX,anguloCuerpoY);
        orejaDer_3D = ini(orejaDer,  new float[]{30,46},anguloCuerpoX,anguloCuerpoY);

    /*cabezaT = new float[][][]{
        {cabello_F_3D[X],cabello_F_3D[Y], cabello_F_3D[Z]},
        {gorro_F_3D[X],gorro_F_3D[Y], gorro_F_3D[Z]},
        {rostro_F_3D[X],rostro_F_3D[Y], rostro_F_3D[Z]},
        {ojoIzq_F_3D[X],ojoIzq_F_3D[Y], ojoIzq_F_3D[Z]},
        {ojoDer_F_3D[X],ojoDer_F_3D[Y], ojoDer_F_3D[Z]},
        /*{orejaIzq_3D[X],orejaIzq_3D[Y], orejaIzq_3D[Z]},
        {orejaDer_3D[X],orejaDer_3D[Y], orejaDer_3D[Z]},
    };*/
        cabezaT = new float[][][]{
                cabello_F_3D, gorro_F_3D, rostro_F_3D, ojoIzq_F_3D, ojoDer_F_3D,
        };
        cabezaT2 = new float[cabezaT.length][][];
        cabezaL = new Color[]{Color.yellow, LTraje, Color.pink, Color.gray, Color.gray};

        corazon = new float[][]{
                {724,680,672,672,679,689,701,714,724,734,747,759,768,776,776,768},
                {488,445,421,409,391,385,385,394,411,394,385,385,391,409,421,445}
        };
        corazonB = new float[][]{
                {724,698,692,692,696,702,711,717,724,731,737,746,752,756,756,751},
                {471,445,429,422,413,408,408,413,425,413,408,408,413,422,429,445}
        };

        corazones3D = new float[10][32][3];
        corazones2D = new float[10][32][2];
        for(int i = 0; i<corazones3D.length;i++){
            corazones3D[i] = iniEH(corazon,  new float[]{i,i+1},0.5,0.5,1);
        }

        corazonesB3D = new float[10][32][3];
        corazonesB2D = new float[10][32][2];
        for(int i = 0; i<corazonesB3D.length;i++){
            corazonesB3D[i] = iniEH(corazonB,  new float[]{i,i+1},0.5,0.5,1);
        }


        corazon_3D = iniEH(corazon,  new float[]{0,10},0.5,0.5,1);
        corazonB_3D = iniEH(corazonB,  new float[]{0,10}, 0.5,0.5,1);

        corazones3D_2 = new float[10][32][3];
        corazones2D_2 = new float[10][32][2];
        for(int i = 0; i<corazones3D_2.length;i++){
            corazones3D_2[i] = iniEH(corazon,  new float[]{i,i+1},1,1,1);
        }

        corazonesB3D_2 = new float[10][32][3];
        corazonesB2D_2 = new float[10][32][2];
        for(int i = 0; i<corazonesB3D_2.length;i++){
            corazonesB3D_2[i] = iniEH(corazonB,  new float[]{i,i+1},1,1,1);
        }

        manoIzq_F  = new float[][]{
                {103,122,122,103},
                {446,446,456,456}
        };
        manoDer_F  = new float[][]{
                {156,175,175,156},
                {446,446,456,456}
        };

        brazoIzq_F  = new float[][]{
                {103,122,122,103},
                {404,404,445,445}
        };
        brazoDer_F  = new float[][]{
                {156,175,175,156},
                {404,404,445,445}
        };

        cuello_F  = new float[][]{
                {128,149,149,128},
                {404,404,415,415}
        };

        hebilla_F  = new float[][]{
                {129,150,150,129},
                {448,448,459,459}
        };
        cintoIzq_F  = new float[][]{
                {103,103,123,123,128,128},
                {459,457,457,448,448,459}
        };
        cintoDer_F = new float[][]{
                {175,175,155,155,151,151},
                {459,457,457,448,448,459}
        };

        float [] zCuerpo = new float[]{5,5};

        manoIzq_F_3D = ini(manoIzq_F,zCuerpo,anguloCuerpoX,anguloCuerpoY);
        manoDer_F_3D = ini(manoDer_F, zCuerpo,anguloCuerpoX,anguloCuerpoY);
        brazoIzq_F_3D = ini(brazoIzq_F, zCuerpo,anguloCuerpoX,anguloCuerpoY);
        brazoDer_F_3D = ini(brazoDer_F, zCuerpo,anguloCuerpoX,anguloCuerpoY);
        cuello_F_3D = ini(cuello_F, zCuerpo,anguloCuerpoX,anguloCuerpoY);
        hebilla_F_3D = ini(hebilla_F, zCuerpo,anguloCuerpoX,anguloCuerpoY);
        cintoIzq_F_3D = ini(cintoIzq_F, zCuerpo,anguloCuerpoX,anguloCuerpoY);
        cintoDer_F_3D = ini(cintoDer_F, zCuerpo,anguloCuerpoX,anguloCuerpoY);

    /*cuerpoT = new float[][][]{
        {cuello_F_3D[X],cuello_F_3D[Y], cuello_F_3D[Z]},
        {gorro_F_3D[X],gorro_F_3D[Y], gorro_F_3D[Z]},
        {hebilla_F_3D[X],hebilla_F_3D[Y], hebilla_F_3D[Z]},
        {cintoIzq_F_3D[X],cintoIzq_F_3D[Y], cintoIzq_F_3D[Z]},
        {cintoDer_F_3D[X],cintoDer_F_3D[Y], cintoDer_F_3D[Z]},
        {manoIzq_F_3D[X],manoIzq_F_3D[Y], manoIzq_F_3D[Z]},
        {manoDer_F_3D[X],manoDer_F_3D[Y], manoDer_F_3D[Z]},
        {brazoIzq_F_3D[X],brazoIzq_F_3D[Y], brazoIzq_F_3D[Z]},
        {brazoIzq_F_3D[X],brazoIzq_F_3D[Y], brazoIzq_F_3D[Z]},
    };*/
        cuerpoT = new float[][][]{cuello_F_3D,hebilla_F_3D,cintoIzq_F_3D,cintoDer_F_3D,manoIzq_F_3D,manoDer_F_3D, brazoIzq_F_3D, brazoDer_F_3D};
        cuerpoT2 = new float[cuerpoT.length][][];
        cuerpoL = new Color[]{Color.pink,Color.yellow, Color.gray, Color.gray, Color.pink, Color.pink, Color.green, Color.green};

        cuerpo = new float[][]{
                {103,175,175,103},
                {404,404,477,477}
        };

        pieIzq = new float[][]{
                {110,134,134,110},
                {477,477,496,496}
        };

        pieIzq2 = new float[][]{
                {100,134,134,100},
                {477,477,506,506}
        };

        pieDer = new float[][]{
                {144,168,168,144},
                {477,477,496,496}
        };

        pieDer2 = new float[][]{
                {144,178,178,144},
                {477,477,506,506}
        };

        pieDer_3D = ini(pieDer, new float[]{5,10},anguloCuerpoX,anguloCuerpoY);
        pieIzq_3D = ini(pieIzq, new float[]{5,10},anguloCuerpoX,anguloCuerpoY);

        pieDer2_3D = ini(pieDer2, new float[]{5,10},anguloCuerpoX,anguloCuerpoY);
        pieIzq2_3D = ini(pieIzq2, new float[]{5,10},anguloCuerpoX,anguloCuerpoY);

        cuerpo_3D = ini(cuerpo, new float[]{5,15},anguloCuerpoX,anguloCuerpoY);

        pieDerO_3D = ini(pieDer, new float[]{5,10},anguloCuerpoX,anguloCuerpoY);
        pieIzqO_3D = ini(pieIzq, new float[]{5,10},anguloCuerpoX,anguloCuerpoY);

        pieIzqG_3D = iniE(pieIzq, new float[]{5,10},1.5,1.5,1.5);
        pieDerG_3D = iniE(pieDer, new float[]{5,10},1.5,1.5,1.5);

        pbRelleno = new float[][]{
                {139,139,139,135,111,170,111,170,119,159,126,153},
                {411,437,454,467,430,430,450,450,486,488,455,455}
        };

        pcRelleno = new float[][]{
                {139,139,139,114,165,79,198},
                {321,348,387,370,372,346,343}
        };

        pfRelleno = new float[][]{
                {139,85,85,90,137,103},
                {298,382,321,438,488,488}
        };

        pfRelleno2 = new float[][]{
                {139,85,85,90,137,92,92},
                {298,382,321,438,488,488,469}
        };

        pcColor = new Color[]{
                LTraje, LCabello, LPiel, Color.black, Color.black, LPiel, LPiel
        };

        pbColor = new Color[]{
                LPiel, LTraje, LHebilla, LTraje, LGorro, LGorro, LPiel, LPiel, LCuero, LCuero, LCuero, LCuero
        };

        pfColor = new Color[]{
                LCubos, LCubos, LCubos, LCubos, LCuero, LCuero, LCuero
        };


        pbRelleno3D = ini(pbRelleno, new float[]{5,5},anguloCuerpoX,anguloCuerpoY);
        pcRelleno3D = ini(pcRelleno, new float[]{0,0},anguloCuerpoX,anguloCuerpoY);
        pfRelleno3D = ini(pfRelleno, new float[]{0,0},anguloCuerpoX,anguloCuerpoY);
        pfRelleno2_3D = ini(pfRelleno2, new float[]{0,0},anguloCuerpoX,anguloCuerpoY);

        pRellenoRoca = new float[][]{
                {520,550,527,555,560,605,605,670,700,790,840,781,890},
                {75 ,87, 95, 155,202,163,200,190,190,120,120,165,165}
        };

        mIzq = new float[][]{
                {371+8,371+8},
                {439-1,412-1}
        };

        mDer = new float[][]{
                {452+8,452+8},
                {439-1,412-1}
        };

        manosColor = new Color[]{
                LGorro,LPiel2
        };

        bDer = new float[][]{
                {443+8,443+8,443+8,462+8,462+8,462+8},
                {460-1,417-1,407-1,407-1,417-1,460-1}
        };

        bIzq = new float[][]{
                {381+8,362+8,362+8,362+8,381+8,381+8},
                {460-1,460-1,417-1,407-1,407-1,417-1}
        };

        bDer3D = ini(bDer, new float[]{0,0},anguloCuerpoX,anguloCuerpoY);
        bIzq3D = ini(bIzq, new float[]{0,0},anguloCuerpoX,anguloCuerpoY);
        bIzq3D = rotacionZO(bIzq3D,180);
        bDer3D = rotacionZO(bDer3D,-180);

        mDer3D = ini(mDer, new float[]{0,0},anguloCuerpoX,anguloCuerpoY);
        mIzq3D = ini(mIzq, new float[]{0,0},anguloCuerpoX,anguloCuerpoY);
        mIzq3D = rotacionZO(mIzq3D,180, bIzq3D[0][X], bIzq3D[0][Y], bIzq3D[0][Z]);
        mDer3D = rotacionZO(mDer3D,-180,bDer3D[0][X], bDer3D[0][Y], bDer3D[0][Z]);
    }

    public float[][] iniE(float[][] xy, float[] z, double eX, double eY, double eZ){
        float [][] fig3D;

        fig3D = PoliProfundo(xy[X], xy[Y],z);
        fig3D = Escalar3D(fig3D, eX, eY, eZ);
        return fig3D;
    }

    public float[][] iniEH(float[][] xy, float[] z, double eX, double eY, double eZ){
        float [][] fig3D;

        fig3D = PoliProfundo(xy[X], xy[Y],z);
        fig3D = Escalar3DH(fig3D, eX, eY, eZ);
        return fig3D;
    }


    public float[][] ini(float[][] xy, float[] z, int aX, int aY, int aZ){
        float [][] fig3D;

        fig3D = PoliProfundo(xy[X], xy[Y],z);
        fig3D = rotacionX(fig3D,aX);
        fig3D = rotacionY(fig3D,aY);
        fig3D = rotacionZ(fig3D,aZ);
        return fig3D;
    }

    public float[][] ini(float[][] xy, float[] z, int aX, int aY){
        float [][] fig3D;

        fig3D = PoliProfundo(xy[X], xy[Y],z);
        //fig3D = rotacionX(fig3D,aX);
        //fig3D = rotacionY(fig3D,aY);
        return fig3D;
    }




    @Override
    public void run() {
        while(true){
            try{
                repaint();
                hilo.sleep(100);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}