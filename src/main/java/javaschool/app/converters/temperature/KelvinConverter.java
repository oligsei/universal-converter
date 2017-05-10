package javaschool.app.converters.temperature;

import javaschool.app.converters.Unit;

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
    public Unit getUnit() {
        return Unit.KELVIN;
    }

    @Override
    public String toString() {
        return "kelvin";
    }

}
