package rain;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Render extends JPanel {

    int n;
    Rain rain[];
    Random rd;

    public Render() {
        n = 100;
        rain = new Rain[n];
        rd = new Random();

        for (int i = 0; i < rain.length; i++)
            rain[i] = new Rain(rd.nextInt(800), 0, rd.nextDouble()+0.5); 
    }

    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        for (int i = 0; i < rain.length; i++) rain[i].makeItRain(g);
        repaint();
    }
}