package problem1;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class NonProfitTest {

  @Test
  public void testNonProfitTotal(){

    NonProfits org =
        new NonProfits("Test Org");

    OneTimeDonations d1 =
        new OneTimeDonations(
            100,
            LocalDateTime.of(2026,1,1,10,0)
        );

    MonthlyDonations d2 =
        new MonthlyDonations(
            10.0,
            LocalDateTime.of(2026,2,1,10,0)
        );

    org.getAllDonations().add(d1);
    org.getAllDonations().add(d2);

    double total =
        org.getTotalDonationsForYear(2026);

    assertTrue(total > 100);
  }

}
