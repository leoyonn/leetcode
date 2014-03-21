/**
 * Solution.java
 * @author leo
 * @date 2013-4-5
 */
package old.q07x.q071_simplify_path;

import java.util.Stack;

/**
 * <pre>
 * Simplify Path 192 / 827
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/1/./..//3/"));
    }
    public String simplifyPath(String path) {
        if (path == null || path.length() < 2) {
            return "/";
        }
        Stack<String> s = new Stack<String>();
        for(String p: path.split("/")) {
            if (p.length() == 0 || p.equals(".")) {
                continue;
            } else if (p.equals("..")) {
                if (!s.empty()) {
                    s.pop();
                }
            } else {
                s.push(p);
            }
        }
        if (s.empty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.size(); i ++) {
            sb.append("/").append(s.get(i));
        }
        return sb.toString();
    }
}
