package code.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class test67 {

    public static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            flag = false;
            String[] input = sc.nextLine().split(" ");
            int len = input.length;
            int[] data = new int[len];
            for (int i = 0; i < len; i++) {
                data[i] = Integer.parseInt(input[i]);
            }
            //System.out.println(Arrays.toString(data));
            boolean[] visited = new boolean[len];
            double rs = 0;
            dfs(data, len, 0, visited, rs);
            System.out.println(flag);
        }


    }

    public static void dfs(int[] data, int len, int depth, boolean[] visited, double rs) {
        if (depth == len) {
            if (rs == 24.0) {
                flag = flag || true;
            }else{
                flag = flag || false;
            }

            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            for (int j = 0; j < 4; j++) {
                double tmp = rs;
                switch (j) {
                    case 0: // +
                        tmp = tmp + data[i];
                        break;
                    case 1: // -
                        tmp = tmp - data[i];
                        break;
                    case 2: // *
                        tmp = tmp * data[i];
                        break;
                    default: // /
                        tmp = tmp / data[i];
                        break;
                }
                dfs(data, len, depth + 1, visited, tmp);
            }
            visited[i] = false;
        }
    }
}
