package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Tests for TemplateProcessor.
 */
public class TemplateProcessorTest {

  @Test
  public void testReplacesSinglePlaceholder() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");

    CustomerRecord record = new CustomerRecord(fields);
    TemplateProcessor processor = new TemplateProcessor();

    String result = processor.processTemplate("Hello [[first_name]]!", record);

    assertEquals("Hello Art!", result);
  }

  @Test
  public void testReplacesMultiplePlaceholders() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");
    fields.put("last_name", "Venere");
    fields.put("email", "art@venere.org");

    CustomerRecord record = new CustomerRecord(fields);
    TemplateProcessor processor = new TemplateProcessor();

    String template = "To:[[email]]\nDear [[first_name]] [[last_name]],";
    String result = processor.processTemplate(template, record);

    assertEquals("To:art@venere.org\nDear Art Venere,", result);
  }

  @Test
  public void testMissingPlaceholderBecomesEmptyString() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");

    CustomerRecord record = new CustomerRecord(fields);
    TemplateProcessor processor = new TemplateProcessor();

    String result = processor.processTemplate("Hello [[middle_name]]!", record);

    assertEquals("Hello !", result);
  }

  @Test
  public void testRepeatedPlaceholderReplacedEverywhere() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");

    CustomerRecord record = new CustomerRecord(fields);
    TemplateProcessor processor = new TemplateProcessor();

    String result = processor.processTemplate(
        "[[first_name]] says hi to [[first_name]].", record);

    assertEquals("Art says hi to Art.", result);
  }
}