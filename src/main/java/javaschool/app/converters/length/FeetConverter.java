package javaschool.app.converters.length;

import javaschool.app.converters.Unit;
import javaschool.app.formatters.Format;

public class FeetConverter extends LengthConverter {
    @Override
    public double from(double value) {
        return value / 0.3048;
    }

    @Override
    public double to(double value) {
        return value * 0.3048;
    }

    @Override
    public String getSuffix() {
        return "ft";
    }

    @Override
    public Format getFormat() {
        return Format.IMPERIAL;
    }

    @Override
    public Unit getUnit() {
        return Unit.FEET;
    }

    @Override
    public String toString() {
        return "feet";
    }
}
