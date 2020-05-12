package us.wellaware.library;
import java.util.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.jupiter.api.Assertions.*;

public class TestDriver {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(LibraryTest.class);

        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("All tests passed successfully.");
        }
    }
}
