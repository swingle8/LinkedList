// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class LinkedList
{
    static Node segregate(Node head)
    {
        int zero = 0;
        int one = 0;
        int two = 0;
        Node start = head;
        while (start != null) {
            if (start.data == 0)
                zero++;
            else if (start.data == 1)
                one++;
            else if (start.data == 2)
                two++;
            start = start.next;
        }
        
        start = head;
        while (zero > 0) {
            start.data = 0;
            start = start.next;
            zero--;
        }
        
        while (one > 0) {
            start.data = 1;
            start = start.next;
            one--;
        }
        
        while (two > 0) {
            start.data = 2;
            start = start.next;
            two--;
        }
        return head;
    }
}


