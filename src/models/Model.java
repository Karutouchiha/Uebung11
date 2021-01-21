package models;

public class Model {
    ModularCounter red;
    ModularCounter green;
    ModularCounter blue;
    public Model(){
        ModularCounter red = new ModularCounter(255, 256);
        ModularCounter green = new ModularCounter(255, 256);
        ModularCounter blue = new ModularCounter(255, 256);
    }
    public void changeColorViaAbsoluteValue(ColorCode cc, String value){

    }
    public void changeColorViaAbsoluteValue(ColorCode cc, int value){

    }
    public void changeColorViaRelativeValue(ColorCode cc, String value){

    }
    public void changeColorViaRelativeValue(ColorCode cc, int value){

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
        System.out.print(red.toString());
        return "hex";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {

    }
}
