class Solution {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int top = getTop(num);            
            int left = getLeft(num, top);
            sb.append(help(num, top));
            num = num - left;
        }
        return sb.toString();
    }

    private int getTop(int num) {
        while (num > 9) {
            num /= 10;
        }
        return num;
    }

    private int getLeft(int num, int top) {
        int time = 0;
        while (num > 9) {
            num /= 10;
            if (time == 0) {
                time = 10;
            }else {
                time *= 10;
            }
        }
        if (time > 0) {
            return top * time;
        }else {
            return top;
        }
    }

    private String help(int num, int top) {
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            for (int i =0; i<top; i++) {
                sb.append("M");
            }
            return sb.toString();
        }else if (num >= 100) {
            return getNum(top, 'C', 'D', 'M');
        }else if (num >= 10) {
            return getNum(top, 'X', 'L', 'C');
        }else {
            return getNum(top, 'I', 'V', 'X');
        }
    }

    private String getNum(int top, char one, char five, char ten) {
        StringBuilder sb = new StringBuilder();
        if (top == 9) {
            sb.append(one);
            sb.append(ten);
        } else if (top >= 5) {
            sb.append(five);
            for (int i =0; i<top-5; i++) {
                sb.append(one);
            }
        } else {
            if (top == 4) {
                sb.append(one);
                sb.append(five);
            }else {
                for (int i=0; i<top; i++){
                    sb.append(one);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.intToRoman(58);
        System.out.println(result);
    }
}
