Feature: OpenLibrary API

Scenario: Get Author info
    Given I set the OpenLibrary API endpoint
    When I send a GET request
    Then the response status should be 200
    And the response should contain author details:
    | personal name          | alternate name                        |
    | Sachi Rautroy          | Yugashrashta Sachi Routray            |
    | Sachi Rautroy          | Satchidananda Rautroy                 |
    | Sachi Rautroy          | Sachi Rautroy                         |