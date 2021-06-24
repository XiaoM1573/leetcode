package code;

import java.util.*;

public class vivo2021 {

    public String CompileSeq(String input) {

        if (input == null) return null;
        String[] array = input.split(",");
        if (array.length == 0) return "";
        int[] data = new int[array.length];
        List<Integer> q1 = new LinkedList<>();
        List<Integer> q2 = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(array[i]);
            if (data[i] == -1) {
                q1.add(i);
            }
        }

        while (!q1.isEmpty()) {
            int index = q1.remove(0);

            for (int i = 0; i < data.length; i++) {
                if (data[i] == index) {
                    q1.add(i);
                }
            }
            Collections.sort(q1);
            q2.add(index);
        }

        // 导出q2
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < q2.size() - 1; i++) {
            builder.append(q2.get(i) + ",");
        }
        builder.append(q2.get(q2.size() - 1));
        return builder.toString();
    }

    //
    public void test() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.delete(i, i + 1);
            flag = checkhuiwen(sb.toString());
            if (flag) {
                System.out.println(sb.toString());
                break;
            }

        }
        if (!flag) System.out.println("false");
    }

    // 判断一个字符串是否是回文字符串
    public boolean checkhuiwen(String s) {
        boolean flag = true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "1,2,-1,1";
        //System.out.println(1);
        System.out.println(new vivo2021().CompileSeq(s));
        new vivo2021().test();
    }

    public void test1() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(7, (a, b) -> b - a);


    }
}


