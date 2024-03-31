package io.beandev.eventstore.smartcontract.entities;

import java.util.Collection;

public class Entity {
    private Aggregate aggregate;
    private Collection<Attribute> attributes;
    private String name;

    public class Version {
        private Entity entity;
        private Collection<Attribute.Version> attributeVersions;
        private short number;
    }
}
