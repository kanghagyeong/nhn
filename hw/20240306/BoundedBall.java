import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall{
    Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, DEFAULT_COLOR);

        bounds = new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
    }
    
    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        if() {
            return true;
        } else {
            return false;
        }
    }

    public void move() {
        super.move();

        Rectangle region = new Rectangle(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius() );
        Rectangle intersection = bounds.intersection(region);

        if((intersection.reagion))
    }

    public void bounce() {
        if (getX() - getRadius() < getBounds().getMinX()) || ((getX() + getRadius() > getBounds().getMaxX())) {
            
        }
        if (getY() - getRadius() < getBounds().getMinY()) || ((getY() + getRadius() > getBounds().getMaxY())) {
            
        }

    }
}
