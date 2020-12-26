package candle;

import draw_algorithms.Bresenham;

import java.awt.*;

public class Candle {

    private final Color color;

    private int size;

    private final int open;
    private final int close;

    private final int max;
    private final int min;

    private final int i;

    private int coordinateX;
    private int coordinateY;

    public Candle(int size, int open, int close, int max, int min, int i, int coordinateX, int coordinateY) {
        this.size = size;
        this.open = open;
        this.close = close;
        this.max = max;
        this.min = min;
        this.i = i;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        if (open < close) {
            color = Color.BLUE;
        } else {
            color = Color.RED;
        }
    }

    public void draw(Bresenham bresenham) {
        bresenham.drawLine(i * size + size / 2 + coordinateX, coordinateY - min, i * size + size / 2 + coordinateX, coordinateY - Math.min(close, open), color);
        bresenham.drawLine(i * size + size / 5 + coordinateX, coordinateY - Math.min(close, open), i * size + size / 5 + coordinateX, coordinateY - Math.max(close, open), color);
        int x1 = i * size + 4 * size / 5;
        bresenham.drawLine(x1 + coordinateX, coordinateY - Math.min(close, open), x1 + coordinateX, coordinateY - Math.max(close, open), color);
        bresenham.drawLine(i * size + size / 5 + coordinateX, coordinateY - close, x1 + coordinateX, coordinateY - close, color);
        bresenham.drawLine(i * size + size / 5 + coordinateX, coordinateY - open, x1 + coordinateX, coordinateY - open, color);
        bresenham.drawLine(i * size + size / 2 + coordinateX, coordinateY - Math.max(close, open), i * size + size / 2 + coordinateX, coordinateY - max, color);
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
