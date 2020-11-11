class Solution {
  public int compareVersion(String version1, String version2) {
        List<Integer> list1 = getVersion(version1);
        List<Integer> list2 = getVersion(version2);
        int index = 0;
        while (index < list1.size() && index <list2.size()) {
            if (list1.get(index) > list2.get(index)) {
                return 1;
            }else if (list1.get(index) < list2.get(index)) {
                return -1;
            }
            index++;
        }
        if (list1.size() == list2.size()) {
            return 0;
        }else if (list1.size() > list2.size()) {
            return 1;
        }else {
            return -1;
        }
    }

    private List<Integer> getVersion(String version) {
        if (version == null || version.length() == 0) {
            return new ArrayList<>();
        }
        String[] versions = version.split("\\.");
        List<Integer> result  = new ArrayList<>();
        for (int i = versions.length - 1; i >= 0; i--) {
            String versionString = versions[i];
            int num = Integer.parseInt(versionString);
            if (num == 0 && result.size() == 0) {
                continue;
            }
            result.add(0, num);
        }
        return result;
    }
}
