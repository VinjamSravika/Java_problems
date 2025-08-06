package dspractice;
import java.util.*;
public class QueueMenu {
	    private int max_size;
	    private int rear;
	    private int front;
	    private int[] queue;

	    public QueueMenu(int size) {
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

	    public boolean isEmpty() {
	        return front == -1;
	    }

	    public boolean isFull() {
	        return rear == max_size - 1;
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
	        Scanner sc=new Scanner(System.in);
	        System.out.print("Enter stack size: ");
	        int size = sc.nextInt();
	        QueueMenu op=new QueueMenu(size);
	        int ch;
	        do{
	            System.out.println("\n1. insert the element");
	            System.out.println("2. delete the element");
	            System.out.println("3. check queue is empty");
	            System.out.println("4. check queue is full");
	             System.out.println("5.getfront");
	              System.out.println("6.getrear");
	            System.out.println("7. display");
	            System.out.println("8. exit");
	            ch=sc.nextInt();
	            switch(ch){
	                case 1:
	                    System.out.print("Enter an element to insert onto the queue:");
	                    int ele=sc.nextInt();
	                    op.enqueue(ele);
	                    break;
	                case 2:
	                    op.dequeue();
	                    break;
	                case 3:
	                    if(op.isEmpty()){
	                        System.out.println("queue is empty");
	                    }else{
	                        System.out.println("queue is not empty");
	                    }
	                    break;
	                case 4:
	                    if(op.isFull()){
	                        System.out.println("queue is full");
	                    }else{
	                        System.out.println("queue is not full");
	                    }
	                    break;
	                     case 5:
	                     int frontElement = op.getFront();
	        if (frontElement != -1) {
	            System.out.println("Front element: " + frontElement);
	        }
	                    break;
	                case 6:
	                     int RearElement = op.getRear();
	        if (RearElement != -1) {
	            System.out.println("Front element: " + RearElement);
	        }
	        break;
	                case 7:
	                    op.display();
	                    break;
	                    case 8:
	                       System.out.println("exiting...");
	                       break;
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }while(ch!=8);
	    }
	}

	   
