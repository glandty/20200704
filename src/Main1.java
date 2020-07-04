/**
 * 对N个长度最长可达到1000的数进行排序。
 *
 * 输入描述:
 * 输入第一行为一个整数N，(1<=N<=100)。
 * 接下来的N行每行有一个数，数的长度范围为1<=len<=1000。
 * 每个数都是一个正数，并且保证不包含前缀零。
 *
 *
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，将给出的N个数从小到大进行排序，输出排序后的结果，每个数占一行。
 * 示例1
 * 输入
 * 3
 * 11111111111111111111111111111
 * 2222222222222222222222222222222222
 * 33333333
 * 输出
 * 33333333
 * 11111111111111111111111111111
 * 2222222222222222222222222222222222
 */

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] str = new String[n];
            for(int i = 0; i < str.length; i++) {
                str[i] = sc.nextLine();
            }
            quickSort(str,0,str.length-1);
            for(String s : str) {
                System.out.println(s);
            }
        }
    }

    private static void quickSort(String[] str, int left, int right) {
        if(left > right) {
            return;
        }
        int i = left,j = right;
        String tmp = str[left];
        while (i != j) {
            while (i < j && !find(tmp,str[j],0)) {
                j--;
            }
            while (i < j && find(tmp,str[i],1)) {
                i++;
            }
            if(i < j) {
                String tmep = str[i];
                str[i] = str[j];
                str[j] = tmep;
            }
        }
        str[left] = str[i];
        str[i] = tmp;
        quickSort(str,left,i-1);
        quickSort(str,i+1,right);
    }

    private static boolean find(String tmp, String s,int flag) {
        if(tmp.length() > s.length()) {
            return true;
        }else if(tmp.length() == s.length()) {
            if(tmp.equals(s)) {
                if(flag == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            for (int i = 0; i < tmp.length(); i++) {
                if(tmp.charAt(i) > s.charAt(i)) {
                    return true;
                }
                if(tmp.charAt(i) < s.charAt(i)) {
                    return false;
                }
            }
        }
        return false;
    }
}

