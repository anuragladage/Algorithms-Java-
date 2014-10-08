import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

//Neighbour is to Vertex like Link is to Linked list.
class Neighbour
{
	public int vertexNum;
	public Neighbour next;
	
	public Neighbour(int vnum, Neighbour nbr)
	{
		this.vertexNum = vnum;
		next = nbr;
	}
}

//This is the linked list.
class Vertex
{
	public String name;
	Neighbour adjList;
	public Vertex(String name, Neighbour nbr)
	{
		this.name = name;
		this.adjList = nbr;
	}
}
	
	

//Graph is a adjacency list or list of linked lists.
public class Graph
{
	Vertex[] adjLists;
	public Graph(String file) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(file));
		adjLists = new Vertex[sc.nextInt()];
		for(int v = 0;v<adjLists.length;v++)
		{
			adjLists[v] = new Vertex(sc.next(),null);
		}
		
		
		while(sc.hasNext())
		{
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			
			adjLists[v1].adjList = new Neighbour(v2, adjLists[v2].adjList);
			adjLists[v2].adjList = new Neighbour(v1, adjLists[v1].adjList);
		}
		sc.close();
	}
	
	
	public int indexForName(String vname)
	{
		for(int v = 0; v<adjLists.length;v++)
		{
			if(adjLists[v].name.equals(vname))
			{
				return v;
			}
		}
		return -1;
	}
	
	
	
	public void print()
	{
		System.out.println();
		for(int v = 0; v<adjLists.length; v++)
		{
			System.out.println(adjLists[v].name);
			for(Neighbour nbr = adjLists[v].adjList;nbr != null; nbr = nbr.next)
			{
				System.out.println("--->" + adjLists[nbr.vertexNum].name);
			}
			System.out.println();
		}
	}
	
	///Depth first Search (Private)
	private void dfs(int v, boolean[] visited)
	{
		visited[v] = true;
		System.out.println("Vertex Visited ---> " + adjLists[v].name);
		for(Neighbour nbr = adjLists[v].adjList;nbr != null;nbr = nbr.next)
		{
			if(!visited[v])
			{
				System.out.println(adjLists[v].name + "--" + adjLists[nbr.vertexNum].name);
				dfs(nbr.vertexNum,visited);
			}
		}
	}
	
	//Depth First Search (Public)
	public void dfs()
	{
		boolean[] visited = new boolean[adjLists.length];
		for(int v=0;v<adjLists.length;v++)
		{
			if(!visited[v])
			{
				System.out.println("Starting at --> " + adjLists[v].name);
				dfs(v,visited);
			}
		}
	}
	
	//Breath First Search
	
/* 	public void bfs()
	{
		boolean[] visited = new boolean[adjLists.length];
		for(int v = 0; v<adjLists.length;v++)
		{
			if(!visited[v])
			{
				visited[v] = true;
				System.out.println("Staring From ---> " + adjLists[v].name);
				for(Neighbour nbr = adjLists[v].adjlist; nbr != null ;nbr = nbr.adjList)
				{
					visited[nbr.vertexNum] = true;
					System.out.println(adjLists[v].name + "-->" + adjLists[nbr].name);
				}
			}
		}
	} */
			
		
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the File Name");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		graph.print();
		sc.close();
		
	}
}
