package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ConfigPanel {
    private int sides=3;
    private String color="BLACK";
    private int stroke=1;
    private int size=100;

    public void setSides(String sides) {
        System.out.println(sides);

        this.sides = Integer.parseInt(sides);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStroke(String stroke) {
        this.stroke = Integer.getInteger(stroke);
    }

    public void setSize(String size) {
        this.size = Integer.parseInt(size);
    }

    public int getSides() {
        return sides;
    }

    public Color getColor() {//cateva culori predefinite
        switch(color){
            case "YELLOW":
                return Color.YELLOW;
            case "WHITE":
                return Color.WHITE;
            case "BLUE" :
                return Color.BLUE;
            case "RED" :
                return Color.RED;
            case "GREEN":
                return Color.GREEN;
            default :
                return Color.BLACK;

        }
    }

    public int getStroke() {
        return stroke;
    }

    public int getSize() {
        return size;
    }
}
