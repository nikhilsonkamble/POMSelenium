package utilities;

import java.util.Hashtable;
import java.util.TreeMap;

public class TestDataProvider {

	public static Object[][] getTestData(String dataFileName, String sheetName, String testName) {
		ReadExcelDataFile readData = new ReadExcelDataFile(
				System.getProperty("user.dir") + "/src/main/java/testData/" + dataFileName);
//		String sheetName = "Feature 1";
//		String testName = "Test Four";

		// Find Start row of test case
		int startRowNum = 1;
		while (!readData.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) {
			startRowNum++;
		}
		int testDataHeaderStartRowNum = startRowNum + 1;
		int testDataStartRowNum = startRowNum + 2;

		// Find number of rows in the test case
		int testDataTotalRows = 0;
		while (!readData.getCellData(sheetName, 0, testDataStartRowNum + testDataTotalRows).equals("")) {
			testDataTotalRows++;
		}

		// Find number of columns in test case
		int testDataTotalColumns = 0;
		while (!readData.getCellData(sheetName, testDataTotalColumns, testDataHeaderStartRowNum).equals("")) {
			testDataTotalColumns++;
		}

		// Get the number of rows the test needs to execute with
		int count = 0;
		for (int rowNumber = testDataStartRowNum; rowNumber < testDataStartRowNum + testDataTotalRows; rowNumber++) {
			for (int columnNumber = 0; columnNumber < testDataTotalColumns; columnNumber++) {
				String key = readData.getCellData(sheetName, columnNumber, testDataHeaderStartRowNum);
				String value = readData.getCellData(sheetName, columnNumber, rowNumber);
				if (key.equalsIgnoreCase("RunTestCase") && value.equalsIgnoreCase("Yes"))
					count++;
			}
		}

		// Get test data for particular test
		Object[][] dataSet = new Object[count][1];
		TreeMap<String, String> dataTable = null;
		int i = 0;
		for (int rowNumber = testDataStartRowNum; rowNumber < testDataStartRowNum + testDataTotalRows; rowNumber++) {
			dataTable = new TreeMap<String, String>();
			for (int columnNumber = 0; columnNumber < testDataTotalColumns; columnNumber++) {
				String key = readData.getCellData(sheetName, columnNumber, testDataHeaderStartRowNum);
				String value = readData.getCellData(sheetName, columnNumber, rowNumber);
				if (key.equalsIgnoreCase("RunTestCase") && value.equalsIgnoreCase("No"))
					break;
				dataTable.put(key, value);
//				dataSet[i][columnNumber] = readData.getCellData(sheetName, columnNumber, rowNumber);
//				System.out.println(readData.getCellData(sheetName, columnNumber, rowNumber));
			}
			if (!dataTable.isEmpty()) {
				dataSet[i][0] = dataTable;
				i++;
			}
		}
		/*
		 * for (int n = 0; n < dataSet.length; n++) { for (int s = 0; s <
		 * dataSet[n].length; s++) { System.out.println("Values at arr[" + n + "][" + s
		 * + "] is " + dataSet[n][s]); } }
		 */
		return dataSet;
	}
}
