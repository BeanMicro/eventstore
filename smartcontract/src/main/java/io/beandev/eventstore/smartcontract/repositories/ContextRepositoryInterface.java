package io.beandev.eventstore.smartcontract.repositories;

import io.beandev.eventstore.smartcontract.entities.Attribute;
import io.beandev.eventstore.smartcontract.entities.Context;
import io.beandev.eventstore.smartcontract.entities.Entity;

public interface ContextRepositoryInterface {
    Context findContextByName(String name);
}
