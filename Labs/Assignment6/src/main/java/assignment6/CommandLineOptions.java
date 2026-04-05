package assignment6;

import java.nio.file.Path;

/**
 * Stores validated command-line options for the program.
 */
public class CommandLineOptions {
  private boolean generateEmail;
  private boolean generateLetter;
  private Path emailTemplatePath;
  private Path letterTemplatePath;
  private Path outputDir;
  private Path csvFilePath;

  /**
   * Creates an empty command-line options object.
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: all flags start as false and all paths start as null.</p>
   */
  public CommandLineOptions() {
  }

  /**
   * Returns whether email messages should be generated.
   *
   * @return true if email output should be generated
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: returns whether email generation is currently enabled.</p>
   */
  public boolean isGenerateEmail() {
    return generateEmail;
  }

  /**
   * Sets whether email messages should be generated.
   *
   * @param generateEmail true if email output should be generated
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: future calls to {@code isGenerateEmail()} return
   * {@code generateEmail}.</p>
   */
  public void setGenerateEmail(boolean generateEmail) {
    this.generateEmail = generateEmail;
  }

  /**
   * Returns whether letters should be generated.
   *
   * @return true if letter output should be generated
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: returns whether letter generation is currently enabled.</p>
   */
  public boolean isGenerateLetter() {
    return generateLetter;
  }

  /**
   * Sets whether letters should be generated.
   *
   * @param generateLetter true if letter output should be generated
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: future calls to {@code isGenerateLetter()} return
   * {@code generateLetter}.</p>
   */
  public void setGenerateLetter(boolean generateLetter) {
    this.generateLetter = generateLetter;
  }

  /**
   * Returns the email template path.
   *
   * @return path to email template
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: returns the email template path stored in this object.</p>
   */
  public Path getEmailTemplatePath() {
    return emailTemplatePath;
  }

  /**
   * Sets the email template path.
   *
   * @param emailTemplatePath path to email template
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: the stored email template path becomes
   * {@code emailTemplatePath}.</p>
   */
  public void setEmailTemplatePath(Path emailTemplatePath) {
    this.emailTemplatePath = emailTemplatePath;
  }

  /**
   * Returns the letter template path.
   *
   * @return path to letter template
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: returns the letter template path stored in this object.</p>
   */
  public Path getLetterTemplatePath() {
    return letterTemplatePath;
  }

  /**
   * Sets the letter template path.
   *
   * @param letterTemplatePath path to letter template
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: the stored letter template path becomes
   * {@code letterTemplatePath}.</p>
   */
  public void setLetterTemplatePath(Path letterTemplatePath) {
    this.letterTemplatePath = letterTemplatePath;
  }

  /**
   * Returns the output directory path.
   *
   * @return output directory path
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: returns the output directory path stored in this object.</p>
   */
  public Path getOutputDir() {
    return outputDir;
  }

  /**
   * Sets the output directory path.
   *
   * @param outputDir output directory path
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: the stored output directory path becomes
   * {@code outputDir}.</p>
   */
  public void setOutputDir(Path outputDir) {
    this.outputDir = outputDir;
  }

  /**
   * Returns the CSV file path.
   *
   * @return CSV file path
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: returns the CSV file path stored in this object.</p>
   */
  public Path getCsvFilePath() {
    return csvFilePath;
  }

  /**
   * Sets the CSV file path.
   *
   * @param csvFilePath CSV file path
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: the stored CSV file path becomes {@code csvFilePath}.</p>
   */
  public void setCsvFilePath(Path csvFilePath) {
    this.csvFilePath = csvFilePath;
  }
}
