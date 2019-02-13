package manager.task;

public class Node {
    public int x;
    public int y;
    public boolean visited;
    public Node next;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
    }
}
