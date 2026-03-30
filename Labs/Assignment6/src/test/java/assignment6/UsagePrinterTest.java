package assignment6;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

/**
 * Tests for UsagePrinter.
 */
public class UsagePrinterTest {

  @Test
  public void testGetUsageTextContainsAllOptions() {
    String usage = UsagePrinter.getUsageText();

    assertTrue(usage.contains("--email"));
    assertTrue(usage.contains("--email-template"));
    assertTrue(usage.contains("--letter"));
    assertTrue(usage.contains("--letter-template"));
    assertTrue(usage.contains("--output-dir"));
    assertTrue(usage.contains("--csv-file"));
  }

  @Test
  public void testGetUsageTextContainsExamples() {
    String usage = UsagePrinter.getUsageText();
    assertTrue(usage.contains("Examples:"));
  }

  @Test
  public void testPrintUsageWritesToStream() {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    PrintStream stream = new PrintStream(buffer);

    UsagePrinter.printUsage(stream);

    String output = buffer.toString();
    assertTrue(output.contains("--email"));
    assertTrue(output.contains("--csv-file"));
  }

  @Test
  public void testPrintUsageDoesNotThrow() {
    assertDoesNotThrow(() -> UsagePrinter.printUsage(System.err));
  }
}
