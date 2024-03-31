package io.beandev.eventstore.smartcontract;

import io.beandev.eventstore.smartcontract.entities.Aggregate;
import io.beandev.eventstore.smartcontract.repositories.AggregateRepositoryInterface;
import io.beandev.eventstore.smartcontract.repositories.ContextRepositoryInterface;
import io.beandev.eventstore.smartcontract.repositories.StoreRepositoryInterface;

import java.io.InputStream;
import java.util.Collection;

public class SmartContractManager {
    private final AggregateRepositoryInterface aggregateRepository;

    public SmartContractManager(
            AggregateRepositoryInterface aggregateRepository
            ) {
        this.aggregateRepository = aggregateRepository;
    }

    public Collection<Aggregate> buildAggregatesFromJarInputStream(InputStream jarInputStream) {
        throw new UnsupportedOperationException();
        // Build Direct entities from jarInputStream
        // Compare with latest version of entities
        // If there is a difference, create a new version
        // If there is no difference, do nothing
        // However, let's focus on the first step for now which is
        //    that this is a new entity and there is no previous version.
    }
}
