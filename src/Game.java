import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.drawOval(350, 100, 200, 200);
        g2d.setColor(Color.YELLOW);
        g2d.drawOval(350, 300, 200, 200);
        g2d.drawOval(350, 100, 200, 200);
    }
}
