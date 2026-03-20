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
   * Returns whether email messages should be generated.
   *
   * @return true if email output should be generated
   */
  public boolean isGenerateEmail() {
    return generateEmail;
  }

  /**
   * Sets whether email messages should be generated.
   *
   * @param generateEmail true if email output should be generated
   */
  public void setGenerateEmail(boolean generateEmail) {
    this.generateEmail = generateEmail;
  }

  /**
   * Returns whether letters should be generated.
   *
   * @return true if letter output should be generated
   */
  public boolean isGenerateLetter() {
    return generateLetter;
  }

  /**
   * Sets whether letters should be generated.
   *
   * @param generateLetter true if letter output should be generated
   */
  public void setGenerateLetter(boolean generateLetter) {
    this.generateLetter = generateLetter;
  }

  /**
   * Returns the email template path.
   *
   * @return path to email template
   */
  public Path getEmailTemplatePath() {
    return emailTemplatePath;
  }

  /**
   * Sets the email template path.
   *
   * @param emailTemplatePath path to email template
   */
  public void setEmailTemplatePath(Path emailTemplatePath) {
    this.emailTemplatePath = emailTemplatePath;
  }

  /**
   * Returns the letter template path.
   *
   * @return path to letter template
   */
  public Path getLetterTemplatePath() {
    return letterTemplatePath;
  }

  /**
   * Sets the letter template path.
   *
   * @param letterTemplatePath path to letter template
   */
  public void setLetterTemplatePath(Path letterTemplatePath) {
    this.letterTemplatePath = letterTemplatePath;
  }

  /**
   * Returns the output directory path.
   *
   * @return output directory path
   */
  public Path getOutputDir() {
    return outputDir;
  }

  /**
   * Sets the output directory path.
   *
   * @param outputDir output directory path
   */
  public void setOutputDir(Path outputDir) {
    this.outputDir = outputDir;
  }

  /**
   * Returns the CSV file path.
   *
   * @return CSV file path
   */
  public Path getCsvFilePath() {
    return csvFilePath;
  }

  /**
   * Sets the CSV file path.
   *
   * @param csvFilePath CSV file path
   */
  public void setCsvFilePath(Path csvFilePath) {
    this.csvFilePath = csvFilePath;
  }
}