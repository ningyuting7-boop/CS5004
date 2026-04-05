package assignment6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads customer information from a CSV file.
 *
 * <p>This reader supports:
 * <ul>
 *   <li>quoted fields</li>
 *   <li>commas inside quoted fields</li>
 *   <li>multiline quoted fields</li>
 *   <li>escaped quotes using "" inside quoted fields</li>
 * </ul>
 */
public class CsvReader {

  /**
   * Creates a CSV reader for customer data.
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: this reader is ready to parse CSV input.</p>
   */
  public CsvReader() {
  }

  /**
   * Reads the CSV file and converts each row into a CustomerRecord.
   *
   * @param csvPath path to the CSV file
   * @return list of customer records
   * @throws IOException if the file cannot be read
   *
   * <p>Precondition: {@code csvPath} is not null and refers to a readable CSV file.</p>
   *
   * <p>Postcondition: returns one CustomerRecord for each nonblank data row
   * in the file.</p>
   */
  public List<CustomerRecord> read(Path csvPath) throws IOException {
    String content = Files.readString(csvPath);
    List<List<String>> rows = parseRows(content);

    if (rows.isEmpty()) {
      return new ArrayList<>();
    }

    List<String> headers = normalizeHeaders(rows.get(0));
    List<CustomerRecord> records = new ArrayList<>();

    for (int rowIndex = 1; rowIndex < rows.size(); rowIndex++) {
      List<String> row = rows.get(rowIndex);
      if (isBlankRow(row)) {
        continue;
      }

      Map<String, String> fields = new LinkedHashMap<>();
      for (int columnIndex = 0; columnIndex < headers.size(); columnIndex++) {
        String header = headers.get(columnIndex);
        String value = columnIndex < row.size() ? row.get(columnIndex) : "";
        fields.put(header, value);
      }

      records.add(new CustomerRecord(fields));
    }

    return records;
  }

  /**
   * Parses the raw CSV content into a list of rows.
   *
   * @param content full CSV file content
   * @return parsed rows
   *
   * <p>Precondition: {@code content} is not null.</p>
   *
   * <p>Postcondition: returns the parsed nonblank rows, or throws an
   * exception if the CSV contains unmatched quotes.</p>
   */
  private List<List<String>> parseRows(String content) {
    List<List<String>> rows = new ArrayList<>();
    List<String> currentRow = new ArrayList<>();
    StringBuilder currentField = new StringBuilder();

    boolean inQuotes = false;

    for (int i = 0; i < content.length(); i++) {
      char ch = content.charAt(i);

      if (ch == '"') {
        if (inQuotes && i + 1 < content.length() && content.charAt(i + 1) == '"') {
          currentField.append('"');
          i++;
        } else {
          inQuotes = !inQuotes;
        }
      } else if (ch == ',' && !inQuotes) {
        currentRow.add(currentField.toString());
        currentField.setLength(0);
      } else if ((ch == '\n' || ch == '\r') && !inQuotes) {
        if (ch == '\r' && i + 1 < content.length() && content.charAt(i + 1) == '\n') {
          i++;
        }

        currentRow.add(currentField.toString());
        currentField.setLength(0);

        if (!isBlankRow(currentRow)) {
          rows.add(currentRow);
        }
        currentRow = new ArrayList<>();
      } else {
        currentField.append(ch);
      }
    }

    if (inQuotes) {
      throw new IllegalArgumentException("CSV file has unmatched quotes.");
    }

    currentRow.add(currentField.toString());
    if (!isBlankRow(currentRow)) {
      rows.add(currentRow);
    }

    return rows;
  }

  /**
   * Normalizes header names.
   *
   * @param headers raw header row
   * @return normalized headers
   *
   * <p>Precondition: {@code headers} is not null.</p>
   *
   * <p>Postcondition: returns lowercase, trimmed header names, removing an
   * initial UTF-8 byte-order mark when present.</p>
   */
  private List<String> normalizeHeaders(List<String> headers) {
    List<String> normalized = new ArrayList<>();

    for (int i = 0; i < headers.size(); i++) {
      String header = headers.get(i);

      if (i == 0 && header.startsWith("\uFEFF")) {
        header = header.substring(1);
      }

      normalized.add(header.trim().toLowerCase());
    }

    return normalized;
  }

  /**
   * Returns whether a row is effectively blank.
   *
   * @param row the row to inspect
   * @return true if all fields are blank
   *
   * <p>Precondition: {@code row} is not null.</p>
   *
   * <p>Postcondition: returns true exactly when every field in the row is null
   * or blank after trimming.</p>
   */
  private boolean isBlankRow(List<String> row) {
    for (String field : row) {
      if (field != null && !field.trim().isEmpty()) {
        return false;
      }
    }
    return true;
  }
}
