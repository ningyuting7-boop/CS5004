package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



/*Class Swimmer contains information about a swimmer, and the list of their swimming times, when swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke, and freestyle.

 */

public class Swimmer implements Comparable<Swimmer> {

  private String name;
  private List<Double> butterfly50mTimes; private List<Double> backstroke50mTimes; private List<Double> breaststroke50mTimes; private List<Double> freestyle50mTimes;

  public Swimmer(String name, List<Double> freestyle50mTimes){
    this.name = name;
    this.freestyle50mTimes = freestyle50mTimes;
  }
  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
      List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breaststroke50mTimes = breaststroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  public String getName() {
    return name;
  }

  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }

  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }

  public List<Double> getBreaststroke50mTimes() {
    return breaststroke50mTimes;
  }

  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

  // compare by average of feelstyle time
  @Override
  public int compareTo(Swimmer otherSwimmer) {
    double sumOther = 0;
    List<Double> lst1 = otherSwimmer.getFreestyle50mTimes();
    for(Double time: lst1){
      sumOther += time;
    }

    double sumThis = 0;
    List<Double> lst2 = freestyle50mTimes;
    for(Double time: lst2){
      sumThis += time;
    }

    return Double.compare(sumThis / (double)lst2.size(), sumOther /(double)lst1.size());
  }

  // test compareTo in main
  public static void main(String[] args) {
    Swimmer s1 = new Swimmer("Alice", Arrays.asList(25.0, 26.0, 24.5));
    Swimmer s2 = new Swimmer("Bob", Arrays.asList(23.0, 22.5, 24.0));
    Swimmer s3 = new Swimmer("Charlie", Arrays.asList(26.0, 27.0, 25.5));
    // compare independently
    System.out.println("s1 vs s2: " + s1.compareTo(s2)); // >0 means slower
    System.out.println("s2 vs s1: " + s2.compareTo(s1));
    // add object to List, sort it
    List<Swimmer> swimmers = new ArrayList<>();
    swimmers.add(s1);
    swimmers.add(s2);
    swimmers.add(s3);

    Collections.sort(swimmers);
    System.out.println("\nAfter sorting (fastest first):");
    for (Swimmer s : swimmers) {
      System.out.println(s.getName());
    }
  }
}
