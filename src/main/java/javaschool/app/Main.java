package javaschool.app;

import asg.cliche.ShellFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ShellFactory
                .createConsoleShell("universal-converter", "This is Phone Book", new UniversalConverter())
                .commandLoop();
    }
}
