package javaschool.app.formatters;

public class ImperialFormatter extends Formatter {
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
