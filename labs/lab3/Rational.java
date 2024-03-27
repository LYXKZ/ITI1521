public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
	    this.numerator = numerator;
      this.denominator = denominator;
      this.reduce();
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
	    int denom = this.denominator * other.denominator;
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        Rational result = new Rational(num, denom);
        result.reduce();
        return result;
    }

    public static Rational plus(Rational a, Rational b) {
    	int denom = a.denominator * b.denominator;
        int num = (a.numerator * b.denominator) + (b.numerator * a.denominator);
        Rational result = new Rational(num, denom);
        result.reduce();
        return result;
    }

    // Transforms this number into its reduced form

    private void reduce() {
      int gcd = gcd(this.numerator, this.denominator);
      this.numerator = this.numerator / gcd;
      this.denominator = this.denominator / gcd;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
      if (a < 0) {
        a = a * -1;
      }
      if (b < 0) {
        b = b * -1;
      }
    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
      this.reduce();
      other.reduce();
      double a = this.numerator;
      double b = this.denominator;
      double c = other.numerator;
      double d = other.denominator;
      if (a/b < c/d) {
        return -10;
      } else if (a/b == c/d) {
        return 0;
      } else {
        return 10;
      }
    }

    public boolean equals(Rational other) {
      this.reduce();
      other.reduce();
      double a = this.numerator;
      double b = this.denominator;
      double c = other.numerator;
      double d = other.denominator;
      if (a / b == c / d) {
        return true;
      } else {
        return false;
      }
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = "" + this.numerator;
    	} else {
    	    result = this.numerator + "/" + this.denominator;
    	}
    	return result;
    }

}
