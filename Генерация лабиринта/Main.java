package manager.task;


import java.util.ArrayList;
import java.util.Stack;

public class Main{

    int n = 10;

    Node [][] nodes = new Node[n][n];
    boolean visited[][] = new boolean[n][n];

    public static void main(String[] args) {

        Window window = new Window();
        window.drawLab();

    }

    public void getMattrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node(i, j);
            }
        }

        Stack<Node> stack = new Stack<Node>();

        stack.push(nodes[4][4]);


        ArrayList<Node> adjacency;
        int nextRandomNode;
        Node current;
        Node nextNode;
        while (!stack.isEmpty()) {
            current = stack.pop();
            current.visited = true;

            adjacency = getAviableAdjacency(current);


            if (adjacency.size() != 0) {
                nextRandomNode = (int)(Math.random()*adjacency.size());
                nextNode = adjacency.get(nextRandomNode);
                current.next = nextNode;
                stack.push(nextNode);
            }


        }

    }

    public ArrayList<Node> getAviableAdjacency(Node node) {
        ArrayList<Node> adjacency = new ArrayList<Node>();
        if (node.x + 1 < 10) {
            if (!nodes[node.x+1][node.y].visited)
                adjacency.add(nodes[node.x+1][node.y]);
        }
        if (node.x - 1 >= 0) {
            if (!nodes[node.x-1][node.y].visited)
                adjacency.add(nodes[node.x - 1][node.y]);
        }
        if (node.y + 1 < 10) {
            if (!nodes[node.x][node.y+1].visited)
                adjacency.add(nodes[node.x][node.y+1]);
        }
        if (node.y - 1 >= 0) {
            if (!nodes[node.x][node.y-1].visited)
                adjacency.add(nodes[node.x][node.y-1]);
        }

        return adjacency;
    }


}
