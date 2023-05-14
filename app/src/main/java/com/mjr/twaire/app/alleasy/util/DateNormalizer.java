package com.mjr.twaire.app.alleasy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateNormalizer {
    
	// Data
	private static final Date date = new Date();
	private static final SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
	private static final SimpleDateFormat sdfdy = new SimpleDateFormat("DD");
	private static final SimpleDateFormat sdfm = new SimpleDateFormat("MM");
	private static final SimpleDateFormat sdfd = new SimpleDateFormat("dd");
	private static final SimpleDateFormat sdfM = new SimpleDateFormat("mm");
	private static final SimpleDateFormat sdfs = new SimpleDateFormat("ss");
	private static int[] normalizeDate = new int[7];
    
	private static int[] normalizedDate() {
		normalizeDate[0] = Integer.valueOf(sdfy.format(date));
		normalizeDate[1] = Integer.valueOf(sdfdy.format(date));
		normalizeDate[2] = Integer.valueOf(sdfm.format(date));
		normalizeDate[3] = Integer.valueOf(sdfd.format(date));
		normalizeDate[4] = date.getHours();
		normalizeDate[5] = Integer.valueOf(sdfM.format(date));
		normalizeDate[6] = Integer.valueOf(sdfs.format(date));
		return normalizeDate;
	}
	
	public static Long getDate() {
		String timer = "";
		
		for (int x: normalizedDate()) {
	
			timer += String.valueOf(x);
		}
		return Long.valueOf(timer) * 2 + 892473;
	}
    
    public static int getYear()
    {
        return Integer.valueOf(sdfy.format(date));
    }
}
