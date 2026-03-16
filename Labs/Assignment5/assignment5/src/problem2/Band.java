package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Band extends Creator {
  private String name;
  private List<Creator> members;

  public Band(String name) {
    this.name = name;
    this.members = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Creator> getMembers() {
    return Collections.unmodifiableList(members);
  }

}
