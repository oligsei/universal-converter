package javaschool.app;

import asg.cliche.ShellFactory;

import java.io.IOException;

public class Console {
    public static void main(String[] args) throws IOException {
        ShellFactory
                .createConsoleShell("universal-converter", "This is Universal Converter", new ConverterShell())
                .commandLoop();
    }
}
