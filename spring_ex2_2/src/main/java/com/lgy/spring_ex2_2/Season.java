package com.lgy.spring_ex2_2;

public class Season {
	private int month;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public String month() {
		String str = "";
		if(month >= 3 && month <= 5) {
			str = "봄";
		}else if(month >= 6 && month <= 8) {
			str = "여름";
		}else if(month >= 9 && month <= 11) {
			str = "가을";
		}else if(month == 12 || month == 1 || month == 2) {
			str = "겨울";
		}
		//방법2
		/*
		switch (month) {
		case 3:
		case 4:
		case 5:
			str="봄";
			break;
		case 6:
		case 7:
		case 8:
			str="여름";
			break;
		case 9:
		case 10:
		case 11:
			str="가을";
			break;
		case 12:
		case 1:
		case 2:
			str="겨울";
			break;
		default:
			str="잘못 입력";
			break;
		}
		*/
		return str;
	}
}
