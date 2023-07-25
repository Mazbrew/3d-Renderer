import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
    protected Frame(Panel panel){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenXPos = (int)(size.getWidth()/2 - panel.getWidth()/2);
        int screenYPos = (int)(size.getHeight()/2 - panel.getHeight()/2);


        this.setTitle("3D Renderer");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(screenXPos, screenYPos);

        this.add(panel);
        this.getContentPane().setPreferredSize(panel.getSize());
        this.pack();
        
        this.setVisible(true);
    }
}
