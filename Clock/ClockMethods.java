import java.util.concurrent.TimeUnit;
import java.time.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides default behavior and state for a pen.  The pen's initial color is blue and its width is 2 pixels.  It is situated at the origin of a sketchpad, facing north (90 degrees).  It is placed down on the sketchpad, ready to draw.
*/

public class ClockMethods extends AbstractPen {

   // Constructors ------------------------------
   
   /**  
   Action: Pops up an application window containing a sketchpad
   and an associated standard pen.
   */  
   public ClockMethods(){
      this(new SketchPad());
      new SketchPadWindow(pad);
   }

   /**  
   Action: Associates a standard pen with a client-supplied sketchpad.
   */  
   public ClockMethods(SketchPad p){
      super(p);
   }

   /**  
   Action: Pops up the client's application window containing a sketchpad
   and an associated standard pen.
   */  
   public ClockMethods(SketchPadWindow w){
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
   
      public void drawTicks() {
        this.setColor(Color.magenta);
        this.drawRegularPoly(1000, 0, 0, 300, 7);
        this.setColor(Color.white);
        this.drawTick(0, 300);
        this.drawTick(300, 0);
        this.drawTick(0, -300);
        this.drawTick(-300, 0);
        this.setColor(Color.white);
        for (int i = 30; i <= 360; i += 30) {
            this.drawSTick(i, 300);
        }
        for (int i = 6; i <= 360; i += 6) {
            this.drawSTick(i, 300, 10);
        }
   }
   
   public void drawTick(int x, int y) {
       this.up();
       this.move(x, y);
       this.down();
       if (x == 0 && y > 0) {
           this.move(x, y - 50);
       } else if(x > 0 && y == 0) {
           this.move(x - 50, y);
       } else if(x == 0 && y < 0) {
           this.move(x, y + 50);
       } else if(x < 0 && y == 0) {
           this.move(x + 50, y);
       }
   }
   
   public void drawSTick(int d, int length) {
       this.up();
       this.move(0, 0);
       this.setDirection(d);
       this.move(length);
       this.down();
       this.setDirection(d - 180);
       this.move(30);  
       
   }
   
   public void drawSTick(int d, int length, int size) {
       this.up();
       this.move(0, 0);
       this.setDirection(d);
       this.move(length);
       this.down();
       this.setDirection(d - 180);
       this.move(size);  
   }
   
   public static void drawClock(){
        ClockMethods clock = new ClockMethods();
        clock.drawTicks();
        ZonedDateTime csts = ZonedDateTime.now(ZoneId.of("America/Chicago")).getSecond();
        ZonedDateTime cstm = ZonedDateTime.now(ZoneId.of("America/Chicago")).getMinute();
        ZonedDateTime csth = ZonedDateTime.now(ZoneId.of("America/Chicago")).getHour();
       
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
               p.pi(csts);
               p.pi(cstm);
               p.pi(csth);
            }
        }, 0, 10);
   }

   
}

