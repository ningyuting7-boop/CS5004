package problem1;

import java.time.LocalDateTime;
import java.time.Month;

public class MonthlyDonations extends Donations{
  private LocalDateTime cancellationDateTime;
  public MonthlyDonations(Double amount, LocalDateTime creationDateTime){
    super(amount, creationDateTime);
  }

  public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
    if (cancellationDateTime == null){
      throw new NullPointerException("CancellationDateTime can not be null!");
    }
    if (getCreationDateTime().isAfter(cancellationDateTime)){
      throw new IllegalArgumentException("Cancellation Date has to be after creation date!");
    }
    this.cancellationDateTime = cancellationDateTime;
  }

  @Override
  public double getTotalForYear(int year){
    int count = 0;
    LocalDateTime current = creationDateTime;
    while(true){
      if(current.getYear() > year){
        break;
      }
      if(cancellationDateTime != null && current.isAfter(cancellationDateTime)){
        break;
      }
      if(current.getYear() == year){
        count ++;
      }
      current = current.plusMonths(1);
    }
    return count * getAmount();
  }
}
