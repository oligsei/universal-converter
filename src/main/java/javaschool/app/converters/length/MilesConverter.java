package javaschool.app.converters.length;

import javaschool.app.converters.Unit;
import javaschool.app.formatters.Format;

public class MilesConverter extends LengthConverter {
    @Override
    public double from(double value) {
        return value / 1000 / 1.609344;
    }

    @Override
    public double to(double value) {
        return value * 1000 * 1.609344;
    }

    @Override
    public String getSuffix() {
        return "mi";
    }

    @Override
    public Format getFormat() {
        return Format.IMPERIAL;
    }

    @Override
    public Unit getUnit() {
        return Unit.MILES;
    }

    @Override
    public String toString() {
        return "miles";
    }
}
