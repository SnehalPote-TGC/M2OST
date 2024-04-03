package com.m2ost.Login;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			captureScreenshot(result.getName()+".jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
