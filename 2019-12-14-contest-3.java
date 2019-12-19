/**
 * Definition:iterator-for-combination
 * 设计迭代器，返回字符串所有的子字符串
 */
class CombinationIterator {


    List<String> keys = new ArrayList<String>();

    public CombinationIterator(String characters, int combinationLength) {
       combine(characters, combinationLength, "");
    }

    private void combine(String character, int combinationLength, String tmp) {
        if (combinationLength == 0 && tmp != null && tmp.length() > 0) {
            keys.add(tmp);
            return;
        }
        for(int i =0; i< character.length(); i++){
            String newTmp = tmp + character.substring(i, i+1);
            String newCharacter = character.substring(i+1, character.length());
            combine(newCharacter, combinationLength -1, newTmp);
        }
    }

    public String next() {
       String key = keys.get(0);
       keys.remove(0);
       return key;
    }

    public boolean hasNext() {
        return keys.size() > 0;
    }

}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
