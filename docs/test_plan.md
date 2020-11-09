# Test plan

## Analysis

Product under test is a messging app. The app is going to be used by medical personel to communicate with each other. The development team just finished registration flow, which is the only function in the app at the time of writing. Application is intended to be used on mobile phones with Android OS.

## Scoping

**In scope:**
* Manual tests: Happy path registration flow.
* Manual tests: Phone number screen.
* Manual tests: Names screen.
* Manual tests: "Max-the-fax" selection screen manual tests.
* Manual tests: Terms screen.
* Automatic tests: Happy path registration flow.
* Automatic tests: Phone number screen.
* Automatic tests: Names screen.

**Out of scope:**
* Non functional testing.
* Performance testing.
* Design review.

## Deliverables
* Test plan with test cases.
* Test code for automatic testing.
* Automatic test report.
* Bug report.
* Requirement review.

## Test cases

### 2 Registration flow: terms screen

#### UI check
* Open applicaton.
* Go to terms screen.
* Check header text.
* Check test below header.
* Check button "Yes, agree".
* Check button "No, I prefer to continue sending good ol' faxes".
* Check "Back" button.

**Expected result:** all checks pass.

#### Accept button
* Open application
* Go to terms screen.
* Press button "Yes, agree".

**Expected result:** names screen opened.

#### Decline button
* Open application
* Go to terms screen.
* Press button "No, I prefer to continue sending good ol' faxes".

**Expected result:** "Max-the-fax" screen opened.

#### Back button
* Open application
* Go to terms screen.
* Press back button.

**Expected result:** Welcome screen opened.

### 3 Registration flow: "Max-the-fax" screen

#### UI check
* Open applicaton.
* Go to "Max-the-fax" screen.
* Check blue screen, terminal like behaviour.
* Check button "I changed my mind!".
* Check button "Call Team Siilo".
* Check "Back" button.

**Expected result:** all checks pass.

#### Accept button
* Open application
* Go to "Max-the-fax" screen.
* Press button "I changed my mind!".

**Expected result:** terms screen opened.

#### Decline button
* Open application
* Go to "Max-the-fax" screen.
* Press button "Call Team Siilo".

**Expected result:** native phone app opened.

### 4 Registration flow: Names screen

#### UI check
* Open applicaton.
* Go to names screen.
* Check header text.
* Check first name with placeholder.
* Check last name with placeholder.
* Check "Next" button.
* Check "Back" button.

**Expected result:** all checks pass.

#### Keyboard
* Open applicaton.
* Go to names screen.
* Tap first/last name field.

**Expected result:** keyboard opens.

#### Required fields
* Open applicaton.
* Go to names screen.
* Input text into one of the fields. 

**Expected result:** Button "Next" is disabled if one of the fields is not filled.

#### Input rule validation
* Open applicaton.
* Go to names screen.
* Input "4" into first name.
* Input "~" into last name.

**Expected result:** Button "Next" is enabled.

#### Input spaces
* Open applicaton.
* Go to names screen.
* Input " " into first name.
* Input " " into last name.

**Expected result:** Button "Next" is disabled.

#### Clear input
* Open applicaton.
* Go to names screen.
* Input "test" into first name.
* Input "test" into last name.
* Check button "Next" is enabled
* Clear both fields.

**Expected result:** Button "next" is disabled.

### 8 Registration flow: phone number screen

#### UI check
* Open applicaton.
* Go to phone number screen.
* Check header text.
* Check select country.
* Check phone number.
* Check "Next" button.
* Check "Back" button.

**Expected result:** all checks pass.

#### Pre-filled inputs
* Open applicaton.
* Go to phone number screen.

**Expected result:** both fields have pre-filled values.

#### Keyboard
* Open applicaton.
* Go to phone number screen.
* Tap phone field.

**Expected result:** keyboard opens.

#### Next button
* Open application
* Go to phone number screen.
* Press "Next" button.

**Expected result:** verification code screen opened.

#### Back button
* Open application
* Go to phone number screen.
* Press "Back" button.

**Expected result:** email confirmation screen opened.

#### Country list
* Open application
* Go to phone number screen.
* Tap country code field.

**Expected result:** country list screen shows the "Most common" countries on top.

#### Required fields
* Open application
* Go to phone number screen.

**Expected result:** Button "next" is disabled.
