package Stream;

import java.util.*;

/**
 * Created by swapnil on 4/28/2017.
 */
public class FindFirst {

    public static void main(String[] args){
        Set<Character> set = new HashSet<>();
        LinkedList<Character> unique = new LinkedList<>();
        String str = "GeeksforGeeks";
        for(char c : str.toCharArray()){
//            System.out.println(c);
            if(set.contains(c)){
                unique.remove(Character.valueOf(c));
//                System.out.println(unique);
            }else{
                set.add(c);
                unique.add(c);
            }
            System.out.println(unique.get(0));
        }

    }

}
