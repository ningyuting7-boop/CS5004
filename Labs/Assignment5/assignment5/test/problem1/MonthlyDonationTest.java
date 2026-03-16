package problem1;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class MonthlyDonationTest {
  @Test
  public void testMonthlyDonation(){

    MonthlyDonations d =
        new MonthlyDonations(
            10.0,
            LocalDateTime.of(2026,2,15,10,0)
        );

    double total = d.getTotalForYear(2026);

    assertEquals(110,total);
  }

  @Test
  public void testCancel(){

    MonthlyDonations d =
        new MonthlyDonations(
            10.0,
            LocalDateTime.of(2026,2,15,10,0)
        );

    d.setCancellationDateTime(
        LocalDateTime.of(2026,5,15,10,0)
    );

    double total = d.getTotalForYear(2026);

    assertEquals(40,total);
  }
}