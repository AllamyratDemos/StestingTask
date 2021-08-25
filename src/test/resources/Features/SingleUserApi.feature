@api
  Feature: Single user end point test

    Scenario: sending get request  to single user end point
      Given sets Get single user api service end point
      When user sends get request to single user end point
      Then the status code should be 200
      And first_name should be "Janet"
