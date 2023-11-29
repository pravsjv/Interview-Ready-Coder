package algods.random;

public class QuickUnionRankOpt {
    private int[] root;
    private int[] rank;
    private int count;

    public QuickUnionRankOpt(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        for(int i=0; i<size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int find(int x){
        if(x == root[x])
            return x;
        return root[x]=find(root[x]);
    }

    // code written specific to problem of Number of Provinces
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
        }
    }

    // method written specific to leetcode problem 261
    public boolean unionBoolean(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            return true;
        }
        return false;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        QuickUnionRankOpt uf = new QuickUnionRankOpt(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
