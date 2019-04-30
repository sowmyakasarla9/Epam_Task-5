import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestReach 
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n+1);
            for(int i=0; i<n+1; i++)
                arr.add(new ArrayList<Integer>());
            
            for(int i=0; i<m; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                arr.get(u).add(v); 
                arr.get(v).add(u);
            }
            int s = sc.nextInt();
            search(s, arr, n);
        }
    }
    
    static void search(int s, ArrayList<ArrayList<Integer>> arr, int n)
    {
        boolean[] visited = new boolean[n+1];
        visited[s] = true;
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[s] = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.add(s);
        while(q.size() > 0)
        {
            int curr = q.peek();
            Iterator<Integer> it= arr.get(curr).iterator();
            while(it.hasNext())
            {
                int temp = it.next();
                if(!visited[temp])
                {
                    distance[temp] = distance[curr] + 1;
                    q.add(temp);
                    visited[temp] = true;
                }
            }
            q.remove();
        }
        
        for(int i=1; i<distance.length; i++){
            if(i != s)
            System.out.print(((distance[i] != -1)?distance[i]*6:-1 )+ " ");
        }
        System.out.println();
    }
}