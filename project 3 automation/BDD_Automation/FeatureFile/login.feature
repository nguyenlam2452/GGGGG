
@tag
Feature: Login with email and password
  @tag1
  Scenario Outline: login 
    Given user is on login pages
    When user enter email "<email>"
    And user enter password "<password>"
    And user click signin button
    Then user should be logged in
    
    
    Examples:
     | email	| password |
     | funixExample1@gmail.com  | Abc@1234 |
     | funixExample2@gmail.com  | Abc@13579 |
     | funixExample3@gmail.com1 | Funix11223 |
     | funixExample4@gmail.com  | Funix1234567 |
     | funixExample5@gmail.com  | Admin1234 |
     | funixExample6@gmail.com  | Abc@000 |
     | funixExample7@gmail.com  | Abc@111 |
     
    @tag2
  Scenario Outline: login failed 
    Given user is on login pages
    When user enter email "<email>"
    And user enter password "<password>"
    And user click signin button
    Then the status must be visible
    
    
    Examples:
     | email	| password |
     | funixExample2@gmail.com  | Abc@13579 |
     | funixExample3@gmail.com1 | Funix11223 |
     | funixExample4@gmail.com  | Funix1234567 |
     | funixExample5@gmail.com  | Admin1234 |
     | funixExample6@gmail.com  | Abc@000 |

     




     
    

