/**
 * The Shoe class represents a shoe with specific kind, color, brand, and size.
 * It uses enums for kind, color, and brand, and validates that Nike does not
 * produce Dress shoes.
 */
public class Shoe {
  private Kind kind;
  private Brand brand;
  private Color color;
  private double size;
  /**
   * Constructs a Shoe object with the given kind, color, brand, and size.
   * Throws IllegalArgumentException if brand is NIKE and kind is DRESS.
   *
   * @param kind  The type of the shoe (e.g., SNEAKER, DRESS)
   * @param color The color of the shoe (e.g., RED, WHITE)
   * @param brand The brand of the shoe (e.g., NIKE, ADIDAS)
   * @param size  The size of the shoe (double)
   * @throws IllegalArgumentException if brand is NIKE and kind is DRESS
   */
  public Shoe(Kind kind, Brand brand, Color color, double size){
    if (brand == Brand.NIKE && kind == Kind.DRESS){
      throw new IllegalArgumentException("NIKE does not sell dress shoes.");
    }
    this.kind = kind;
    this.brand = brand;
    this.color = color;
    this.size = size;
  }
  /**
   * Returns the kind (type) of the shoe.
   *
   * @return the kind of the shoe
   */
  public Kind getKind() {return this.kind;}
  /**
   * Returns the brand of the shoe.
   *
   * @return the brand of the shoe
   */
  public Brand getBrand() {return this.brand;}
  /**
   * Returns the color of the shoe.
   *
   * @return the color of the shoe
   */
  public Color getColor() {return this.color;}
  /**
   * Returns the size of the shoe.
   *
   * @return the size of the shoe
   */
  public double getSize() {return this.size;}

  private String capitalize(String s){
    return s.charAt(0) + s.substring(1).toLowerCase();
  }
  /**
   * Returns a string representation of the shoe, summarizing all attributes.
   * Uses switch statements for custom capitalization and provides default
   * names for some colors.
   *
   * @return a formatted string with shoe details
   */
  @Override
  public String toString(){
    String kindStr;
    switch (kind){
      case BOOT, DRESS, SNEAKER, SANDAL -> kindStr = capitalize(kind.name());
      default -> kindStr = "Unknow kind";
    }
    String brandStr;
    switch (brand) {
      case NIKE, ADIDAS, PUMA, NEW_BALANCE -> brandStr = capitalize(brand.name());
      default -> brandStr = "Unknown Brand";
    }
    String colorStr;
    switch (color){
      case RRD, PINK, WHITE, BLACK -> colorStr = capitalize(color.name());
      default -> colorStr = "Neutral";
    }
    return "Shoe [Kind=" + kindStr + ", Color=" + colorStr + ", Brand=" + brandStr + ", Size=" + size + "]";
  }
}
