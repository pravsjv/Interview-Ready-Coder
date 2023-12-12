package algods.facebook.mostfrequent;

import java.util.ArrayList;
public class BuildingsOceanView {
    public int[] findBuildings(int[] heights) {
        // edge case
        if(heights == null)
            throw new IllegalArgumentException("Input cannot be null");

        var list = new ArrayList<Integer>();
        int maxHeight = Integer.MIN_VALUE;
        for(int i=heights.length-1; i>=0; i--){
            if(heights[i] > maxHeight){
                list.add(i);
                maxHeight = heights[i];
            }
        }

        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(list.size()-i-1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {4,2,3,1};
        BuildingsOceanView obj = new BuildingsOceanView();
        int[] result = obj.findBuildings(heights);
        for(int i : result)
            System.out.println(i);
    }
}
