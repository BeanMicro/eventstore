package io.beandev.eventstore.migration;

import org.flywaydb.core.Flyway;

public class App {
    public static void main(String[] args) {
        var url = "jdbc:postgresql://localhost:5433/eventstore_db";
        var user = "postgres";
        var password = "password";
        Flyway flyway = Flyway
                .configure()
                .baselineOnMigrate(true)
                .locations("classpath:migrations")
                .dataSource(url, user, password).load();
        flyway.migrate();
    }
}