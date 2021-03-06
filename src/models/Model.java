package models;


import java.io.*;
import java.util.Scanner;

public class Model{
    ModularCounter red;
    ModularCounter green;
    ModularCounter blue;
    final String datName = "color.dat";
    final String Identifier = "Color File Format 1.0";

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
            red.dec(redd*-1);
            else {
                red.inc(redd);
            }
        }
        else if (cc == ColorCode.GREEN){
            int greend=value-getGreen();
            if (greend<0)
                green.dec(greend*-1);
            else {
                green.inc(greend);
            }
        }
        else{
            int blued=value-getBlue();
            if (blued<0)
                blue.dec(blued*-1);
            else {
                blue.inc(blued);
            }
        }
    }
    public void changeColorViaRelativeValue(ColorCode cc, String value){
        changeColorViaAbsoluteValue(cc,Integer.parseInt(value));
    }
    public void saveToFile(){
        try(FileWriter fileWriter = new FileWriter(datName)){
            BufferedWriter BWriter = new BufferedWriter(fileWriter);
            BWriter.write(Identifier);
            BWriter.newLine();
            BWriter.write(String.valueOf(getRed()));
            BWriter.newLine();
            BWriter.write(String.valueOf(getGreen()));
            BWriter.newLine();
            BWriter.write(String.valueOf(getBlue()));
            BWriter.close();
        }
        catch (IOException io){
            System.out.print(io.getMessage());
        }
    }
    public void loadFormFile(){
        try(FileReader fileReader = new FileReader(datName)){
            BufferedReader BReader = new BufferedReader(fileReader);
            String k = BReader.readLine();
            String r = BReader.readLine();
            String g = BReader.readLine();
            String b = BReader.readLine();
            if (!k.equals(null)&&!r.equals(null)&&!g.equals(null)&& !b.equals(null) && k.equals(Identifier)) {
                changeColorViaAbsoluteValue(ColorCode.RED, r);
                changeColorViaAbsoluteValue(ColorCode.GREEN, g);
                changeColorViaAbsoluteValue(ColorCode.BLUE, b);
            }
            else{
                System.out.println("File corrupted");
            }
        }
        catch (IOException io){
            System.out.print(io.getMessage());
        }
    }
    public void changeColorViaRelativeValue(ColorCode cc, int value){
        if (cc == ColorCode.RED){
            if (value<0)
                red.dec(value*-1);
            else {
                red.inc(value);
            }
        }
        else if (cc == ColorCode.GREEN){
            if (value<0)
                green.dec(value*-1);
            else {
                green.inc(value);
            }
        }
        else{
            if (value<0)
                blue.dec(value*-1);
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
        return  String.format("#%02x%02x%02x", getRed(), getGreen(), getBlue());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("red: "+getRed()+"\n");
        stringBuilder.append("green: "+getGreen()+"\n");
        stringBuilder.append("blue: "+getBlue()+"\n");
        stringBuilder.append("hex: "+getHex()+"\n");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Model m = new Model();
        Scanner scanner = new Scanner(System.in);
        String s;
        String color;
        ColorCode cc = null;
        do {

            System.out.print("---------------------------\n");
            System.out.print("Commands:\n" +
                    "a - setAbsoluteValue\n" +
                    "r - setRelativeValue\n" +
                    "s - saveColor\n" +
                    "l - loadColor\n" +
                    "? - view current Settings\n" +
                    "q - quit Program\n");
            s = scanner.next();
            if (s.equals("a")||s.equals("r")) {
                System.out.print("Which Color should be changed?\n");
                color = scanner.next();
                if (color.equals("red")){
                    cc= ColorCode.RED;
                }
                else if (color.equals("green")){
                    cc= ColorCode.GREEN;
                }
                else if (color.equals("blue")){
                    cc= ColorCode.BLUE;
                }
                try {

                    if (!cc.equals(null)) {
                        System.out.print("Please enter Value");
                        try {
                            if (s.equals("a")) {
                                m.changeColorViaAbsoluteValue(cc, scanner.nextInt());
                            } else {
                                m.changeColorViaRelativeValue(cc, scanner.nextInt());
                            }
                        }
                        catch (Exception x){
                            System.out.print("The Input is not permitted.\n");
                        }
                        cc = null;
                    }
                }
                catch (NullPointerException x){
                    System.out.print("This is not a permitted color.\n");
                }
            } else if (s.equals("?")) {
                System.out.print(m.toString());
            }
            else if (s.equals("s")){
                m.saveToFile();
            }
            else if (s.equals("l")){
                m.loadFormFile();
            }
            else if (!s.equals("q")){
                System.out.print("Command not found\n");
            }
        }while (!s.equals("q"));
    }
}
