package level.easy;

import java.util.ArrayList;

/**
 * @author lawrence
 * 不用转化字符串实现判断是否是回文数
 *
 * 官方题解：
 *
 * 映入脑海的第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。
 *
 * 第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。 但是，如果反转后的数字大于
 * int.MAX
 * int.MAX，我们将遇到整数溢出问题。
 *
 * 按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转
 * int
 * int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
 *
 * 例如，输入 1221，我们可以将数字“1221”的后半部分从“21”反转为“12”，并将其与前半部分“12”进行比较，因为二者相同，我们得知数字 1221 是回文。
 *
 * 让我们看看如何将这个想法转化为一个算法。
 *
 *
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x){

        if(x < 0){
            return false;
        }

        ArrayList<Integer> list = new ArrayList<>();

        int y = 0;
        int remain = x;

        while((y = (remain/10)) > 0){
            int temp = remain - y * 10;
            list.add(temp);
            remain /= 10;
            if(remain < 10){
                list.add(remain);
            }
        }

       // System.out.println(list.toString());

        for(int i = 0 , j = list.size() - 1 ; i < j;i++,j--){
            if(list.get(i).intValue() != list.get(j).intValue())
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }




}
