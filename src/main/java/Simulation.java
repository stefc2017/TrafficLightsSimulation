package main.java;

import javax.swing.*;
import java.awt.*;

public class Simulation extends JPanel {

    private int timeLeft = 20;
    private boolean redLight_enabled = false;
    private boolean yellowLight_enabled = false;
    private boolean greenLight_enabled = true;

    public void reduceTime(){
        timeLeft--;
    }

    public int getTimeLeft(){
        return timeLeft;
    }

    public void setTimeLeft(int time){
        timeLeft = time;
    }

    public void setLightOn(String lightColor){
        if(lightColor == "green"){
            greenLight_enabled = true;
        }
        else if(lightColor == "yellow"){
            yellowLight_enabled = true;
        }
        else{
            redLight_enabled = true;
        }
    }

    public void setLightOff(String lightColor){
        if(lightColor == "green"){
            greenLight_enabled = false;
        }
        else if(lightColor == "yellow"){
            yellowLight_enabled = false;
        }
        else{
            redLight_enabled = false;
        }
    }

    public String getCurrentEnabledLight(){
        String enabledLight = "";
        if(greenLight_enabled){
            enabledLight = "green";
        }
        else if(yellowLight_enabled){
            enabledLight = "yellow";
        }
        else{
            enabledLight = "red";
        }
        return enabledLight;
    }

    @Override
    public void paint(Graphics graphic) {
        System.out.println(timeLeft + "time left2s");
        super.paint(graphic);
        Graphics2D graphic2d = (Graphics2D) graphic;
        graphic2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        drawTrafficLight(graphic2d);
        drawCrossingTrafficLight(graphic2d);
        drawActiveLight(graphic2d);
        reduceTime();
    }

    private void drawActiveLight(Graphics2D graphic){
        if(getCurrentEnabledLight() == "green"){
            graphic.setColor(Color.green);
            graphic.fillOval(175, 550, 150, 150);
        }
        else if(getCurrentEnabledLight() == "yellow"){
            graphic.setColor(Color.yellow);
            graphic.fillOval(175, 325, 150, 150);
        }
        else if(getCurrentEnabledLight() == "red"){
            graphic.setColor(Color.red);
            graphic.fillOval(175, 100, 150, 150);
        }
    }

    private void drawTrafficLight(Graphics2D graphic){
        graphic.setColor(new Color(231, 180, 22));
        //color in traffic light
        graphic.fillRect(50, 50, 400, 700);

        graphic.setColor(Color.black);
        //red traffic light
        graphic.fillOval(175, 100, 150, 150);
        //yellow traffic light
        graphic.fillOval(175, 325, 150, 150);
        //green traffic light
        graphic.fillOval(175, 550, 150, 150);
    }

    private void drawCrossingTrafficLight(Graphics2D graphic){
        //traffic light for walking (crossing the street)
        graphic.fillRect(500, 50, 400, 700);

        graphic.setColor(Color.gray);
        //picture that says to cross or stop
        graphic.fillRect(575, 110, 250, 250);
        //timer
        graphic.fillRect(575, 440, 250, 250);
        //drawPedestrianLightSignal(graphic);
        drawTimeLeft(graphic);
    }

    private void drawTimeLeft(Graphics2D graphic){
        int xcoordinate = 610;
        int ycoordinate = 610;

        graphic.setColor(Color.red);
        graphic.setFont(new Font("TimesRoman", Font.PLAIN, 150));

        if(timeBelowTenSeconds()){
            xcoordinate = 695;
        }

        System.out.println(timeLeft + "time left");
        graphic.drawString(timeLeft + "",xcoordinate, ycoordinate);
    }

    private boolean timeBelowTenSeconds(){
        return (timeLeft - 10 < 0);
    }

    private void drawPedestrianLightSignal(Graphics2D graphic){
        ImageIcon icon = new ImageIcon(this.getClass()
                .getResource("../images/walkingGuy.png"));
        int x = 100;
        int y = 100;
        icon.paintIcon(this, graphic, x, y);
    }
}
