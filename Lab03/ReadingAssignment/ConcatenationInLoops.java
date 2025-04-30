package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        // Dùng +
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Using '+' took: " + (System.currentTimeMillis() - start) + " ms");
        // Dùng StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Using StringBuilder took: " + (System.currentTimeMillis() - start) + " ms");
        // Dùng StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbuf.append(r.nextInt(2));
        }
        s = sbuf.toString();
        System.out.println("Using StringBuffer took: " + (System.currentTimeMillis() - start) + " ms");
    }
}
