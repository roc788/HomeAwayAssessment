/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver

waiting {
	timeout = 10
}

baseUrl = "http://store.demoqa.com"
driver = { new FirefoxDriver() }
reportsDir = "reports"

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

	// run via “./gradlew ieTest”
    ie {
        driver = { new InternetExplorerDriver() }
    }

}

// To run the tests with all browsers just run “./gradlew test”
