package sample;

import javafx.scene.shape.Polygon;

public class CustomPolygon {
    private double centerX;
    private double centerY;
    private double radius;
    private int sides;

    public CustomPolygon(double centerX, double centerY, double radius, int sides) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.sides = sides;
    }

    public Polygon newPolygon (){
        Polygon polygon = new Polygon();
        double angleStep = Math.PI * 2 / sides;
        double angle = 0; // assumes one point is located directly beneat the center point
        for (int i = 0; i < sides; i++, angle += angleStep) {
            polygon.getPoints().addAll(
                    Math.sin(angle) * radius + centerX, // x coordinate of the corner
                    Math.cos(angle) * radius + centerY // y coordinate of the corner
            );
        }
        return polygon;

    }
}
