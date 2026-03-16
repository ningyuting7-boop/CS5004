package problem1;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class PledgeTest {
  @Test
  public void testPledge(){

    Pledges p =
        new Pledges(
            200,
            LocalDateTime.of(2025,1,1,10,0)
        );

    p.setProcessingDate(
        LocalDateTime.of(2026,6,1,10,0)
    );

    assertEquals(200,p.getTotalForYear(2026));
  }

}
