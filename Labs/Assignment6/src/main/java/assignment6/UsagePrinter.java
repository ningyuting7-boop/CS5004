package assignment6;

import java.io.PrintStream;

/**
 * Prints usage information for the program.
 */
public final class UsagePrinter {

  private UsagePrinter() {
    // Utility class
  }

  /**
   * Prints usage information to the given output stream.
   *
   * @param out destination stream
   *
   * <p>Precondition: {@code out} is not null.</p>
   *
   * <p>Postcondition: the full usage message has been written to {@code out}.</p>
   */
  public static void printUsage(PrintStream out) {
    out.println(getUsageText());
  }

  /**
   * Returns the usage text for the program.
   *
   * @return usage text
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: returns the complete usage message shown when the user
   * provides invalid command-line input.</p>
   */
  public static String getUsageText() {
    return "Usage:\n"
        + "--email Generate email messages. If this option is provided, then "
        + "--email-template must also be provided.\n"
        + "--email-template <path/to/file> A filename for the email template.\n"
        + "--letter Generate letters. If this option is provided, then "
        + "--letter-template must also be provided.\n"
        + "--letter-template <path/to/file> A filename for the letter template.\n"
        + "--output-dir <path/to/folder> The folder to store all generated files. "
        + "This option is required.\n"
        + "--csv-file <path/to/file> The CSV file to process. "
        + "This option is required.\n"
        + "\nExamples:\n"
        + "--email --email-template email-template.txt --output-dir emails "
        + "--csv-file customer.csv\n"
        + "--letter --letter-template letter-template.txt --output-dir letters "
        + "--csv-file customer.csv\n"
        + "--email --email-template email-template.txt --letter "
        + "--letter-template letter-template.txt --output-dir output "
        + "--csv-file customer.csv";
  }
}
