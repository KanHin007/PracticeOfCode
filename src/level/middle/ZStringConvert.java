package level.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lawrence
 * <p>
 * Z型变换
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZStringConvert {


    /**
     * 常规方法
     * 按列计数
     *
     * 官方写的这个方法的代码比较精简利用了 取反符号
     *
     * @param content
     * @param numRows
     * @return
     */
    public static String convert(String content, int numRows) {

        if (numRows == 1) {
            return content;
        }

        List<StringBuilder> rows = new ArrayList<>();
        //首先初始化 三个stringBuilder
        for (int i = 0; i < Math.min(numRows, content.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;

        //利用一个变量存储方向
        boolean goingDown = false;

        for (char c : content.toCharArray()) {
            rows.get(curRow).append(c);
            //如果当前处于第一行或者最后一行 就去相反的布尔
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }

        return ret.toString();
    }

    /**
     * 找寻规律直接求
     *
     * 1     5    9
     * 2  4  6  8 10
     * 3     7    11
     *
     *
     * 1           7               13
     * 2       6   8          12
     * 3   5       9     11
     * 4           10
     *
     *
     *
     * todo 公式没明白 需要反复理解
     *
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convertImprove(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }


        return null;
    }


    public static void main(String[] args) {

        System.out.println(convert("LEETCODEISHIRING", 3));


    }

}
