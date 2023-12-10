package algods.facebook;
/**
 * https://leetcode.com/problems/next-permutation/description/
 * LeetCode   31
 */
public class NextPermutation {
    public void nextPermutation(int[] arr) {
        if(arr == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int pivot = arr.length-2;
        while(pivot>=0 && arr[pivot]>=arr[pivot+1]){
            pivot--;
        }

        if(pivot>=0){
            int j = arr.length-1;
            while(arr[j]<=arr[pivot])
                j--;
            swap(arr,pivot,j);
        }
        reverse(arr,pivot+1);
    }

    private void reverse(int[] arr, int start){
        int end = arr.length-1;
        while(start<=end){
            swap(arr, start,end);
            start++;
            end--;
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,7,9,8,6,4};

        NextPermutation obj = new NextPermutation();
        obj.nextPermutation(arr);
        System.out.print("Next permutation number: ");
        for(int val: arr)
            System.out.println(val);
    }
}
