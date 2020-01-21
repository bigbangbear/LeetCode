class Solution {
    public boolean isLongPressedName(String name, String typed) {

        int indexOfName = 0;
        for(int i=0; i<typed.length(); i++) {
            char charOfName = name.charAt(indexOfName);
            char charOfTyped = typed.charAt(i);
            if (i == 0) {
                if (charOfName != charOfTyped) {
                    return false;
                }
            }
            if (charOfName == charOfTyped) {
                if (indexOfName < name.length()-1) {
                    char next = name.charAt(indexOfName + 1);
                    if (next == charOfName) {
                        indexOfName++;
                    }
                }
            }else {
                if (indexOfName < name.length()-1) {
                    char next = name.charAt(indexOfName + 1);
                    if(next == charOfTyped) {
                        indexOfName++;
                    }else {
                        return false;
                    }
                }
            }
        }
        return indexOfName == name.length() -1;
    }

}

