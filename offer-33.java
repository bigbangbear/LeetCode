class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null && postorder.length == 0) {
            return true;
        }
        return help(postorder, 0, postorder.length-1);
    }

    public boolean help(int[] postorder, int left, int right) {
       
        if (left == right) {
            return true;
        }
        int i = left;
        for (; i<right; i++) {
            if (postorder[i] > postorder[right]) {
                break;
            }
        }
        int leftL = i - left;
        int rightL = right - i;
        if (leftL > 0) {
            for (int j=left; j<left+leftL; j++) {
                if (postorder[j] > postorder[right]) {
                    return false;
                }
            }
            if (!help(postorder, left, left + leftL - 1)) {
                return false;
            }
        }
        if (rightL > 0) {
            for (int j=i; j<right; j++) {
                if (postorder[j] < postorder[right]) {
                    return false;
                }
            }
            if (!help(postorder, i, right -1)) {
                return false;
            }
        }
        return true;
    }
}
