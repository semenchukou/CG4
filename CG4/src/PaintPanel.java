import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {
    List<Figure> figures;
    int scale;

    public PaintPanel() {
        this.scale = 1;
        setScale(scale);
        figures = new ArrayList<>();
    }

    public void setScale(int scale) {
        this.scale = scale;
        this.repaint();
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        AffineTransform atrans = null;
        Graphics2D g2d = (Graphics2D) g;
        atrans = AffineTransform.getScaleInstance(scale, scale);
        if (atrans != null) {
            g2d.setTransform(atrans);
        }
        for (Figure f : figures) {
            f.paint(g);
        }
    }
}
