package assignment6;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Entry point for the insurance communication generator program.
 */
public class Main {

  /**
   * Prevents accidental instantiation of this utility class.
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: this class remains a static program entry point only.</p>
   */
  private Main() {
  }

  /**
   * Runs the program using command-line arguments.
   *
   * @param args command-line arguments
   *
   * <p>Precondition: {@code args} is not null.</p>
   *
   * <p>Postcondition: the requested output files are generated, or an error
   * message is printed and the program exits with a non-zero status.</p>
   */
  public static void main(String[] args) {
    try {
      ArgumentParser parser = new ArgumentParser();
      CommandLineOptions options = parser.parse(args);

      CsvReader csvReader = new CsvReader();
      List<CustomerRecord> records = csvReader.read(options.getCsvFilePath());

      TemplateProcessor processor = new TemplateProcessor();
      OutputGenerator generator = new OutputGenerator();

      if (options.isGenerateEmail()) {
        String emailTemplate = Files.readString(options.getEmailTemplatePath());
        generator.generateFiles(records, emailTemplate, processor,
            options.getOutputDir(), "email");
      }

      if (options.isGenerateLetter()) {
        String letterTemplate = Files.readString(options.getLetterTemplatePath());
        generator.generateFiles(records, letterTemplate, processor,
            options.getOutputDir(), "letter");
      }

    } catch (IllegalArgumentException e) {
      System.err.println("Error: " + e.getMessage());
      UsagePrinter.printUsage(System.err);
      System.exit(1);
    } catch (IOException e) {
      System.err.println("I/O error: " + e.getMessage());
      System.exit(1);
    }
  }
}
