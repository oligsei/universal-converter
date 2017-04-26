package javaschool.app.formatters;

import org.junit.Assert;
import org.junit.Test;

public class MetricFormatterTest {
    private final Formatter formatter = new MetricFormatter();

    @Test
    public void format() throws Exception {
        Assert.assertEquals("10,12 s", formatter.format(10.123, "s"));
    }

}