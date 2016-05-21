# HomeAway Assessment

## Recreating the test environment

You must first generate a Gradle build file which contains the correct versions of Groovy, Geb, Selenium, and the associated drivers.  Dependencies consisting of Spock and JUnit are necessary as well.  For test reporting, you may specify the location of where to put test results and screenshots within the generated tasks in the `build.gradle` file.

If you want to be able to run Gradle standalone without worrying about it already being installed, you can run `gradle wrapper` to download the wrapper.  You would then run `gradlew <argument>` for all gradle commands.

For working with the Windows OS, I leveraged build tasks from the [Geb Examples](https://github.com/geb/geb-example-gradle) project.

There should be a `src/test/groovy` and a `src/test/resources` directory.  The groovy directory should contain all tests, Page classes, and Module classes.  The resources directory should at least contain the `GebConfig.groovy` file.  This file is ran before tests are run, and specifies what driver to use, what base url to use, and other Geb configurations.

The build is setup to work with Firefox, Chrome and Internet Explorer. References to these browsers are found in the `build.gradle` and the `src/test/resources/GebConfig.groovy` files.

## Test Pre-requisites and assumptions

### Exercise 1

For the test case in which the user must log in and modify his profile, the user must already be registered. You can see in the test that "Joe" is the username and "foobar" is the password.  This user with this password must exist for this test to pass as it is currently written.

Item selection and deletion is based on the exact name given for each item, as shown in the tests.  It is assumed that these names will not be modified.

### Exercise 2

There must be an API key provided for the tests.  My API is included in the test class as it currently stands.

Since the site uses SSL authentication, for testing purposes, I ignored the strict SSL issues, assuming that the client would not have any SSL issues connecting otherwise.

## Usage

The following commands will launch the tests with the individual browsers:

    ./gradlew chromeTest
    ./gradlew firefoxTest
    ./gradlew ieTest

To run with all, you can run:

    ./gradlew test

Replace `./gradlew` with `gradlew.bat` in the above examples if you're on Windows.

## Issues Found

### Exercise 1

The price summary does not show up when you first arrive at the info page during a purchase.  However, when you navigate away from the page and back to the info page, it shows up.

It would be easier to write element closures if all pertinent elements had a consistant attribute which had a value that was unique to the given element. It would then be less likely for a change to the page to break the test due to a necessary change to the closure.

### Exercise 2

The wording in the slides are misleading for this exercise.  The URL given is for the documentation, not the endpoint.

There is no country key returned in the json when querying for a station by the ID.