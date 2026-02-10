import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FractionImplTest {

  @Test
  void constructorRejectsNonPositiveDenominator() {
    assertThrows(IllegalArgumentException.class,
        () -> new FractionImpl(2, -5));
  }

  @Test
  void gettersReturnCorrectValues() {
    Fraction f = new FractionImpl(3, 4);
    assertEquals(3, f.getNumerator());
    assertEquals(4, f.getDenominator());
  }

  @Test
  void setDenominatorRejectsNonPositive() {
    Fraction f = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class,
        () -> f.setDenominator(-5));
  }

  @Test
  void toDoubleWorks() {
    Fraction f = new FractionImpl(1, 4);
    assertEquals(0.25, f.toDouble(), 1e-9);
    Fraction f1 = new FractionImpl(-8, 4);
    assertEquals(-2.00, f1.toDouble(), 1e-9);
  }

  @Test
  void toStringSimplifiesFraction() {
    Fraction f = new FractionImpl(-4, 2);
    assertEquals("-2 / 1", f.toString());
  }

  @Test
  void reciprocalWorksForPositiveFraction() {
    Fraction f = new FractionImpl(2, 3);
    Fraction r = f.reciprocal();
    assertEquals("3 / 2", r.toString());
  }

  @Test
  void reciprocalWorksForNegativeFraction() {
    Fraction f = new FractionImpl(-2, 3);
    Fraction r = f.reciprocal();
    assertEquals("-3 / 2", r.toString());
  }

  @Test
  void reciprocalThrowsForZero() {
    Fraction f = new FractionImpl(0, 5);
    assertThrows(ArithmeticException.class, f::reciprocal);
  }

  @Test
  void addTest() {
    Fraction f1 = new FractionImpl(1, 2);
    Fraction f2 = new FractionImpl(-1, 4);
    Fraction f3 = new FractionImpl(2, 3);
    Fraction f4 = new FractionImpl(-2, 5);
    Fraction sum = f1.add(f2);
    assertEquals("1 / 4", sum.toString());
    Fraction sum1 = f1.add(f3);
    assertEquals("7 / 6", sum1.toString());
    Fraction sum2 = f2.add(f4);
    assertEquals("-13 / 20", sum2.toString());

  }

  @Test
  void compareToWorks() {
    Fraction f1 = new FractionImpl(1, 2);
    Fraction f2 = new FractionImpl(2, 3);

    assertTrue(f1.compareTo(f2) < 0);
    assertTrue(f2.compareTo(f1) > 0);
    assertEquals(0, new FractionImpl(2, 4)
        .compareTo(new FractionImpl(1, 2)));
  }
}
