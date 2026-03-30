package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Tests for CustomerRecord.
 */
public class CustomerRecordTest {

  @Test
  public void testGetReturnsCorrectValue() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");
    fields.put("last_name", "Venere");

    CustomerRecord record = new CustomerRecord(fields);

    assertEquals("Art", record.get("first_name"));
    assertEquals("Venere", record.get("last_name"));
  }

  @Test
  public void testGetReturnsNullForMissingKey() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");

    CustomerRecord record = new CustomerRecord(fields);

    assertNull(record.get("email"));
  }

  @Test
  public void testGetFieldsReturnsAllFields() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");
    fields.put("email", "art@venere.org");

    CustomerRecord record = new CustomerRecord(fields);
    Map<String, String> result = record.getFields();

    assertEquals(2, result.size());
    assertEquals("Art", result.get("first_name"));
    assertEquals("art@venere.org", result.get("email"));
  }

  @Test
  public void testGetFieldsIsUnmodifiable() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");

    CustomerRecord record = new CustomerRecord(fields);

    assertThrows(UnsupportedOperationException.class,
        () -> record.getFields().put("last_name", "Venere"));
  }

  @Test
  public void testOriginalMapMutationDoesNotAffectRecord() {
    Map<String, String> fields = new LinkedHashMap<>();
    fields.put("first_name", "Art");

    CustomerRecord record = new CustomerRecord(fields);
    fields.put("first_name", "Changed");

    assertEquals("Art", record.get("first_name"));
  }
}
