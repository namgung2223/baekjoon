package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int last_value = 0;
        int n = Integer.parseInt(bf.readLine());
        while(n -- > 0){
            int value = Integer.parseInt(bf.readLine());
            if (value > last_value) {
                for (int j = last_value + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                last_value = value;
            } else {
                if (stack.peek() != value) {
                    System.out.println("NO");
                    return;
                }
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}