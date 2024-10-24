

import java.awt.Color;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
The behavior of all pens.
*/

public interface Pen {

   /**   
   Action: The pen lowers itself to the drawing surface.
   */   
   public void down();
  
   /**   
   Action: Draws the string at the pen's position.
   */   
   public void drawString (String text);

   /**   
   The pen jumps to the center of the graphics window without drawing
   and points north.
   */   
   public void home();

   /**   
   Action: The pen moves the specified distance in the current direction. 
   The distance can be an integer or floating-point number and is measured 
   in pixels (picture elements). The size of a pixel depends on the 
   monitor�s resolution. For instance, when we say that a monitor's 
   resolution is 800 by 600, we mean that the monitor is 800 pixels wide 
   and 600 pixels high.
   */   
   public void move (double distance);

   /**   
   Action: Moves the pen to the position (x, y).
   */   
   public void move (double x, double y);

   /**   
   Action: Sets the pen's color to the specified color.
   */   
   public void setColor (Color color);

   /**   
   Action: The pen points in the indicated direction. Due east corresponds 
   to 0 degrees, north to 90 degrees, west to 180 degrees, and south to 270 
   degrees. Because there are 360 degrees in a circle, setting the 
   direction to 400 would be equivalent to 400 - 360 or 40 and setting it 
   to -30 would be equivalent to 360 - 30 or 330.
   Example: pen.setDirection(90);   Make the pen point due north.
   */   
   public void setDirection (double direction);

   /**   
   Action: Sets the pen's width to the specified width (the default width is 2 pixels).
   */   
   public void setWidth (int width);

   /**   
   Action: Returns information about the pen's state.
   */   
   public String toString();

   /**   
   Action: The pen adds the indicated degrees to its current direction. 
   Positive degrees correspond to turning counterclockwise. The degrees can 
   be an integer or floating-point number.
   Example: pen.turn(-45);  Rotate the pen 45 degrees clockwise.
   */   
   public void turn (double degrees);

   /**   
   Action: The pen raises itself from the drawing surface.
   */   
   public void up();
}
