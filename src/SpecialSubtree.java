import java.math.*;

import java.util.*;

class Node
{
    int distance=Integer.MAX_VALUE;
    ArrayList<Edge> list=new ArrayList<Edge>(); 
    boolean isProcessed=false;
    
}
class Edge
{
    Node n;
    int distance;
    boolean inQueue=false;
    
    public Edge(Node n1,int d)
    {
        n=n1;
        distance=d;
    }
}
public class SpecialSubtree {

    public static void main(String[] args) {
       
        Scanner scan=new Scanner(System.in);
        for(int t=0;t<1;t++)
        {
            int n=scan.nextInt();
            int m=scan.nextInt();
            Node[] nodes=new Node[n];
            for(int i=0;i<n;i++)
            {    
                nodes[i]=new Node();
            }
            for(int i=0;i<m;i++)
            {
                int n1=scan.nextInt();
                int n2=scan.nextInt();
                int r=scan.nextInt();
                
                nodes[n1-1].list.add(new Edge(nodes[n2-1],r));
                nodes[n2-1].list.add(new Edge(nodes[n1-1],r));    
            }
            
            int S=scan.nextInt();
            
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>(10,new Comparator<Edge>(){
                public int compare(Edge n1,Edge n2)
                {
                    if(n1.distance<=n2.distance)
                        return -1;
                    else
                        return 1;
                }
            });
            
            for(Edge e:nodes[S-1].list)
                if(!e.n.isProcessed)
                    pq.add(e);
           nodes[S-1].isProcessed=true;
            int weight=0;    
             
            while(!pq.isEmpty())
            {
                
                Edge e=pq.remove();
                if(!e.n.isProcessed)weight+=e.distance;
                
                e.n.isProcessed =true;
                e.inQueue=false;
                
               for(Edge e1 : e.n.list)
                {
                    if(!e1.inQueue && !e1.n.isProcessed)
                    {
                            pq.add(e1);
                    }
                        
                }
            }
            
            System.out.println(weight);
            } 
        }         
}
