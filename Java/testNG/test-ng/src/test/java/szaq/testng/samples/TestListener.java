package szaq.testng.samples;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by pmalczyk on 3/13/14.
 */
public class TestListener implements ITestListener {


        @Override
        public void onTestStart(ITestResult iTestResult) {
            System.out.println(getClass() + "Test-Start");
        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {
            System.out.println(getClass() +"Test-SUCCESS");
        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {
            System.out.println(getClass() + "Test-FAIL");
        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {
            System.out.println(getClass() +"Test-SKIPPED");
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        }

        @Override
        public void onStart(ITestContext iTestContext) {
            System.out.println(getClass() +"Test-Start");
        }

        @Override
        public void onFinish(ITestContext iTestContext) {
            System.out.println(getClass() +"Test-Finish");
        }
}
