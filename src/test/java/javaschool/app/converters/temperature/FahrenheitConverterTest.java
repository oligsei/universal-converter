package javaschool.app.converters.temperature;

import javaschool.app.converters.Converter;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FahrenheitConverterTest {
    private final Converter source = new CelsiusConverter();
    private final Converter target = new FahrenheitConverter();

    @Test
    public void from() throws Exception {
        assertEquals(target.from(source.to(10)), 50, 0.001);
    }

    @Test
    public void to() throws Exception {
        assertEquals(source.from(target.to(50)), 10, 0.001);
    }

}