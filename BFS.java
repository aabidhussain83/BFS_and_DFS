import java.util.*;
import java.io.*;
public class BFS {
    
    private int Nodes;
    
  private LinkedList<Integer> adj[];
   
   BFS(int nodes)
   {
       Nodes=nodes;
       adj=new LinkedList[Nodes];
       for(int i=0;i<nodes;i++)
           adj[i]=new LinkedList();
   }
    
  void addEdge(int source,int destination)
    {
        adj[source].add(destination);
        adj[destination].add(source);
    }
  
  void bFS(int source)
    {
      boolean [] hasVisited=new boolean[Nodes];
      LinkedList<Integer> q=new LinkedList<Integer>();
      
      hasVisited[source]=true;
      q.add(source);
      
      while(q.size()!=0)
      {
          source=q.poll();
          System.out.print(source+" ");
          
          Iterator<Integer> i = adj[source].listIterator();
            while (i.hasNext())
           {   int n = i.next();
              if(! hasVisited[n])
                      {
                          hasVisited[n]=true;
                          q.add(n);
                      }
           }
      }
      
    }
  
    
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        
        System.out.println("Enter numbers of Vertices : ");
        int Nodes=scan.nextInt();
        BFS obj=new BFS(Nodes);
        
        System.out.println("Enter Source vertex");
        int source=scan.nextInt();
        
        System.out.println("Enter number of edges");
        int edges=scan.nextInt();
        
        System.out.println("Enter "+edges+" edge : source vertex destination vertex");
        for(int i=0;i<edges;i++)
        {  
           int s=scan.nextInt();
           int d=scan.nextInt();
            obj.addEdge(s,d);
        }
        
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex "+source+" )");
        obj.bFS(source);
    }
}
