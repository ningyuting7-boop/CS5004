package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFreq {

  public static void countFrequency(List<Integer> lst){
    // build a map
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer num: lst){
      if (map.containsKey(num)){
        map.put(num, map.get(num) + 1);
      } else{
        map.put(num, 1);
      }
    }
    // iterate a map to calculate the frequency
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      System.out.println(entry.getKey() + " → " + entry.getValue() / (double)lst.size());
    }
  }
  public static void main(String[] args){
    List<Integer> lst = new ArrayList<>(Arrays.asList( 1, 1, 1, 2, 2, 3, 3, 4, 4, 4));
    countFrequency(lst);
  }

}
