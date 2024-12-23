

import javax.swing.*;
import java.awt.Container;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides behavior for an application window with sketchpads.
*/

public class SketchPadWindow extends JFrame{

   /**   
   Action: Sets the close operation to exit, but the client 
   must add the sketchpad(s) and set all of the other attributes 
   of the window.
   */   
   public SketchPadWindow(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   /**   
   Action: Sets the close operation to exit and the window's
   width and height to the parameters, but the client 
   must add the sketchpad(s) and set all of the other attributes 
   of the window.
   */   
   public SketchPadWindow(int width, int height){
      this();
      setSize(width, height);
   }

   /**   
   Action: Pops up an application window with the client's
   sketchpad and a default size of 150, 150.
   */   
   public SketchPadWindow(SketchPad pad){
      this(150, 150, pad);
   }

   /**   
   Action: Pops up an application window with the client's
   sketchpad, width, and height.
   */   
   public SketchPadWindow(int width, int height, SketchPad pad){
      Container container = getContentPane();
      container.add(pad);
      setSize(width, height);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

}