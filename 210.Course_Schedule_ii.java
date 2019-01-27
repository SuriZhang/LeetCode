class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        int[] visited = new int[numCourses];
        List<Integer> ans = new ArrayList<Integer>();
        Integer index = numCourses;
        for (int i = 0; i < numCourses; ++i)
            if (dfs(i, graph, visited, ans)) return new int[0];        
        
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited, List<Integer> ans) {
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;
        
        visited[curr] = 1;
        for (int next : graph.get(curr))
            if (dfs(next, graph, visited, ans)) return true;
        
        visited[curr] = 2;
        ans.add(curr);
        
        return false;
    }    
}


/**
 Problem is representad by Graph.
 Topological sort will help to see if graph has no cycle (DAG - Direct Acyclic Graph)
 If no cycle present, then it is possible to take all courses 
 Topological sort can be done via DFS or BFS
 This soultion uses BFS
 
This question asks for an order in which prerequisite courses must be taken first. This prerequisite relationship reminds one of directed graphs. Then, the problem reduces to find a topological sort order of the courses, which would be a DAG if it has a valid order.

The first step is to transform it into a directed graph. Since it is likely to be sparse,we use adjacency list graph data structure. 1 -> 2 means 1 must be taken before 2.


How can we obtain a topological sort order of a DAG?

We observe that if a node has incoming edges, it has prerequisites. Therefore, the first few in the order must be those with no prerequisites, i.e. no incoming edges. Any non-empty DAG must have at least one node without incoming links. You can draw a small graph to convince yourself. If we visit these few and remove all edges attached to them, we are left with a smaller DAG, which is the same problem. This will then give our BFS solution.

*/


class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incomingEdges, adjs, prerequisites);
        return bfs(incomingEdges, adjs);
    }
    
    private void initialiseGraph(int[] incomingEdges,
                                 List<List<Integer>> adjs,
                                 int[][] prerequisites) {
        int course, prereq;
        for (int i = 0; i < incomingEdges.length; i++) {
            adjs.add(new ArrayList<>());    
        }
        for (int[] edge : prerequisites) {
            course = edge[0];
            prereq = edge[1]; 
            incomingEdges[course]++;
            adjs.get(prereq).add(course);
        }
    }
    
    private int[] bfs(int[] incomingEdges, List<List<Integer>> adjs) {
        int[] order = new int[incomingEdges.length];
        Queue<Integer> queue = new LinkedList<>();
        
        // lets visit all courses which have no prerequisites first
        for (int i = 0; i < incomingEdges.length; i++) {
            if (incomingEdges[i] == 0) queue.add(i);
        }
        
        int visited = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            order[visited++] = from;
            
            for (int to : adjs.get(from)) {
                incomingEdges[to]--;
                if (incomingEdges[to] == 0) queue.add(to);
            }
        }
        
        return visited == incomingEdges.length ? order : new int[] {};
    }
        
}
