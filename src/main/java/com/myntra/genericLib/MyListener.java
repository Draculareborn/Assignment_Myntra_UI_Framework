package com.myntra.genericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

/**
 * This is a listner class for test execution
 * @author Bhaskar
 *
 */
public class MyListener extends BaseTest implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) 
	{
		Reporter.log(context.getName()+" Execution Started ", true);;
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Reporter.log(context.getName()+" Execution Completed ", true);
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log(result.getName()+" Started ", true);;
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log(result.getName()+" Passed ", true);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log(result.getName()+" Failed ", true);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+result.getName()+".png");
		try 
		{
			Files.copy(src, dest);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log(result.getName()+" Skipped ", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

}
