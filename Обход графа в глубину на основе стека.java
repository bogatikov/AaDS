package manager.task;


import java.util.Stack;

public class Main {
    static int [][] matrix = {
        //   0  1  2  3  4  5  6  7
            {0, 1, 1, 1, 0, 0, 0, 0}, //0
            {1, 0, 0, 0, 1, 0, 0, 0}, //1
            {1, 0, 0, 0, 0, 0, 0, 0}, //2
            {1, 0, 0, 0, 0, 1, 0, 0}, //3
            {0, 1, 0, 0, 0, 1, 0, 0}, //4
            {0, 0, 0, 1, 1, 0, 1, 1}, //5
            {0, 0, 0, 0, 0, 1, 0, 0}, //6
            {0, 0, 0, 0, 0, 1, 0, 0}, //7
    };

    static boolean [] visited = new boolean[8];
    static boolean [] instack = new boolean[8];


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        while (!stack.isEmpty()) {
            System.out.println(stack);
            int c = stack.pop();
            instack[c] = false;
            visited[c] = true;
            for (int i = 0; i < 8; i++) {
                if (matrix[c][i] == 1 && !visited[i] && !instack[i]) {
                    stack.push(i);
                    instack[i] = true;
                }
            }
        }
    }


}
