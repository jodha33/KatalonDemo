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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(UrlYahoo)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_FirstName'), FirstName)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_LastName'), LastName)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_ID'), ID)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_Password'), Password)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_Mobile'), MobileNo)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Yahoo/Select_Month'), DOB_Month, true)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_Date'), DOB_DAY)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_Year'), DOB_Year)

WebUI.setText(findTestObject('Object Repository/Page_Yahoo/Input_Gender'), DOB_Year)

WebUI.closeWindowIndex(0)

