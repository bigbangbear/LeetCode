class Solution {
    public boolean checkValidString(String s) {

        ArrayList<Character> list = new ArrayList<>();

        return true;
    }

    private boolean isValidString(String s, int index, List<Character> list){
        if (index >= s.length() && list.size() == 0){
            return true;
        }
        for (int i = index; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') {
                list.add(c);
            }else if( c == ')' ){
                if (list.size() <= 0){
                    return false;
                }
                char c = list.get(list.size() - 1);
                if (c == ')'){
                    return false;
                }
                list.remove(list.size() - 1);
            }else if (c == '*'){
                List<Character> list = 
            }
        }

    }
}
