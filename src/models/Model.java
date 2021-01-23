package models;

import javafx.scene.paint.Color;

public class Model{
    ModularCounter red;
    ModularCounter green;
    ModularCounter blue;
    public Model(){
        this.red = new ModularCounter(255, 256);
        this.green = new ModularCounter(255, 256);
        this.blue = new ModularCounter(255, 256);
    }
    public void changeColorViaAbsoluteValue(ColorCode cc, String value){
        changeColorViaAbsoluteValue(cc,Integer.parseInt(value));
    }
    public void changeColorViaAbsoluteValue(ColorCode cc, int value){
        if (cc == ColorCode.RED){
            int redd=value - getRed();
            if (redd<0)
            red.dec(redd);
            else {
                red.inc(redd);
            }
        }
        else if (cc == ColorCode.GREEN){
            int greend=value-getGreen();
            if (greend<0)
                green.dec(greend);
            else {
                green.inc(greend);
            }
        }
        else{
            int blued=value-getBlue();
            if (blued<0)
                blue.dec(blued);
            else {
                blue.inc(blued);
            }
        }
    }
    public void changeColorViaRelativeValue(ColorCode cc, String value){
        changeColorViaAbsoluteValue(cc,Integer.parseInt(value));
    }
    public void changeColorViaRelativeValue(ColorCode cc, int value){
        if (cc == ColorCode.RED){
            if (value<0)
                red.dec(value);
            else {
                red.inc(value);
            }
        }
        else if (cc == ColorCode.GREEN){
            if (value<0)
                green.dec(value);
            else {
                green.inc(value);
            }
        }
        else{
            if (value<0)
                blue.dec(value);
            else {
                blue.inc(value);
            }
        }
    }

    public int getRed() {
        return red.getValue();
    }
    public int getGreen() {
        return green.getValue();
    }

    public int getBlue() {
        return blue.getValue();
    }

    public String getHex(){
        return "hex";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {

    }
}
