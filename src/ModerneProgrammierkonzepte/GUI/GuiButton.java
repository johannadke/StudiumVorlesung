package ModerneProgrammierkonzepte.GUI;

import processing.core.*; //import processing

public class GuiButton extends PApplet{
    private float x0;
    private float y0;
    //private float x1;
    //private float y1;
    private float width;
    private float height;
    private int color;
    private String text;
    PApplet parent;


    public GuiButton(float x0, float y0, float width, float height, String text, PApplet parent){
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
        this.text = text;
        this.parent = parent;

    }
    public void drawButton( int color){
       parent.fill(100,0,0);
        parent.rect(x0, y0, width, height);
    }
}
