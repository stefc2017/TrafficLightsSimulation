import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        //traffic light
        g2d.drawRect(50, 50, 400, 700);
        //red traffic light
        g2d.drawOval(175, 100, 150, 150);
        //yellow traffic light
        g2d.drawOval(175, 325, 150, 150);
        //green traffic light
        g2d.drawOval(175, 550, 150, 150);

        //traffic light for walking (crossing the street)
        g2d.drawRect(500, 50, 400, 700);
        //picture that says to cross or stop
        g2d.drawRect(575, 110, 250, 250);
        //timer
        g2d.drawRect(575, 440, 250, 250);

    }
}
