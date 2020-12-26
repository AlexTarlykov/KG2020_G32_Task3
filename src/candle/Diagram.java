package candle;

import draw_algorithms.Bresenham;
import draw_algorithms.pixel_drawer.GraphicsPixelDrawer;

import java.awt.*;
import java.util.ArrayList;

public class Diagram {

    private final ArrayList<Candle> candles;

    private int i = 0;

    public Diagram(ArrayList<Candle> candles) {
        this.candles = candles;
    }

    public void draw(Graphics g) {
        Bresenham bresenham = new Bresenham(new GraphicsPixelDrawer(g));
        int j = i;
        int size = 30;
        while (j * size + candles.get(0).getCoordinateX() >= 0) {
            j--;
        }
        i = j + 1;
        j = i;
        while (j * size + candles.get(0).getCoordinateX() <= 500) {
            if (j * size + candles.get(0).getCoordinateX() >= 0) {
                candles.get(j).draw(bresenham);
            } else {
                i++;
            }
            j++;
        }
    }

    public void move(int dX, int dY) {
        if (candles.get(0).getCoordinateY() + dY >= 500) {
            for (Candle v : candles) {
                v.setCoordinateY(v.getCoordinateY() + dY);
            }
        }
        if (candles.get(0).getCoordinateX() + dX <= 0 ) {
            for (Candle v : candles) {
                v.setCoordinateX(v.getCoordinateX() + dX);
            }
        }
    }
}
