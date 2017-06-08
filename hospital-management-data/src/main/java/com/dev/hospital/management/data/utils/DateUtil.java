package com.dev.hospital.management.data.utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * The Class DateUtil.
 */
public class DateUtil {

	/** The Constant DATE_PATTERN_DAY. */
	public static final String DATE_PATTERN_DAY = "yyyy-MM-dd";

	/**
	 * String to date.
	 *
	 * @param sDate the s date
	 * @param pattern the pattern
	 * @return the date
	 */
	public static Date stringToDate(String sDate) {
		Date date = null;
		DateTime dt = stringToDateTime(sDate, DATE_PATTERN_DAY);
		if (dt != null) {
			date = dt.toDate();
		}
		return date;
	}

	/**
	 * String to date.
	 *
	 * @param sDate the s date
	 * @param pattern the pattern
	 * @return the date
	 */
	public static DateTime stringToDateTime(String sDate, String pattern) {
		DateTime dateTime = null;
		if (StringUtils.isNotBlank(sDate)) {
			DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
			dateTime = formatter.parseDateTime(sDate);
		}
		return dateTime;
	}

	/**
	 * String to SQL date.
	 *
	 * @param sDate the s date
	 * @param pattern the pattern
	 * @return the date
	 */
	public static java.sql.Date stringToSQLDate(String sDate) {
		Date date = stringToDate(sDate);
		return new java.sql.Date(date.getTime());
	}

}
