# HomeAway Assessment

## Description

This is an example of incorporating Geb into a Gradle build. It shows the use of Spock and JUnit 4 tests.

The build is setup to work with Firefox, Chrome and PhantomJS. Have a look at the `build.gradle` and the `src/test/resources/GebConfig.groovy` files.

## Usage

The following commands will launch the tests with the individual browsers:

    ./gradlew chromeTest
    ./gradlew firefoxTest
    ./gradlew ieTest

To run with all, you can run:

    ./gradlew test

Replace `./gradlew` with `gradlew.bat` in the above examples if you're on Windows.


