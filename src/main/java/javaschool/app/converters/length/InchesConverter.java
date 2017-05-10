package javaschool.app.converters.length;

import javaschool.app.converters.Unit;
import javaschool.app.formatters.Format;

public class InchesConverter extends LengthConverter {

    @Override
    public double from(double value) {
        return value / 0.0254;
    }

    @Override
    public double to(double value) {
        return value * 0.0254;
    }

    @Override
    public String getSuffix() {
        return "\"";
    }

    @Override
    public Format getFormat() {
        return Format.IMPERIAL;
    }

    @Override
    public Unit getUnit() {
        return Unit.INCHES;
    }

    @Override
    public String toString() {
        return "inches";
    }
}
