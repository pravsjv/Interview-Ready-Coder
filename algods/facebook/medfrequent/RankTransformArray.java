package algods.facebook.medfrequent;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/description/
 * Leetcode: 1331
 */

 import java.util.Map;
 import java.util.HashMap;
public class RankTransformArray {
    public int[] arrayRankTransform(int[] arr) {
        if(arr == null || arr.length==0)
            return arr;

        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int rank = 1;
        int prev = arr[0];

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            if(prev != num)
                rank++;
            map.putIfAbsent(num, rank);
            prev = num;
        }

        for(int i=0; i<result.length; i++){
            result[i] = map.get(result[i]);
        }
        
        return result;
    }
}
