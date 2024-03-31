package io.beandev.eventstore.smartcontract.repositories;

import io.beandev.eventstore.smartcontract.entities.Attribute;
import io.beandev.eventstore.smartcontract.entities.Entity;

public interface AggregateRepositoryInterface {
    Entity.Version getLatestEntityVersion(Entity entity);

    Attribute.Version getLatestAttributeVersion(Attribute attribute);
}
