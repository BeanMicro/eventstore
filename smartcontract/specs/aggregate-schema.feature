Feature: Aggregate Schema

  Rule: WHEN a Jar InputStream is converted to SmartContract (SC) domain objects,
    the System SHALL validate and return the corresponding SC domain objects.

    Scenario Outline: Validate <jarType> JAR file and return the converted SC domain objects.
      Given an InputStream of a <jarType> JAR file
      And the aggregate <aggregate> is in the JAR file
      But the aggregate <aggregate> is NOT in the System
      When the aggregates are built from the jar input stream
      Then the System SHALL build the aggregates
      And the returned <aggregate> aggregate SHALL have version 1 for all its entities and attributes

      Examples:
        | jarType | aggregate |
        | GENERIC | person    |