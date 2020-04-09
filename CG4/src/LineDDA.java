
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class LineDDA implements Figure {
    int x1;
    int y1;
    int x2;
    int y2;
    Color col;

    public LineDDA(int x1, int y1, int x2, int y2, Color col) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.col = col;
    }

    public void paint(Graphics g) {
        int x_start = Math.round(x1);
        int y_start = Math.round(y1);
        int x_end = Math.round(x2);
        int y_end = Math.round(y2);
        int delta_x = Math.abs(x_end - x_start);
        int delta_y = Math.abs(y_end - y_start);
        int L = Math.max(delta_x, delta_y) + 1;
        float x = x1, y = y1;
        g.setColor(col);
        for (int i = 0; i < L; i++) {
            x += 1. * delta_x / L;
            y += 1. * delta_y / L;
            int _x = Math.round(x);
            int _y = Math.round(y);
            g.drawLine(_x, _y, _x, _y);
        }
    }
}
