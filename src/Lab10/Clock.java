/**
 * Clock - a simple clock widget
 * 
 * The Clock widget may be used wherever a JPanel can be. It occupies a square whose side (in
 * pixels) is the only argument to its constructor. The Clock starts at 0 minutes, 0 seconds. It has
 * three hands: one makes a revolution every second, one every minute, one every hour.
 * 
 * The clock is updated with the current wall time using the method setTime(), and sets itself to
 * display that time. Since it has a sub-second hand, it is useful to update the time several times
 * a second, perhaps even every 5 milliseconds.
 * 
 * @author Ronny Sivan ronny.sivan@gmail.com
 * @date 19 May 2016
 */
package Lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Clock extends JPanel
{
   /**
    * serialVersionUID -
    */
   private static final long serialVersionUID = 1L;

   private int    size;             // the round clock fits into a square of this size
   private double radius;           // distance from center of clock to edge
   
   private double millisPos    = 0; // current second position, 0..999
   private double secondPos    = 0; // current second position, 0..59
   private double minutePos    = 0; // current minute position, 0..59

// private double oldMillisPos = 0; // previous second position, 0..999
// private double oldSecondPos = 0; // previous second position, 0..59
// private double oldMinutePos = 0; // previous minute position, 0..59

   private long   startTime;
   
   private int    xmargin;
   private int    ymargin;

   /**
    * 
    * Constructor -
    *
    * @param size - side of square containing clock (pixels)
    */
   public Clock( int size )
   {
      this.size = size;
      this.radius = (double) size / 2 - 5;
      setPreferredSize( new Dimension( size, size ) );
      xmargin = size / 20;
      ymargin = size / 15;
      
      startTime = 0;
      
      clockRunner();
   }

   
 
   /**
    * clockRunner - display the clock
    * 
    * Calling this method will display the clock on the screen
    *
    */
   private void clockRunner()
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      int edge = size + size / 6;
      frame.setPreferredSize( new Dimension( edge, edge ) );
      frame.add( this );
      frame.pack();
      frame.setVisible( true );      
   }
   
   
   
   /**
    * drawMillisSHand -
    *
    * @param g
    * @param pos - hand position (0..999.99)
    */
   private void drawMillisHand( Graphics g, double pos )
   {
      g.setColor( Color.red );
      traceMillisHand( g, pos );
   }

   /**
    * drawMinuteHand -
    *
    * @param g
    * @param pos - hand position (0..59.99)
    */
   private void drawMinuteHand( Graphics g, double pos )
   {
      g.setColor( Color.blue );
      traceMinuteHand( g, pos );
   }

   /**
    * drawNumbers - paint the face of the dial
    *
    * @param g
    */
   private void drawNumbers( Graphics g )
   {
      for( int i = 1; i <= 12; i++ )
      {
         String s = Integer.toString( i );
         double a = ( 0.5 - ( ( i <= 6 ) ? .01 : -.01 ) - (double) i / 6.0 ) * Math.PI;
         int x = (int) ( size / 2 + radius * Math.cos( a ) );
         int y = (int) ( size / 2 - radius * Math.sin( a ) );
         g.setFont( new Font( "ScriptMT", Font.BOLD, 24 ) );
         g.setColor( Color.black );
         g.drawString( s, x + xmargin, y + ymargin );
      }
   }

   /**
    * drawSecondHand -
    *
    * @param g
    * @param pos - hand position (0..59.99)
    */
   private void drawSecondHand( Graphics g, double pos )
   {
      g.setColor( Color.green );
      traceSecondHand( g, pos );
   }

   /**
    * erase - erase all hands
    *
    * @param g
    */
   private void erase( Graphics g )
   {
      double d;
      
      g.setColor( getBackground() );
      g.fillRect( 0, 0, getWidth(), getHeight() );
      return;
      
//      eraseMillisHand( g, oldMillisPos );
//      
//      for( d = -0.05; d < 0.05; d += .01 )
//      {
//         eraseSecondHand( g, oldSecondPos + d );
//         eraseMinuteHand( g, oldMinutePos + d );
//      }

   }

   /**
    * eraseMillisHand - draw the millisHand with background color
    *
    * @param g
    * @param pos
    */
   private void eraseMillisHand( Graphics g, double pos )
   {
      g.setColor( getBackground() );
      traceMillisHand( g, pos );
   }

   /**
    * eraseMinuteHand - draw the minuteHand with background color
    *
    * @param g
    * @param pos
    */
   private void eraseMinuteHand( Graphics g, double pos )
   {
      g.setColor( getBackground() );
      traceMinuteHand( g, pos );
   }


   
   /**
    * eraseSecondHand - draw the secondHand with background color
    *
    * @param g
    * @param pos
    */
   private void eraseSecondHand( Graphics g, double pos )
   {
      g.setColor( getBackground() );
      traceSecondHand( g, pos );
   }


   
   
   /**
    * paintComponent - interface callback routine used by window system
    */
   public void paintComponent( Graphics g )
   {
      erase( g );

      drawMinuteHand( g, minutePos );
      drawSecondHand( g, secondPos );
      drawMillisHand( g, millisPos );

      drawNumbers( g );

//      oldMinutePos = minutePos;
//      oldSecondPos = secondPos;
//      oldMillisPos = millisPos;
   }

   
   /**
    * setTime - set the time shown by the clock
    * 
    * The clock hands are moved to match the time provided in the argument. 
    * Since there is a hand which makes a revolution every second, this method 
    * should be called frequently, perhaps as often as 20 times a second or more. 
    *
    * @param millis - the time to display represented as a long containing the 
    *                 number of milliseconds since midnight, January 1, 1970.
    *                 This value is easily obtained from System.currentTimeMillis().
    */
   public void setTime( long millis )
   {
      if( startTime == 0 )
          startTime = millis;
      
      double curr = millis - startTime;
      curr -= (double) ( (int) ( curr / ( 1000 * 60 * 60 ) ) ) * 1000 * 60 * 60;
      minutePos = curr / ( 1000 * 60 );
      curr -= (double) ( ( (int) minutePos ) * 1000 * 60 );
      secondPos = curr / 1000;
      curr -= (double) ( (int) secondPos * 1000 );
      millisPos = curr;

      repaint();
   }

   /**
    * tick - advance clock by 1 second
    * 
    * This method advances the clock hands by one second. It does not
    * cause the millisHand to move. 
    *
    */
   public void tick()
   {
      if( secondPos >= 59 )
      {
         minutePos = ( minutePos + 1 ) % 60;
         secondPos = 0;
      }
      else
         secondPos++;
   }

   
   /**
    * traceMillisHand - depending on the current color, draw (if foreground) 
    *                   or erase (if background) the millis hand.
    *
    * @param g
    * @param pos
    */
   private void traceMillisHand( Graphics g, double pos )
   {
      double a = ( 0.5 - pos / 500 ) * Math.PI;
      int x2 = (int) ( size / 2 + radius * Math.cos( a ) / 2 );
      int y2 = (int) ( size / 2 - radius * Math.sin( a ) / 2 );
      g.drawLine( size / 2 + xmargin, size / 2 + ymargin, x2 + xmargin, y2 + ymargin );
   }

   
   /**
    * traceMinuteHand - depending on the current color, draw (if foreground) 
    *                   or erase (if background) the minute hand.
    *
    * @param g
    * @param pos
    */
   private void traceMinuteHand( Graphics g, double pos )
   {
      double a = ( 0.5 - pos / 30 ) * Math.PI;
      int x2 = (int) ( size / 2 + radius * Math.cos( a ) );
      int y2 = (int) ( size / 2 - radius * Math.sin( a ) );
      g.drawLine( size / 2 + xmargin, size / 2 + ymargin, x2 + xmargin, y2 + ymargin );
   }
   
   
   /**
    * traceSecondHand - depending on the current color, draw (if foreground) 
    *                   or erase (if background) the second hand.
    *
    * @param g
    * @param pos
    */
   private void traceSecondHand( Graphics g, double pos )
   {
      double a = ( 0.5 - pos / 30 ) * Math.PI;
      int x2 = (int) ( size / 2 + radius * Math.cos( a ) );
      int y2 = (int) ( size / 2 - radius * Math.sin( a ) );
      g.drawLine( size / 2 + xmargin, size / 2 + ymargin, x2 + xmargin, y2 + ymargin );
   }

   /**
    * main - test program
    * 
    * @param args
    */
   public static void main( String[] args )
   {
      Clock clock = new Clock( 600 );
      
      clock.clockRunner();
      
      while( true )
      {
         clock.setTime( System.currentTimeMillis() );
      }

   }

}
