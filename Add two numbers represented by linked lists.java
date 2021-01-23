// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static int carry = 0;
    static Node addTwoLists(Node first, Node second){
        carry = 0;
        int len1 = 0;
        int len2 = 0;
        Node start1 = first;
        Node start2 = second;
        
        while (start1 != null) {
            len1++;
            start1 = start1.next;
        }
        start1 = first;
        while (start2 != null) {
            len2++;
            start2 = start2.next;
        }
        
        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff != 0) {
                start1 = start1.next;
                diff--;
            }
        }
        
        start2 = second;
        if (len2 > len1) {
            int diff = len2 - len1;
            while (diff != 0) {
                start2 = start2.next;
                diff--;
            }
        }
        
       Node end = sum (start1, start2, null);
       
       start1 = first;
       start2 = second;
       if (len1 > len2) {
            int gap = len1-len2;
            end = fillGap (start1, end, gap);
        }
        
        else if  (len2 > len1) {
            int gap = len2-len1;
            end = fillGap (start2, end, gap);
        }
        
        if (carry > 0) {
            Node begin = new Node(carry);
            begin.next = end;
            end = begin;
        }
        return end;
    }
    
    public static Node sum (Node first, Node second, Node last) {
        if (first == null && second == null)
            return last;
        
        
        last = sum (first.next, second.next, last);
        
        int sum = first.data + second.data + carry;
        carry = 0;
        int num = sum%10;
        sum = sum/10;
        if (last == null)
            last = new Node(num);
        else {
             Node curr = new Node(num);
             curr.next = last;
             last = curr;
        }
        if (sum > 0)
            carry = sum%10;
        return last;
    }
    
    public static Node fillGap (Node start, Node end, int gap) {
        if (gap <= 0)
            return end;
        //System.out.println("Shivam : " + gap);
        end = fillGap (start.next, end, gap-1);
        int val = start.data + carry;
        carry = 0;
        int num = val%10;
        Node curr = new Node(num);
        curr.next = end;
        end = curr;
        
        val = val/10;
        if (val > 0)
            carry = val%10;
        return end;
        
    }
}