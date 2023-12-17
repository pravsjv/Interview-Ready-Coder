package algods.arrays;

public class MinimizeMaxElement {
    public int minimizeArrayValue(int[] arr) {
        if(arr == null)
            throw new IllegalArgumentException("Input cannot be null.");

        long result = arr[0];
        int sum = arr[0];
        for(int i=1; i<arr.length; i++) {
            sum += arr[i];
            result = Math.max(result,(sum+i)/(i+1));
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int[] arr = {3,7,1,6};
        MinimizeMaxElement obj = new MinimizeMaxElement();
        System.out.print("Maximum element after minimized: "+obj.minimizeArrayValue(arr));
    }
}
