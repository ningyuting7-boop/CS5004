package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

/**
 * Tests for ArgumentParser.
 */
public class ArgumentParserTest {

  @Test
  public void testParseValidEmailOnlyArguments() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--email",
        "--email-template", "email-template.txt",
        "--output-dir", "emails",
        "--csv-file", "customers.csv"
    };

    CommandLineOptions options = parser.parse(args);

    assertTrue(options.isGenerateEmail());
    assertFalse(options.isGenerateLetter());
    assertEquals(Paths.get("email-template.txt"), options.getEmailTemplatePath());
    assertEquals(Paths.get("emails"), options.getOutputDir());
    assertEquals(Paths.get("customers.csv"), options.getCsvFilePath());
  }

  @Test
  public void testParseValidBothModesAnyOrder() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--csv-file", "customers.csv",
        "--letter-template", "letter-template.txt",
        "--email",
        "--output-dir", "output",
        "--letter",
        "--email-template", "email-template.txt"
    };

    CommandLineOptions options = parser.parse(args);

    assertTrue(options.isGenerateEmail());
    assertTrue(options.isGenerateLetter());
    assertEquals(Paths.get("email-template.txt"), options.getEmailTemplatePath());
    assertEquals(Paths.get("letter-template.txt"), options.getLetterTemplatePath());
    assertEquals(Paths.get("output"), options.getOutputDir());
    assertEquals(Paths.get("customers.csv"), options.getCsvFilePath());
  }

  @Test
  public void testMissingOutputDirThrows() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--email",
        "--email-template", "email-template.txt",
        "--csv-file", "customers.csv"
    };

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> parser.parse(args)
    );

    assertEquals("--output-dir is required.", exception.getMessage());
  }

  @Test
  public void testEmailWithoutTemplateThrows() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--email",
        "--output-dir", "emails",
        "--csv-file", "customers.csv"
    };

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> parser.parse(args)
    );

    assertEquals("--email provided but no --email-template was given.",
        exception.getMessage());
  }

  @Test
  public void testNoGenerationModeThrows() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--output-dir", "output",
        "--csv-file", "customers.csv"
    };

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> parser.parse(args)
    );

    assertEquals("At least one of --email or --letter must be provided.",
        exception.getMessage());
  }

  @Test
  public void testMissingValueThrows() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--email",
        "--email-template",
        "--output-dir", "output",
        "--csv-file", "customers.csv"
    };

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> parser.parse(args)
    );

    assertEquals("Missing value for --email-template.", exception.getMessage());
  }

  @Test
  public void testMissingCsvFileThrows() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--email",
        "--email-template", "email-template.txt",
        "--output-dir", "emails"
    };

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> parser.parse(args)
    );

    assertEquals("--csv-file is required.", exception.getMessage());
  }

  @Test
  public void testUnknownArgumentThrows() {
    ArgumentParser parser = new ArgumentParser();

    String[] args = {
        "--email",
        "--email-template", "email-template.txt",
        "--output-dir", "output",
        "--csv-file", "customers.csv",
        "--weird-option"
    };

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> parser.parse(args)
    );

    assertEquals("Unknown argument: --weird-option", exception.getMessage());
  }
}