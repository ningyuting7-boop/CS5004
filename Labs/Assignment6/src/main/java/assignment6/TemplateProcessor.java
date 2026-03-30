package assignment6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Replaces template placeholders such as [[first_name]] using data from a CustomerRecord.
 */
public class TemplateProcessor {
  private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\[\\[(.+?)\\]\\]");

  /**
   * Creates a processor for template text.
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: this processor is ready to replace placeholders in a
   * template.</p>
   */
  public TemplateProcessor() {
  }

  /**
   * Processes a template by replacing all placeholders with values from the record.
   *
   * @param template template text
   * @param record customer record containing field values
   * @return processed output text
   *
   * <p>Precondition: {@code template} and {@code record} are not null.</p>
   *
   * <p>Postcondition: returns the template text with each placeholder
   * replaced by the matching record value, or an empty string if the record
   * does not contain that field.</p>
   */
  public String processTemplate(String template, CustomerRecord record) {
    Matcher matcher = PLACEHOLDER_PATTERN.matcher(template);
    StringBuffer result = new StringBuffer();

    while (matcher.find()) {
      String key = matcher.group(1).trim();
      String replacement = record.get(key);

      if (replacement == null) {
        replacement = "";
      }

      matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
    }

    matcher.appendTail(result);
    return result.toString();
  }
}
