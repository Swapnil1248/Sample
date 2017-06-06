/**
 * Created by swapnil on 6/2/2017.
 */
import java.util.*;
import java.text.*;
public class Asana {

    public static void main(String[] args){
        String[] ans = recurringTask("01/02/4000", 4, new String[]{"Sunday", "Monday"}, 4);
        System.out.println(Arrays.toString(ans));
    }

    public static String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
        String[] ans = new String[n];
        int[] arr = new int[daysOfTheWeek.length];
        for(int i = 0; i < arr.length; i++){
            String day = daysOfTheWeek[i];
            if(day.equals("Sunday")) arr[i] = 1;
            else if(day.equals("Monday")) arr[i] = 2;
            else if(day.equals("Tuesday")) arr[i] = 3;
            else if(day.equals("Wednesday")) arr[i] = 4;
            else if(day.equals("Thursday")) arr[i] = 5;
            else if(day.equals("Friday")) arr[i] = 6;
            else arr[i] = 7;
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            cal.setTime(sdf.parse(firstDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        int z = 0;
        while(z < n){
            System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime()).toString());
            int i = 7;
            while(i-- > 0){
                for(int j = 0; j < arr.length; j++){
                    if(cal.get(Calendar.DAY_OF_WEEK) == arr[j]){
                        ans[z++] = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
                    }
                }
                cal.add(Calendar.DATE, 1);
            }
            cal.add(Calendar.DATE, (k-1)*7);
        }
        return ans;
    }
}
