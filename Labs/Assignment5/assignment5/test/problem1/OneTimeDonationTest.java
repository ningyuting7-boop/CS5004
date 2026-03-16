package problem1;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class OneTimeDonationTest {

  @Test
  public void testCorrectYear(){

    OneTimeDonations d =
        new OneTimeDonations(
            100,
            LocalDateTime.of(2026,3,1,10,0)
        );

    assertEquals(100,d.getTotalForYear(2026));
  }

  @Test
  public void testWrongYear(){

    OneTimeDonations d =
        new OneTimeDonations(
            100,
            LocalDateTime.of(2026,3,1,10,0)
        );

    assertEquals(0,d.getTotalForYear(2025));
  }
}
