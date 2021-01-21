// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Rotate g = new Rotate();
            head = g.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Rotate{
    // This function should rotate list counter-
    // clockwise by k and return head node
    
    public Node rotate(Node head, int k) {
        Node first = head;
        k--;
        while (head != null && k > 0) {
            k--;
            head = head.next;
            
        }
        if (head.next == null)
            return first;
            
        Node furtherIteration = head.next;
        Node ans = head.next;
        head.next = null;
        
        
        while (furtherIteration.next != null) {
            furtherIteration = furtherIteration.next;
        }
        furtherIteration.next = first;
        return ans;
    }
}
