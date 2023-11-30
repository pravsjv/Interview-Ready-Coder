package algods.graphs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0)
            throw new IllegalArgumentException("Input cannot be null");

        int len = isConnected.length;
        
        QuickUnionRankOpt uf = new QuickUnionRankOpt(len);
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(isConnected[i][j] == 1)
                    uf.union(i,j);
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();

        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        int numProvinces = obj.findCircleNum(isConnected);
        System.out.println(numProvinces);
    }
}
