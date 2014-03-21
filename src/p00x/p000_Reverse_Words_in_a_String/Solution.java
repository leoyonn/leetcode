/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p000_Reverse_Words_in_a_String;


/**
 * <pre>
 * Reverse Words in a String Total Accepted: 2555 Total Submissions: 16875 My Submissions
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * click to show clarification.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    /**
     * Runtime: 392 ms
     *
     * @param s
     * @return
     */
    public String reverseWords_v1(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean appended = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            String a = arr[i].trim();
            if (!a.isEmpty()) {
                sb.append(a).append(" ");
                appended = true;
            }
        }
        if (appended) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Runtime: 344 ms
     *
     * @param s
     * @return
     */
    public String reverseWords_v2(String s) {
        if (s.isEmpty()) {
            return s;
        }
        char[] arr = s.toCharArray();
        // 1. reduce ' 's
        int i = 0, j = 0, len = arr.length;
        while (j <len) {
            while (j < len && arr[j] == ' ') j ++;
            while (j < len && arr[j] != ' ') arr[i++] = arr[j ++];
            if (j < len) arr[i++] = ' ';
        }
        if (i == 0) {
            return "";
        }
        len = arr[i - 1] == ' ' ? i - 1 : i;
        // 2. swap hole line.
        for (i = 0, j = len - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
        // 3. swap each word
        int wordBegin = 0;
        for (i = wordBegin, j = i + 1; i < len; ) {
            while (j < len && arr[j] != ' ') {
                j++;
            }
            wordBegin = j + 1;
            while (--j > i) {
                swap(arr, i, j);
                i++;
            }
            i = wordBegin;
            j = i + 1;
        }
        return new String(arr, 0, len);
    }

    private static void swap(char[] arr, int i, int j) {
        char swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "   1 ", r = "";
        System.out.println(String.format("|%s|%d.", str, str.length()));
        System.out.println(String.format("|%s|%d.", r = s.reverseWords_v1(str), r.length()));
        System.out.println(String.format("|%s|%d.", r = s.reverseWords_v2(str), r.length()));
    }
}
