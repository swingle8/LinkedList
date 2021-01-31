// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new solve().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class solve{
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deq = new LinkedList<Integer>();
        for (int i = 0 ; i < k ; i ++) {
            while (! deq.isEmpty() && arr[i] > arr[deq.peekLast()])
                deq.removeLast();
            deq.addLast(i);
        }
        ans.add(arr[deq.peek()]);
        int i = 0;
        while (k < n) {
            int num = arr[k];
            while (! deq.isEmpty() && num > arr[deq.peekLast()])
                deq.removeLast();
            deq.addLast(k);
            
            while (deq.peek() <= i)
                deq.remove();
            
            ans.add(arr[deq.peek()]);
            k++;
            i++;
        }
        
        return ans;
    }
}