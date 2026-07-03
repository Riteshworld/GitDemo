Feature: Validating Place API's

  Scenario: Verify if Place is being successfully added using AddPlaceAPI
    Given Add place Payload with "<name>" "<address>"
    When User calls "AddPlaceAPI" with "POST" http request
    And "status" in responce body is "OK"
    And "scope" in responce body is "APP"
    
    
    Examples:
    |name|address|
    |AAhouse|World cross centre|
    |BBhouse|World cross centre1|
