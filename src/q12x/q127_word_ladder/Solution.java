/**
 * Solution.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-10 下午4:32:39
 */
package q12x.q127_word_ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <pre>
 * Word LadderFeb 112580 / 9279
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("a", "c", new HashSet<String>() {
            private static final long serialVersionUID = 1L;
            {
                add("a");
                add("b");
                add("c");
            }
        }));
    }

    private static enum Status {
        VIRGIN, INQUEUE, FUCKED,
    }
    /**
     * node of the word-neighboring net
     * @author leo
     */
    private static class Node {
        private String word;
        private int step;
        private Status  stat;
        private List<Node> neighbors = new LinkedList<Node>();

        public Node(String word, int step) {
            this.word = word;
            this.step = step;
            this.stat = Status.VIRGIN;
        }
        
        public void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
        }
        
        public String toString() {
            return word + "|" + step;
        }
    }

    private Node[] nodes = null;
    private Node startNode;

    /**
     * connect words in dict which are neighbors(1 change)
     * @param dict
     */
    private void buildNet(String start, String end, Set<String> dict) {
        nodes = new Node[dict.size()];
        startNode = nodes[0] = new Node(start, 1);
        dict.remove(start);
        int i = 1;
        for (String word: dict) {
            nodes[i++] = new Node(word, 0);
        }

        for (i = 0; i < nodes.length - 1; i++) {
            for (int j = i + 1; j < nodes.length; j++) {
                if (diff1(nodes[i].word, nodes[j].word)) {
                    nodes[i].addNeighbor(nodes[j]);
                    nodes[j].addNeighbor(nodes[i]);
                }
            }
        }
    }
    
    /**
     * check if there is only 1 diff in w1 and w2. 
     * assumes w1/w2 not null and same length
     * @param w1
     * @param w2
     * @return
     */
    private boolean diff1(String w1, String w2) {
        boolean got = false;
        for (int i = 0; i < w1.length(); i ++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (got) {
                    return false;
                }
                got = true;
            }
        }
        return got;
    }

    /**
     * entry func
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.equals(end) || !dict.contains(start) || !dict.contains(end) || dict.size() < 2) {
            return 0;
        }
        buildNet(start, end, dict);
        Queue<Node> q = new LinkedList<Node>();
        q.add(startNode);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.stat == Status.FUCKED) {
                continue;
            } else if (node.word.equals(end)) {
                return node.step;
            }
            node.stat = Status.FUCKED;
            for (Node neighbor: node.neighbors) {
                if (neighbor.stat == Status.VIRGIN) { // only add virgin
                    neighbor.step = node.step + 1;
                    neighbor.stat = Status.INQUEUE;
                    q.add(neighbor);
                }
            }
        }
        return 0;
    }
}
