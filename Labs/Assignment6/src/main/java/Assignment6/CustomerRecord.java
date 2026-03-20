package Assignment6;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents one CSV row as a mapping from header name to value.
 */
public class CustomerRecord {
  private final Map<String, String> fields;

  /**
   * Constructs a customer record from the given field mapping.
   *
   * @param fields mapping of CSV headers to values
   */
  public CustomerRecord(Map<String, String> fields) {
    this.fields = new LinkedHashMap<>(fields);
  }

  /**
   * Returns the value associated with the given field name.
   *
   * @param key CSV header name
   * @return the field value, or null if not found
   */
  public String get(String key) {
    return fields.get(key);
  }

  /**
   * Returns an unmodifiable view of all fields in this record.
   *
   * @return unmodifiable map of fields
   */
  public Map<String, String> getFields() {
    return Collections.unmodifiableMap(fields);
  }
}