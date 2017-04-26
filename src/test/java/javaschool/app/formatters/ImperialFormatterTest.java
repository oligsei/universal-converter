package javaschool.app.formatters;

import org.junit.Assert;
import org.junit.Test;

public class ImperialFormatterTest {
    private final Formatter formatter = new ImperialFormatter();

    @Test
    public void formatHalf() throws Exception {
        Assert.assertEquals(this.formatter.format(10.5, "s"), "10 1/2 s");
    }

    @Test
    public void formatFourth() throws Exception {
        Assert.assertEquals(this.formatter.format(10.25, "s"), "10 1/4 s");
    }

    @Test
    public void formatEight() throws Exception {
        Assert.assertEquals(this.formatter.format(10.125, "s"), "10 1/8 s");
    }

}