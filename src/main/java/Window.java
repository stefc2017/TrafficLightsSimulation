package main.java; /**
 * Created by Stefan on 2017-12-20.
 */
import javax.swing.*;

public class Window{

    public Window() throws InterruptedException {
        JFrame myFrame = new JFrame("Traffic Lights main.java.Simulation");
        Simulation simulation = new Simulation();
        myFrame.add(simulation);
        myFrame.setSize(1000,1000);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

        while(true){
            if(simulation.getTimeLeft() == 3 && simulation.getCurrentEnabledLight() == "green"){
                simulation.setLightOff("green");
                simulation.setLightOn("yellow");
            }
            else if(simulation.getTimeLeft() == -1 && simulation.getCurrentEnabledLight() == "yellow"){
                simulation.setLightOff("yellow");
                simulation.setLightOn("red");
                simulation.setTimeLeft(20);
            }
            else if(simulation.getTimeLeft() == -1 && simulation.getCurrentEnabledLight() == "red"){
                simulation.setLightOff("red");
                simulation.setLightOn("green");
                simulation.setTimeLeft(20);
            }

            simulation.repaint();
            Thread.sleep(1000);
        }
    }
}
