package javaschool.app.converters.temperature;

import javaschool.app.converters.Converter;

public abstract class TemperatureConverter extends Converter {
    @Override
    public Type getType() {
        return Type.TEMPERATURE;
    }
}
