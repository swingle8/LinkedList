// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    
    class Node{
        int data;
        Node next;
        
        Node(int x){
            data = x;
            next = null;
        }
        
    }
    class GFG{
        static void printList(Node node) 
        { 
            while (node != null) 
            { 
                System.out.print(node.data + " "); 
                node = node.next; 
            } 
            System.out.println(); 
        }
        public static void main(String args[]) throws IOException { 
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t > 0){
                int n = sc.nextInt();
                Node head = new Node(sc.nextInt());
                Node tail = head;
                for(int i=0; i<n-1; i++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                Solution g = new Solution();
                int ans = g.getMiddle(head);
                System.out.println(ans);
                //printList(head); 
                t--;
            }
        } 
    } 
       // } Driver Code Ends
    
    
    /* Node of a linked list
     class Node {
       int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    */
    
    class Solution
    {
        int getMiddle(Node head)
        {
            //counting the length approach
             int len = 0;
             Node headIterator = head;
             while (headIterator != null) {
                 len++;
                 headIterator = headIterator.next;
             }
             
             int middle = len/2;
             headIterator = head;
             while (middle > 0) {
                 middle--;
                 headIterator = headIterator.next;
             }
            
            
            //Double jump approach
            Node pointer = head;
            Node fastPointer = head;
            
            while (fastPointer != null && fastPointer.next != null) {
                pointer = pointer.next;
                fastPointer = fastPointer.next.next;
            }
            
            return pointer.data;
        }
    }
    