import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created by swapnil on 11/21/2016.
 */
public class QuoraOntology {
    private static class Node{
        String val;
        List<Node> child;

        public Node(String val){
            this.val = val;
            child = new ArrayList<>();
        }
    }


    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());
            Map<String, Node> map = new HashMap<>();
            String[] line = br.readLine().split("\\s+");
            Node root = new Node(line[0]);
            Deque<String> stack = new ArrayDeque<String>();
            // System.out.println(Arrays.toString(line));
            int i = 1;
            String currParent = line[0];
            String prevElement  = line[0];
            map.put(line[0], root);
            while( i < line.length){
                if(line[i].equals("(")){
                    stack.push(prevElement);
                    currParent = prevElement;
                }
                else if(line[i].equals(")")){
                    stack.pop();
                    currParent = stack.peek();
                }else {
                    map.put(line[i], new Node(line[i]));
                    map.get(currParent).child.add(map.get(line[i]));
                }
                prevElement = line[i];
                i++;
            }
            n = Integer.parseInt(br.readLine());
            Map<String, List<String>> mapQ = new HashMap<>();
            while(n-- > 0){
                line = br.readLine().split(":");
                line[0] = line[0].trim();
                if(mapQ.containsKey(line[0])){
                    List<String> temp = mapQ.get(line[0]);
                    temp.add(line[1].trim());
                    mapQ.put(line[0], temp);
                }else{
                    List<String> temp = new ArrayList<>();
                    temp.add(line[1].trim());
                    mapQ.put(line[0], temp);
                }
            }
            n = Integer.parseInt(br.readLine());
            while(n-- > 0){
                int count = 0;
                String currLine = br.readLine();
                int index = currLine.indexOf(' ');
                String topic = currLine.substring(0,index);
                String question = currLine.substring(index+1);

                Deque<Node> queue = new ArrayDeque<Node>();
                queue.offer(map.get(topic));
                while(!queue.isEmpty()){
                    Node top = queue.poll();
                    List<String> db = mapQ.get(top.val);
                    if(db != null){
                        for(String s : db){
                            if(s.startsWith(question)) count++;
                        }
                    }
                    for(Node nn : top.child){
                        queue.offer(nn);
                    }
                }
                System.out.println(count);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

