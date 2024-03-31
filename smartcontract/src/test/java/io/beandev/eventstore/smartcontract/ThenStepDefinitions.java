package io.beandev.eventstore.smartcontract;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.fail;

public class ThenStepDefinitions {

    @Then("the System SHALL build the aggregates")
    public void theSystemSHALLBuildTheAggregates() {
        // TODO Assert expectations
        fail();
    }

    @And("the returned {} aggregate SHALL have version {int} for all its entities and attributes")
    public void theReturnedAggregateSHALLHaveVersionForAllItsEntitiesAndAttributes(String aggregateName, int versionNum) {
        // TODO Assert expectations
        fail();
    }
}
