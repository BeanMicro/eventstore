package io.beandev.eventstore.smartcontract;

import io.cucumber.java.ParameterType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParameterTypeDefinitions {

    @ParameterType(".*")
    public LocalDateTime datetime(String dateTimeString) {
        System.out.println("dateTimeString: " + dateTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    @ParameterType(".*")
    public GivenStepDefinitions.JarType jarType(String jarTypeString) {
        return GivenStepDefinitions.JarType.valueOf(jarTypeString.toUpperCase());
    }

}
