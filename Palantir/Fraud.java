package Palantir;

import java.util.*;
/**
 * Created by swapnil on 3/8/2017.
 */
public class Fraud {

    private static class DayandFraud implements Comparable<DayandFraud>{
        int day;
        String name;

        public DayandFraud(int day, String name){
            this.day = day;
            this.name = name;
        }

        public String toString(){
            return day +" | "+name;
        }

        public int compareTo(DayandFraud other) {
            return this.day == other.day ? this.name.compareTo(other.name): Integer.compare(this.day, other.day);
        }
    }

    private static class LineDetail{
        long price;
        String name;
        boolean transaction;
        long amount;

        LineDetail(long price, String name, boolean transaction, long amount){
            this.price = price;
            this.amount = amount;
            this.transaction = transaction;
            this.name = name;
        }
    }
    public static void main(String[] args){
        String[] datafeed = new String[20];
        datafeed[0] = "0|1000";
        datafeed[1] = "0|Shilpa|BUY|30000";
        datafeed[2] = "0|Will|BUY|50000";
        datafeed[3] = "0|Tom|BUY|40000";
        datafeed[4] = "0|Kristi|BUY|15000";
        datafeed[5] = "1|Kristi|BUY|11000";
        datafeed[6] = "1|Tom|BUY|1000";
        datafeed[7] = "1|Will|BUY|19000";
        datafeed[8] = "1|Shilpa|BUY|25000";
        datafeed[9] = "2|1500";
        datafeed[10] = "2|Will|SELL|7000";
        datafeed[11] = "2|Shilpa|SELL|8000";
        datafeed[12] = "2|Kristi|SELL|6000";
        datafeed[13] = "2|Tom|SELL|9000";
        datafeed[14] = "3|500";
        datafeed[15] = "38|1000";
        datafeed[16] = "78|Shilpa|BUY|30000";
        datafeed[17] = "79|Kristi|BUY|60000";
        datafeed[18] = "80|1100";
        datafeed[19] = "81|1200";
        Set<DayandFraud> set = new Fraud().findFraudolentTraders(datafeed);
        for(DayandFraud s : set){
            System.out.println(s);
        }
    }

    public Set<DayandFraud> findFraudolentTraders(String[] dataFeed){
        Set<DayandFraud> set = new TreeSet<>();
        Map<Integer, List<LineDetail>> map = new HashMap<>();
        long currentPrice = 0;
        for(String feed : dataFeed){
            String[] vals = feed.split("\\|");
            if(vals.length == 2){
                int day = Integer.parseInt(vals[0]);
                currentPrice = Long.parseLong(vals[1]);
                for(int i = day-3; i < day; i++){
                    if(map.containsKey(i)){
                        for(LineDetail l : map.get(i)){
                            boolean fraud = false;
                            if(l.transaction){
                                fraud = (currentPrice - l.price) * l.amount >= 500000;
                            }else{
                                fraud = ( l.price - currentPrice) * l.amount >= 500000;
                            }
                            if(fraud){
                                set.add(new DayandFraud(i, l.name));
                            }
                        }
                    }
                }
            }else{
                int day = Integer.parseInt(vals[0]);
                String name = vals[1];
                boolean isBuy = vals[2].equals("BUY");
                long amount = Long.parseLong(vals[3]);
                if(!map.containsKey(day)){
                    map.put(day, new ArrayList<>());
                }
                List<LineDetail> temp = map.get(day);
                temp.add(new LineDetail(currentPrice, name, isBuy, amount));
            }
        }
        return set;
    }
}
