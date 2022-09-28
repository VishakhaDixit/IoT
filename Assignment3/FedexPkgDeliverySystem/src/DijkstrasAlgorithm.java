import java.util.ArrayList;
import java.util.Collections; 
  
class DijkstrasAlgorithm 
{ 
	// No parent for first vertex
    private static final int NO_PARENT = -1;  
    
    private static int[] dijkstra(int[][] graph, int srcVertex) 
    { 
        int totalVertices = graph[0].length; 
  
        int[] shortestDistances = new int[totalVertices]; 

        // Boolean array for vertices that have been processed
        boolean[] added = new boolean[totalVertices]; 
  
        // Init distances for all vertices as INFINITE and added[] as false 
        for (int vertexIdx = 0; vertexIdx < totalVertices; vertexIdx++) 
        { 
            shortestDistances[vertexIdx] = Integer.MAX_VALUE; 
            added[vertexIdx] = false; 
        } 
          
        // Distance of source vertex from itself is always 0 
        shortestDistances[srcVertex] = 0; 
  
        // Parent array to store shortest path tree 
        int[] parents = new int[totalVertices]; 
  
        // Init src vertex with no parent
        parents[srcVertex] = NO_PARENT; 
  
        // Compute shortest path for all vertices 
        for (int i = 1; i < totalVertices; i++) 
        { 
  
            // Pick the minimum distance vertex from the set of vertices not yet 
            // processed. nearestVertex is always equal to startNode in  
            // first iteration. 
            int nearestVertex = -1; 
            int shortestDistance = Integer.MAX_VALUE; 
            
            for (int vertexIndex = 0; vertexIndex < totalVertices; vertexIndex++) 
            { 
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance)  
                { 
                    nearestVertex = vertexIndex; 
                    shortestDistance = shortestDistances[vertexIndex]; 
                } 
            } 
  
            // Mark the selected vertex as processed 
            added[nearestVertex] = true; 
  
            // Update distance value of the adjacent vertices of the processed vertex. 
            for (int vertexIndex = 0; vertexIndex < totalVertices; vertexIndex++)  
            { 
                int edgeDistance = graph[nearestVertex][vertexIndex]; 
                  
                if ((edgeDistance > 0) && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))  
                { 
                    parents[vertexIndex] = nearestVertex; 
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance; 
                } 
            } 
        } 
  
        return parents; 
    } 
    
    public ArrayList<Integer> getShortestPath(int src, int dst)
    {
    	ArrayList<Integer> path = new ArrayList<Integer>();
		
        int[][] adjacencyMatrix = { { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1 },
						            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0 } }; 
    	
        int[] parent = dijkstra(adjacencyMatrix, src);  
    	path =	vPath (dst, parent,src);
    	
        Collections.reverse(path);
    	return path;
    }
  
    private static ArrayList<Integer> vPath(int greatestVertex, int[] parents, int src) 
    {
    	ArrayList<Integer> vpath = new ArrayList<Integer>();
    	vpath.add(greatestVertex);
    	
        while (greatestVertex != src ) 
        {

      		vpath.add(parents[greatestVertex]);
    		greatestVertex = parents[greatestVertex];
    	}

    	return vpath;
    }
} 
  
