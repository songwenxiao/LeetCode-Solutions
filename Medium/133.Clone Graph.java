/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {//DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null){  
            return null;  
        }  
        HashMap<Integer, UndirectedGraphNode> checker=new HashMap<Integer, UndirectedGraphNode>();  
        return clone(checker, node); 
    }
    
    public UndirectedGraphNode clone(Map<Integer,UndirectedGraphNode> checker, UndirectedGraphNode node){
        if(checker.containsKey(node.label)){
            return checker.get(node.label);
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        checker.put(node.label,newNode);
        for(UndirectedGraphNode n :node.neighbors){
            newNode.neighbors.add(clone(checker,n));
        }
        return newNode;
    }
}

public class Solution {//BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
        HashMap<Integer, UndirectedGraphNode> map = new HashMap(); //store visited nodes
        
        map.put(newNode.label, newNode); //add first node to HashMap
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue
        
        while (!queue.isEmpty()) { //if more nodes need to be visited
            UndirectedGraphNode n = queue.pop(); //search first node in the queue
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
            }
        }
        
        return newNode;
    }
}