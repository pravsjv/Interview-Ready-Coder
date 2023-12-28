package algods.facebook.mostfrequent;

public class MaximumSwap {
    public int maximumSwap(int num) {
        if(num < 10)
            return num;

        char[] digits = Integer.toString(num).toCharArray();
        int[] lastOccurrance = new int[10];

        for(int i=0; i<digits.length; i++){
            lastOccurrance[digits[i]-'0'] = i;
        }

        for(int i=0; i<digits.length; i++){
            for(int d=9; d>=digits[i]-'0'; d--){
                if(lastOccurrance[d] > i){
                    char temp = digits[i];
                    digits[i] = digits[lastOccurrance[d]];
                    digits[lastOccurrance[d]] = temp;
                    return Integer.parseInt(new String(digits)); 
                }
            }
        }
        return num;
    }

    // Time Complexity: O(N) lastOccurrance is O(N)
    // Space Complexity: O(1)

    public static void main(String[] args) {
        MaximumSwap obj = new MaximumSwap();
        System.out.println(obj.maximumSwap(2736)); // 7236
        System.out.println(obj.maximumSwap(9973)); // 9973
    }
}
