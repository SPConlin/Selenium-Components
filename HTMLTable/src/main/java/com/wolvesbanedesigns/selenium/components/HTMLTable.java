package com.wolvesbanedesigns.selenium.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HTMLTable implements WebElement {
	private WebDriver webDriver = null;
	private By tblLocator = null;

	public HTMLTable() {

	}

	public HTMLTable(WebDriver driver, By locator) {
		this.webDriver = driver;
		this.tblLocator = locator;
	}

	/**
	 * Table methods
	 */

	/**
	 * Returns the value from a table cell
	 * 
	 * @param rowLocator
	 * @param row
	 * @param col
	 * @return
	 */
	public String getCellValue(By rowLocator, int row, int col) {
		List<WebElement> rows = this.findElements(rowLocator);
		List<WebElement> cols = rows.get(row).findElements(By.xpath("./td"));

		return cols.get(col).getText();
	}

	/**
	 * Finds the provided value in the specified column and returns the row it
	 * appears in.
	 * 
	 * @param rowLocator
	 * @param col
	 * @param value
	 * @return
	 */
	public WebElement findRowByColValue(By rowLocator, int col, String value) {
		int foundRow = -1;

		List<WebElement> rows = this.findElements(rowLocator);

		for (int row = 0; row < rows.size(); row++) {
			List<WebElement> cols = rows.get(row)
					.findElements(By.xpath("./td"));
			if (cols.get(col).getText().equals(value.toUpperCase())) {
				foundRow = row;
				break;
			}
		}
		if (foundRow >= 0) {
			return rows.get(foundRow);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#clear()
	 */
	public void clear() {
		webDriver.findElement(tblLocator).clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#click()
	 */
	public void click() {
		webDriver.findElement(tblLocator).click();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#findElement(org.openqa.selenium.By)
	 */
	public WebElement findElement(By by) {
		WebElement webTable = null;

		try {
			webTable = (new WebDriverWait(webDriver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (TimeoutException toe) {
			// captureError("timeout" + new
			// SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + ".jpg");
			throw toe;
		}
		return webTable.findElement(by);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#findElements(org.openqa.selenium.By)
	 */
	public List<WebElement> findElements(By by) {
		List<WebElement> items = new ArrayList<>();
		items = webDriver.findElement(tblLocator).findElements(by);
		return items;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#getAttribute(java.lang.String)
	 */
	public String getAttribute(String name) {
		return webDriver.findElement(tblLocator).getAttribute(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#getCssValue(java.lang.String)
	 */
	public String getCssValue(String propertyName) {
		return webDriver.findElement(tblLocator).getCssValue(propertyName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#getLocation()
	 */
	public Point getLocation() {
		return webDriver.findElement(tblLocator).getLocation();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#getSize()
	 */
	public Dimension getSize() {
		return webDriver.findElement(tblLocator).getSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#getTagName()
	 */
	public String getTagName() {
		return webDriver.findElement(tblLocator).getTagName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#getText()
	 */
	public String getText() {
		return webDriver.findElement(tblLocator).getText();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#isDisplayed()
	 */
	public boolean isDisplayed() {
		return webDriver.findElement(tblLocator).isDisplayed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#isEnabled()
	 */
	public boolean isEnabled() {
		return webDriver.findElement(tblLocator).isEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#isSelected()
	 */
	public boolean isSelected() {
		return webDriver.findElement(tblLocator).isSelected();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#sendKeys(java.lang.CharSequence[])
	 */
	public void sendKeys(CharSequence... keysToSend) {
		webDriver.findElement(tblLocator).sendKeys(keysToSend);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.WebElement#submit()
	 */
	public void submit() {
		webDriver.findElement(tblLocator).submit();
	}

}
