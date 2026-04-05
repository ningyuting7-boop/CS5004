package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

/**
 * Tests for CommandLineOptions.
 */
public class CommandLineOptionsTest {

  @Test
  public void testDefaultsAreFalseAndNull() {
    CommandLineOptions options = new CommandLineOptions();

    assertFalse(options.isGenerateEmail());
    assertFalse(options.isGenerateLetter());
    assertNull(options.getEmailTemplatePath());
    assertNull(options.getLetterTemplatePath());
    assertNull(options.getOutputDir());
    assertNull(options.getCsvFilePath());
  }

  @Test
  public void testSetAndGetGenerateEmail() {
    CommandLineOptions options = new CommandLineOptions();
    options.setGenerateEmail(true);
    assertTrue(options.isGenerateEmail());
  }

  @Test
  public void testSetAndGetGenerateLetter() {
    CommandLineOptions options = new CommandLineOptions();
    options.setGenerateLetter(true);
    assertTrue(options.isGenerateLetter());
  }

  @Test
  public void testSetAndGetEmailTemplatePath() {
    CommandLineOptions options = new CommandLineOptions();
    Path path = Paths.get("email-template.txt");
    options.setEmailTemplatePath(path);
    assertEquals(path, options.getEmailTemplatePath());
  }

  @Test
  public void testSetAndGetLetterTemplatePath() {
    CommandLineOptions options = new CommandLineOptions();
    Path path = Paths.get("letter-template.txt");
    options.setLetterTemplatePath(path);
    assertEquals(path, options.getLetterTemplatePath());
  }

  @Test
  public void testSetAndGetOutputDir() {
    CommandLineOptions options = new CommandLineOptions();
    Path path = Paths.get("output");
    options.setOutputDir(path);
    assertEquals(path, options.getOutputDir());
  }

  @Test
  public void testSetAndGetCsvFilePath() {
    CommandLineOptions options = new CommandLineOptions();
    Path path = Paths.get("customers.csv");
    options.setCsvFilePath(path);
    assertEquals(path, options.getCsvFilePath());
  }
}
