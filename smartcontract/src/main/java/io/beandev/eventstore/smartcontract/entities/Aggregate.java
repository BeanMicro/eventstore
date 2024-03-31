package io.beandev.eventstore.smartcontract.entities;

import java.io.InputStream;
import java.util.Collection;

public class Aggregate {
    private final Context context;
    private final String name;

    private Collection<Entity> entities;

    private Aggregate(
            Context context,
            String name
    ) {
        this.context = context;
        this.name = name;
    }

    public static AggregateBuilder builder(
            Context context
    ) {
        return new AggregateBuilder(context);
    }

    public static class AggregateBuilder {
        private final Context context;
        private String name = "DefaultAggregate";

        AggregateBuilder(Context context) {
            this.context = context;
        }

        public AggregateBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Aggregate build() {
            return new Aggregate(
                    context,
                    name
            );
        }
    }

    public Context getContext() {
        return context;
    }

    public String getName() {
        return name;
    }
}
