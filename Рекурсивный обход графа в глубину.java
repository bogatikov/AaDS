package manager.task;


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


    public static void main(String[] args) {
        DFS(5, matrix[5]);
    }

    private static void DFS(int j, int [] node)
    {
        visited[j] = true;
        for (int i = 0; i < 8; i++) {
            if ((node[i] == 1) && !visited[i]) {
                System.out.println("Посетил узел " + j + " перехожу в узел " + i);
                DFS(i, matrix[i]);
            }
        }
    }
}
