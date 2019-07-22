package cliinjection;

import io.micronaut.configuration.picocli.PicocliRunner;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import javax.inject.Inject;

@Command(name = "mini-java-util", description = "...",
        mixinStandardHelpOptions = true)
public class MiniJavaUtilCommand implements Runnable {

    @Inject
    ConverterService converterService;
    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(MiniJavaUtilCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("converterService :" + converterService);
        }
    }
}
