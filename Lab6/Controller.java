package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sun.security.krb5.Config;

public class Controller {
    ConfigPanel configPanel = new ConfigPanel();
    ControlPanel controlPanel = new ControlPanel();
    DrawingPanel drawingPanel = new DrawingPanel();
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private TextField textField6;
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
        configPanel.setColor(textField1.getText());

    }

    public void tf3Function() {
        configPanel.setSides(textField1.getText());

    }

    public void tf4Function() {
        configPanel.setStroke(textField1.getText());

    }
    public void draw (){
        GraphicsContext gc = canvas1.getGraphicsContext2D();
        //gc.drawImage();


    }



    public void saveFunction() {

    }

    public void loadfunction() {

    }

    public void exitfunction() {

    }

    public void resetfunction() {

    }


}
