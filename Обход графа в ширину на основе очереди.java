package manager.task;


import sun.misc.Queue;

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
    static boolean [] inqueue = new boolean[8];


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();

       queue.enqueue(0);
       inqueue[0] = true;

       while (!queue.isEmpty()) {
           try {
               int c = queue.dequeue();
               inqueue[c] = false;
               visited[c] = true;
               System.out.println("Посетил узел " + c);

               for (int i = 0; i < 8; i++) {
                   if (matrix[c][i] == 1 && !inqueue[i] && !visited[i]) {
                       queue.enqueue(i);
                       inqueue[i] = true;
                   }
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }


}
