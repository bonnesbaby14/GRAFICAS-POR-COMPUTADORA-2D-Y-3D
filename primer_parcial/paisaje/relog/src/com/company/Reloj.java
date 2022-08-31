package com.company;

import javax.swing.*;
import java.awt.*;

public class Reloj extends JFrame implements Runnable {

    private Image image;

    private Image buffer;
    int min;
    int hora;
    int sec;

    int manecillasHora=100;
    int manecillasMinuto=70;
    int manecillasSegundo=50;



    @Override
    public void run() {

    }

    Reloj(){

    }
}
