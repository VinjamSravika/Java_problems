package dspractice;
import java.util.*;
public class CircularQueue {
	    int front = -1;
	    int rear = -1;
	    int max_size;
	    int queue[];

	    CircularQueue(int size) {
	        max_size = size;
	        queue = new int[max_size];
	    }

	    void enqueue(int x) {
	        if ((rear + 1) % max_size == front) {
	            System.out.println("Queue overflow");
	            return;
	        }
	        if (front == -1) { 
	            front = 0;
	        }
	        rear = (rear + 1) % max_size;
	        queue[rear] = x;
	        System.out.println(x + " enqueued");
	    }

	    void dequeue() {
	        if (front == -1) {
	            System.out.println("Queue underflow");
	            return;
	        }
	        System.out.println(queue[front] + " dequeued");
	        if (front == rear) {
	          
	            front = -1;
	            rear = -1;
	        } else {
	            front = (front + 1) % max_size;
	        }
	    }

	    void display() {
	        if (front == -1) {
	            System.out.println("Queue is empty");
	            return;
	        }
	        System.out.print("Queue elements: ");
	        int i = front;
	        while (true) {
	            System.out.print(queue[i] + " ");
	            if (i == rear) break;
	            i = (i + 1) % max_size;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        CircularQueue q = new CircularQueue(5);

	        q.enqueue(10);
	        q.enqueue(20);
	        q.enqueue(30);
	        q.enqueue(40);
	        q.enqueue(50);  

	        q.display();

	        q.dequeue();
	        q.dequeue();

	        q.display();

	        q.enqueue(60);
	        q.enqueue(70);

	        q.display();
	    }
	}


