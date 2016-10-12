/**
 * 
 */
package edu.cvtc.web.util;

import java.text.DecimalFormat;

/**
 * @author Fong
 *
 */
public class StringUtils {
	public static boolean isNotEmpty(String checkString) {
		return null != checkString && !checkString.isEmpty();
	}

	public static boolean isANumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static String doubleToString(Double number) {
		DecimalFormat format = new DecimalFormat("###.#");

		return format.format(number).toString();
	}
}
