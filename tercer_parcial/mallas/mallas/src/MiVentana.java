import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MiVentana extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    int [] inicial1={100,100};
    int [] inicial2={500,500};

    int separacion=50;



    public MiVentana(){
        setTitle("Malla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);
        buffer= new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);
        graPixel=(Graphics2D)buffer.createGraphics();

    }


    public void putPixel(int x, int y, Color c, Graphics g) {
        buffer.setRGB(0, 0, c.getRGB());

        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void paint (Graphics g) {
        super.paint(g);

        int [] punto1=new int[]{inicial1[0],inicial1[1]};
        int [] punto2=new int[]{inicial2[0],inicial1[1]};
        int [] punto3 = new int[]{inicial2[0],inicial2[1]};
        int [] punto4=new int[]{inicial1[0],inicial2[1]};
        ArrayList<Integer> x=new ArrayList<Integer>();
        ArrayList<Integer> y=new ArrayList<Integer>();


        for(int _x=punto1[0];_x<=punto2[0];_x=_x+separacion){
            x.add(_x);
        }
        for(int _y=punto1[1];_y<=punto3[1];_y=_y+separacion){
            y.add(_y);
        }

        ArrayList<int[]> cruces=new ArrayList<>();

        for(int i=0;i<x.size();i++){
            int aux=x.get(i);
            for(int u=0; u<y.size();u++){
                cruces.add(new int[]{aux,y.get(u)});

            }

        }

        for(int h=0;h<x.size();h++){
            Bresenham(x.get(h),punto1[1],x.get(h),punto3[1],g);
        }
        for(int h=0;h<y.size();h++){
            Bresenham(punto1[0],y.get(h),punto2[0],y.get(h),g);
        }


        for(int t=0; t<cruces.size();t++){
            putPixel(cruces.get(t)[0],cruces.get(t)[1],Color.BLUE,g);
            putPixel(cruces.get(t)[0]-1,cruces.get(t)[1],Color.BLUE,g);
            putPixel(cruces.get(t)[0]+1,cruces.get(t)[1],Color.BLUE,g);
            putPixel(cruces.get(t)[0],cruces.get(t)[1]+1,Color.BLUE,g);
            putPixel(cruces.get(t)[0],cruces.get(t)[1]-1,Color.BLUE,g);

        }



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



}

