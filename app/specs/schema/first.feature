Feature: A new distributed ID can be generated
  Snowflakes are 64 bits in binary.
  (Only 63 are used to fit in a signed integer.)
  The first 41 bits are a timestamp, representing milliseconds since the chosen epoch.
  The next 10 bits represent a machine ID, preventing clashes.
  Twelve more bits represent a per-machine sequence number,
  to allow creation of multiple snowflakes in the same millisecond.
  The final number is generally serialized in decimal.

  Rule: When a snowflake id is generated without epoch,
    it should be defaulted to 1759536000000
    And the sequence number should be incremented.

    Scenario Outline: Validating the calculation of timestamp and
    generation of the per-machine sequence number
      Given today is <datetime> UTC

      Examples:
        | datetime            |  |  |  |  |
        | 2025-04-10T00:00:00 |  |  |  |  |
