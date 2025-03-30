import java.util.Arrays;
import java.util.Scanner;

public class Ex6_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so hang cua ma tran: ");
        int r = sc.nextInt();
        System.out.print("Nhap so cot cua ma tran: ");
        int c = sc.nextInt();
        int[][] A = new int[r][c];
        int[][] B = new int[r][c];
        int[][] C = new int[r][c];
        System.out.println("Nhap ma tran thu nhat:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("Nhap ma tran thu hai:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("Ma tran A la : "); Print(A);
        System.out.println("Ma tran B la : "); Print(B);
        System.out.println("Tong ma tran A va B la : "); Print(C);
        sc.close();
    }
    public static void Print(int[][] a) {
        for (int[] row : a) {  
            System.out.println(Arrays.toString(row)); 
        }
        System.out.println();
    }
    
}
