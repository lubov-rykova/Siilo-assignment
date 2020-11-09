# Bug report

## Common

### App crash on rotation
* Open application.
* Change rotation to landscape.

**Expected result:** Application does not crash. 

**Actual result:** Appliaction crashes.

### App crash on rotation
**Precondition:** "Don't keep activities" option is enabled in developer options.
* Open application.
* Minimise application.
* Expand application.

**Expected result:** Application does not crash. 

**Actual result:** Appliaction crashes.


### Missed back button
* Open application.
* Go to through the registration flow.

**Expected result:** All screens have "Back" button.

**Actual result:** No screen has "Back" button.

### App overlays status bar
* Open application.

**Expected result:** Status bar is visible.

**Actual result:** Status bar is not visible.

### Overlaying screens
* Open application.
* Go to any screen with an input field.
* Tap the field.
* Check the keyboard is shown.
* Go to the next screen.

**Expected result:** Keyboard is not open.

**Actual result:** Keyboard is still open.

## 2 Registration flow: terms screen

### Escaped HTML
* Open application.
* Go to terms screen.

**Expected result:** Read terms button does not contain HTML tags.

**Actual result:** Read terms button contains HTML tags.

## 3 Registration flow: Max-the-fax screen

### Return button closes app
* Open application.
* Go to "Max-the-fax" screen.
* Press "I changed my mind!" bbutton.

**Expected result:** Terms screen opens.

**Actual result:** Application closes.

## 4 Registration flow: Names screen

### Input spaces
* Open application.
* Go to names screen.
* Input " " into first/last name.

**Expected result:** "Next" button is disabled.

**Actual result:** "Next" button is enabled.

### First name is optional
* Open application.
* Go to names screen.
* Fill last name only.

**Expected result:** "Next" button is disabled.

**Actual result:** "Next" button is enabled.

## 5 Registration flow: professions screen

### Incorrect formatting
* Open application.
* Go to professions screen.

**Expected result:** Name submitted on the previous step is inserted into the header.

**Actual result:** Actual "%s" format placeholder is displayed instead of name.

### Confirmation is absent
* Open application.
* Go to professions screen.
* Tap on any profession.

**Expected result:** confirmation button is displayed.

**Actual result:** email screen opens.

## 6 Registration flow: email screen

## Incorrect text
* Open application.
* Go to email screen.

**Expected result:** all text on the screen matches the specs.

**Actual result:** no text matches the specs.

## 7 Registration flow: email confirmation screen

### Email underscore
* Open application.
* Go to email confirmation screen.

**Expected result:** email value is not underscored.

**Actual result:** email value is underscored.

## 8 Registration flow: phone number screen

### No pre-filled values
* Open application.
* Go to phone number screen.

**Expected result:** country code has a pre-filled country. Phone number has matching country code prefix.

**Actual result:** both country code and phone fields are empty.

### Phone is optional
* Open application.
* Go to phone number screen.
* Select country code.

**Expected result:** "Next" button is disabled.

**Actual result:** "Next" button is enabled.

### Country name underscored
* Open application.
* Go to phone number screen.
* Select country code.
* Change country code to a different one.

**Expected result:** County text in the filed is not underscored.

**Actual result:** County text in the filed is underscored.

## 9 Registration flow: verification code screen

### Extra button
* Open application.
* Go to verification code screen.

**Expected result:** There is only one button by the spec.

**Actual result:** "I didn't receive a code" button is present.

## 10 Registration flow: notification choice screen

### Extra content
* Open application.
* Go to notification choice screen.

**Expected result:** All text matches the spec.

**Actual result:** There is an info icon which is not in the spec. There is "notification example" text under each option which is not in the spec.
