/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q05x.q057_length_of_last_words;


/**
 * <pre>
 *  Length of Last Word 209 / 507
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int i = (s = s.trim()).length() - 1;
        for (; i >= 0 && s.charAt(i) != ' '; i --);
        return s.length() - i - 1;
    }
}