import processing.core.PApplet;

public class Thing {


  private final String NAME; // the constant name identifying this object
  private boolean isActive; // active means thing is visible and can be interacted with
  private static PApplet processing = null;

  /*
   * Constructor for this class which initializes name, and set isActive to true
   */
  public Thing(String name) {
    this.NAME = name;
    this.isActive = true;
  }

  /*
   * returns true only when contents of name equal NAME
   */
  public boolean hasName(String name) {
    if (this.NAME.equals(name)) {
      return true;
    }
    return false;
  }

  /*
   * returns true only when isActive is true
   */
  public boolean isActive() {
    if (this.isActive == true) {
      return true;
    }
    return false;
  }

  /*
   * changes isActive to true
   */
  public void activate() {
    this.isActive = true;
  }

  /*
   * changes isActive to false
   */
  public void deactivate() {
    this.isActive = false;
  }

  /*
   * initializes processing field
   */
  public static void setProcessing(PApplet processing) {
    Thing.processing = processing;
  }

  /*
   * accessor method to retrieve this static field
   */
  protected static PApplet getProcessing() {
    return processing;
  }

  /*
   * this method returns null subclass types will override this update() method to do more
   * interesting things
   * 
   */
  public Action update() {
    return null;
  } 

}
