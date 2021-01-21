package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import models.Model;

public class Controller {
    @FXML private TextArea txt_red;
    @FXML private TextArea txt_green;
    @FXML private TextArea txt_blue;
    @FXML private TextField field_color;
    @FXML private Text txt_hex;
    @FXML private Text txt_col;
    Model mod = new Model();

    public void gethex(){
        gethex();
    }

}
