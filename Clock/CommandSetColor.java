 package net.blueaxealotle.clock;

import java.awt.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
*/

public class CommandSetColor extends Command {

   private Color color;

   public CommandSetColor(Color c){
      color = c;
   }
   
   public void doCommand(Graphics2D g, int width, int height){
      g.setColor(color);
   }
}
