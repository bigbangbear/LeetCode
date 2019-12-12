/**
 * 题目：把字符串分割为回文字符串
 * 思路：递归的思路求解
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        if (s.length() == 1) {
            // 数组长度为 1，肯定是回文数组直接添加
            add(result, s);
        } else {
            // 数组长度大于 1
            // 截取子数组进行回文递归处理
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                if (isPalindrome(sub)) {
                    List<List<String>> subList = new ArrayList<>();
                    if (i <= s.length() - 1) {
                        // 递归找出子字符串中的回文数组
                        subList = partition(s.substring(i));
                    }
                    if (subList.size() == 0) {
                        add(subList, sub);
                    } else {
                        for (List<String> list : subList) {
                            list.add(0, sub);
                        }
                    }
                    result.addAll(subList);
                }
            }
        }
        return result;
    }

    private void add(List<List<String>> lists, String s) {
        List<String> list = new ArrayList<>();
        list.add(s);
        lists.add(list);
    }

    private boolean isPalindrome(String s) {

        for (int i = 0; s != null && i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
