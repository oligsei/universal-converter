package javaschool.app.converters.temperature;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FahrenheitConverterTest {
    private final FahrenheitConverter converter = new FahrenheitConverter();

    @Test
    public void from() throws Exception {
        assertEquals(converter.from(10), 50, 0.001);
    }

    @Test
    public void to() throws Exception {
        assertEquals(converter.to(50), 10, 0.001);
    }

}