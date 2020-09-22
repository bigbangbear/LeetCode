class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int gap = needle.length() - 1;
        for (int i=0; i<=haystack.length() - needle.length(); i++) {
            int pre = 0;
            int last = gap;
            while ( pre <= last ) {
                if (haystack.charAt(i + pre) != needle.charAt(pre) ||
                        haystack.charAt(i + last) != needle.charAt(last)) {
                    break;
                } else {
                    pre ++;
                    last --;
                }
            }
            if (pre > last) {
                return i;
            }
        }
        return -1;
    }
}
