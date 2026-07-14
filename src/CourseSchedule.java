package src;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{0,1}};
        int numCourses = 2;
        int n = prerequisites.length;
        int [] in = new int [numCourses];
        int [] used = new int [numCourses];
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < numCourses ;i++){
            map.put(i,new ArrayList());
        }
        for(int i = 0; i < n;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            in[a]++;
            map.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n;i++){
            if(in[i] == 0){
                q.add(i);
                used[i] = 1;
            }
        }


        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> list = map.get(curr);
            for(Integer a : list.toArray(new Integer [0])){
                in[a]--;
                if(in[a] == 0 && used[a] == 0){
                    q.add(a);
                    used[a] = 1;
                }
            }
        }

        for(int i = 0; i < numCourses;i++){
            if(used[i] == 0){
                System.out.println(false);
            }
        }
        System.out.println(true);

    }
}