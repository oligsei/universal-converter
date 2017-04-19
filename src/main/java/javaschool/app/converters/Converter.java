package javaschool.app.converters;

import javaschool.app.formatters.Format;

public abstract class Converter {
    protected enum Category {
        TEMPERATURE,
        LENGTH
    }

    public double from(double value) {
        return value;
    }

    public double to(double value) {
        return value;
    }

    public abstract Category getCategory();

    public abstract String getSuffix();

    public Format getFormat() {
        return Format.METRIC;
    }

    public abstract String toString();
}
