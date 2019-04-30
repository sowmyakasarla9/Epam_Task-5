import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsAndLibraries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int j = 0; j < q; j++)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int c_lib = in.nextInt();
            int c_road = in.nextInt();
            
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
             a[i] = -1;
            
            for(int k = 0; k < m; k++)
            {
                int c1 = in.nextInt();
                int c2 = in.nextInt();
                int node1 = c1, node2 = c2;
                while (a[node1] > 0) 
                    node1 = a[node1];
                while (a[node2] > 0) 
                    node2 = a[node2];
                if (node1 != node2) 
                {
                    if (a[node1] <= a[node2]) 
                    {
                        a[node1] += a[node2];
                        a[node2] = node1;
                    } 
                    else 
                    {
                        a[node2] += a[node1];
                        a[node1] = node2;
                    }
                    
                }
            }
            
            long cost = 0;
            for (int i = 1; i <= n; i++) 
            {    
                if (a[i] < 0) {
                    cost += c_lib + (-a[i] - 1) * Math.min(c_lib, c_road);
                }
            }

            System.out.println(cost);
        }
    }
}
