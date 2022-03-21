import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class GraphicsUtil
{
  protected Graphics g;
  protected ImageObserver observer;
  public GraphicsUtil(Graphics g, ImageObserver observer)
  {
    this.g = g;
    this.observer = observer;
  }

  public enum Align
  {
    North, NorthEast, East, SouthEast, South, SouthWest, West, NorthWest, Center
  }

  public static Rectangle2D expand(RectangularShape rect, double amount)
  {
    return expand(rect, amount, amount);
  }
  public static Rectangle2D expand(RectangularShape rect, double amountX, double amountY)
  {
    return new Rectangle2D.Double(
      rect.getX() - amountX,
      rect.getY() - amountY,
      rect.getWidth() + (2*amountX),
      rect.getHeight() + (2*amountY)
    );
  }

}
