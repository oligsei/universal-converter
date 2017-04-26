package javaschool.app.formatters;

import java.math.BigInteger;

public class ImperialFormatter extends Formatter {
    // http://stackoverflow.com/questions/379176
    public String format(double value, String suffix) {
        int whole = (int) value;
        int denominator = 10000;
        int numerator = (int) ((value - whole) * denominator);

        if (numerator == 0) {
            return String.format("%d %s", whole, suffix);
        }
        while (numerator % 2 == 0) {
            numerator /= 2;
            denominator /= 2;
        }

        // http://stackoverflow.com/questions/4009198
        int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();
        numerator /= gcd;
        denominator /= gcd;

        if (whole == 0) {
            return String.format("%d/%d %s", numerator, denominator, suffix);
        } else {
            return String.format("%d %d/%d %s", whole, numerator, denominator, suffix);
        }
    }

    @Override
    public String toString() {
        return "imperial";
    }
}
