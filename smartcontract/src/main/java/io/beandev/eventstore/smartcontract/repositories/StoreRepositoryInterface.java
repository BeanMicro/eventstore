package io.beandev.eventstore.smartcontract.repositories;

import io.beandev.eventstore.smartcontract.entities.Store;

public interface StoreRepositoryInterface {
    Store findStoreByName(String name);
}
