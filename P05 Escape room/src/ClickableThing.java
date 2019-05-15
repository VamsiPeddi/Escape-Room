
public class ClickableThing extends VisibleThing {

  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

  /*
   * initializes this new object
   */
  public ClickableThing(String name, int x, int y, Action action) {
    super(name, x, y);
    this.action = action;
  } 

  @Override
  /*
   * calls VisibleThing update, then returns action only when mouse is first clicked
   * @see VisibleThing#update()
   */
  public Action update() {
    super.update();
    
    int xPos = getProcessing().mouseX;
    int yPos = getProcessing().mouseY;
    boolean mousePressed = getProcessing().mousePressed;
    boolean over = isOver(xPos, yPos);
    
    
    if ( over == true && mousePressed == true && this.mouseWasPressed == false) {
      this.mouseWasPressed = true;
      return action;
    }
    
    return null;
    
  } 


}
