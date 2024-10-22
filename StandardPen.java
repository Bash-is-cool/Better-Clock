import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.LocalTime;
import java.awt.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides default behavior and state for a pen.  The pen's initial color is blue and its width is 2 pixels.  It is situated at the origin of a sketchpad, facing north (90 degrees).  It is placed down on the sketchpad, ready to draw.
*/

public class StandardPen extends AbstractPen {

   // Constructors ------------------------------
   
   /**   
   Action: Pops up an application window containing a sketchpad 
   and an associated standard pen.
   */   
   public StandardPen(){
      this(new SketchPad());
      new SketchPadWindow(pad);
   }

   /**   
   Action: Associates a standard pen with a client-supplied sketchpad.
   */   
   public StandardPen(SketchPad p){
      super(p);
   }

   /**   
   Action: Pops up the client's application window containing a sketchpad 
   and an associated standard pen.
   */   
   public StandardPen(SketchPadWindow w){
      this(new SketchPad());
      Container c = w.getContentPane();
      c.add(pad);
      w.setVisible(true);
   }


   // Public methods ----------------------------
   
   public void drawString(String text) {
      pad.setColor(color);
      pad.drawString(text, xPos, yPos, color);
   }
   
   // Protected methods -------------------------

   protected void drawLine(double x, double y){
      if (isDown){
         pad.setColor(color);
         pad.setPenWidth(width);
         pad.drawLine(xPos, yPos, x, y, color, width);
      }
      xPos = x;
      yPos = y;
   }   
   
   public void drawSquare() {
       for (int i = 0; i < 5; i++) {
           this.move(100);
           this.turn(90);
       }
   }
   
   public void drawSquare(int x, int y) {
       this.up();
       this.move(x, y);
       this.down();
       this.setDirection(0);
        for (int i = 0; i < 5; i++) {
           this.move(100);
           this.turn(90);
       }
   }
   
   public void drawSquare(int x, int y, int length, int width) {
       this.up();
       this.move(x, y);
       this.down();
       this.setDirection(0);
       this.setWidth(width);
        for (int i = 0; i < 5; i++) {
           this.move(length);
           this.turn(90);
       }
   }
   
   public void goTo() {
       this.move(0, 0);
   }
   
   public void drawRegularPoly(int sides, int x, int y, int length, int width){
        this.up();
        this.move(x, y);
        this.down();
        this.setDirection(0);
        this.setWidth(width);
        int angle = (180 * (sides-2)) / sides;
         for(int i = 0; i <= sides; i++){
             this.move(length);
             this.move(0, 0);
             this.turn(360 - angle);
        }
    }
   
   public void  drawInitials() {
       this.turn(30);
       this.move(100);
       this.turn(120);
       this.move(100);
       this.turn(180);
       this.move(50);
       this.turn(300);
       this.move(50);
       this.up();
       this.move(10,0);
       this.down();
       this.setDirection(0);
       this.move(50);
       for (int i = 0; i < 2; i++) {
           this.turn(90);
           this.move(50);
        }
       this.setDirection(0);
       for (int i = 0; i < 3; i++) {
           if (i == 0) {
               this.turn(90);
               this.move(50);
           } else if (i == 1) {
               this.turn(-90);
               this.move(50);
           }
        }
   }
}
