import java.awt.*;
import java.util.ArrayList;

public class Algorithm {
    public static ArrayList<Point> lineStep(Graphics g, int x1, int y1, int x2, int y2, Color col) {
        ArrayList<Point> points = new ArrayList<>();
        float A = y1 - y2;
        float B = x2 - x1;
        float C = x1 * y2 - x2 * y1;
        float k = -A / B;
        float b = -C / B;
        int delta_x = Math.abs(x2 - x1);
        int delta_y = Math.abs(y2 - y1);
        int L = Math.max(delta_x, delta_y);

        g.setColor(col);

        if (x1 > x2) {
            x1 = x2;
        }

        float x = x1;
        for (int i = 0; i < L; i++) {
            x += (float) delta_x / L;
            int _x = Math.round(x);
            int _y = Math.round(k * x + b);
            g.drawLine(_x, _y, _x, _y);
            points.add(new Point(_x, _y));
        }

        return points;
    }

    public static ArrayList<Point> lineDDA(Graphics g, int x1, int y1, int x2, int y2, Color col) {
        ArrayList<Point> points = new ArrayList<>();
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
            points.add(new Point(_x, _y));
        }
        return points;
    }

    public static ArrayList<Point> lineBresenham(Graphics g, int x1, int y1, int x2, int y2, Color col) {
        ArrayList<Point> points = new ArrayList<>();
        int x = x1, y = y1;
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int sx = Integer.compare(x2 - x1, 0);
        int sy = Integer.compare(y2 - y1, 0);
        int tx, ty;
        if (dx >= dy) {
            tx = sx;
            ty = 0;
        } else {
            int z = dx;
            dx = dy;
            dy = z;
            tx = 0;
            ty = sy;
        }
        g.setColor(col);
        int scount = 2 * dy;
        int count = scount - dx;
        int dcount = count - dx;
        for (; ; ) {
            dx -= 1;
            if (dx < -1) break;
            g.drawLine(x, y, x, y);
            points.add(new Point(x, y));
            if (count >= 0) {
                x += sx;
                y += sy;
                count += dcount;
            } else {
                x += tx;
                y += ty;
                count += scount;
            }
        }
        return points;
    }

    public static ArrayList<Point> circleBresenham(Graphics g, int x, int y, int r, Color col) {
        ArrayList<Point> points = new ArrayList<>();
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

            points.add(new Point(x + sx, y - sy));
            points.add(new Point(x + sx, y + sy));
            points.add(new Point(x - sx, y - sy));
            points.add(new Point(x - sx, y + sy));

            points.add(new Point(x + sy, y + sx));
            points.add(new Point(x - sy, y + sx));
            points.add(new Point(x + sy, y - sx));
            points.add(new Point(x - sy, y - sx));

            if (d < 0) {
                d = d + 4 * sx + 6;
            } else {
                d = d + 4 * (sx - sy) + 10;
                sy = sy - 1;
            }
            sx += 1;
        }
        return points;
    }
}
