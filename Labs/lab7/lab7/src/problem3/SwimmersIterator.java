package problem3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import problem2.Swimmer;

public class SwimmersIterator implements Iterator<Swimmer> {
  private List<Swimmer> swimmers;
  private int currentIndex;
  private Swimmer nextSwimmer;
  private static final double OLYMPIC_QUALIFY_TIME = 26.17;

  public SwimmersIterator(List<Swimmer> swimmers) {
    this.swimmers = swimmers;
    this.currentIndex = 0;
    this.nextSwimmer = null;
  }

  @Override
  public boolean hasNext(){
    if (nextSwimmer != null){
      return true;
    }
    while(currentIndex < swimmers.size()){
      Swimmer candidate = swimmers.get(currentIndex);
      currentIndex ++;
      if (isValid(candidate)){
        nextSwimmer = candidate;
        return true;
      }
    }
    return false;
  }

  @Override
  public Swimmer next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more swimmers");
    }
    Swimmer result = nextSwimmer;
    nextSwimmer = null;
    return result;
  }

  private boolean isValid(Swimmer candidate){
    if (candidate.getButterfly50mTimes() == null ||candidate.getButterfly50mTimes().size() < 5) return false;
    List<Double> lst = candidate.getFreestyle50mTimes();
    if (candidate.getFreestyle50mTimes() == null) return false;
    for(Double time: lst){
      if (time <= OLYMPIC_QUALIFY_TIME ) return true;
    }
    return false;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

  // test in main
  public static void main(String[] args) {
    // Create several Swimmer objects
    Swimmer s1 = new Swimmer(
        "Alice",
        Arrays.asList(25.0, 26.0, 24.5, 25.5, 26.1), // Butterfly ≥ 5 times ✅
        Arrays.asList(27.0, 27.5),
        Arrays.asList(28.0, 28.5),
        Arrays.asList(26.0, 26.5) // Freestyle ≤ 26.17 ✅
    );

    Swimmer s2 = new Swimmer(
        "Bob",
        Arrays.asList(25.0, 26.0, 24.5), // Butterfly < 5 times ❌
        Arrays.asList(27.0, 27.5),
        Arrays.asList(28.0, 28.5),
        Arrays.asList(25.5, 26.1) // Freestyle ≤ 26.17 ✅
    );

    Swimmer s3 = new Swimmer(
        "Charlie",
        Arrays.asList(25.5, 26.0, 25.5, 25.7, 25.8), // Butterfly ≥ 5 times ✅
        Arrays.asList(27.0, 27.5),
        Arrays.asList(28.0, 28.5),
        Arrays.asList(26.5, 26.8) // Freestyle > 26.17 ❌
    );

    Swimmer s4 = new Swimmer(
        "Dana",
        Arrays.asList(25.0, 25.2, 25.1, 24.9, 25.3), // Butterfly ≥ 5 times ✅
        Arrays.asList(27.0, 27.5),
        Arrays.asList(28.0, 28.5),
        Arrays.asList(25.9, 26.1) // Freestyle ≤ 26.17 ✅
    );

    List<Swimmer> runners = Arrays.asList(s1, s2, s3, s4);

    // Use SwimmersIterator
    SwimmersIterator it = new SwimmersIterator(runners);

    System.out.println("Swimmers who meet the criteria:");
    while (it.hasNext()) {
      Swimmer s = it.next();
      System.out.println(s.getName());
    }
  }
}
