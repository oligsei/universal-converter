package javaschool.app.converters.temperature;

public class KelvinConverter extends TemperatureConverter {
    @Override
    public double from(double value) {
        return value + 273.15;
    }

    @Override
    public double to(double value) {
        return value - 273.15;
    }

    @Override
    public String getSuffix() {
        return "K";
    }

    @Override
    public String toString() {
        return "kelvin";
    }

}
