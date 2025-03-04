import java.util.Arrays;
import java.util.Scanner;

public class Ex6_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("So luong phan tu : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        double average = (double) sum / n;
        System.out.println("Original Array: " + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Sorted Array: " + Arrays.toString(a));
        System.out.println("Sum of Array: " + sum);
        System.out.println("Average of Array: " + average);
        sc.close();
    }
}
