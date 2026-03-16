package problem1;

import java.time.LocalDateTime;

public class OneTimeDonations extends Donations{
  public OneTimeDonations(double amount, LocalDateTime creationDateTime){
    super(amount, creationDateTime);
  }

  @Override
  public double getTotalForYear(int year){
    double res = 0.0;
    if (getCreationDateTime().getYear() == year) {
      res = getAmount();
    }
    return res;
  }
}
