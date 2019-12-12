/**
 * 题目：访问所有点的最小时间
 * 解题：可以横、竖走，斜着。因此两点间最短的距离等于坐标点距离差的最大值
 */
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += minTimeToVisit(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
        }
        return sum;
    }

    private int minTimeToVisit(int xPoint1, int yPoint1, int xPoint2, int yPoint2) {
        int x = Math.abs(xPoint1 - xPoint2);
        int y = Math.abs(yPoint1 - yPoint2);
        int max = Math.max(x, y);
        return max;
    }
}

/**
 * 题目：统计参与通信的服务器, 只要坐标方向上有有两台以上电脑就通信
 * 思路：分别计算水平方向上超过两台电脑的数量，保存坐标关系到 Set，最后统计 Set 的长度
 */
class Solution {
    public int countServers(int[][] grid) {

        Set<String> servers = new HashSet<String>();
        // 计算水平方向上能够通信的计算机的坐标
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[i].length && sum <= 1; j++) {
                sum += grid[i][j];
            }
            if (sum > 1) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        servers.add("x=" + i + "y=" + j);
                    }
                }
            }
        }

        // 计算竖直方向上能够通信的计算机的坐标
        for (int i = 0; i < grid[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < grid.length && sum <= 1; j++) {
                sum += grid[j][i];
            }
            if (sum > 1) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[j][i] == 1) {
                        servers.add("x=" + j + "y=" + i);
                    }
                }
            }
        }

        return servers.size();

    }
}

/**
 * 题目：搜索推荐系统
 * 思路：先排序(第一次没通过的原因), 分别比较子字符串匹配字典的数量
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> match = new ArrayList<>();
            String word = searchWord.substring(0, i + 1);
            int size = 0;
            for (String s : products) {
                if (size < 3 && s.length() >= word.length()) {
                    if (word.equals(s.substring(0, i + 1))) {
                        match.add(s);
                        size++;
                    }
                }
            }
            result.add(match);
        }
        return result;
    }
}
