/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p018_Clone_Graph;


import java.util.*;

/**
 * <pre>
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *      1
 *     / \
 *    /   \
 *   0 --- 2
 *        / \
 *        \_/
 * </pre>
 *
 * @author leo
 */
public class Solution {
    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(label).append(',');
            for (UndirectedGraphNode child : neighbors) {
                sb.append(child.label).append(',');
            }
            return sb.append('#').toString();
        }
    }

    private UndirectedGraphNode getNew(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode newNode = map.get(node.label);
        if (newNode == null) {
            newNode = new UndirectedGraphNode(node.label);
            map.put(newNode.label, newNode);
        }
        return newNode;
    }

    /**
     * 12 / 12 test cases passed.
     * Status: Accepted
     * Runtime: 612 ms
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Set<Integer> cloned = new HashSet<Integer>();
        stack.push(node);
        UndirectedGraphNode cloneRoot = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneRoot);
        cloned.add(node.label);
        while (!stack.isEmpty()) {
            node = stack.pop();
            UndirectedGraphNode clone = getNew(node, map);
            for (UndirectedGraphNode child : node.neighbors) {
                UndirectedGraphNode cloneChild = getNew(child, map);
                clone.neighbors.add(cloneChild);
                if (!cloned.contains(child.label)) {
                    cloned.add(child.label);
                    stack.push(child);
                }
            }
        }
        return cloneRoot;
    }

    private static void print(UndirectedGraphNode node) {
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        Set<Integer> labels = new HashSet<Integer>();
        labels.add(node.label);
        while (!stack.isEmpty()) {
            System.out.print(node = stack.pop());
            for (UndirectedGraphNode child : node.neighbors) {
                if (!labels.contains(child.label)) {
                    labels.add(child.label);
                    stack.push(child);
                }
            }
        }
        System.out.println(".");
    }

    public static void main(String[] args) {
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        n0.neighbors.add(n1);
        n0.neighbors.add(n2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n2);
        UndirectedGraphNode node = new Solution().cloneGraph(n0);
        print(n0);
        print(node);
    }
}
 