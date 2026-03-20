package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests for OutputGenerator.
 */
public class OutputGeneratorTest {

  @TempDir
  Path tempDir;

  @Test
  public void testGeneratesOutputFiles() throws IOException {
    List<CustomerRecord> records = new ArrayList<>();

    Map<String, String> first = new LinkedHashMap<>();
    first.put("first_name", "Art");
    first.put("email", "art@venere.org");
    records.add(new CustomerRecord(first));

    Map<String, String> second = new LinkedHashMap<>();
    second.put("first_name", "Jane");
    second.put("email", "jane@example.com");
    records.add(new CustomerRecord(second));

    TemplateProcessor processor = new TemplateProcessor();
    OutputGenerator generator = new OutputGenerator();

    String template = "To:[[email]]\nDear [[first_name]],";
    Path outputDir = tempDir.resolve("output");

    List<Path> files = generator.generateFiles(
        records, template, processor, outputDir, "email");

    assertEquals(2, files.size());

    Path firstFile = outputDir.resolve("email-1.txt");
    Path secondFile = outputDir.resolve("email-2.txt");

    assertTrue(Files.exists(firstFile));
    assertTrue(Files.exists(secondFile));

    assertEquals("To:art@venere.org\nDear Art,", Files.readString(firstFile));
    assertEquals("To:jane@example.com\nDear Jane,", Files.readString(secondFile));
  }
}