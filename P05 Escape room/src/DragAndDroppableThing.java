
public class DragAndDroppableThing extends DraggableThing {


  private VisibleThing target; // object over which this object can be dropped
  private Action action; // action that results from dropping this object over target

  /*
   * Constructor initializes new object
   */
  public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) {
    super(name, x, y);
    this.target = target;
    this.action = action;
  }

  @Override
  /*
   * returns action and deactivates objects in response to successful drop When this object is over
   * its target and its target is active: deactivate both this object and the target object, and
   * return action, otherwise return null
   * 
   * @see DraggableThing#drop()
   */
  protected Action drop() {
    if (isOver(target) && isActive()) {
      deactivate();
      return action;
    } else {
      return null;
    }
  } 
  
}
