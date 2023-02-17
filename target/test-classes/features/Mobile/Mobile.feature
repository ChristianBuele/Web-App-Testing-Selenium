Feature: Mobile Feature
  Background:
    Given Start Navigator
  Scenario: Mobile Feature
   When Write "ocastro@flow.com" in text box with id "username"
   When Write "12345" in text box with id "password"
   When Click on Sing In button
   When Click Custom "//*[@id='root']/main/div/section/div[2]/div[2]/div/div[1]/button/img" option
   When Choose a "Mobile" option
   When Select "Passport" from selectId "customer.identification.identificationType"
   When Write "1234567990" in text box with id "customer.identification.identificationNumber"
   When Write "12/30/2026" in text box with id "customer.identification.expirationDate"
   When Write "Jhommyy" in text box with id "customer.firstName"
   When Write "Smitherss" in text box with id "customer.lastName"
   When Select "Taxable" from selectId "taxException"
   When Click on "Save and Continue" button
   When Choose a "CUR Chippie 7 - 2 year" option
   When Click on "Continue" button
   When Await "3" seconds
   When Click on "Continue" button
   When Click on custom button "//*[@id='root']/div/main/section/section/div[2]/div/div/div[2]/div/div[1]/article/div[3]/button"
   When Click on "Continue" button
   When Select "selectNumber" radio button
   When Click on "Continue" button
   When Click on "Proceed to checkout" button
   When Select "Mr" from selectId "salutation"
   When Write "01/01/2000" in text box with id "DOB"
   When Select "Ecuador" from selectId "nationality"
   When Select "Male" from selectId "gender"
   When Write "test@gmai.com" in text box with id "email"
   When Write "Sigsig" in text box with id "address.street1"
   When Write "1234" in text box with id "address.postCode"
   When Click on "Save and Continue" button
   When Select "Residential" from selectId "billingType"
   When Select "Cycle 20th" from selectId "billingCycle"
   When Select "English" from selectId "languagePreference"
   When Click on "Continue" button
   When Scan products
   When Write "89599910000000003638" in text box with id "serialNo"
   When Click on "Confirm" button
   When Click on "Continue" button
   When Click on "Continue" button
   When Click on "Continue" button
   When Click on "Accept" button
