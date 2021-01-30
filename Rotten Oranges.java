// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Element> q = new LinkedList<Element>(); 
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Element(i, j));
                }
            }
        }
        
        while (! q.isEmpty()) {
            int size = q.size();
            boolean root = false;
            for (int i = 0 ; i < size ; i++) {
                Element current = q.remove();
                if (current.x < n-1 && grid[current.x + 1][current.y] == 1)  {
                    q.add(new Element(current.x + 1, current.y));
                    grid[current.x + 1][current.y] = 2;
                    root = true;
                }
                if (current.x > 0 && grid[current.x - 1][current.y] == 1)  {
                    q.add(new Element(current.x - 1, current.y));
                    grid[current.x - 1][current.y] = 2;
                    root = true;
                }
                if (current.y < m-1 && grid[current.x][current.y + 1] == 1)  {
                    q.add(new Element(current.x, current.y + 1));
                    grid[current.x][current.y + 1] = 2;
                    root = true;
                }
                if (current.y > 0 && grid[current.x][current.y - 1] == 1)  {
                    q.add(new Element(current.x, current.y - 1));
                    grid[current.x][current.y - 1] = 2;
                    root = true;
                }
            }
            
            if (root)
                time++;
            
        }
        
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        
        return time;
    }
    
    
}

class Element {
    int x = 0;
    int y = 0;
    public Element (int i, int j) {
        x = i;
        y = j;
    }
}