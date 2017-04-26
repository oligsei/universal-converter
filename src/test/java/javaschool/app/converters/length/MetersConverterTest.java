package javaschool.app.converters.length;

import javaschool.app.converters.Converter;
import org.junit.Assert;
import org.junit.Test;

public class MetersConverterTest {
    private final Converter source = new MetersConverter();
    private final Converter target = new MetersConverter();

    @Test
    public void from() throws Exception {
        Assert.assertEquals(10, target.from(source.to(10)), 0.001);
    }

    @Test
    public void to() throws Exception {
        Assert.assertEquals(10, source.from(target.to(10)), 0.001);
    }

}