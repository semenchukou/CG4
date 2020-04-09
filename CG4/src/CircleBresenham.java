
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class CircleBresenham implements Figure {
    int x;
    int y;
    int r;
    Color col;

    public CircleBresenham(int x, int y, int r, Color col) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.col = col;
    }

    public void paint(Graphics g) {
        int sx = 0;
        int sy = r;
        int d = 3 - 2 * r;
        g.setColor(col);
        while (sx <= sy) {
            g.drawLine(x + sx, y - sy, x + sx, y - sy);
            g.drawLine(x + sx, y + sy, x + sx, y + sy);
            g.drawLine(x - sx, y - sy, x - sx, y - sy);
            g.drawLine(x - sx, y + sy, x - sx, y + sy);
            g.drawLine(x + sy, y + sx, x + sy, y + sx);
            g.drawLine(x - sy, y + sx, x - sy, y + sx);
            g.drawLine(x + sy, y - sx, x + sy, y - sx);
            g.drawLine(x - sy, y - sx, x - sy, y - sx);
            if (d < 0) {
                d = d + 4 * sx + 6;
            } else {
                d = d + 4 * (sx - sy) + 10;
                sy = sy - 1;
            }
            sx += 1;
        }
    }
}
