package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests for CsvReader.
 */
public class CsvReaderTest {

  @TempDir
  Path tempDir;

  @Test
  public void testReadsQuotedCommaCorrectly() throws IOException {
    String csv = "\"first_name\",\"last_name\",\"company_name\",\"email\"\n"
        + "\"Art\",\"Venere\",\"Chemel, James L Cpa\",\"art@venere.org\"\n";

    Path file = tempDir.resolve("customers.csv");
    Files.writeString(file, csv);

    CsvReader reader = new CsvReader();
    List<CustomerRecord> records = reader.read(file);

    assertEquals(1, records.size());
    assertEquals("Art", records.get(0).get("first_name"));
    assertEquals("Venere", records.get(0).get("last_name"));
    assertEquals("Chemel, James L Cpa", records.get(0).get("company_name"));
    assertEquals("art@venere.org", records.get(0).get("email"));
  }

  @Test
  public void testReadsMultipleRows() throws IOException {
    String csv = "\"first_name\",\"last_name\",\"email\"\n"
        + "\"Art\",\"Venere\",\"art@venere.org\"\n"
        + "\"Jane\",\"Doe\",\"jane@example.com\"\n";

    Path file = tempDir.resolve("customers.csv");
    Files.writeString(file, csv);

    CsvReader reader = new CsvReader();
    List<CustomerRecord> records = reader.read(file);

    assertEquals(2, records.size());
    assertEquals("Art", records.get(0).get("first_name"));
    assertEquals("Jane", records.get(1).get("first_name"));
  }

  @Test
  public void testReadsMultilineQuotedField() throws IOException {
    String csv = "\"first_name\",\"last_name\",\"address\",\"email\"\n"
        + "\"Art\",\"Venere\",\"8 W Cerritos Ave\n#54\",\"art@venere.org\"\n";

    Path file = tempDir.resolve("customers.csv");
    Files.writeString(file, csv);

    CsvReader reader = new CsvReader();
    List<CustomerRecord> records = reader.read(file);

    assertEquals(1, records.size());
    assertEquals("8 W Cerritos Ave\n#54", records.get(0).get("address"));
  }
}