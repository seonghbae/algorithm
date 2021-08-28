import java.util.Scanner;

public class Main {
    private int front;
    private int back;
    private int maxSize;
    private Object[] queue;

    public Main(int maxSize){
        this.maxSize = maxSize;
        this.queue = new Object[maxSize];
        this.front = -1;
        this.back = -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str;
        Main queue = new Main(sc.nextInt() + 1);
        int i;
        for (i=0; i<queue.maxSize; i++){
            str = sc.nextLine();
            if (str.contains("push")) {
                String[] temp = str.split(" ");
                queue.push(Integer.parseInt(temp[1]));
            }
            else {
                switch (str) {
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
                }
            }
        }
        
        sc.close();
    }

    public void push(int X){
        if(this.front == -1) {
            this.front++;
            this.back++;
            this.queue[this.back] = X;
        }
        else {
            this.back++;
            this.queue[this.back] = X;
        }
    }
    
    public void pop() {
        if (this.front == -1 || this.front > this.back) {
            System.out.println("-1");
        }
        else {
            System.out.println(this.queue[this.front]);
            this.queue[this.front] = -1;
            this.front++;
        }
    }
    
    public void size() {
        if (this.front == -1 || this.front > this.back) {
            System.out.println('0');
        }
        else {
            System.out.println(this.back - this.front + 1);
        }
    }
    
    public void empty() {
        if (this.front == -1 || this.front > this.back) {
            System.out.println('1');
        }
        else {
            System.out.println('0');
        }
    }
    
    public void front() {
        if (this.front == -1 || this.front > this.back) {
            System.out.println("-1");
        }
        else {
            System.out.println(this.queue[this.front]);
        }
    }
    
    public void back() {
        if (this.front == -1 || this.front > this.back) {
            System.out.println("-1");
        }
        else {
            System.out.println(this.queue[this.back]);
        }
    }
}