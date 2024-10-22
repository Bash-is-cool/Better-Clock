 

import java.awt.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides the same behavior as a standard pen, but each move is in the
opposite direction.
*/

public class BackwardPen extends AbstractPen {

   // Constructors ------------------------------
   
   public BackwardPen(){
      this(new SketchPad());
      new SketchPadWindow(pad);
   }

   public BackwardPen(SketchPad p){
      super(p);
   }

   public BackwardPen(SketchPadWindow w){
      this(new SketchPad());
      Container c = w.getContentPane();
      c.add(pad);
      w.setVisible(true);
   }

   // Public methods ----------------------------
   
   public void drawString(String text) {
      pad.setColor(color);
      pad.drawString(text, -xPos, -yPos, color);
   }
   
   // Protected methods -------------------------

   protected void drawLine(double x, double y){
      if (isDown){
         pad.setColor(color);
         pad.setPenWidth(width);
         pad.drawLine(-xPos, -yPos, -x, -y, color, width);
      }
      xPos = x;
      yPos = y;
   }   
}
