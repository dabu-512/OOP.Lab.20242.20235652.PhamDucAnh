import java.util.Scanner;
public class Ex6_4 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        // Nhập năm
        System.out.print("Nhap nam : ");
        int year = sc.nextInt();
        // Nhập tháng
        System.out.print("Nhap thang :");
        int month = sc.nextInt();
        System.out.println("So ngay cua thang " +month + " nam " + year + " la :" + Days(year,month) + "ngay");
    }
    public static int LeapYear(int year){
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))? 1 : 0;
    }

    public static int Month(String input) {
        switch (input) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun.": case "jun": case "6": return 6;
            case "july": case "jul.": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }   
    public static int Days(int year, int month){
        switch(month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31; 
            case 4: case 6: case 9: case 11: return 30;
            case 2:
                return(LeapYear(year) == 1) ? 29 : 28;
            default:
                return -1;
        }
    }
}
