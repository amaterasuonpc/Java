package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel {
    public void save (Canvas canvas1){
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("png files (.png)", ".png");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage((int) canvas1.getWidth(), (int) canvas1.getHeight());
                canvas1.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                //Logger.getLogger(JavaFX_DrawOnCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }



    }
    public void load (Canvas canvas1){
        FileChooser fileChooser = new FileChooser();
        //open file dialog
        File file = fileChooser.showOpenDialog(null);
        //Image are in constructor doar variabile de tipul URI deci a trebuit sa convertesc file la URI
        Image img2 = new Image(file.toURI().toString(),780,380,true,true);
        GraphicsContext gc = canvas1.getGraphicsContext2D();
        try {
            BufferedImage img = ImageIO.read(file);

            gc.drawImage(img2,0,0);

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void reset(Canvas canvas1){
        //se deseneaaza un patrat alb pe canvas de dimensiunea pe care o are si canvas
        GraphicsContext gc = canvas1.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.clearRect(0, 0, canvas1.getWidth(), canvas1.getHeight());

    }
    public void exit(){
        System.exit(0);

    }


}
