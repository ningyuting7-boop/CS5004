package problem1;

import java.time.LocalDateTime;

public class Pledges extends Donations{
  private LocalDateTime processingDate;

  public Pledges(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  public void setProcessingDate(LocalDateTime date) {
    if (date != null && date.isBefore(creationDateTime)) {
      throw new IllegalArgumentException();
    }
    this.processingDate = date;
  }

  @Override
  public double getTotalForYear(int year) {
    if (processingDate != null && processingDate.getYear() == year) {
      return amount;
    }
    return 0;
  }
}
