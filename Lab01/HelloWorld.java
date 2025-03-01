import java.util.Scanner;

import javax.swing.JOptionPane;

public class HelloWorld {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, 
                "Please input the first number:", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, 
                "Please input the second number:", "Input", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double tong = num1 + num2;
        double hieu = num1 - num2;
        double tich = num1 * num2;
	    double thuong = 0;
	    if (num2 != 0) {
		    thuong = num1 / num2;
	    }

        System.out.println("Tong hai so la: " + tong);
        System.out.println("Hieu hai so la: " + hieu);
        System.out.println("Tich hai so la: " + tich);
        if (num2 != 0) {
            System.out.println("Thuong hai so la: " + thuong);
        } 
	    else {
            System.out.println("Khong thuc hien duoc phep chia");
        }
    }
}
