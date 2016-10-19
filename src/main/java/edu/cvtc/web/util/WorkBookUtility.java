package edu.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.model.Restaurant;

/**
 * The Class WorkBookUtility.
 *
 * @author Project Skeleton
 */
public class WorkBookUtility {

	/**
	 * Retrieve restaurants from work book.
	 *
	 * @param file the file
	 * @return the list
	 * @throws InvalidFormatException the invalid format exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static List<Restaurant> retrieveRestaurantsFromWorkBook(final File file)
			throws InvalidFormatException, IOException {
		final Workbook workbook = WorkbookFactory.create(file);
		final List<Restaurant> restaurants = new ArrayList<Restaurant>();

		final Sheet sheet = workbook.getSheetAt(0);

		for (final Row row : sheet) {

			if (null != row.getCell(0)) {
				final String name = row.getCell(0).getStringCellValue();
				final String address = row.getCell(1).getStringCellValue();
				final String city = row.getCell(2).getStringCellValue();
				final String state = row.getCell(3).getStringCellValue();
				final String zipCode = StringUtils.doubleToString(row.getCell(4).getNumericCellValue());
				final String telephoneNumber = row.getCell(5).getStringCellValue();
				final String website = row.getCell(6).getStringCellValue();

				final Restaurant restaurant = new Restaurant(name, address, city, state, zipCode, telephoneNumber,
						website);

				restaurants.add(restaurant);
			}

		}

		return restaurants;
	}

}
