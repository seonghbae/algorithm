import java.util.Scanner;

public class Main {
    private int top;
    private int maxSize;
    private Object[] stack;

    public Main(int maxSize){
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
        this.top = -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str;
        Main stack = new Main(sc.nextInt() + 1);
        int i;
        for (i=0; i<stack.maxSize; i++){
            str = sc.nextLine();
            if (str.contains("push")) {
                String[] temp = str.split(" ");
                stack.push(Integer.parseInt(temp[1]));
            }
            else {
                switch (str) {
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
                }
            }
        }
        
        sc.close();
    }

    public void push(int X){
        this.top++;
        this.stack[this.top] = X;
    }
    
    public void pop() {
        if (this.top == -1) {
            System.out.println("-1");
        }
        else {
            System.out.println(this.stack[this.top]);
            this.stack[this.top] = -1;
            this.top--;
        }
    }
    
    public void size() {
        if (this.top == -1) {
            System.out.println('0');
        }
        else {
            System.out.println(this.top + 1);
        }
    }
    
    public void empty() {
        if (this.top == -1) {
            System.out.println('1');
        }
        else {
            System.out.println('0');
        }
    }
    
    public void top() {
        if (this.top == -1) {
            System.out.println("-1");
        }
        else {
            System.out.println(this.stack[this.top]);
        }
    }
}