package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends CommonOperations implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("--------------- Starting test : " + result.getName());
    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS
     */
    public void onTestSuccess(ITestResult result) {
        System.out.println("--------------- Starting test : " + result.getName() + "---Passed-------");
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    public void onTestFailure(ITestResult result) {
        System.out.println("--------------- Starting test : " + result.getName() + "---Failed-------");
        saveScrenShot();
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    public void onTestSkipped(ITestResult result) {
        System.out.println("--------------- Skipped test : " + result.getName());
    }

    /**
     * Invoked each time a method fails but has been annotated with successPercentage and this failure
     * still keeps it within the success percentage requested.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
     */
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test fails due to a timeout.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     */
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    /**
     * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
     * and calling all their Configuration methods.
     */
    public void onStart(ITestContext context) {
        System.out.println("--------------- Starting execution ------------");
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
     * and all their Configuration methods have been called.
     */
    public void onFinish(ITestContext context) {
        System.out.println("--------------- Finish execution ------------");
    }

    @Attachment(value = "Page screen shot", type = "image/png")
    public byte[] saveScrenShot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}
