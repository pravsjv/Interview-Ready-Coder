package algods.facebook.mostfrequent;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class CoursesSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        if(prerequisites == null || numCourses == 0)
            throw new IllegalArgumentException("Input cannot be null.");

        int numCoursesCompleted = 0;
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]]++;
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int course = q.poll();
            numCoursesCompleted++;
            for(int neighbor : adj.get(course)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }
        return numCoursesCompleted==numCourses;
    }
}
