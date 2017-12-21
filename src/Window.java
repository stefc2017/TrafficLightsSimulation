/**
 * Created by Stefan on 2017-12-20.
 */
import javax.swing.*;

public class Window{

    public Window(){
        JFrame myFrame = new JFrame("Traffic Lights Simulation");
        myFrame.add(new Game());
        myFrame.setSize(1000,1000);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}
