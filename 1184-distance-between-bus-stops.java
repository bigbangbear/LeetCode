/**
 * Definition: 找出两个车站间的最短距离
 */
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for(int i=0; i<distance.length; i++) {
            sum += distance[i];
        }
        int distanceSum = 0;
        if (destination < start) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for (int i=start; i<destination; i++) {
            distanceSum += distance[i];
        }
        
        return Math.min(distanceSum, sum - distanceSum);
    }
}
