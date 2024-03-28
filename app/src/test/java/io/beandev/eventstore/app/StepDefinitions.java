package io.beandev.eventstore.app;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StepDefinitions {
    LocalDateTime datetime;
    String machineId;

    @ParameterType(".*")
    public LocalDateTime datetime(String dateTimeString) {
        System.out.println("dateTimeString: " + dateTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    @Given("today is {datetime} UTC")
    public void todayIs(LocalDateTime datetime) {
        System.out.println("Date: " + datetime);
        this.datetime = datetime;
    }

    @And("machineId is {string}")
    public void machineIdIs(String machineId) {
        System.out.println("MachineId: " + machineId);
        this.machineId = machineId;
    }

    @And("previous sequence number is {int}")
    public void previousSequenceNumberIs(int previousSequenceNumber) {
        System.out.println("Previous Sequence Number: " + previousSequenceNumber);
    }

    @Given("previous sequence number is NULL")
    public void previous_sequence_number_is_null() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Previous Sequence Number: NULL");
    }

    @When("a new distributed ID is generated")
    public void aNewDistributedIDIsGenerated() {
        System.out.println("WHEN New distributed ID is generated with machineId " + machineId);
    }

    @Then("it should be {string}")
    public void itShouldBe(String newId) {
        System.out.println("THEN New distributed ID is " + newId);
    }

    @And("the new sequence number should be {int}")
    public void theNewSequenceNumberShouldBe(int newSequenceNumber) {
        System.out.println("New Sequence Number: " + newSequenceNumber);
    }
}
