package dspractice;
import java.util.*;
public class queue {
	    private int max_size;
	    private int rear;
	    private int front;
	    private int[] queue;

	    public queue(int size) {
	        this.max_size = size;
	        this.rear = -1;
	        this.front = -1;
	        this.queue = new int[size];
	    }

	    public void enqueue(int element) {
	        if (isFull()) {
	            System.out.println("Queue is full");
	            return;
	        }

	        if (front == -1) {
	            front = 0;
	        }

	        queue[++rear] = element;
	        System.out.println(element + " enqueued");
	    }

	    public void dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty");
	            return;
	        }

	        int temp = queue[front];
	        System.out.println("Deleted element is: " + temp);
	        front++;

	        if (front > rear) {
	            front = -1;
	            rear = -1;
	        }
	    }

	    public boolean isEmpty() {
	        return front == -1;
	    }

	    public boolean isFull() {
	        return rear == max_size - 1;
	    }
	    public int getFront() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty");
	            return -1; 
	        }
	        return queue[front];
	    }

	    public int getRear() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty");
	            return -1; 
	        }
	        return queue[rear];
	    }


	    public void display() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty");
	            return;
	        }

	        System.out.print("Queue elements: ");
	        for (int i = front; i <= rear; i++) {
	            System.out.print(queue[i] + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter queue size: ");
	        int size = sc.nextInt();
	        queue q = new queue(size);

	      
	        q.enqueue(10);
	        q.enqueue(20);
	        q.enqueue(30);
	        q.display();
	        System.out.println(q.getFront());
	        q.dequeue();
	         System.out.println(q.getRear());
	        q.display();
	        q.enqueue(40);
	        q.enqueue(50); 
	        q.enqueue(60); 
	        q.display();
	        q.dequeue(); 
	      
	        
	    }
	}

