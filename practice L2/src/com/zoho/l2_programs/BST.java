package com.zoho.l2_programs;

import java.util.Scanner;

//print all the leaf nodes from the given binary search tree....
class Binary{

    public Node create(int val){
        Node newNode = new Node();
        newNode.data = val;
        newNode.left=null;
        newNode.right=null;
        return newNode;
    }

    public void findLeafNode(Node root) {
        if(root==null){
            System.out.println("There is no tree");
        }
        else if(root.left==null&&root.right==null){
            System.out.println(root.data);
        }
        else{
            if(root.left!=null){
                findLeafNode(root.left);
            }
            if(root.right!=null){
                findLeafNode(root.right);
            }
        }
    }
    public Node insert(Node node,int val){
        if(node==null){
            return create(val);
        }
        if(val<node.data){
            node.left = insert(node.left,val);
        }
        else if(val>node.data){
            node.right = insert(node.right,val);
        }
        return node;
    }
}
class Node{
    int data;
    Node left,right;
}
public class BST {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Binary bin = new Binary();
        Node root = null;
        System.out.println("Enter size");
        int size = scan.nextInt();
        int array [] = new int[size];
        System.out.println("Enter elements");
        for(int i=0;i< array.length;i++){
            array[i] = scan.nextInt();
        }
        root = bin.insert(root,array[0]);
        for(int i=1;i< array.length;i++){
            bin.insert(root,array[i]);
        }
        System.out.println("The leaf Nodes Are:");
        bin.findLeafNode(root);
    }
}
