package algods.random;

public class Pair<K,V> {
    private K row;
    private V col;

    public Pair(K row, V col){
        this.row = row;
        this.col = col;
    }

    public K getKey(){
        return row;
    }

    public V getValue(){
        return col;
    }
}
