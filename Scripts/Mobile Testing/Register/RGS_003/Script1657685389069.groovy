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

Mobile.startApplication('C:\\Users\\095068\\Documents\\Automation Testing with Katalon Studio\\Sesi 11\\Final Project1_F.X. Airell V.S.W._KSAT006ONL013\\FinalProjectMobile - Sesi 11\\APK\\app-debug.apk', 
    true)

Mobile.waitForElementPresent(findTestObject('All Header/title_Home'), 5)

Mobile.tap(findTestObject('Login Page/btn_Create A Profile'), 0)

Mobile.setText(findTestObject('Register Page/txt_First Name'), 'Jane', 0)

Mobile.setText(findTestObject('Register Page/txt_Country'), 'Indonesia', 0)

Mobile.setText(findTestObject('Register Page/txt_Username'), 'janedoe', 0)

Mobile.setText(findTestObject('Register Page/txt_Password'), 'JaneDoeTesting1', 0)

Mobile.setText(findTestObject('Register Page/txt_Confirm Password'), 'JaneDoeTesting1', 0)

Mobile.tap(findTestObject('Register Page/btn_Create Profile'), 0, FailureHandling.STOP_ON_FAILURE)

// Verify Toast
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

def toast = driver.findElementByXPath('//android.widget.Toast[@text=\'You have left one or more fields blank\']')

println('Toast element: ' + toast)

if (toast == null) {

    KeywordUtil.markFailed('ERROR: Toast object not found!')

} else {

	println('Success: Toast object is found!')

}

Mobile.closeApplication()

