import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    public int leastInterval(char[] tasks, int n) {
       int [] nums = new int[26];
       for (int i = 0; i < tasks.length; i++) {
           nums[tasks[i] - 'A'] ++;
       }
       PriorityQueue<Integer> taskList = new PriorityQueue<Integer>(new Comparator<Integer>(){
           @Override
           public int compare(Integer a, Integer b) {
               if (a > b) {
                   return -1;
               }else{
                   return 1;
               }
           }
       });

       for (int i = 0; i < nums.length; i++) {
           if (nums[i] > 0) {
               taskList.add(nums[i]);
           }
       }

       int size = 0;
       while ( taskList.size() > 0) {
        
           List<Integer> list = new ArrayList<Integer>();
           int step = Math.min(taskList.size(), n+1);
           for (int i = 0; i <  step; i++) {
                Integer num = taskList.poll();
                list.add(num - 1);
                size++;
                System.out.print("num = " + num + ",");
           }
     
           for (int i = 0; i < list.size(); i++) {
               int num = list.get(i);
               if (num > 0) {
                   taskList.add(num);
               }
           }
            if (taskList.size() == 0) {
                break;
            } 
           size += (n+1 - list.size());

           System.out.println("size" + size);
       }

       return size;


    }
}
