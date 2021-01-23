package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import models.ColorCode;
import models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextArea txt_red;
    @FXML private TextArea txt_green;
    @FXML private TextArea txt_blue;
    @FXML private TextField field_color;
    @FXML private Text txt_hex;
    @FXML private Text txt_col;
    Model mod = new Model();
    public void changecolor(){
        mod.changeColorViaAbsoluteValue(ColorCode.RED, txt_red.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        field_color.setEditable(false);
    }
}
