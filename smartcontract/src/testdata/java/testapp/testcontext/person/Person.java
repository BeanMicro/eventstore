package testapp.testcontext.person;

import io.beandev.eventstore.smartcontract.annotations.AggregateRoot;
import io.beandev.eventstore.smartcontract.annotations.Default;
import io.beandev.eventstore.smartcontract.annotations.Fallback;
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
