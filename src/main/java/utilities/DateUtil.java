package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy_hh_mm_ss");
		return sdf.format(date);
	}
}
