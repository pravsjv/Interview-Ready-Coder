package algods.random;

import java.util.LinkedList;
import java.util.Deque;
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path == null)
            throw new IllegalArgumentException("Input cannot be null.");

        Deque<String> q = new LinkedList();
        for(String dir : path.split("/")){
            if(dir.equals("..")){
                if(!q.isEmpty())
                    q.poll();
            } else if(!dir.isEmpty() && !dir.equals(".")){
                q.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append("/").append(q.pollLast());
        }

        return sb.length()!=0?sb.toString():"/";
    }
}
