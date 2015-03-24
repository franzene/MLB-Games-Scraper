public class Calendar {
	int month;
	int day;
	int year;

	Calendar() {
		month = 01;
		day = 01;
		year = 2015;
	}

	boolean nextMonth() {
		if (month == 1 && day == 31) {
			return true;
		} else if (month == 2) {
			if (!(year % 4 == 0) && day == 28) {
				return true;
			} else if (!(year % 100 == 0) && day == 29) {
				return true;
			} else if (!(year % 400 == 0 && day == 28)) {
				return true;
			} else if (day == 29) {
				return true;
			}

		} else if (month == 3 && day == 31) {
			return true;
		} else if (month == 4 && day == 30) {
			return true;
		} else if (month == 5 && day == 31) {
			return true;
		} else if (month == 6 && day == 30) {
			return true;
		} else if (month == 7 && day == 31) {
			return true;
		} else if (month == 8 && day == 31) {
			return true;

		} else if (month == 9 && day == 30) {
			return true;
		} else if (month == 10 && day == 31) {
			return true;
		} else if (month == 11 && day == 30) {
			return true;
		} else if (month == 12 && day == 30) {
			return true;
		}
		return false;

	}

	String nextDay(String d) {

		String date = d;
		String Month = date.substring(0, 2);
		String Day = date.substring(3, 5);
		String Year = date.substring(6, 10);
		month = Integer.parseInt(Month);
		day = Integer.parseInt(Day);
		year = Integer.parseInt(Year);

		if (nextMonth()) {
			month++;
			day = 0;
			if (month == 13) {
				month = 1;
				year++;
			}
		} else {
			day++;
		}
		return ((String.format("%02d", month) + "/"
				+ String.format("%02d", day) + "/" + String
					.format("%02d", year)));

	}

}
