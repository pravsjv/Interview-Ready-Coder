package algods.facebook.mostfrequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DiagnolTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0)
            throw new IllegalArgumentException("Input cannot be null.");

        int rowLen = mat.length;
        int colLen = mat[0].length;

        int k = 0;
        List<Integer> intermediate = new ArrayList<>();

        int[] result = new int[rowLen*colLen];

        for(int i=0; i<rowLen+colLen; i++) {
            intermediate.clear();

            int row = i<colLen?0:i-colLen+1;
            int col = i<colLen?i:colLen-1;

            while(row < rowLen && col <colLen){
                intermediate.add(mat[row][col]);
                row++;
                col--;
            }
            
            if(i%2 == 1)
                Collections.reverse(intermediate);

            for(int j=0; j<intermediate.size(); j++)
                result[k++] = intermediate.get(j);
        }

        return result;
    }
}
