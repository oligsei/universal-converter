package javaschool.app.converters.length;

import javaschool.app.converters.Unit;

public class MetersConverter extends LengthConverter {
    @Override
    public String getSuffix() {
        return "m";
    }

    @Override
    public Unit getUnit() {
        return Unit.METERS;
    }

    @Override
    public String toString() {
        return "meters";
    }
}
