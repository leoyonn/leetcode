/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q068_text_justification;

import java.util.ArrayList;



/**
 * <pre>
 * Text Justification 110 / 542
 * Given an array of words and a length L, format the text such that each line
 *  has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can
 *  in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible.
 *  If the number of spaces on a line do not divide evenly between words,
 *  the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(new String[] {
                "What","must","be","shall","be."
            //  "This", "is", "an", "example", "of", "text", "justification."
        }, 16));
    }

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        } else if (L == 0) {
            res.add("");
            return res;
        }
        int i = 0, j;
        char[] buf = new char[L];
        for (; i < words.length; i = j) {
            int len = words[i].length(), idx = 0;
            // find how many words this line can hold
            for (j = i + 1; j < words.length; j ++) {
                if (len + 1 + words[j].length() > L) {
                    break;
                }
                len += 1 + words[j].length();
            }
            // if only one, left-just
            idx = set(buf, 0, words[i].toCharArray());
            if (j == i + 1 || j == words.length) {
                for (int w = i + 1; w < j; w ++) {
                    buf[idx ++] = ' ';
                    idx = set(buf, idx, words[w].toCharArray());
                }
                // if (j != words.length) {
                idx = set(buf, idx, ' ', L - idx);
                // }
                res.add(String.valueOf(buf, 0, idx));
                continue;
            }
            // more that one words
            int nslot = j - i - 1;
            len -= nslot; // len with no ' 's
            int nspace = L - len, slotLen = nspace / nslot, remainder = nspace - slotLen * nslot;
            for (int w = i + 1; w < j; w ++) {
                idx = set(buf, idx, ' ', remainder-- > 0 ? slotLen + 1: slotLen);
                idx = set(buf, idx, words[w].toCharArray());
            }
            res.add(String.valueOf(buf));
        }
        return res;
    }
    
    private int set(char[] des, int offset, char[] src) {
        for (char c: src) {
            des[offset ++] = c;
        }
        return offset;
    }

    private int set(char[] des, int offset, char c, int len) {
        for (int i = 0; i < len; i ++) {
            des[offset ++] = c;
        }
        return offset;
    }
}
