/**
 * Tel Hai College
 *
 * @author Ron Sivan (ronny.sivan@gmail.com)
 * @date   18 May 2014 21:20:16
 *
 */

package Lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Monitor - 
 *
 */
public class Monitor extends JPanel implements Runnable
{
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private JFrame jframe;
   private List<Fork> forks;
   private List<IPhilosopher> philos;
   private int[] forkX = {  65, 116, 280, 331, 198,  65 };
   private int[] forkY = {  239, 83,  83, 239, 336, 239 };
   
   private int[] philoX = {  57, 190, 323, 272, 108,  57 };
   private int[] philoY = {  147, 50, 147, 303, 303, 147 };
   
   private int loop = 200;

   
   public Monitor( List<IPhilosopher> philos, List<Fork> forks )
   {
      this.forks = forks;
      this.philos = philos;
           
      SwingUtilities.invokeLater( new Runnable()
      {
         public void run()
         {
            init();
         }
      });
   }
   
   public void init()
   {
      jframe = new JFrame();
      jframe.setTitle( "Dining Philosophers" );
      jframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//      jframe.setLayout( null );
      Dimension d = new Dimension( 400, 400 );
      jframe.setSize( d );
      jframe.setPreferredSize( d );
      
      setPreferredSize( d );
      jframe.add( this );
      jframe.pack();
      jframe.setVisible( true );

   }
   public void paintComponent( Graphics g )
   {
      int total = 0;
      Color bg = this.getBackground();
      
      g.setColor( Color.black );
      g.drawArc( 120, 120, 160, 160, 0, 360 );

      for( IPhilosopher ph : philos )
      {
         int place = ph.getPlace() % philos.size();
         if( ph.isEating() )
         {
            g.setColor( Color.red );
            g.fillArc( philoX[place], philoY[place], 20, 20, 0, 360 );
            g.setColor( Color.black );            
         }
         else
         {
            g.setColor( Color.white);
            g.fillArc( philoX[place], philoY[place], 20, 20, 0, 360 );
            g.setColor( Color.black );
            g.drawArc( philoX[place], philoY[place], 20, 20, 0, 360 );
         }

         g.drawString( Integer.toString( ph.getPlace() ), 
                       philoX[place] + 8, 
                       philoY[place] + 14 );
         
         total += ph.getCount();
      }
      
      g.setColor( bg );
      g.fillArc( 150, 150, 100, 100, 0, 360 );
      g.setColor( Color.black );
      g.drawString( Integer.toString( total ), 180, 200 );

      for( int i = 0; i < forks.size(); i++ )
      {
         g.setColor( bg );
         g.fillRect( forkX[i] - 10, forkY[i] - 20, 20, 30 );
         g.setColor( Color.black );
         int owner = forks.get( i ).getOwner();
         if( owner > 0 )
         {
            g.drawString( Integer.toString( owner ), forkX[i], forkY[i] );
         }
      }
   }
   
   
   
   /* (non-Javadoc)
    * 
    * run - 
    *
    * @see java.lang.Runnable#run()
    */
   @Override
   public void run()
   {
      while( loop-->0 )
      {
         try
         {
            Thread.sleep( 50 );
         }
         catch( InterruptedException e )
         {
            e.printStackTrace();
         }

         repaint();
      }
      jframe.setVisible(false);
      //jframe.dispose();
      //System.exit(0);


   }
   
}
