package javaschool.app.converters.length;

import javaschool.app.converters.Converter;
import org.junit.Assert;
import org.junit.Test;

public class InchesConverterTest {
    private final Converter source = new MetersConverter();
    private final Converter target = new InchesConverter();

    @Test
    public void from() throws Exception {
        Assert.assertEquals(target.from(source.to(10)), 393.70078, 0.001);
    }

    @Test
    public void to() throws Exception {
        Assert.assertEquals(source.from(target.to(393.70078)), 10, 0.001);
    }

}