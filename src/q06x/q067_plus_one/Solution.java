/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q067_plus_one;



/**
 * <pre>
 * Valid Number 221 / 1202
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous.
 *  You should gather all requirements up front before implementing one.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("10.3"));
    }

    public boolean isNumberFree(String s) {
        try {
            Double.valueOf(s.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    interface Proc {
        State to(char c);
    }

    enum State implements Proc {
        INVALID (false) {
            public State to(char c) {
                return INVALID;
            }
        },
        INIT (false) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return INT;
                } else if (c =='-' || c == '+') {
                    return SIGN;
                } else if (c == '.') {
                    return POINT;
                }
                return INVALID;
            }
        },
        INT (true) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return INT;
                } else if (c == '.') {
                    return FLOAT;
                } else if (c == 'e' || c == 'E') {
                    return E;
                }
                return INVALID;
            }
        },
        SIGN (false) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return INT;
                } else if (c == '.') {
                    return POINT;
                }
                return INVALID;
            }
        },
        POINT (false) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return FLOAT;
                }
                return INVALID;
            }
        },
        FLOAT (true) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return FLOAT;
                } if (c == 'e' || c == 'E') {
                    return E;
                }
                return INVALID;
            }
        },
        E (false) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return EXP;
                } else if (c =='-' || c == '+') {
                    return SE;
                }
                return INVALID;
            }
        },
        SE (false) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return EXP;
                }
                return INVALID;
            }
        },
        EXP (true) {
            public State to(char c) {
                if (c >= '0' && c <= '9') {
                    return EXP;
                }
                return INVALID;
            }
        };
        boolean valid;
        State(boolean valid) {
            this.valid = valid;
        }
        
        static boolean proc(String s) {
            if (s == null || (s = s.trim()).length() == 0) {
                return false;
            }
            State state = INIT;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length && state != INVALID; i ++) {
                state = state.to(arr[i]);
            }
            return state.valid;
        }
    }
    
    public boolean isNumber(String s) {
        return State.proc(s);
    }
}
