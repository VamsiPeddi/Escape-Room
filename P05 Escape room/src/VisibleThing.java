import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class VisibleThing extends Thing {



  private PImage image; // the graphical representation of this thing
  private int x; // the horizontal position (in pixels of this thing's left side)
  private int y; // the vertical position (in pixels of this thing's top side)

  public VisibleThing(String name, int x, int y) {
    super(name);

    this.x = x;
    this.y = y;
    this.image = getProcessing().loadImage("images"+File.separator+ name +".png");
  }
  // the image for this visible thing should be loaded from :
  // "images"+File.separator+ name +".png"

  @Override
  /*
   * draws image at its position before returning null
   * @see Thing#update()
   */
  public Action update() {
    getProcessing().image(this.image, x, y);
    return null;
  } 

  /*
   * changes x by adding dx to it (and y by dy)
   */
  public void move(int dx, int dy) {
    this.x = x + dx;
    this.y = y + dy;
  } 

  /*
   * return true only when point x,y is over image
   */
  public boolean isOver(int x, int y) {
    int width = image.width;
    int height = image.height;
    int xBottomLeftCorner = this.x;
    int yBottomLeftCorner = this.y + height;
    int xTopRightCorner = this.x + width;
    int yTopRightCorner = this.y;


    if (x > xBottomLeftCorner && x < xTopRightCorner && y < yBottomLeftCorner
        && y > yTopRightCorner) {
      return true;
    }

    return false;
  } 

  /*
   * return true only when other's image overlaps this one's
   */
  public boolean isOver(VisibleThing other) {
    int xBottomLeftCorner = other.x;
    int yBottomLeftCorner = other.y + other.image.height;
    int xTopRightCorner = other.x + other.image.width;
    int yTopRightCorner = other.y;

    if (this.x > xBottomLeftCorner && this.x < xTopRightCorner && this.y > yBottomLeftCorner
        && this.y < yTopRightCorner) {
      return true;
    }

    return false;

  } 


}
