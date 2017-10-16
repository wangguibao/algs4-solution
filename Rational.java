import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Rational {
    private final int n;
    private final int d;
    
    public Rational(int numerator, int denominator) {
        n = numerator;
        d = denominator;
    }
    
    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public Rational plus(Rational b) {
        int numerator = this.n * b.d + this.d * b.n;
        int denominator = d * b.d;
        int divisor = gcd(numerator, denominator);
        if (divisor > 1) {
            numerator /= divisor;
            denominator /= divisor;
        }
        
        return new Rational(numerator, denominator);
    }
    
    public Rational minus(Rational b) {
        int numerator = this.n * b.d - this.d * b.n;
        int denominator = d * b.d;
        boolean lt0 = false;
        if (numerator < 0) {
            lt0 = true;
            numerator = -numerator;
        }
        int divisor = gcd(numerator, denominator);
        if (divisor > 1) {
            numerator /= divisor;
            denominator /= divisor;
        }
        
        if (lt0 == true) {
            numerator = -numerator;
        }
        return new Rational(numerator, denominator);
    }
    
    public Rational times(Rational b) {
        int numerator = this.n * b.n;
        int denominator = this.d * b.d;
        
        boolean lt0 = false;
        if (numerator < 0) {
            lt0 = true;
            numerator = -numerator;
        }
        int divisor = gcd(numerator, denominator);
        if (divisor > 1) {
            numerator /= divisor;
            denominator /= divisor;
        }
        
        if (lt0) {
            numerator = -numerator;
        }
        return new Rational(numerator, denominator);
    }
    
    public Rational divides(Rational b) {
        Rational r = new Rational(b.d, b.n);
        return this.times(r);
    }
    
    public boolean equals(Rational that) {
        if (that == null) {
            return false;
        }
        
        if (this == that) {
            return true;
        }
        
        if (this.getClass() != that.getClass()) {
            return false;
        }

        Rational r = (Rational)that;
        if (this.n != r.n || this.d != r.d) {
            return false;
        }
        
        return true;
    }
    
    public String toString() {
        if (d == 1) {
            return Integer.toString(n);
        }
        else {
            return n + "/" + d;
        }
    }
    
    public static void main(String[] args) {
        int divisor = args[0].indexOf('/');
        int n1 = Integer.parseInt(args[0].substring(0, divisor));
        int d1 = Integer.parseInt(args[0].substring(divisor + 1, args[0].length()));
        
        divisor = args[1].indexOf('/');
        int n2 = Integer.parseInt(args[1].substring(0, divisor));
        int d2 = Integer.parseInt(args[1].substring(divisor + 1, args[1].length()));
        
        Rational r1 = new Rational(n1, d1);
        Rational r2 = new Rational(n2, d2);
        
        StdOut.println(r1 + " + " + r2 + " = " + r1.plus(r2));
        StdOut.println(r1 + " - " + r2 + " = " + r1.minus(r2));
        StdOut.println(r1 + " * " + r2 + " = " + r1.times(r2));
        StdOut.println(r1 + " / " + r2 + " = " + r1.divides(r2));
    }
}
