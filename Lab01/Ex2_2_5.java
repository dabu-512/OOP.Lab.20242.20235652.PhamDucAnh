import javax.swing.JOptionPane;
public class Ex2_2_5 {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, 
                "Nhập số thứ nhất:", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, 
                "Nhập số thứ hai:", "Input", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double tong = num1 + num2;
        double hieu = num1 - num2;
        double tich = num1 * num2;
        String thuong;
        if (num2 != 0) {
            thuong = String.valueOf(num1 / num2);
        } else {
            thuong = "Không thể thực hiện phép chia";
        }
        String result = "Tổng: " + tong + "\n" +
                        "Hiệu: " + hieu + "\n" +
                        "Tích: " + tich + "\n" +
                        "Thương: " + thuong;

        JOptionPane.showMessageDialog(null, result, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
