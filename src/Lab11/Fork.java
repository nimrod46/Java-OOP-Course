/**
 * Tel Hai College
 * 
 * @author Ron Sivan (ronny.sivan@gmail.com)
 * @date 18 May 2014 20:50:44
 * 
 */
package Lab11;

/**
 * Fork - class simulating a fork
 *  
 * A fork is a simple implement: it is either unused or in use by 
 * some philosopher. the class variable "owner" is set to 0 in the 
 * first case and to the number of the owning philosopher in the second.  
 */
public class Fork
{
   /*
    * number of philosopher currently owning the fork. 0 if not being used.
    */
   private int owner;
   
   /**
    * Constructor - 
    *
    */
   public Fork()
   {
      owner = 0;
   }

   /**
    * @return the owner
    */
   public int getOwner()
   {
      return owner;
   }

   /**
    * @param owner the owner to set
    */
   public void setOwner( int owner )
   {
      this.owner = owner;
   }
   
   
}
