package level.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lawrence
 * 2019.02.21
 *
 * 3. 无重复字符的最长子串
 *
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {


    /**
     * 暴力求解
     *
     * @param s 给定的条件字符串
     * @return 返回长度
     */
    public static int lengthOfLongestSubstring2(String s) {

        int length = s.length();

        char[] chars = s.toCharArray();

        //这里习惯对长度进行判断 代码不美观
        if (length == 0) {
            return 0;
        }
        int result = 0;
        //遍历字符串
        for (int i = 0; i < length; i++) {
            Set<Character> characterSet = new HashSet<>();
            characterSet.add(chars[i]);
            int j;
            for (j = i + 1; j < length; j++) {
                //如果包含跳出外侧循环
                if (characterSet.contains(chars[j])) {
                    break;
                } else {
                    characterSet.add(chars[j]);
                }
            }

            result = Math.max(result, j - i);
        }

        return result;
    }


    /**
     * 滑动窗口法 设置两个指针 游走
     * <p>
     * 这道题在网上看过 so。。。。
     * abc abc
     * ->
     * i j
     *
     * @param s 给定的条件字符串
     * @return 返回长度
     */
    public static int lengthOfLongestSubstring(String s) {

        //这里习惯对长度进行判断 代码不美观
        if (s.length() == 0) {
            return 0;
        }

        // 设置两个指针
        int i = 0, j = 1, result = 1;

        Set<Character> characterSet = new HashSet<>(16);
        char[] chars = s.toCharArray();

        characterSet.add(chars[0]);
        int length = s.length();

        //这里只需要判断后面的指针到头没
        while (i < length && j < length) {
            if (!characterSet.contains(chars[j])) {
                characterSet.add(chars[j]);
                j++;
                result = Math.max(result, j - i);
            } else {
                //移除掉前一个元素
                characterSet.remove(chars[i]);
                i++;
            }
        }


        return result;
    }


    /**
     * 滑动窗口法 设置两个指针 游走
     * <p>
     * 优化版：
     * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
     * <p>
     * 直接扒的官方题解
     * <p>
     * abc abc
     * ->
     * i j
     *
     * @param s 给定的条件字符串
     * @return 返回长度
     */
    public static int lengthOfLongestSubstring3(String s) {

        int n = s.length(), ans = 0;

        // 利用map记录 key - char  ,  value - index
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            //如果在j的位置上发现元素存在 将i替换成当前的j
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }


    public static void main(String[] args) {


        String testStringA = "abcabcbb";

        String testStringB = "bbbbb";

        String testStringC = "pwwkew";

        System.out.println(lengthOfLongestSubstring(testStringA));

        System.out.println(lengthOfLongestSubstring(testStringB));

        System.out.println(lengthOfLongestSubstring(testStringC));


        System.out.println(lengthOfLongestSubstring2(testStringA));

        System.out.println(lengthOfLongestSubstring2(testStringB));

        System.out.println(lengthOfLongestSubstring2(testStringC));
    }


}
