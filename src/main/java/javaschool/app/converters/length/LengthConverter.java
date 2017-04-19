package javaschool.app.converters.length;

import javaschool.app.converters.Converter;

public abstract class LengthConverter extends Converter {
    @Override
    public Category getCategory() {
        return Category.LENGTH;
    }
}
