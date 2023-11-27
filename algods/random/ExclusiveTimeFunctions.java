package algods.random;
import java.util.List;
import java.util.Stack;
public class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs){
        if(logs == null || logs.size()==0)
            throw new IllegalArgumentException("Input cannot be null.");

        var exclusiveTime = new int[n];
        var stack = new Stack<Integer>();

        String[] function = logs.get(0).split(":");
        stack.push(Integer.parseInt(function[0]));
        int i=1, prev = Integer.parseInt(function[2]);

        while(i < logs.size()){
            function = logs.get(i).split(":");
            if(function[1].equals("start")){
                if(!stack.isEmpty())
                    exclusiveTime[stack.peek()] += Integer.parseInt(function[2])-prev;
                stack.push(Integer.parseInt(function[0]));
                prev = Integer.parseInt(function[2]);
            } else {
                exclusiveTime[stack.peek()] += Integer.parseInt(function[2])-prev+1;
                stack.pop();
                prev = Integer.parseInt(function[2])+1;
            }
            i++;
        }
        return exclusiveTime;
    }
}
