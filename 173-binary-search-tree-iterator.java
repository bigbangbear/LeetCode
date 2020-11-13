class BSTIterator {

    private List<TreeNode> list = new ArrayList<>();
    private int index = 0;
    public BSTIterator(TreeNode root) {
        scan(root);
    }
    
    private void scan(TreeNode root) {
        if (root == null) {
            return;
        }
        scan(root.left);
        list.add(root);
        scan(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        int val = list.get(index).val;
        index++;
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }
}

