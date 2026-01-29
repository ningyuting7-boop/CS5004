/**
 * This class represents a triangle in 2D space.
 * It extends AbstractShape and implements all methods required by the Shape interface.
 * The first point provided in the constructor is considered the reference point
 * used to define the distance from the origin.
 */
public class Triangle extends AbstractShape{
  private final Point2D p1; // reference point
  private final Point2D p2;
  private final Point2D p3;
  /**
   * Constructs a Triangle object with the given three points.
   * The first point is the reference point.
   * Throws IllegalArgumentException if any two points are identical.
   *
   * @param x1 x-coordinate of the reference point
   * @param y1 y-coordinate of the reference point
   * @param x2 x-coordinate of the second point
   * @param y2 y-coordinate of the second point
   * @param x3 x-coordinate of the third point
   * @param y3 y-coordinate of the third point
   */
  public Triangle(double x1, double y1,
                  double x2, double y2,
                  double x3, double y3){
    super(new Point2D(x1, y1));
    if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x3 == x2 && y3 == y2)) {
      throw new IllegalArgumentException("Two points can not be the same");
    }
    this.p1 = new Point2D(x1, y1);
    this.p2 = new Point2D(x2, y2);
    this.p3 = new Point2D(x3, y3);
  }
  /** @return length of side between p1 and p2 */
  private double getSide1(){return this.p1.getDistance(this.p2.getX(), this.p2.getY());}
  /** @return length of side between p2 and p3 */
  private double getSide2(){return this.p2.getDistance(this.p3.getX(), this.p3.getY());}
  /** @return length of side between p3 and p1 */
  private double getSide3(){return this.p3.getDistance(this.p1.getX(), this.p1.getY());}
  /**
   * Computes the perimeter of the triangle.
   *
   * @return the perimeter
   */
  @Override
  public double perimeter(){
    return getSide1() + getSide2() + getSide3();
  }
  /**
   * Computes the area of the triangle using Heron's formula.
   *
   * @return the area
   */
  @Override
  public double area(){
    double s = this.perimeter() / 2.0;
    return Math.sqrt(s * (s - getSide1()) * (s - getSide2()) * (s - getSide3()));
  }
  /**
   * Creates and returns a new Triangle resized in area by the given factor.
   * The reference point stays in the same location.
   *
   * @param factor the scaling factor for area
   * @return a new Triangle with scaled sides
   * @throws IllegalArgumentException if factor <= 0
   */
  @Override
  public Triangle resize(double factor){
    double scale = Math.sqrt(factor);

    // reference point stays the same
    double x1 = this.p1.getX();
    double y1 = this.p1.getY();

    // scale p2 relative to p1
    double x2 = x1 + scale * (this.p2.getX() - x1);
    double y2 = y1 + scale * (this.p2.getY() - y1);

    // scale p3 relative to p1
    double x3 = x1 + scale * (this.p3.getX() - x1);
    double y3 = y1 + scale * (this.p3.getY() - y1);

    return new Triangle(x1, y1, x2, y2, x3, y3);
  }
  /**
   * Returns a string representation of the triangle, including all points.
   *
   * @return string describing the triangle
   */
  @Override
  public String toString() {
    return String.format(
        "Triangle: reference point (%.3f,%.3f) p2 (%.3f,%.3f) p3 (%.3f,%.3f)",
        this.p1.getX(), this.p1.getY(),
        this.p2.getX(), this.p2.getY(),
        this.p3.getX(), this.p3.getY()
    );
  }
}
