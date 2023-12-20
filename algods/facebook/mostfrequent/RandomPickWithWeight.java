package algods.facebook.mostfrequent;

public class RandomPickWithWeight {
    private int[] prefixWeights;
    private int totalSum;
    public RandomPickWithWeight(int[] weights){
        if(weights == null || weights.length == 0)
            throw new IllegalArgumentException("Weights array cannot be null.");

        prefixWeights = new int[weights.length];
        int prefixSum = 0;
        for(int i=0; i<weights.length; i++){
            prefixSum += weights[i];
            prefixWeights[i] = prefixSum;
        }
        totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = totalSum*Math.random();

        int low = 0;
        int high = prefixWeights.length;

        while(low < high){
            int mid = low+(high-low)/2;

            if(target > prefixWeights[mid])
                low = mid+1;
            else 
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {1,3};

        RandomPickWithWeight obj = new RandomPickWithWeight(weights);

        System.out.println(obj.pickIndex());
    }
}
