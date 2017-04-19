package javaschool.app.converters.length;

public class MetersConverter extends LengthConverter {
    @Override
    public String getSuffix() {
        return "m";
    }

    @Override
    public String toString() {
        return "meters";
    }
}
