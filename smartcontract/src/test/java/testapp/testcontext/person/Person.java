package testapp.testcontext.person;

import io.beandev.eventstore.core.AggregateRoot;
import io.beandev.eventstore.core.Default;
import io.beandev.eventstore.core.Fallback;
import jakarta.validation.constraints.NotNull;

@AggregateRoot
class Person {
    String familyName;

    @NotNull
    String givenName;

    Short yearOfBirth;

    @Default("OTHER")
    Gender gender;

    @Fallback("UNKNOWN")
    enum Gender {
        MALE,
        FEMALE,
        OTHER,
        UNKNOWN
    }
}
