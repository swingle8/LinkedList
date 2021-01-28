// { Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new GfG().tour(p,d));
		t--;
		}
	}
}// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance
class GfG
{
    int tour(int petrol[], int distance[]) {
	    int len1 = petrol.length;
	    int len2 = distance.length;
	    if (len1 != len2)
	        return -1;
	    
	    int sum = 0;
	    int extra = 0;
	    int ans = -1;
	    
	    for (int i = 0 ; i < len1 ; i++) {
	        int extraPetrol = petrol[i] + extra - distance[i];
	        extra = 0;
	        if (extraPetrol < 0) {
	            ans = -1; 
	            sum = sum + extraPetrol;
	        }
	        else {
	            if (ans == -1)
	                ans = i;
	            extra = extraPetrol;
	        }
	    }
	    
	    //System.out.println("sum : " + sum);
	    if (extra < Math.abs(sum))
	        ans = -1;
	    return ans;
    }
}