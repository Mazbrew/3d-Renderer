import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


public class Panel extends JPanel implements MouseInputListener{
    private int size;
    private Vector vector;
    private Edge edge;

    private int circleSize = 3;

    private int origin;

    private Point initialClick = new Point();


    public Panel(int size, Vector vector, Edge edge){
        this.size = size;
        this.vector = vector;
        this.edge = edge;

        this.setVisible(true);
        this.setSize(size, size);

        this.origin = size/2;

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g){
        paintBG(g);
        paintVectors(g);
        paintEdges(g);

        try{
            Thread.sleep(2);
        }catch(Exception e){
            System.out.println(e);
        }

        repaint();
    }

    private void paintBG(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, size, size);
    }

    private void paintVectors(Graphics g){
        g.setColor(Color.white);

        for(int i = 0; i < vector.getVectorMatrix().length; i ++){
            g.fillOval(origin + (int)vector.getVectorMatrix()[i][0] - circleSize/2, origin +(int)vector.getVectorMatrix()[i][1] - circleSize/2, circleSize, circleSize);
        }
    }

    private void paintEdges(Graphics g){
        g.setColor(Color.white);

        for(int i = 0; i < edge.getEdges().length; i ++){
            int first = edge.getEdges()[i][0];
            int second = edge.getEdges()[i][1];
            g.drawLine(origin + (int)vector.getVectorMatrix()[first][0], origin + (int)vector.getVectorMatrix()[first][1], origin + (int)vector.getVectorMatrix()[second][0], origin + (int)vector.getVectorMatrix()[second][1]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        initialClick = e.getPoint();
        System.out.println(initialClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        //fix the rotation
        double xdiff;

        if(initialClick.getX() > e.getPoint().getX()){
            xdiff = e.getPoint().getX()- initialClick.getX();
        }else{
            xdiff = initialClick.getX() - e.getPoint().getX();
        }
        
        System.out.println(xdiff);

        if(xdiff > 0){
            vector.rotateY(xdiff/this.size * 0.05);
        }else{
            vector.rotateY(xdiff/this.size * -0.05);
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
