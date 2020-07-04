/**
 * 输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。
 *
 * 输入描述:
 * 输入包括一个字符串，字符串长度不超过100。
 *
 *
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，
 * 对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。
 * 示例1
 * 输入
 * 3
 * 3a
 * 输出
 * 10110011
 * 10110011
 * 01100001
 */
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            for (int i = 0; i < s.length(); i++) {
                int ch=s.charAt(i);
                if (c(ch)%2 == 0){
                    ch += 128;
                }
                System.out.println(num(ch));
            }
        }
    }
    public static int c(int n) {
        int count = 0;
        int b = 1;
        for (int i = 0; i < 8; i++){
            if ((n & b) == b) {
                count++;
            }
            b = (b<<1);
        }return count;
    }

    public static String num(int n) {
        int b = 128;
        StringBuilder string=new StringBuilder();
        for (int i = 0; i < 8; i++){
            if ((n & b) == b){
                string.append("1");
            }else{
                string.append("0");
            }
            b = (b>>>1);
        }return string.toString();
    }
}
