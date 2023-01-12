import java.util.Scanner;

public class checkMonth {
	public static int getMonth(String month) {
		String january = "January Jan. Jan 1";
		String february = "February Feb. Feb 2";
		String march = "March Mar. Mar 3";
		String april = "April Apr. Apr 4";
		String may = "May 5";
		String june = "June Jun 6";
		String july = "July Jul 7";
		String august = "August Aug. Aug 8";
		String september = "September Sept. Sept 9";
		String october = "October Oct. Oct 10";
		String november = "November Nov. Nov 11";
		String december = "December Dec. Dec 12";
		if (january.contains(month)) return 1;
		else if (february.contains(month)) return 2;
		else if (march.contains(month)) return 3;
		else if (april.contains(month)) return 4;
		else if (may.contains(month)) return 5;
		else if (june.contains(month)) return 6;
		else if (july.contains(month)) return 7;
		else if (august.contains(month)) return 8;
		else if (september.contains(month)) return 8;
		else if (october.contains(month)) return 10;
		else if (november.contains(month)) return 11;
		else if (december.contains(month)) return 12;
		return 0;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		System.out.println("Enter month: ");
		String month ;
		month = scanner.nextLine();
		while (getMonth(month) == 0) {
			System.out.println("Wrong format. Enter again:");
			month = scanner.nextLine();
		}
		
		String str_year;
		System.out.println("Enter year: ");
		str_year = scanner.nextLine();
		int year = Integer.parseInt(str_year);
		int result;
		System.out.println("Year: "+str_year);
		result = getMonth(month);
		System.out.println("Month: "+months[result-1]);
		if (result == 4||result == 6||result == 9||result == 11) {
			System.out.println("Number of days: 30");
		}
		else if (result == 1||result == 3||result == 5||result == 7 ||result == 8 ||result == 10 ||result == 12) {
			System.out.println("Number of days: 31");
		}
		else {
			if (year % 4 != 0) {// common year
				System.out.println("Number of days: 28");
			}
			else {
				if(year % 100 == 0 && year % 400 != 0) {
					System.out.println("Number of days: 28");
				}
				else {
					System.out.println("Number of days: 29");
				}
			}
		}
		scanner.close();
		System.exit(0);
	}
}
