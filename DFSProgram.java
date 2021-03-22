import java.util.*;
import java.io.*;
public class DFSProgram {
    
    LinkedList<Integer> adj[];
    boolean[] isVisited ;
    int Nodes;
    
    DFSProgram(int nodes)
    { 
        Nodes=nodes;
        adj=new LinkedList[Nodes];
        isVisited=new boolean[Nodes];
        
        for(int i=0;i<Nodes;i++)
            adj[i]=new LinkedList<>();
    }
    
    void addEdge(int source,int destination)
    {
        adj[source].add(destination);
        adj[destination].add(source);
       
    }
    
    
    void DFS(int source)
    {
        isVisited[source]=true;
        
        System.out.print(source + " ");

    Iterator<Integer> ite = adj[source].listIterator();
    while (ite.hasNext()) {
      int neighbour = ite.next();
      if (!isVisited[neighbour])
        DFS(neighbour);
    }
    }
    
    public static void main(String args[]) {
        
        Scanner scan=new Scanner(System.in);
        
        System.out.println("Enter numbers of Vertices : ");
        int Nodes=scan.nextInt();
        DFSProgram obj=new DFSProgram(Nodes);
        
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
        
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex "+source+" )");
        
        obj.DFS(source);
    }
     
}
