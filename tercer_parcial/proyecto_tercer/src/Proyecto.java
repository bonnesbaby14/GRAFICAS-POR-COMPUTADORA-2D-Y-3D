

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


public class Proyecto extends JFrame implements Runnable{
    private BufferedImage bufferPixel, imagenCompleta;

    private int alternadorcolor=0;
    private Color unknown,miColor;
    private Thread hilo;


    private float[][] PUNTOS_GENERICOS=new float[][]{
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
    };
    private float  cuboX[][];
    private float carasX[][];
    private float centrosX[][];


    private float  cuboExtra[][];
    private float carasExtra[][];
    private float centrosExtra[][];
    private float printCuboExtra[][];
    private float printCuboX[][];




    private float FIGURA_ANGULO_X_2[];
    private float FIGURA_ANGULO_Y_2[];
    private final int X = 0, Y = 1, Z = 2;

    private int ajustador=1;

    int [] centroColicion={410,390};


    public int [] cubo1mov={10,70};
    public int [] cubo2mov={10,700};
    public int [] cubo3mov={800,70};
    public int [] cubo4mov={800,700};

    private float[][] arbol=new float[][]{
            {0,1,2},
            {2,1,2},
            {2,3,2},
            {0,3,2},
            {1,2,5},

            {1.5F, 1.5F,2},
            {0.5F, 1.5F,2},
            {0.5F, 2.5F,2},
            {1.5F,2.5F,2},

            {1.5F, 1.5F,1},
            {0.5F, 1.5F,1},
            {0.5F,2.5F,1},
            {1.5F, 2.5F,1},


    };
    public Proyecto(){

        setTitle("Proyecto");
        setSize(1000,1000);
        setLayout(null);
        this.setDefaultCloseOperation(3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        this.bufferPixel = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        this.imagenCompleta = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);
        this.hilo = new Thread(this);
        this.hilo.start();
        int colorDesconocido = imagenCompleta.getRGB(0, 0);

        //COLORES RELEVANTES
        unknown = new Color(colorDesconocido);
        miColor = Color.red;

        //PUNTOS DE FIGURAS GENERICAS
        FIGURA_ANGULO_X_2 = new float[]{0,20,20,0};
        FIGURA_ANGULO_Y_2 = new float[]{0,0,20,20};



        //FIGURAS ESENCIALES
        cuboX = profundidad_figura(FIGURA_ANGULO_X_2, FIGURA_ANGULO_Y_2, 20);
        carasX = PUNTOS_GENERICOS;
        centrosX = centro_tridimensional(cuboX, 20);
        cuboExtra = profundidad_figura(FIGURA_ANGULO_X_2, FIGURA_ANGULO_Y_2, 20);
        carasExtra = PUNTOS_GENERICOS;
        centrosExtra = centro_tridimensional(cuboExtra, 20);
        setVisible(true);
    }

    public void paint(Graphics g){
        imagenCompleta = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);

        float minZ, punto = 0;
        float minZExtra, puntoExtra=0;


        if(cubo1mov[0]<377) {
            cuboX = rotacionX(cuboX, 5);
            centrosX = rotacionX(centrosX,5);
            cuboX = rotacionY(cuboX, 5);
            centrosX = rotacionY(centrosX,5);
            cuboX = rotacionZ(cuboX, 5);
            centrosX = rotacionZ(centrosX,5);

            printCuboX = convertir3Dto2D(cuboX,0,0,1);
            float[][] printCentrosX = convertir3Dto2D(centrosX, 0, 0, 1);

            minZ = cuboX[0][Z];
            for(int i = 0; i < cuboX.length; i++){
                if(minZ>cuboX[i][Z]){
                    minZ = cuboX[i][Z];
                    punto = i;
                }
            }
            dibujar_profundidad_figura(printCuboX, punto, cubo1mov[0], cubo1mov[1], 3, 3, Color.white);
            dibujar_profundidad_figura(printCuboX, punto, cubo2mov[0], cubo2mov[1], 3, 3, Color.orange);
            dibujar_profundidad_figura(printCuboX, punto, cubo3mov[0], cubo3mov[1], 3, 3, Color.red);
            dibujar_profundidad_figura(printCuboX, punto, cubo4mov[0], cubo4mov[1], 3, 3, Color.blue);

            rellenoCubo(printCentrosX, carasX, punto, cubo1mov[0], cubo1mov[1], 3, 3, new Color[]{Color.blue, Color.blue, Color.blue, Color.blue, Color.blue, Color.blue});
            rellenoCubo(printCentrosX, carasX, punto, cubo2mov[0], cubo2mov[1], 3, 3, new Color[]{Color.green, Color.green, Color.green, Color.green, Color.green, Color.green});
            rellenoCubo(printCentrosX, carasX, punto, cubo3mov[0], cubo3mov[1], 3, 3, new Color[]{Color.orange, Color.orange, Color.orange, Color.orange, Color.orange, Color.orange});
            rellenoCubo(printCentrosX, carasX, punto, cubo4mov[0], cubo4mov[1], 3, 3, new Color[]{Color.white, Color.white, Color.white, Color.white, Color.white, Color.white});
        }else{
            if(cubo1mov[0]<1060) {
                arbol = rotacionX(arbol, 2);
                arbol = rotacionY(arbol, 2);
                arbol = rotacionZ(arbol, 2);


                arbol = Escalar3D(arbol, 1.01, 1.01, 1.01);


                printCuboExtra = convertir3Dto2D(arbol, 0, 0, 1);
                imprimirArbol(printCuboExtra, 0);
                imprimirArbol(printCuboExtra, 100);
                imprimirArbol(printCuboExtra, 200);
                imprimirArbol(printCuboExtra, 300);
                imprimirArbol(printCuboExtra, 400);
                imprimirArbol(printCuboExtra, 500);
                imprimirArbol(printCuboExtra, 600);
                imprimirArbol(printCuboExtra, 700);

                  }else{

                //pintar curvas

                switch (alternadorcolor){
                    case 0:
                        alternadorcolor+=1;
                        g.setColor(Color.WHITE);
                        break;
                    case 1:
                        alternadorcolor+=1;
                        g.setColor(Color.blue);
                        break;
                    case 2:
                        g.setColor(Color.green);
                        alternadorcolor+=1;
                        break;
                    case 3:
                        g.setColor(Color.red);
                        alternadorcolor+=1;
                        break;
                    case 4:
                        g.setColor(Color.yellow);
                        alternadorcolor=0;

                        break;
                }

                g.setFont(new Font("ALGERIAN", Font.PLAIN, 70));
                g.drawString("FELIZ NAVIDAD!!!", 220,    450);

                estrella(50,70,Color.blue);
                estrella(100,70,Color.green);
                estrella(150,70,Color.red);
                estrella(200,70,Color.blue);
                estrella(250,70,Color.green);
                estrella(300,70,Color.red);
                estrella(350,70,Color.blue);
                estrella(400,70,Color.green);
                estrella(450,70,Color.red);
                estrella(500,70,Color.blue);
                estrella(550,70,Color.green);
                estrella(600,70,Color.red);
                estrella(650,70,Color.blue);
                estrella(700,70,Color.blue);
                estrella(750,70,Color.green);
                estrella(800,70,Color.red);
                estrella(850,70,Color.blue);
                estrella(900,70,Color.green);
                estrella(950,70,Color.red);

                estrella(950,120,Color.blue);
                estrella(950,170,Color.green);
                estrella(950,220,Color.red);
                estrella(950,270,Color.blue);
                estrella(950,320,Color.green);
                estrella(950,370,Color.red);
                estrella(950,420,Color.blue);
                estrella(950,470,Color.green);
                estrella(950,520,Color.red);
                estrella(950,570,Color.blue);
                estrella(950,620,Color.green);
                estrella(950,670,Color.red);
                estrella(950,720,Color.blue);


                estrella(50,720,Color.blue);
                estrella(100,720,Color.green);
                estrella(150,720,Color.red);
                estrella(200,720,Color.blue);
                estrella(250,720,Color.green);
                estrella(300,720,Color.red);
                estrella(350,720,Color.blue);
                estrella(400,720,Color.green);
                estrella(450,720,Color.red);
                estrella(500,720,Color.blue);
                estrella(550,720,Color.green);
                estrella(600,720,Color.red);
                estrella(650,720,Color.blue);
                estrella(700,720,Color.blue);
                estrella(750,720,Color.green);
                estrella(800,720,Color.red);
                estrella(850,720,Color.blue);
                estrella(900,720,Color.green);
                estrella(950,720,Color.red);

                estrella(50,120,Color.blue);
                estrella(50,170,Color.green);
                estrella(50,220,Color.red);
                estrella(50,270,Color.blue);
                estrella(50,320,Color.green);
                estrella(50,370,Color.red);
                estrella(50,420,Color.blue);
                estrella(50,470,Color.green);
                estrella(50,520,Color.red);
                estrella(50,570,Color.blue);
                estrella(50,620,Color.green);
                estrella(50,670,Color.red);
                estrella(50,720,Color.blue);
                estrella(50,770,Color.green);
                estrella(50,820,Color.red);
                estrella(50,870,Color.blue);

                parametrica(150,180, Color.yellow);
                parametrica(850,620, Color.yellow);
                parametrica(150,620, Color.gray);
                parametrica(850,180, Color.gray);
                curva(Color.green,500,200);







            }
        }

        g.drawImage(imagenCompleta,0,0,null);

    }

    public void rellenoCubo(float[][] centros, float[][] caras, float omitir, int disminucionX, int disminucionY, int amplificacionX, int amplificacionY, Color[] c){
        for(int i = caras.length-1; i >= 0 ; i--){
            if(caras[i][0]==omitir||caras[i][1]==omitir||caras[i][2]==omitir||caras[i][3]==omitir){

            }else{
                //Punto(new float[]{centros[i][X]*amplificacionX,centros[i][Y]*amplificacionY},disminucionX, disminucionY, Color.red);
                relleno((int)(centros[i][X]*amplificacionX)+disminucionX, (int)(centros[i][Y]*amplificacionY)+disminucionY, unknown, c[i]);
            }
        }
    }


    public void relleno(int x,int y, Color color, Color color_relleno){
        if(color.getRGB()==imagenCompleta.getRGB(x, y)){
            this.putPixel(x, y, color_relleno);
            this.relleno(x-1,y,color,color_relleno);
            this.relleno(x+1,y,color, color_relleno);
            this.relleno(x,y-1,color,color_relleno);
            this.relleno(x,y+1,color,color_relleno);
        }
    }


    public void imprimirArbol(float[][] puntos, int ajuste){
/*
        private float[][] arbol=new float[][]{
                {0,1,1},A-0
                {2,1,1},B-1
                {2,3,1},C-2
                {0,3,1},D-3
                {1,2,5},E,-4

           {1.5F, 1.5F,2},-5
            {0.5F, 1.5F,2},-6
            {0.5F, 2.5F,2},-7
            {1.5F,2.5F,2},-8

            {1.5F, 1.5F,1},-9
            {0.5F, 1.5F,1},-10
            {0.5F,2.5F,1},-11
            {1.5F, 2.5F,1},-12
        };
  */

        rellenoArbol(puntos,ajuste);
        Bresenham((int) ((puntos[0][X]))+ajuste, (int) ((puntos[0][Y])+ajuste), (int) ((puntos[4][X])+ajuste), (int) ((puntos[4][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[1][X]))+ajuste, (int) ((puntos[1][Y])+ajuste), (int) ((puntos[4][X])+ajuste), (int) ((puntos[4][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[2][X]))+ajuste, (int) ((puntos[2][Y])+ajuste), (int) ((puntos[4][X])+ajuste), (int) ((puntos[4][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[3][X]))+ajuste, (int) ((puntos[3][Y])+ajuste), (int) ((puntos[4][X])+ajuste), (int) ((puntos[4][Y])+ajuste), Color.LIGHT_GRAY);






        Bresenham((int) ((puntos[0][X]))+ajuste, (int) ((puntos[0][Y])+ajuste), (int) ((puntos[1][X])+ajuste), (int) ((puntos[1][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[1][X]))+ajuste, (int) ((puntos[1][Y])+ajuste), (int) ((puntos[2][X])+ajuste), (int) ((puntos[2][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[2][X]))+ajuste, (int) ((puntos[2][Y])+ajuste), (int) ((puntos[3][X])+ajuste), (int) ((puntos[3][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[3][X]))+ajuste, (int) ((puntos[3][Y])+ajuste), (int) ((puntos[0][X])+ajuste), (int) ((puntos[0][Y])+ajuste), Color.LIGHT_GRAY);



        Bresenham((int) ((puntos[9][X]))+ajuste, (int) ((puntos[9][Y])+ajuste), (int) ((puntos[5][X])+ajuste), (int) ((puntos[5][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[10][X]))+ajuste, (int) ((puntos[10][Y])+ajuste), (int) ((puntos[6][X])+ajuste), (int) ((puntos[6][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[11][X]))+ajuste, (int) ((puntos[11][Y])+ajuste), (int) ((puntos[7][X])+ajuste), (int) ((puntos[7][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[12][X]))+ajuste, (int) ((puntos[12][Y])+ajuste), (int) ((puntos[8][X])+ajuste), (int) ((puntos[8][Y])+ajuste), Color.LIGHT_GRAY);


        Bresenham((int) ((puntos[5][X]))+ajuste, (int) ((puntos[5][Y])+ajuste), (int) ((puntos[6][X])+ajuste), (int) ((puntos[6][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[6][X]))+ajuste, (int) ((puntos[6][Y])+ajuste), (int) ((puntos[7][X])+ajuste), (int) ((puntos[7][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[7][X]))+ajuste, (int) ((puntos[7][Y])+ajuste), (int) ((puntos[8][X])+ajuste), (int) ((puntos[8][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[8][X]))+ajuste, (int) ((puntos[8][Y])+ajuste), (int) ((puntos[5][X])+ajuste), (int) ((puntos[5][Y])+ajuste), Color.LIGHT_GRAY);




//fondo1
        Bresenham((int) ((puntos[9][X]))+ajuste, (int) ((puntos[9][Y])+ajuste), (int) ((puntos[10][X])+ajuste), (int) ((puntos[10][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[10][X]))+ajuste, (int) ((puntos[10][Y])+ajuste), (int) ((puntos[11][X])+ajuste), (int) ((puntos[11][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[11][X]))+ajuste, (int) ((puntos[11][Y])+ajuste), (int) ((puntos[12][X])+ajuste), (int) ((puntos[12][Y])+ajuste), Color.LIGHT_GRAY);
        Bresenham((int) ((puntos[12][X]))+ajuste, (int) ((puntos[12][Y])+ajuste), (int) ((puntos[9][X])+ajuste), (int) ((puntos[9][Y])+ajuste), Color.LIGHT_GRAY);


    }



    public float [][] Escalar3D(float[][] figura_en_3d, double sx, double sy, double sz){
        float temp [] = new float[3];
        float figura [][] = new float[figura_en_3d.length][3];

        for(int i = 0; i<figura_en_3d.length; i++){
            temp = escalarPunto(figura_en_3d[i][X], figura_en_3d[i][Y], figura_en_3d[i][Z], sx, sy, sz);
            figura[i][X] = temp[X];
            figura[i][Y] = temp [Y];
            figura[i][Z] = temp [Z];

        }

        return figura;
    }

    public float[] escalarPunto(float x, float y, float z, double sx, double sy, double sz){ //Arreglo puntos, movimiento en x, movimiento en y
        double[] punto={x, y, z, 1};
        double[][] punto_temporal={
                {sx,0,0,0},
                {0,sy,0,0},
                {0,0,sz,0},
                {0,0,0,1}
        };
        punto[0]=punto[0]*punto_temporal[0][0]+punto[1]*punto_temporal[0][1]+punto[2]*punto_temporal[0][2]+punto[3]*punto_temporal[0][3];
        punto[1]=punto[0]*punto_temporal[1][0]+punto[1]*punto_temporal[1][1]+punto[2]*punto_temporal[1][2]+punto[3]*punto_temporal[1][3];
        punto[2]=punto[0]*punto_temporal[2][0]+punto[1]*punto_temporal[2][1]+punto[2]*punto_temporal[2][2]+punto[3]*punto_temporal[2][3];
        punto[3]=punto[0]*punto_temporal[3][0]+punto[1]*punto_temporal[3][1]+punto[3]*punto_temporal[3][2]+punto[3]*punto_temporal[3][3];

        float end[]={(float)punto[0],(float)punto[1],(float)punto[2]};

        return end;

    }

    public float [][] rotacionX(float figura_en_3d[][], int angulo){
        float[][] figura = new float[figura_en_3d.length][3];


        for(int i = 0; i<figura_en_3d.length; i++){

            figura[i][X] = figura_en_3d[i][X];
            figura[i][Y] = (float)((figura_en_3d[i][Y]*Math.cos(Math.toRadians(angulo)))-(figura_en_3d[i][Z]*(Math.sin(Math.toRadians(angulo)))));
            figura[i][Z] = (float)((figura_en_3d[i][Y]*Math.sin(Math.toRadians(angulo)))+(figura_en_3d[i][Z]*(Math.cos(Math.toRadians(angulo)))));
        }

        return figura;
    }

    public float [][] rotacionY(float figura_en_3d[][], int angulo){
        float[][] figura = new float[figura_en_3d.length][3];


        for(int i = 0; i<figura_en_3d.length; i++){

            figura[i][X] = (float)((figura_en_3d[i][X]*Math.cos(Math.toRadians(angulo)))+(figura_en_3d[i][Z]*(Math.sin(Math.toRadians(angulo)))));
            figura[i][Y] = figura_en_3d[i][Y];
            figura[i][Z] = (float)((-figura_en_3d[i][X]*Math.sin(Math.toRadians(angulo)))+(figura_en_3d[i][Z]*(Math.cos(Math.toRadians(angulo)))));
        }

        return figura;
    }

    public float [][] rotacionZ(float figura_en_3d[][], int angulo){
        float[][] figura = new float[figura_en_3d.length][3];


        for(int i = 0; i<figura_en_3d.length; i++){

            figura[i][Z] = figura_en_3d[i][Z];
            figura[i][X] = (float)((figura_en_3d[i][X]*Math.cos(Math.toRadians(angulo)))-(figura_en_3d[i][Y]*(Math.sin(Math.toRadians(angulo)))));
            figura[i][Y] = (float)((figura_en_3d[i][X]*Math.sin(Math.toRadians(angulo)))+(figura_en_3d[i][Y]*(Math.cos(Math.toRadians(angulo)))));
        }

        return figura;
    }


    public float [][] convertir3Dto2D(float figura_en_3d[][], int dx, int dy, int dz){
        float[][] fugura_2D = new float[figura_en_3d.length][2];


        for(int i = 0; i<figura_en_3d.length; i++){
            fugura_2D[i][X] = (figura_en_3d[i][X]-((dx/dz)*figura_en_3d[i][Z]));
            fugura_2D[i][Y] = (figura_en_3d[i][Y]-((dy/dz)*figura_en_3d[i][Z]));
            System.out.println("x:"+fugura_2D[i][X]+" y:"+fugura_2D[i][Y]);
        }

        return fugura_2D;
    }


    public void dibujar_profundidad_figura(float[][] fugura_2D, float omitir, int disminucionX, int disminucionY, int amplificacionX, int amplificacionY, Color c){
        int n = fugura_2D.length/2;
        int nn = n;
        for(int i = 0; i<n-1;i++){
            if(i!=omitir&&i+1!=omitir){
                Bresenham((int) ((fugura_2D[i][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[i][Y]*amplificacionY)+disminucionY), (int) ((fugura_2D[i+1][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[i+1][Y]*amplificacionY)+disminucionY), c);
            }
        }
        if(n-1!=omitir&&0!=omitir)
            Bresenham((int) ((fugura_2D[n-1][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[n-1][Y]*amplificacionY)+disminucionY), (int) ((fugura_2D[0][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[0][Y]*amplificacionY)+disminucionY), c);

        for(int i = nn; i<fugura_2D.length-1;i++){
            if(i!=omitir&&i+1!=omitir)
                Bresenham((int) ((fugura_2D[i][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[i][Y]*amplificacionY)+disminucionY), (int) ((fugura_2D[i+1][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[i+1][Y]*amplificacionY)+disminucionY), c);
        }
        if(fugura_2D.length-1!=omitir&&nn!=omitir)
            Bresenham((int) ((fugura_2D[fugura_2D.length-1][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[fugura_2D.length-1][Y]*amplificacionY)+disminucionY), (int) ((fugura_2D[nn][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[nn][Y]*amplificacionY)+disminucionY), c);

        for(int i = 0; i<n;i++){
            if(i!=omitir&&i+n!=omitir)
                Bresenham((int) ((fugura_2D[i][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[i][Y]*amplificacionY)+disminucionY), (int) ((fugura_2D[i+n][X]*amplificacionX)+disminucionX), (int) ((fugura_2D[i+n][Y]*amplificacionY)+disminucionY), c);
        }
    }

    public void rellenoArbol(float [][] puntos,int ajuste){

        Graphics g=imagenCompleta.getGraphics();
        g.setColor(Color.yellow);
        g.fillPolygon(new int[]{(int) puntos[9][X]+ajuste, (int) puntos[10][X]+ajuste, (int) puntos[11][X]+ajuste, (int) puntos[12][X]+ajuste, (int) puntos[9][X]+ajuste},new int []{(int) puntos[9][Y]+ajuste, (int) puntos[10][Y]+ajuste, (int) puntos[11][Y]+ajuste, (int) puntos[12][Y]+ajuste, (int) puntos[9][Y]+ajuste},4);
        g.fillPolygon(new int[]{(int) puntos[5][X]+ajuste, (int) puntos[6][X]+ajuste, (int) puntos[10][X]+ajuste, (int) puntos[9][X]+ajuste, (int) puntos[5][X]+ajuste},new int []{(int) puntos[5][Y]+ajuste, (int) puntos[6][Y]+ajuste, (int) puntos[10][Y]+ajuste, (int) puntos[9][Y]+ajuste, (int) puntos[5][Y]+ajuste},4);
        g.fillPolygon(new int[]{(int) puntos[7][X]+ajuste, (int) puntos[8][X]+ajuste, (int) puntos[12][X]+ajuste, (int) puntos[11][X]+ajuste, (int) puntos[7][X]+ajuste},new int []{(int) puntos[7][Y]+ajuste, (int) puntos[8][Y]+ajuste, (int) puntos[12][Y]+ajuste, (int) puntos[11][Y]+ajuste, (int) puntos[7][Y]+ajuste},4);
        g.fillPolygon(new int[]{(int) puntos[6][X]+ajuste, (int) puntos[7][X]+ajuste, (int) puntos[11][X]+ajuste, (int) puntos[10][X]+ajuste, (int) puntos[6][X]+ajuste},new int []{(int) puntos[7][Y]+ajuste, (int) puntos[8][Y]+ajuste, (int) puntos[11][Y]+ajuste, (int) puntos[10][Y]+ajuste, (int) puntos[6][Y]+ajuste},4);

        g.setColor(Color.green);
        g.fillPolygon(new int[]{(int) puntos[0][X]+ajuste, (int) puntos[1][X]+ajuste, (int) puntos[4][X]+ajuste, (int) puntos[0][X]+ajuste},new int []{(int) puntos[0][Y]+ajuste, (int) puntos[1][Y]+ajuste, (int) puntos[4][Y]+ajuste, (int) puntos[0][Y]+ajuste},3);
        g.fillPolygon(new int[]{(int) puntos[1][X]+ajuste, (int) puntos[2][X]+ajuste, (int) puntos[4][X]+ajuste, (int) puntos[1][X]+ajuste},new int []{(int) puntos[1][Y]+ajuste, (int) puntos[2][Y]+ajuste, (int) puntos[4][Y]+ajuste, (int) puntos[1][Y]+ajuste},3);
        g.fillPolygon(new int[]{(int) puntos[2][X]+ajuste, (int) puntos[3][X]+ajuste, (int) puntos[4][X]+ajuste, (int) puntos[2][X]+ajuste},new int []{(int) puntos[2][Y]+ajuste, (int) puntos[3][Y]+ajuste, (int) puntos[4][Y]+ajuste, (int) puntos[2][Y]+ajuste},3);
        g.fillPolygon(new int[]{(int) puntos[3][X]+ajuste, (int) puntos[0][X]+ajuste, (int) puntos[4][X]+ajuste, (int) puntos[3][X]+ajuste},new int []{(int) puntos[3][Y]+ajuste, (int) puntos[0][Y]+ajuste, (int) puntos[4][Y]+ajuste, (int) puntos[3][Y]+ajuste},3);

    }

    public float [][] profundidad_figura(float[] x, float[] y, int z){
        float[][] figura_en_3d = new float[(x.length)*2][3];
        int n = x.length;

        for(int i = 0; i<x.length; i++){
            figura_en_3d[i][X] = x[i];
            figura_en_3d[i+n][X] = x[i];
            figura_en_3d[i][Y] = y[i];
            figura_en_3d[i+n][Y] = y[i];
            figura_en_3d[i][Z] = 0;
            figura_en_3d[i+n][Z] = z;
        }

        return figura_en_3d;
    }



    public float [][] centro_tridimensional(float[][] figura_en_3d, float z){
        float n = z/(float)2;
        return new float[][]{
                {figura_en_3d[0][X]+n,figura_en_3d[0][Y]+n,figura_en_3d[0][Z]},
                {figura_en_3d[4][X]+n,figura_en_3d[4][Y]+n,figura_en_3d[4][Z]},
                {figura_en_3d[0][X]+n,figura_en_3d[0][Y], figura_en_3d[0][Z]+n},
                {figura_en_3d[3][X]+n,figura_en_3d[3][Y], figura_en_3d[3][Z]+n},
                {figura_en_3d[0][X],figura_en_3d[0][Y]+n, figura_en_3d[0][Z]+n},
                {figura_en_3d[1][X],figura_en_3d[0][Y]+n, figura_en_3d[0][Z]+n},
        };
    }

    public void putPixel(int x, int y, Color c){
        bufferPixel.setRGB(0, 0, c.getRGB());
        imagenCompleta.getGraphics().drawImage(bufferPixel, x, y, this);

    }



    public void estrella(int x, int y,Color color) {
        double _x, _y;



        for (double i = 0; i < 14 * Math.PI; i += Math.PI / 800) {
            _x = (17*Math.cos(i) + 7*Math.cos((2.428571428571429)*i))+x;
            _y = (17*Math.sin(i) - 7*Math.sin((2.428571428571429)*i))+y;
            putPixel((int) _x, (int) _y, color);



        }

    }

    public void parametrica(double x, double y,Color color) {
        double _x, _y;

        double y_ = 0;
        double  x_ = 0;


        for (double i = 0; i < 2 * Math.PI; i += Math.PI / 200) {
            _x = (Math.cos(i) + .5*Math.cos(7*i) + .33*Math.sin(17*i))*40+x;
            _y =((Math.sin(i) + .5*Math.sin(7*i) + .33*Math.cos(17*i))*40+y);

            if(i==0){
                y_ = _y;
                x_ = _x;
            }
            Bresenham((int) _x, (int) _y, (int) x_, (int) y_, color);
            y_ = _y;
            x_ = _x;


        }
    }
    public void Bresenham(int x0, int y0, int x1, int y1, Color color) {
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
        this.putPixel(x0, y0, color);
        int p;
        int incE;
        int incNE;
        if (dx > dy) {
            p = 2 * dy - dx;
            incE = 2 * dy;

            for(incNE = 2 * (dy - dx); x != x1; this.putPixel(x, y, color)) {
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

            for(incNE = 2 * (dx - dy); y != y1; this.putPixel(x, y, color)) {
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

    public void curva(Color color, int px, int py){

        double y = 0, y_ =0;
        double x = 0, x_ =0;


        for (float i = 0; i < 2 * Math.PI; i +=  Math.PI / 205) {
            x = i * Math.cos(8 * i) * 20 + px;
            y = i * 20 + py;

            if(i==0){
                x_ = x;
                y_ = y;
            }

            Bresenham((int) x, (int) y, (int) x_, (int) y_,color);
            x_ = x;
            y_ = y;

        }
    }
    @Override
    public void run() {
        while(true){
            try{
                repaint();

                cubo1mov[0]+=1;
                cubo1mov[1]+=1;
                cubo2mov[0]+=1;
                cubo2mov[1]-=1;
                cubo3mov[0]-=1;
                cubo3mov[1]+=1;
                cubo4mov[0]-=1;
                cubo4mov[1]-=1;

                System.out.println("x: "+cubo1mov[0]+ ", "+"y: "+cubo1mov[1] );



                hilo.sleep(30);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}