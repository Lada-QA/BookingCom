Feature: Search on Booking.com with filters

  Scenario: Search with filters
    Given User is looking for hotels in 'Minsk' city
    When User does search
    Then User choose criteria for hotel
