package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import models.ColorCode;
import models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextField txt_red;
    @FXML private TextField txt_green;
    @FXML private TextField txt_blue;
    @FXML private TextField field_color;
    @FXML private Text txt_hex;
    @FXML private Text txt_col;
    Model mod = new Model();

    public void changecolorText(){
        try {
            mod.changeColorViaAbsoluteValue(ColorCode.RED, txt_red.getText());
            mod.changeColorViaAbsoluteValue(ColorCode.GREEN, txt_green.getText());
            mod.changeColorViaAbsoluteValue(ColorCode.BLUE, txt_blue.getText());
        }
        catch (Exception x){
            System.out.print("The Input is not permitted.\n");
        }
        updateColor();
    }

    public void saveColor(){
        mod.saveToFile();
    }
    public void loadColor(){
        mod.loadFormFile();
        updateColor();
    }

    public void changecolorButton(MouseEvent event){
        Object node = event.getSource();
        Button btn = (Button)node;
        String s = btn.getText();
        String color = btn.getId();
        if (s.equals("+10"))
        {
           if (color.equals("red")){
               mod.changeColorViaRelativeValue(ColorCode.RED,10);
           }
           else if (color.equals("green")){
               mod.changeColorViaRelativeValue(ColorCode.GREEN,10);
           }
           else {
               mod.changeColorViaRelativeValue(ColorCode.BLUE,10);
           }
        }
        else {
            if (color.equals("red")){
                mod.changeColorViaRelativeValue(ColorCode.RED,-10);
            }
            else if (color.equals("green")){
                mod.changeColorViaRelativeValue(ColorCode.GREEN,-10);
            }
            else {
                mod.changeColorViaRelativeValue(ColorCode.BLUE,-10);
            }
        }
        updateColor();
    }
    private void updateColor(){
        txt_red.setText(String.valueOf(mod.getRed()));
        txt_green.setText(String.valueOf(mod.getGreen()));
        txt_blue.setText(String.valueOf(mod.getBlue()));
        field_color.setStyle("-fx-background-color: "+mod.getHex()+";");
        txt_col.setStyle("-fx-fill: "+mod.getHex()+";");
        txt_hex.setText("Hex: "+ mod.getHex());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        field_color.setEditable(false);
        updateColor();
    }
}
