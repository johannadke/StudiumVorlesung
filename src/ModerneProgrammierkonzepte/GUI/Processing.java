package ModerneProgrammierkonzepte.GUI;

import ModerneProgrammierkonzepte.GUI.GuiButton;
import processing.core.*; //import processing
public class Processing extends PApplet {

    GuiButton button = new GuiButton(320.0f, 220.0f,50.0f,50.0f, "klick", this);

    public static void main(String[] args) {
        PApplet.main("ModerneProgrammierkonzepte.GUI.Processing");
    }

    public void settings() { // startup settings
        size(800, 600); //Größe des Fensters
    }
    public void setup() { // setup called after settings - auch während der Laufzeit aufrufbar
        stroke(255, 0, 0, 255);
        textSize(72);
    }

    public void draw() { // draw loop is calling every frame (60 Hz)
        background(562); // clear background
        //textSize(bgCol);

        button.drawButton(100);
        //text("Hello World!",10,300);
        //bgCol = (bgCol + 1) % 128;
    }
}
