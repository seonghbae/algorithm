package binarysearchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
	public int data;
	public Node left;
	public Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public Node insertNode(Node newNode, int str){
    	Node curNode = null;
    	if(newNode == null) {
    		return new Node(str);
    	}
    	if(str < newNode.data) {
    		curNode = insertNode(newNode.left, str);
    		newNode.left = curNode;
    	}
    	else {
    		curNode = insertNode(newNode.right, str);
    		newNode.right = curNode;
    	}
    	return newNode;
    }
    
    public void postOrder(Node node) {
    	if(node == null) {
    		return;
    	}
    	else {
    		postOrder(node.left);
    		postOrder(node.right);
    		System.out.println(node.data);
    	}
    }
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Node newNode = new Node(Integer.parseInt(str));
		while((str = br.readLine()) != null && str.length() != 0) {
			newNode = newNode.insertNode(newNode, Integer.parseInt(str));
		}
		newNode.postOrder(newNode);
		br.close();
	}
}