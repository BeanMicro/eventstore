Feature: Aggregate Schema

  Rule: WHEN a Jar InputStream is converted to SmartContract (SC) domain objects,
    the System SHALL validate and return the corresponding SC domain objects.

    Scenario Outline: Validate <jarType> JAR file and return the converted SC domain objects.
      Given an InputStream of a <jarType> JAR file

      Examples: My Description
        | jarType |  |  |  |  |
        | GENERIC |  |  |  |  |
