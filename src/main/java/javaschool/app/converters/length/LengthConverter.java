package javaschool.app.converters.length;

import javaschool.app.converters.Converter;

public abstract class LengthConverter extends Converter {
    @Override
    public Type getType() {
        return Type.LENGTH;
    }
}
