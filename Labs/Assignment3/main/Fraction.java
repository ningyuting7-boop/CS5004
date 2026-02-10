/**
 * The Fraction interface represents a mathematical fraction
 * with an integer numerator and a positive integer denominator.
 *
 * Implementations must ensure:
 * - The denominator is always positive
 * - Any negativity is stored in the numerator
 *
 * Implementing classes must provide:
 * - A constructor Fraction(int numerator, int denominator)
 *   that throws IllegalArgumentException if denominator <= 0
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of this fraction.
   *
   * @return the numerator
   */
  int getNumerator();

  /**
   * Sets the numerator of this fraction.
   *
   * @param numerator the new numerator
   */
  void setNumerator(int numerator);

  /**
   * Returns the denominator of this fraction.
   *
   * @return the denominator (always positive)
   */
  int getDenominator();

  /**
   * Sets the denominator of this fraction.
   *
   * @param denominator the new denominator (must be positive)
   * @throws IllegalArgumentException if denominator <= 0
   */
  void setDenominator(int denominator);

  /**
   * Returns the decimal (scientific) value of this fraction.
   *
   * @return the value of this fraction as a double
   */
  double toDouble();

  /**
   * Returns a String representation of this fraction
   * in simplest form.
   *
   * Examples:
   *  - "4 / 2" becomes "2 / 1"
   *  - "-6 / 8" becomes "-3 / 4"
   *
   * @return the simplified fractional representation
   */
 @Override
  String toString();

  /**
   * Returns the reciprocal of this fraction.
   *
   * @return a new Fraction that is the reciprocal
   * @throws ArithmeticException if the numerator is 0
   */
  Fraction reciprocal();

  /**
   * Adds this fraction to another fraction.
   *
   * @param other the fraction to add
   * @return a new Fraction representing the sum
   * @throws IllegalArgumentException if other is null
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction with another fraction.
   *
   * @param other the fraction to compare to
   * @return a negative integer if this < other,
   *         a positive integer if this > other,
   *         or 0 if equal
   * @throws IllegalArgumentException if other is null
   */
  @Override
  int compareTo(Fraction other);
}
