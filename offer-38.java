class Solution {
        public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        s = sort(s);
        List<String> result = new LinkedList<>();
        boolean[] used = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        help(s, result, used, sb, 0);

        return result.toArray(new String[0]);

    }

    private String sort(String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private void help(String s, List<String> result, boolean[] used, StringBuilder sb, int index) {
        if (index >= s.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }
            sb.append(s.charAt(i));
            used[i] = true;

            help(s, result, used, sb, index + 1);

            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }
        }
    }
}
