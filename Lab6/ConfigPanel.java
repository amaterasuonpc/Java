package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConfigPanel {
    private int sides=3;
    private String color="BLACK";
    private int stroke=1;
    private int size=100;

    public void setSides(String sides) {
        this.sides = Integer.getInteger(sides);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStroke(String stroke) {
        this.stroke = Integer.getInteger(stroke);
    }

    public void setSize(String size) {
        this.size = Integer.getInteger(size);
    }

    public int getSides() {
        return sides;
    }

    public String getColor() {
        return color;
    }

    public int getStroke() {
        return stroke;
    }

    public int getSize() {
        return size;
    }
}
