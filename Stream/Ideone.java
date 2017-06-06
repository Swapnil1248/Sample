/* package whatever; // don't place package name! */
package Stream;
import java.util.*;
import java.lang.*;
import java.util.Map;
import java.util.HashMap;
public class Ideone
{
    private static class CharacterCount{
        Character c;
        int count;
        public CharacterCount(Character c, int count){
            this.c = c;
            this.count = count;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here

        String s = "BLOOMBERG";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }


        List<CharacterCount> list = new ArrayList<>();
        for(char c : s.toCharArray()){
            list.add(new CharacterCount(c,map.get(c)));
        }

        Collections.sort(list, new Comparator<CharacterCount>(){
        public int compare(CharacterCount a, CharacterCount b){
            return a.count == b.count ? a.c.compareTo(b.c): b.count - a.count;
        }
    });

        StringBuilder sb = new StringBuilder();
        for(CharacterCount item : list){
            sb.append(item.c);
        }

        System.out.println(sb.toString());
    }
}