package io.beandev.eventstore.smartcontract;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GivenStepDefinitions {
     public enum JarType {
        GENERIC
    }

    @Given("an InputStream of a {} JAR file")
    public void anInputStreamOfAJARFile(JarType jarType) {
        System.out.println("JarType is " + jarType);
    }
}
