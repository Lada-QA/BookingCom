Feature: Search on booking.com

  Scenario: Search by city criteria
    Given User is looking for hotels in 'Minsk' city
    When User does search
    Then Hotel 'Hampton by Hilton Minsk City Centre' should be on the first page

  Scenario Outline: Search by different cities criteria
    Given User is looking for hotels in '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page

    Examples:
      | City  | Hotel                               |
      | Minsk | Hampton by Hilton Minsk City Centre |
      | Brest | Hampton by Hilton Brest             |
      | Gomel | Чисто Отель                         |

  Scenario Outline: Check different hotels rating
    Given User is looking for hotels in '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be '<Rating>'

    Examples:
      | City     | Hotel                                 | Rating |
      | Venice   | Palazzo Veneziano - Venice Collection | 9,2    |
      | Mogilev  | Hotel ATRIUM                          | 9,4    |
      | Budapest | Hotel Clark Budapest - Adults Only    | 9,2    |