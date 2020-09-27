class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && Integer.parseInt(num1) == 0) {
            return "0";
        }
        if (num2.length() == 1 && Integer.parseInt(num2) == 0) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        List<List<Integer>> result= new ArrayList<>();
        for (int i=0; i<num2.length(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<i; j++) {
                list.add(0);
            }
            int num = num2.charAt(num2.length() - 1 - i) - '0';
            System.out.println("num2=" + num);
            if (num == 0) {
                continue;
            }
            int remain = 0;
            for (int j=num1.length()-1; j>= 0; j--) {
                int p = num1.charAt(j) - '0';
                p = p * num + remain;
                if (p > 10) {
                    remain = p / 10;
                    p = p % 10;
                }else {
                    p = p;
                    remain = 0;
                }
                list.add(p);
            }
            if (remain > 0) {
                list.add(remain);
            }
            System.out.println("num1=" + list.toString());
            result.add(list);
        }
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        for (int i=0; i<result.get(result.size()-1).size() ; i++) {
            int num = remain;
            for (int j=0; j<result.size(); j++) {
                if (result.get(j).size() > i) {
                    num += result.get(j).get(i);
                }
            }
            if (num >= 10) {
                remain = num / 10;
                num = num % 10;
            }else {
                remain = 0;
            }
            sb.append(num);
            System.out.println("scan" + num);
        }
        if (remain > 0) {
            sb.append(remain);
        }
        return sb.reverse().toString();
    }


}
