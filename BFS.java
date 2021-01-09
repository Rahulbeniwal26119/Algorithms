class Quene {
    int SIZE = 7;
    int items[] = new int[7];
    int front, rear;

    Quene() {
        front = rear = -1;
    }

   public  boolean isFull() {
        if (front == 0 && rear == SIZE - 1)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (front == rear && front == -1) {
            return true;
        }
        return false;
    }

    public void enQuene(int val) {
        if (isFull())
            System.out.println("Quene is full");
        else {
            if (isEmpty()) {
                front = 0;
            }
            rear++;
            items[rear] = val;
            System.out.println("Insert" + val);
        }
    }

    public int deQuene() {
        int element;
        if (isEmpty()) {
            System.out.println("Quene is Empty");
            return -1;
        } else {
            element = items[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                ++front;
            }
        }
        return element;
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Quene is Empty");
        } else {
            for (i = front; i <= rear; i++) {
                System.out.print(items[i] + "  ");
            }
        }
    }
}

public class BFS {

    static void BreadthFirstSearch(int vertex , int adjMat[][] , int n)
    {
        Quene q = new Quene();
        int visited[] = new int[7];
        System.out.print(vertex + " ");
        visited[vertex] = 1;
        q.enQuene(vertex);
        while (!q.isEmpty())
        {
            int u = q.deQuene();
            for(int v=1; v<7; v++)
            {
                if(adjMat[u][v] == 1 && visited[v] == 0)
                {
                    System.out.print(v + " ");
                    visited[v] = 1;
                    q.enQuene(v);
                }
            }
        }

    }
    public static void main(String[] args) {
        int [][] adjacencyMatrix = new int [] [] {
            {0 , 0 , 0 , 0 , 0 , 0 , 0},
            {0 , 0 , 1 , 1 , 0 , 0 , 1},
            {0 , 1 , 0 , 0 , 1 , 0 , 1},
            {0 , 1 , 0 , 0 , 1 , 1 , 0},
            {0 , 0 , 1 , 1 , 0 , 1 , 0},
            {0 , 0 , 0 , 1 , 1 , 0 , 0},
            {0 , 1 , 1 , 0 , 0 , 0 , 0}
        } ;
        BreadthFirstSearch(3 , adjacencyMatrix , 7);
    }
}