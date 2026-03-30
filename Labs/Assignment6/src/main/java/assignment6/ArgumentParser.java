package assignment6;

import java.nio.file.Paths;

/**
 * Parses and validates command-line arguments.
 */
public class ArgumentParser {

  /**
   * Creates an argument parser for this program.
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: this object is ready to parse and validate
   * command-line arguments.</p>
   */
  public ArgumentParser() {
  }

  /**
   * Parses and validates the provided command-line arguments.
   *
   * @param args command-line arguments
   * @return a populated CommandLineOptions object
   * @throws IllegalArgumentException if arguments are invalid
   *
   * <p>Precondition: {@code args} is not null.</p>
   *
   * <p>Postcondition: returns a validated CommandLineOptions object that
   * matches the supplied arguments.</p>
   */
  public assignment6.CommandLineOptions parse(String[] args) {
    assignment6.CommandLineOptions options = new assignment6.CommandLineOptions();

    for (int i = 0; i < args.length; i++) {
      String arg = args[i];

      switch (arg) {
        case "--email":
          options.setGenerateEmail(true);
          break;

        case "--letter":
          options.setGenerateLetter(true);
          break;

        case "--email-template":
          ensureValueExists(args, i, "--email-template");
          options.setEmailTemplatePath(Paths.get(args[++i]));
          break;

        case "--letter-template":
          ensureValueExists(args, i, "--letter-template");
          options.setLetterTemplatePath(Paths.get(args[++i]));
          break;

        case "--output-dir":
          ensureValueExists(args, i, "--output-dir");
          options.setOutputDir(Paths.get(args[++i]));
          break;

        case "--csv-file":
          ensureValueExists(args, i, "--csv-file");
          options.setCsvFilePath(Paths.get(args[++i]));
          break;

        default:
          throw new IllegalArgumentException("Unknown argument: " + arg);
      }
    }

    validate(options);
    return options;
  }

  /**
   * Ensures that an option requiring a value actually has one immediately after it.
   *
   * @param args the full command-line argument array
   * @param index the current index of the option
   * @param optionName the option being checked
   * @throws IllegalArgumentException if the required value is missing
   *
   * <p>Precondition: {@code args} and {@code optionName} are not null, and
   * {@code index} identifies an option within {@code args}.</p>
   *
   * <p>Postcondition: returns only when the option is followed by an actual
   * value instead of another flag or the end of the array.</p>
   */
  private void ensureValueExists(String[] args, int index, String optionName) {
    if (index + 1 >= args.length || args[index + 1].startsWith("--")) {
      throw new IllegalArgumentException("Missing value for " + optionName + ".");
    }
  }

  /**
   * Validates parsed options against assignment requirements.
   *
   * @param options parsed command-line options
   * @throws IllegalArgumentException if the combination is invalid
   *
   * <p>Precondition: {@code options} is not null.</p>
   *
   * <p>Postcondition: returns only when the chosen options form a legal
   * command-line invocation for this program.</p>
   */
  private void validate(assignment6.CommandLineOptions options) {
    if (!options.isGenerateEmail() && !options.isGenerateLetter()) {
      throw new IllegalArgumentException(
          "At least one of --email or --letter must be provided.");
    }

    if (options.getOutputDir() == null) {
      throw new IllegalArgumentException("--output-dir is required.");
    }

    if (options.getCsvFilePath() == null) {
      throw new IllegalArgumentException("--csv-file is required.");
    }

    if (options.isGenerateEmail() && options.getEmailTemplatePath() == null) {
      throw new IllegalArgumentException(
          "--email provided but no --email-template was given.");
    }

    if (options.isGenerateLetter() && options.getLetterTemplatePath() == null) {
      throw new IllegalArgumentException(
          "--letter provided but no --letter-template was given.");
    }
  }
}
