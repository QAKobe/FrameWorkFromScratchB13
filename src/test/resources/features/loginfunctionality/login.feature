@regression   @smoke
Feature: Testing the login positive and negative functionalities

#  Scenario: Validating the successful login for OpenMrs
#    Given User navigates to OpenMrs website and provides credentials
#    Then User validates title 'ui' and 'https://demo.openmrs.org/openmrs/referenceapplication/home.page'

  Scenario Outline: Validating the negative login for OpenMrs
    Given User navigates to OpenMrs website and provides invalid credentials which are '<username>' and '<password>'
    Then User validates the errorMessage 'Invalid username/password. Please try again.'

    Examples:
      | username  | password  |
      | admin     | adsadas   |
      | adasdsa   | Admin123  |
      |           | asdsadsd  |
      | adsadsad  |           |
      | 123234322 | 123123213 |
      | admin     |           |
      |           | Admin1234 |
      | ADMIN     | ADMIN123  |
      |!@#@#$#$@  |@#@#$%$^%$^|

