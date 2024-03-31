package io.beandev.eventstore.smartcontract.entities;

public class Attribute {
    private Entity entity;
    private String name;

    public class Version {
        private Attribute attribute;
        private Entity.Version entityVersion;
        private short number;
    }
}
