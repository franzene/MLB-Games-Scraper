public class Calendar {
	int month;
	int day;
	int year;

	int pagemonth;
	int pageday;
	int pageyear;
	boolean firstDate;

	Calendar() {
		month = 01;
		day = 01;
		year = 2015;
		firstDate = true;

	}

	void setpage() {
		pagemonth = month;
		pageday = day;
		pageyear = year;
	}

	int convertMonth(String m) {
		if (m.equals("Jan")) {
			return 1;
		} else if (m.equals("Feb")) {
			return 2;
		} else if (m.equals("Mar")) {
			return 3;
		} else if (m.equals("Apr")) {
			return 4;
		} else if (m.equals("May")) {
			return 5;
		} else if (m.equals("Jun")) {
			return 6;
		} else if (m.equals("Jul")) {
			return 7;
		} else if (m.equals("Aug")) {
			return 8;
		} else if (m.equals("Sep")) {
			return 9;
		} else if (m.equals("Oct")) {
			return 10;
		} else if (m.equals("Nov")) {
			return 11;
		} else if (m.equals("Dec")) {
			return 12;
		}
		return 0;
	}

	boolean nextMonth() {
		if (month == 1 && day >= 31) {
			return true;
		} else if (month == 2) {
			if ((year % 400 == 0) && day >= 29) {
				return true;
			} else if ((year % 100 == 0) && day >= 28) {
				return true;
			} else if ((year % 4 == 0 && day >= 29)) {
				return true;
			} else if (day >= 28) {
				return true;
			}

		} else if (month == 3 && day >= 31) {
			return true;
		} else if (month == 4 && day >= 30) {
			return true;
		} else if (month == 5 && day >= 31) {
			return true;
		} else if (month == 6 && day >= 30) {
			return true;
		} else if (month == 7 && day >= 31) {
			return true;
		} else if (month == 8 && day >= 31) {
			return true;

		} else if (month == 9 && day >= 30) {
			return true;
		} else if (month == 10 && day >= 31) {
			return true;
		} else if (month == 11 && day >= 30) {
			return true;
		} else if (month == 12 && day >= 30) {
			return true;
		}
		return false;

	}

	Boolean laterDate(String cD, String lD) {
		String cDate = cD;
		String cMonth = cDate.substring(0, 2);
		String cDay = cDate.substring(3, 5);
		String cYear = cDate.substring(6, 10);
		int cmonth = Integer.parseInt(cMonth);
		int cday = Integer.parseInt(cDay);
		int cyear = Integer.parseInt(cYear);

		String lDate = lD;
		String lMonth = lDate.substring(0, 2);
		String lDay = lDate.substring(3, 5);
		String lYear = lDate.substring(6, 10);
		int lmonth = Integer.parseInt(lMonth);
		int lday = Integer.parseInt(lDay);
		int lyear = Integer.parseInt(lYear);

		if (cyear > lyear) {
			return true;
		}
		if (cyear == lyear && cmonth > lmonth) {

			return true;
		}
		if (cyear == lyear && cmonth == lmonth && cday > lday) {
			// System.out.println("3");
			return true;
		}

		return false;
	}

	String convertDate(String d) {
		String date = d;
		String Month = date.substring(0, 3);
		String Day = date.substring(4, date.length());
		month = convertMonth(Month);
		day = Integer.parseInt(Day);

		if (pagemonth == 1 && month == 12) {
			if (day == 31 || day == 30) {
				year = pageyear - 1;
			}
		} else if (pagemonth == 12 && month == 1) {
			if (day == 1 || day == 2) {
				year = pageyear + 1;
			}
		} else {
			year = pageyear;
		}

		return ((String.format("%02d", month) + "/"
				+ String.format("%02d", day) + "/" + String
					.format("%02d", year)));

	}

	String nextDay(String d) {

		String date = d;
		String Month = date.substring(0, 2);
		String Day = date.substring(3, 5);
		String Year = date.substring(6, 10);
		month = Integer.parseInt(Month);
		day = Integer.parseInt(Day);
		year = Integer.parseInt(Year);

		for (int i = 0; i < 3; i++) {
			if (firstDate) {
				i = 2;
				firstDate = false;
			}
			if (nextMonth()) {
				month++;
				day = 1;
				if (month == 13) {
					month = 1;
					year++;
				}
			} else {
				day++;
			}
		}
		setpage();
		return ((String.format("%02d", month) + "/"
				+ String.format("%02d", day) + "/" + String
					.format("%02d", year)));

	}

}
