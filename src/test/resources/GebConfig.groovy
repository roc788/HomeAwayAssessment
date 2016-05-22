/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

waiting {
	timeout = 10
}

baseUrl = "http://store.demoqa.com"

//Driver setup here as well for now when running in IDE
driver = {
	def driverInstance = new FirefoxDriver()
	driverInstance.manage().window().maximize()
	driverInstance
}
reportsDir = "reports"

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = {
			def driverInstance = new ChromeDriver()
			driverInstance.manage().window().maximize()
			driverInstance
		}
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = {
			def driverInstance = new FirefoxDriver()
			driverInstance.manage().window().maximize()
			driverInstance
		}
	}

}

// To run the tests with all browsers just run “./gradlew test”
