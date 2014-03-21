/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p001_Evaluate_Reverse_Polish_Notation;


import java.util.Stack;

/**
 * <pre>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * </pre>
 *
 * @author leo
 */
public class Solution {
    private interface IExec {
        int op(int x, int y);
    }

    private enum Op {
        Add(new IExec() {
            @Override
            public int op(int x, int y) {
                return x + y;
            }
        }),
        Sub(new IExec() {
            @Override
            public int op(int x, int y) {
                return x - y;
            }
        }),
        Mul(new IExec() {
            @Override
            public int op(int x, int y) {
                return x * y;
            }
        }),
        Div(new IExec() {
            @Override
            public int op(int x, int y) {
                return x / y;
            }
        }),;

        private IExec exec;

        Op(IExec exec) {
            this.exec = exec;
        }

        public int exec(int x, int y) {
            return exec.op(x, y);
        }

        public static Op find(char c) {
            switch (c) {
                case '+':
                    return Add;
                case '-':
                    return Sub;
                case '*':
                    return Mul;
                case '/':
                    return Div;
            }
            return null;
        }
    }

    /**
     * Runtime: 536 ms
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String t : tokens) {
            char c = t.charAt(0);
            if (t.length() > 1 || (c <= '9' && c >= '0')) {
                stack.push(Integer.valueOf(t));
            } else {
                int y = stack.pop(), x = stack.pop();
                int r = Op.find(c).exec(x, y);
                stack.push(r);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(s.evalRPN(tokens));
    }
}
