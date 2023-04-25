Feature: TV Feature
  Background:
    Given Start Navigator
  Scenario: TV Feature
    When Open develop console
    When Write "ocastro@flow.com" in text box with id "username"
    When Write "12345" in text box with id "password"
    When Click on Sing In button
    When Click Custom "//*[@id='root']/main/div/section/div[2]/div[2]/div/div[2]/button/img" option
    When Await "3" seconds
    When Choose a "TV" option
    When Select "Passport Number" from selectId "customer.identification.identificationType"
    When Write "0105211783" in text box with id "customer.identification.identificationNumber"
    When Write "12/30/2026" in text box with id "customer.identification.expirationDate"
    When Write "Jhommyy" in text box with id "customer.firstName"
    When Write "Smitherss" in text box with id "customer.lastName"
    When Select "Taxable" from selectId "taxException"
    When Click on "Save and Continue" button
    When Verify existing account "No"
    When Select "ST. GEORGE" from selectId "address.county"
    When Select "BARNES HILL VILLAGE" from selectId "address.area"
    When Select sugestion "BARN" from id "address.streetName"
    When Write "BSN-21WQ" in text box with id "address.houseNumber"
    When Click on "Continue" button
    When Await "4" seconds
    When Click on "Continue" button
    When Choose a "TV Essential" option
    When Click on "Continue" button
    When Select items "Asian Pack;PSTV;Adult;RAI ITALIA"
    When Click on "Continue" button
    When Click on "Proceed to checkout" button
    When Select "Mr" from selectId "salutation"
    When Write "01/01/2000" in text box with id "DOB"
    When Select "Ecuador" from selectId "nationality"
    When Select "Male" from selectId "gender"
    When Write "test@gmai.com" in text box with id "email"
    When Write "0985631653" in text box with id "phone"
    When Click on "Save and Continue" button
    When Select "Residential" from selectId "billingType"
    When Select "Cycle 1st" from selectId "billingCycle"
    When Select "English" from selectId "languagePreference"
    When Click on "Continue" button
    When Select schedule
    When Click on "Continue" button
    When Await "3" seconds
    When Click on "Continue" button
    When Click on "Accept" button
