import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
// Another import
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Mobile Testing/Make Account/MAC_003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Dashboard/btn_Widget'), 0)

Mobile.tap(findTestObject('Widget/btn_Make a Transfer'), 0)

Mobile.tap(findTestObject('Transfer/ddn_Receiving Account'), 0)

Mobile.tap(findTestObject('Transfer/ddn_Jane 2'), 0)

Mobile.tap(findTestObject('Transfer/ddn_Sending Account'), 0)

Mobile.tap(findTestObject('Transfer/ddn_Jane 1'), 0)

Mobile.tap(findTestObject('Transfer/btn_Confirm Transfer'), 0)

// Verify Toast
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

def toast = driver.findElementByXPath('//android.widget.Toast[@text=\'Please enter an amount to transfer\']')

println('Toast element: ' + toast)

if (toast == null) {

    KeywordUtil.markFailed('ERROR: Toast object not found!')

} else {

	println('Success: Toast object is found!')

}

Mobile.closeApplication()

