 

import java.awt.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
*/

public class CommandSetPenWidth extends Command {

   private int penWidth;

   public CommandSetPenWidth(int w){
      penWidth = w;
   }
   
   public void doCommand(Graphics2D g, int width, int height){
      g.setStroke(new BasicStroke(penWidth));
   }    
}
