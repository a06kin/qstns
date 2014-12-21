Feature: Successful question application
  Scenario: Mr.Duke ask a question
    Given Mr.Duke want to ask a question "why mascots have no salary?"
    When Mr.Duke ask question with status 200
    Then Mr.Duke has question in history