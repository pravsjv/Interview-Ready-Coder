package algods.facebook.medfrequent;

public class MovingAvgDataStream {
    private int size,head=0,count=0, winSum=0;
    private int[] q;
    public MovingAvgDataStream(int size){
        this.size = size;
        q = new int[size];
    }

    public double next(int val) {
        ++count;
        int tail = (head+1)%size;
        winSum = winSum+val-q[tail];
        head = (head+1)%size;
        q[head] = val;
        return winSum*1.0/Math.min(count,size);
    }
}

// Time Complexity: O(1)
// Time Complexity: O(N)
