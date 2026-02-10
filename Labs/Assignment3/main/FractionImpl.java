public class FractionImpl implements Fraction{
  private int numerator;
  private int denominator;

  public FractionImpl(int numerator, int denominator){
    if (denominator <= 0) {
      throw new IllegalArgumentException("The denominator should be positive.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getNumerator() {return this.numerator;}
  public int getDenominator() {return this.denominator;}

  public void setNumerator(int newNumerator) {
    this.numerator = newNumerator;
  }

  public void setDenominator(int newDenominator){
    if (newDenominator <= 0){
      throw new IllegalArgumentException("The denominator should be positive.");
    }
    this.denominator = newDenominator;
  }

  public double toDouble(){
    return this.numerator / (double)this.denominator;
  }

  // Helper: generate the simplified fractional representation for toString()
  private static int gcd(int a, int b) {
    if(b == 0) {return a;}
    return gcd(b, a % b);
  }

  public String toString(){
    int commonDivisor = gcd(Math.abs(this.numerator), this.denominator);
    return this.numerator / commonDivisor + " / " + this.denominator / commonDivisor;
  }

  public Fraction reciprocal(){
    if (this.numerator == 0) {
      throw new ArithmeticException("Cannot take reciprocal of zero.");
    }
    int newDenominator = this.numerator;
    int newNumerator = this.denominator;
    // deal with negative numerator
    if (newDenominator < 0) {
      newNumerator = -newNumerator;
      newDenominator = -newDenominator;
    }
    return new FractionImpl(newNumerator, newDenominator);
  }

  public Fraction add(Fraction other){
    if (other == null) {
      throw new IllegalArgumentException("Other fraction cannot be null");
    }
    int a = this.numerator;
    int b = this.denominator;
    int c = other.getNumerator();
    int d = other.getDenominator();
    int newNumerator = a * d + b * c;
    int newDenominator = b * d;
    if (newDenominator < 0) {
      newNumerator = -newNumerator;
      newDenominator = -newDenominator;
    }
    int common = gcd(Math.abs(newNumerator), newDenominator);
    return new FractionImpl(newNumerator / common, newDenominator / common);
  }

  public int compareTo(Fraction other){
    if (other == null) {
      throw new IllegalArgumentException("Other Fraction ca not be null");
    }
    int result = numerator * other.getDenominator() - denominator * other.getNumerator();
    return result;
  }
}
