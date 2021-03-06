package io.testproject.generated.tests.myfirstproject;

import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.TakeScreenshotConditionType;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import org.openqa.selenium.By;

/**
 * This class was automatically generated by TestProject
 * Project: My first Project
 * Test: TestSimon
 * Generated by: B deBautista (fsimonbcontact@gmail.com)
 * Generated on Wed Jul 06 23:55:53 GMT 2022.
 */
@Test(
    name = "TestSimon",
    version = "1.0"
)
public class Testsimon implements AndroidTest {
  public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
    AndroidDriver driver = helper.getDriver();
    // set timeout for driver actions (similar to step timeout)
    driver.setTimeout(15000);
    TestReporter report = helper.getReporter();
    By by;
    boolean booleanResult;

    // 1. Reset App
    //    Clear application data and restart (Auto-generated)
    GeneratedUtils.sleep(500);
    booleanResult = driver.testproject().resetApp();
    report.step("Reset App", booleanResult, TakeScreenshotConditionType.Failure);

    // 2. Click '5'
    GeneratedUtils.sleep(500);
    by = By.id("com.miui.calculator:id/btn_5_s");
    booleanResult = driver.testproject().click(by);
    report.step("Click '5'", booleanResult, TakeScreenshotConditionType.Failure);

    // 3. Click '2'
    GeneratedUtils.sleep(500);
    by = By.id("com.miui.calculator:id/btn_2_s");
    booleanResult = driver.testproject().click(by);
    report.step("Click '2'", booleanResult, TakeScreenshotConditionType.Failure);

    // 4. Click 'multiplicar'
    GeneratedUtils.sleep(500);
    by = By.id("com.miui.calculator:id/btn_mul_s");
    booleanResult = driver.testproject().click(by);
    report.step("Click 'multiplicar'", booleanResult, TakeScreenshotConditionType.Failure);

    // 5. Click '1'
    GeneratedUtils.sleep(500);
    by = By.id("com.miui.calculator:id/btn_1_s");
    booleanResult = driver.testproject().click(by);
    report.step("Click '1'", booleanResult, TakeScreenshotConditionType.Failure);

    // 6. Click '7'
    GeneratedUtils.sleep(500);
    by = By.id("com.miui.calculator:id/btn_7_s");
    booleanResult = driver.testproject().click(by);
    report.step("Click '7'", booleanResult, TakeScreenshotConditionType.Failure);

    // 7. Click 'igual a'
    GeneratedUtils.sleep(500);
    by = By.id("com.miui.calculator:id/btn_equal_s");
    booleanResult = driver.testproject().click(by);
    report.step("Click 'igual a'", booleanResult, TakeScreenshotConditionType.Failure);

    // 8. Does '= 884' contain '= 885'?
    GeneratedUtils.sleep(500);
    by = By.xpath("//android.widget.TextView[@text = '= 884']");
    booleanResult = driver.testproject().containsText(by,"= 885");
    report.step("Does '= 884' contain '= 885'?", booleanResult, TakeScreenshotConditionType.Failure);

    return ExecutionResult.PASSED;
  }
}
