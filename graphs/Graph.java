import java.util.*;

public class Graph{
  //Adjacenct List
  public Map<Integer,ArrayList<Integer>> map = new HashMap<>();

  public void createNode(int node)
  {
    if(map.get(node)!=null){System.out.println("Node already exist");return;}
    map.put(node,new ArrayList<>());
    System.out.println(map);
  }

  public void createEdge(int start,int end)
  {
    if(map.get(start)==null || map.get(end)==null){System.out.println("Node not found");return;}

    //Undirected Graph
    map.get(start).add(end);
    //Ignore the below in case of directed graph
    map.get(end).add(start);
    System.out.println(map);
  }
  
  public void bfs(int start)
  {
    if(map.get(start)==null){
      System.out.println("StartPoint not found"); return;
    } 
    
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> que = new ArrayDeque<>();    

    visited.add(start);
    que.add(start);

    while(!que.isEmpty())
    {
      int node = que.poll();
      System.out.print(node+" ");

      for(int i: map.get(node))
      {
        if(!visited.contains(i)){
          visited.add(i);
          que.add(i);
        }
      }     
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner c = new Scanner(System.in);
    Graph g = new Graph();    

    while(true)
    {
      System.out.println("1.create node 2.create edge 3.BFS 4.Exit");
      int choice = c.nextInt();
      switch (choice)
      {
        case 1: g.createNode(c.nextInt()); break;
        case 2: g.createEdge(c.nextInt(),c.nextInt()); break;
        case 3: g.bfs(c.nextInt()); break;
        default: return;
      }
    }
    
  }
}