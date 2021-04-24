import com.aventstack.extentreports.MediaEntityBuilder
import com.aventstack.extentreports.MediaEntityModelProvider
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.logging.model.TestSuiteLogRecord
import com.kms.katalon.core.reporting.ReportWriterUtil
import com.kms.katalon.core.setting.BundleSettingStore
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.internal.ExceptionsUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


class LaunchBrowser {
	
	@AfterTestSuite
	public void exportKatalonReports() {
		
			
			
			String reportFolder = RunConfiguration.getReportFolder();
			String projectDir = RunConfiguration.getProjectDir();

			BundleSettingStore bundleSettingStore = new BundleSettingStore(projectDir, "com.katalon.plugin.report",
					true);

			boolean genereteHTML = bundleSettingStore.getBoolean("generateHTML", true);
			boolean genereteCSV = bundleSettingStore.getBoolean("generateCSV", true);
			// boolean genereteJUnit = bundleSettingStore.getBoolean("generateJUnit", true);
			boolean generetePDF = bundleSettingStore.getBoolean("generatePDF", false);
			if (!genereteCSV && !generetePDF) {
				return;
			}

			

			TestSuiteLogRecord suiteLogEntity = ReportWriterUtil.generate(reportFolder);
			File reportFolderFile = new File(projectDir+"/Reports/lateshHtmlReport/"+RunConfiguration.getExecutionSourceName());
			if (genereteHTML) {
				KeywordUtil.logInfo("Start generating HTML report folder at: " + reportFolder + "...");
				ReportWriterUtil.writeHtmlReport(suiteLogEntity, reportFolderFile);
				KeywordUtil.logInfo("HTML report generated");
			}

//			if (genereteCSV) {
//				KeywordUtil.logInfo("Start generating CSV report folder at: " + reportFolder + "...");
//				ReportWriterUtil.writeCSVReport(suiteLogEntity, reportFolderFile);
//				KeywordUtil.logInfo("CSV report generated");
//			}

//            if (genereteJUnit) {
//                KeywordUtil.logInfo("Start generating JUnit report folder at: " + reportFolder + "...");
//                ReportWriterUtil.writeJUnitReport(suiteLogEntity, reportFolderFile);
//                KeywordUtil.logInfo("JUnit report generated");
//            }
//
//			if (generetePDF) {
//				KeywordUtil.logInfo("Start generating PDF report folder at: " + reportFolder + "...");
//				ReportWriterUtil.writePdfReport(suiteLogEntity, reportFolderFile);
//				KeywordUtil.logInfo("PDF report generated");
//			}
			/*
			 * } catch (Exception e) {
			 * KeywordUtil.markWarning(ExceptionsUtil.getStackTraceForThrowable(e)); }
			 */
	}
	
}