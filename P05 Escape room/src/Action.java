import java.util.ArrayList;

public class Action {
  
  private String message; // message printed by this action (or null to do nothing)
  private Thing thing;
  
  /*
   * Constructor for this class
   */
  public Action(String message) {
    this.message = message;
  } 
  /*
   * Constructor With Thing object as a parameter
   */
  public Action(Thing thing) {
    this.thing = thing;
  }
  /*
   * Constructor with Two Parameters
   */
  public Action(String message, Thing thing){
    this.message = message;
    this.thing = thing;
  }
  /*
   * Prints message if it's not null and activates Things from the allThings ArrayList 
   */
  public void act( ArrayList<Thing> allThings) { 
    for (int i = 0; i < allThings.size(); i++) {
      if (allThings.get(i) != null) {
      allThings.get(i).activate();
      allThings.add(allThings.get(i));
      thing = null;
      }
    }
      
    if (message != null) {
      System.out.println(message); // when message is not null, message is printed to System.out
    }
  } 
  
}
