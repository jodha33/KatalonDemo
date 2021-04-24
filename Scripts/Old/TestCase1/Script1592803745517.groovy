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

WebUI.navigateToUrl('https://www.amazon.in/')

WebUI.waitForPageLoad(7)

WebUI.waitForElementPresent(findTestObject('Object Repository/HomePage/Input_SearchKeywords'), 5)

WebUI.setText(findTestObject('Object Repository/HomePage/Input_SearchKeywords'), 'mobile')

WebUI.click(findTestObject('Object Repository/HomePage/Input_SerachGo'))

url = WebUI.getUrl()

if (url.contains('mobile')) {
    print('URL Verified')
} else {
    print('Incorrect URL')
}

WebUI.waitForElementPresent(findTestObject('SearchResultPage/Span_Iphone'), 5)

WebUI.click(findTestObject('Object Repository/SearchResultPage/Span_Iphone'))

WebUI.switchToWindowIndex(1)

Label = WebUI.getText(findTestObject('Page_AppleiPhone/Span_iPhoneLabel'))

print('Iphone Label---' + Label)

WebUI.switchToWindowIndex(0)

WebUI.setText(findTestObject('Object Repository/HomePage/Input_SearchKeywords'), 'zqa123')

WebUI.click(findTestObject('Object Repository/HomePage/Input_SerachGo'))

Result_1 = WebUI.getText(findTestObject('HomePage/Span_NoResultLabel1'))

Result_2 = WebUI.getText(findTestObject('HomePage/Span_NoResultLabel2'))

print((('Printing the Result for ZQA123---' + Result_1) + ' ') + Result_2)

WebUI.closeWindowIndex(0)

