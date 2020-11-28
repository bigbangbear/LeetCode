class Solution {
    public String largestNumber(int[] nums) {

        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String num1 = a + b;
                String num2 = b + a;
                for (int i= 0; i<num1.length(); i++) {

                    if ( num1.charAt(i) < num2.charAt(i)) {
                        return 1;
                    }else    if ( num1.charAt(i) > num2.charAt(i)) {
                        return -1;
                    }
        
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        boolean isAdd = false;
        for (int i = 0; i < nums.length; i++) {
            if (!isAdd && numStrs[i].equals("0")) {
                continue;
            }
            isAdd = true;
            sb.append(numStrs[i]);
        }
        if (nums.length > 0 && sb.toString().equals("")) {
            return "0";
        }
        return sb.toString();


    }
}
