import javax.swing.JOptionPane;

public class Ex2_2_6 {
    public static void main(String[] args) {
        while (true) { // Lặp vô hạn đến khi chọn đúng 1-4
            String menu = "CHỌN CÔNG CỤ:\n" +
                    "1. Giải phương trình bậc nhất (1 ẩn)\n" +
                    "2. Giải hệ phương trình bậc nhất (2 ẩn)\n" + 
                    "3. Giải phương trình bậc hai (1 ẩn)\n" +
                    "4. Thoát";
            
            String sc = JOptionPane.showInputDialog(null,
             menu, "Bài 2.2.6 - Equation Solver", JOptionPane.INFORMATION_MESSAGE);

            if (sc == null) {
                JOptionPane.showMessageDialog(null,
                 "Thoát chương trình!", "Kết thúc", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            switch (sc) {
                case "1":
                    LinearEquation();
                    return;
                case "2":
                    LinearSystem();
                    return;
                case "3":
                    QuadraticEquation();
                    return;
                case "4":
                    JOptionPane.showMessageDialog(null,
                     "EXIT", "Kết thúc", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null,
                     "Lựa chọn không hợp lệ! Vui lòng nhập lại từ 1 đến 4.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static double NhapSo(String string) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null,
                 string, "Nhập số", JOptionPane.INFORMATION_MESSAGE);
                if (input == null) {
                    JOptionPane.showMessageDialog(null,
                     "Hủy nhập! Thoát chương trình.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                 "Vui lòng nhập số hợp lệ!", "Lỗi nhập", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void Output(String output) {
        JOptionPane.showMessageDialog(null,
         output, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void LinearEquation() {
        double a = NhapSo("Nhập số a: ");
        double b = NhapSo("Nhập số b: ");
        if (a == 0) {
            if (b == 0) {
                Output("Phương trình có vô số nghiệm");
            } else {
                Output("Phương trình vô nghiệm");
            }
        } else {
            double nghiem = -b / a;
            Output("Phương trình có nghiệm duy nhất x = " + nghiem);
        }
    }

    public static void LinearSystem() {
        double a11 = NhapSo("Nhập số a11: ");
        double a12 = NhapSo("Nhập số a12: ");
        double b1 = NhapSo("Nhập số b1: ");
        double a21 = NhapSo("Nhập số a21: ");
        double a22 = NhapSo("Nhập số a22: ");
        double b2 = NhapSo("Nhập số b2: ");
        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        if (D == 0) {
            if (D1 == 0 && D2 == 0) Output("Hệ phương trình có vô số nghiệm");
            else Output("Hệ phương trình vô nghiệm");
        } else {
            double x1 = D1 / D, x2 = D2 / D;
            Output("Hệ có nghiệm duy nhất: x1 = " + x1 + " x2 = " + x2);
        }
    }

    public static void QuadraticEquation() {
        double a = NhapSo("Nhập số a: ");
        double b = NhapSo("Nhập số b: ");
        double c = NhapSo("Nhập số c: ");
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    Output("Phương trình bậc 2 có vô số nghiệm");
                } else {
                    Output("Phương trình bậc 2 vô nghiệm");
                }
            } else {
                double nghiem = -c / b;
                Output("Phương trình bậc 2 có nghiệm duy nhất x = " + nghiem);
            }
            return;
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            Output("Phương trình bậc 2 vô nghiệm");
        } else if (delta == 0) {
            Output("Phương trình bậc 2 có nghiệm kép x = " + -b / (2 * a));
        } else {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            Output("Phương trình bậc 2 có hai nghiệm x1 = " + x1 + "\nx2 = " + x2);
        }
    }
}
