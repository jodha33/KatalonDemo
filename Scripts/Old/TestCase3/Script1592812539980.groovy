import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://amazon.in')

WebUI.waitForPageLoad(5)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> mylist = driver.findElements(By.xpath('//div[@class=\'a-cardui-header\']/h2'))

FileInputStream fis = new FileInputStream(RunConfiguration.getProjectDir() + '/Data Files/MyData.xlsx')

XSSFWorkbook workbook = new XSSFWorkbook(fis)

XSSFSheet sheet = workbook.getSheet('Sheet2')

XSSFRow row

int row_no = 1

for (WebElement e : mylist) {
    if (e.getText().trim().length()!=0) {
        row = sheet.createRow(row_no)

        //print(e.getText());
        XSSFCell cell = row.createCell(0)

        cell.setCellValue(e.getText().trim())
    }
    
    row_no++
}

FileOutputStream fos = new FileOutputStream(RunConfiguration.getProjectDir() + '/Data Files/MyData.xlsx')

workbook.write(fos)

fos.close()