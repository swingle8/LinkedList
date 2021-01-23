// { Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Palindrome g = new Palindrome();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}



// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Palindrome
{
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        int len = 0;
        Node iterator = head;
        while (iterator != null) {
            len++;
            iterator = iterator.next;
        }
        int mid = len/2;
        Node back = head;
        for (int i = 0 ; i < mid ; i++) {
            back = back.next;
        }
        
        if (len%2 != 0)
            back = back.next;
        
        
        Node revert = reverse (back);
        //System.out.println(revert.data);
        
        while (mid > 0 && revert != null && head != null) {
            if (revert.data != head.data)
                return false;
            mid--;
            revert = revert.next;
            head = head.next;
        }
        return true;
        // return isGivenHalfSame (head, back, mid, mid);
    }
    
    //reverse the mid - n LinkedList
    Node reverse (Node back) {
        Node prev = null;
        while (back != null) {
            Node next = back.next;
            back.next = prev;
            prev = back;
            back = next;
            
        }
        return prev;
        
    }
    
    //Recurdion way
    boolean isGivenHalfSame (Node head, Node last, int half, int i) {
        if (last == null)
            return true;
        if (! isGivenHalfSame (head, last.next, half, i-1))
            return false;
        while (i > 1) {
            head = head.next;
            i--;
        }
        if (head.data == last.data)
            return true;
        return false;
        
    }
}

