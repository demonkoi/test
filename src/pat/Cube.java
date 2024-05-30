package pat;

import java.awt.*;
import javax.swing.*;

public class Cube extends JPanel implements Runnable {
    private double angleX = 0;
    private double angleY = 0;
    private double angleZ = 0;

    private final int size = 200;
    private final int[][] vertices = {
            { -1, -1, -1 }, { 1, -1, -1 }, { 1, 1, -1 }, { -1, 1, -1 },
            { -1, -1, 1 }, { 1, -1, 1 }, { 1, 1, 1 }, { -1, 1, 1 }
    };

    private final int[][] edges = {
            { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 },
            { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 4 },
            { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 }
    };

    public Cube() {
        new Thread(this).start();
    }

    private void rotate(double[] point, double angleX, double angleY, double angleZ) {
        double x = point[0];
        double y = point[1];
        double z = point[2];

        // Rotate around X-axis
        double temp = y;
        y = y * Math.cos(angleX) - z * Math.sin(angleX);
        z = temp * Math.sin(angleX) + z * Math.cos(angleX);

        // Rotate around Y-axis
        temp = x;
        x = x * Math.cos(angleY) + z * Math.sin(angleY);
        z = -temp * Math.sin(angleY) + z * Math.cos(angleY);

        // Rotate around Z-axis
        temp = x;
        x = x * Math.cos(angleZ) - y * Math.sin(angleZ);
        y = temp * Math.sin(angleZ) + y * Math.cos(angleZ);

        point[0] = x;
        point[1] = y;
        point[2] = z;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);

        int width = getWidth();
        int height = getHeight();

        double[][] transformedVertices = new double[8][3];
        for (int i = 0; i < 8; i++) {
            // Convert int[] to double[]
            transformedVertices[i] = new double[] { vertices[i][0], vertices[i][1], vertices[i][2] };
            for (int j = 0; j < 3; j++) {
                transformedVertices[i][j] *= size / 2.0;
            }
            rotate(transformedVertices[i], angleX, angleY, angleZ);
            transformedVertices[i][0] += width / 2.0;
            transformedVertices[i][1] += height / 2.0;
        }

        for (int[] edge : edges) {
            int x1 = (int) transformedVertices[edge[0]][0];
            int y1 = (int) transformedVertices[edge[0]][1];
            int x2 = (int) transformedVertices[edge[1]][0];
            int y2 = (int) transformedVertices[edge[1]][1];
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    public void run() {
        while (true) {
            angleX += 0.01;
            angleY += 0.01;
            angleZ += 0.01;
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
