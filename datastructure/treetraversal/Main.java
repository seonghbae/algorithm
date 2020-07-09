package treetravel;

import java.util.Scanner;

class Node{
    public char data;
    public Node left;
    public Node right;

    public Node(){
        this.setData(' ');
        this.setLeft(null);
        this.setRight(null);
    }
    
    public void setNode(Node node) {
    	this.setData(node.data);
    	this.setLeft(node.left);
    	this.setRight(node.right);
    }

    public void setData(char data){
        this.data = data;
    }
    public void setLeft(Node left){
        this.left = left;
    }
    public void setRight(Node right){
        this.right = right;
    }
}

class Tree{
    public Node root;

    public Tree(){
        this.root = null;
    }

    public void setRoot(Node node){
        this.root = node;
    }

    public void insertNode(Node curNode, Node newNode){
    	if(curNode.left==null && curNode.right==null) {
    		return;
    	}
    	else {
    		if(curNode.left!=null){
    			if(curNode.left.data==newNode.data){
                    curNode.setLeft(newNode);
                    return;
                }
                insertNode(curNode.left, newNode);
            }
            if(curNode.right!=null){
                if(curNode.right.data==newNode.data){
                    curNode.setRight(newNode);
                    return;
                }
                insertNode(curNode.right, newNode);
            }
    	}
    }

    public void preOrder(Node node) {
    	if(node == null) {
    		return;
    	}
    	else {
    		System.out.printf("%c",node.data);
    		preOrder(node.left);
    		preOrder(node.right);
    	}
    }
    
    public void inOrder(Node node) {
    	if(node == null) {
    		return;
    	}
    	else {
    		inOrder(node.left);
    		System.out.printf("%c",node.data);
    		inOrder(node.right);
    	}
    }
    
    public void postOrder(Node node) {
    	if(node == null) {
    		return;
    	}
    	else {
    		postOrder(node.left);
    		postOrder(node.right);
    		System.out.printf("%c",node.data);
    	}
    }
}

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        int depth = sc.nextInt();
        int i;
        for(i=0; i<depth; i++){
            Node newNode = new Node();
            char input = sc.next().trim().charAt(0);
            newNode.setData(input);
            input = sc.next().trim().charAt(0);
            if(input!='.'){
            	Node childNode = new Node();
            	childNode.setData(input);
            	newNode.setLeft(childNode);
            }
            else {
            	newNode.setLeft(null);
            }
            input = sc.next().trim().charAt(0);
            if(input!='.'){
            	Node childNode = new Node();
            	childNode.setData(input);
            	newNode.setRight(childNode);
            }
            else {
            	newNode.setRight(null);
            }
            if(newNode.data=='A'){
                tree.setRoot(newNode);
            }
            else {
                tree.insertNode(tree.root,newNode);
            }
        } 
        sc.close();
        tree.preOrder(tree.root);
        System.out.println("");
        tree.inOrder(tree.root);
        System.out.println("");
        tree.postOrder(tree.root);
    }
}