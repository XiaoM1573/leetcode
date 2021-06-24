package code.huawei;

import java.util.Scanner;

public class test106 {

    public static String reverse(String s) {
        int len = s.length();
        if(len == 1) return s;
        String left = s.substring(0, len / 2);
        String right = s.substring(len / 2, len);
        return reverse(right) + reverse(left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
    }
}
