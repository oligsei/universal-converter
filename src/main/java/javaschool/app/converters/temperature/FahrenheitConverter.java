package javaschool.app.converters.temperature;

public class FahrenheitConverter extends TemperatureConverter {
    @Override
    public double from(double value) {
        return value * 9 / 5 + 32;
    }

    @Override
    public double to(double value) {
        return (value - 32) / 1.8;
    }

    @Override
    public String getSuffix() {
        return "°F";
    }

    @Override
    public String toString() {
        return "fahrenheit";
    }

}
