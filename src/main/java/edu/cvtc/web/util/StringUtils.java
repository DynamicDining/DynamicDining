/**
 * 
 */
package edu.cvtc.web.util;

import java.text.DecimalFormat;

/**
 * The Class StringUtils.
 *
 * @author Fong
 */
public class StringUtils {
	
	/**
	 * Checks if is not empty.
	 *
	 * @param checkString the check string
	 * @return true, if is not empty
	 */
	public static boolean isNotEmpty(String checkString) {
		return null != checkString && !checkString.isEmpty();
	}

	/**
	 * Checks if is a number.
	 *
	 * @param number the number
	 * @return true, if is a number
	 */
	public static boolean isANumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Double to string.
	 *
	 * @param number the number
	 * @return the string
	 */
	public static String doubleToString(Double number) {
		DecimalFormat format = new DecimalFormat("###.#");

		return format.format(number).toString();
	}
}
