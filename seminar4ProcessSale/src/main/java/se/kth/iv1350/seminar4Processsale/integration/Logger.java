package se.kth.iv1350.seminar4Processsale.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class Logger {
    private PrintWriter dataWriter;


    /**
     * Loggers the exceptions into textFile or print a massage to user and saveStackTrace
     */
    public Logger(){
        try {
            dataWriter = new PrintWriter(new FileWriter("log.txt",true), true);
        } catch (IOException ioe) {
            System.out.println("Something went wrong when logging the exception to the file.");
            ioe.printStackTrace();
        }
    }

    /**
     * @param exception that may occurs while running the program
     */
    public void logForDeveloper(Exception exception) {
        dataWriter.println("This error massage will be sent and shown only to the developer.");
        exception.printStackTrace(dataWriter);
    }

    /**
     * @param exception that may occurs while running the program
     */
    public void logForUser(Exception exception) {
        System.out.println(exception.getMessage());
    }

}
