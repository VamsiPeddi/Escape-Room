
public class DraggableThing extends VisibleThing {
  private boolean mouseWasPressed; // similar to use in ClickableThing
  private boolean isDragging; // true when this object is being dragged by the user
  private int oldMouseX; // horizontal position of mouse during last update
  private int oldMouseY; // vertical position of mouse during last update

  /*
   * Constructor initialize new thing
   */
  public DraggableThing(String name, int x, int y) {
    super(name, x, y);
    this.oldMouseX = x;
    this.oldMouseY = y;
  } //

  @Override
  /*
   * calls VisibleThing update(), then moves according to mouse drag each time isDragging changes
   * from true to false, the drop() method below will be called once and any action objects returned
   * from that method should then be returned from update()
   * 
   * @see VisibleThing#update()
   */
  public Action update() {

    super.update();

    Action action = null;

    if (isDragging) {
      super.move(getProcessing().mouseX - oldMouseX, getProcessing().mouseY - oldMouseY);
      this.oldMouseX = getProcessing().mouseX;
      this.oldMouseY = getProcessing().mouseY;
      action = drop();
    }
    if (isOver(getProcessing().mouseX, getProcessing().mouseY) == true) {
      if (mouseWasPressed == false && getProcessing().mousePressed) {
        mouseWasPressed = true;
        isDragging = true;
      }
      if (!getProcessing().mousePressed) {
        isDragging = false;
      }
    }

    mouseWasPressed = getProcessing().mousePressed;
    return action;


  }

  /*
   * this method returns null subclass types will override this drop() method to do more interesting
   * things
   */
  protected Action drop() {
    return null;
  } 

}
