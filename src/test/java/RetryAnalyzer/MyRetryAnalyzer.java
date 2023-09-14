package RetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 4;

    @Override
    public boolean retry(ITestResult iTestResult) {
        return retryCount++ < maxRetryCount;
    }
}
