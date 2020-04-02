package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    ConfigPanel configPanel = new ConfigPanel();
    CustomPolygon customPolygon;
    ControlPanel controlPanel = new ControlPanel();
    DrawingPanel drawingPanel = new DrawingPanel();
    double screenX;
    double screenY;

    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;

    @FXML
    private Region region1;
    @FXML
    private Canvas canvas1;

    @FXML
    private Button save;
    @FXML
    private Button exit;
    @FXML
    private Button reset;
    @FXML
    private Button load;

    public void tf1Function() {
        configPanel.setSize(textField1.getText());
    }

    public void tf2Function() {

        configPanel.setSides(textField2.getText());

    }

    public void tf3Function() {
        configPanel.setColor(textField3.getText());

    }


    public void draw() {
        MouseEvent event;

        canvas1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {//pentru a luat pozitia mouse-ului a trebuit sa folosim un EventHandler

                screenX = event.getX();
                screenY = event.getY();
                customPolygon = new CustomPolygon(screenX, screenY, configPanel.getSize(), configPanel.getSides());//se creeaza un polygon la coordonatele specificate
                GraphicsContext gc = canvas1.getGraphicsContext2D();
                gc.setFill(configPanel.getColor());//se schimba culoarea

                Polygon temp = customPolygon.newPolygon();
                List<Double> points;
                points = temp.getPoints();//se iau coordonatele fiecarui punct si sunt puse in 2 arrays diferite pentru a putea fi trimise la functia .fillPolygon
                double[] pointsx = new double[configPanel.getSides()];
                double[] pointsy = new double[configPanel.getSides()];


                for (int i = 0; i < points.size(); i++) {
                    if (i % 2 == 0) {
                        pointsx[i / 2] = points.get(i);
                    } else {
                        pointsy[i / 2] = points.get(i);
                    }

                }


                gc.fillPolygon(pointsx,
                        pointsy, configPanel.getSides());

            }
        });


    }


    public void saveFunction() {
        controlPanel.save(canvas1);
    }

    public void loadfunction() {
        controlPanel.load(canvas1);
    }

    public void exitfunction() {
        controlPanel.exit();

    }

    public void resetfunction() {
        controlPanel.reset(canvas1);

    }


}
