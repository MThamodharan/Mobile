package com.mobile.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utility.ExcelOperation;
import com.utility.SeleniumCommands;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Task1 extends SeleniumCommands {

	List<List<String>> data = new ArrayList<>();
	List<String> data1 = new ArrayList<>();
	List<String> data2 = new ArrayList<>();

	@Given("user is clicks on docs tab")
	public void docsClick() {
		driver.findElement(By.xpath("//a[text()='Docs']")).click();

	}

	@Then("user expand main concept")
	public void mainExpand() throws Throwable {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Main Concepts']/parent::button")).click();

	}

	@Then("user write all data into excel")
	public void writeData() throws Throwable {
		List<WebElement> list = driver
				.findElements(By.xpath("//div[text()='Main Concepts']/parent::button//following-sibling::ul/li/a"));

		for (int i = 0; i < list.size(); i++) {
			data1.add(list.get(i).getText());

		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Main Concepts']/parent::button")).click();
		driver.findElement(By.xpath("//div[text()='Advanced Guides']/parent::button")).click();
		List<WebElement> list1 = driver
				.findElements(By.xpath("//div[text()='Advanced Guides']/parent::button//following-sibling::ul/li/a"));

		for (int i = 0; i < list1.size(); i++) {
			data1.add(list1.get(i).getText());

		}
		data.add(data1);
		data.add(data2);

		ExcelOperation.excelWrite(System.getProperty("user.dir") + "//Task1Output//Book1.xlsx", 0, 0, data);
	}

	@Then("user close browser")
	public void close() throws Throwable {

		driver.quit();
	}

	@Given("user is clicks on tutorial tab")
	public void tutorialClick() {
		driver.findElement(By.xpath("//a[text()='Tutorial']")).click();

	}

	@Then("user verify scroll down function")
	public void scroll() throws Throwable {

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> findElements = driver
				.findElements(By.xpath("//div[text()='Tutorial']//parent::button//following-sibling::ul/li/a"));
		for (WebElement e : findElements) {
			js.executeScript("arguments[0].scrollIntoView(true)", e);
		}
	}
}
