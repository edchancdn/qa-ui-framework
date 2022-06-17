package ui.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import ui.framework.util.Utils;

public class HtmlReport {
    private static HtmlReport instance;
    private ExtentReports reports;

    private HtmlReport(){
        reports = new ExtentReports();
            reports.attachReporter(new ExtentSparkReporter(Utils.getReportFile()));
    }

    public synchronized static ExtentTest createTest(String testname){
        if(instance ==null){
            instance = new HtmlReport();
        }
        return instance.reports.createTest(testname);
    }

    public synchronized static void flushReports(){
        if(instance!=null) {
            instance.reports.flush();
        }
    }
}
