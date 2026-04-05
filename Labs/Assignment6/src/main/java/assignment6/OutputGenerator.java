package assignment6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Writes processed template output to text files.
 */
public class OutputGenerator {

  /**
   * Creates an object that writes generated output files.
   *
   * <p>Precondition: none.</p>
   *
   * <p>Postcondition: this generator is ready to write output files.</p>
   */
  public OutputGenerator() {
  }

  /**
   * Generates one output file per customer record.
   *
   * @param records   customer records
   * @param template  raw template text
   * @param processor template processor
   * @param outputDir directory where files should be written
   * @param prefix    file name prefix such as "email" or "letter"
   * @return list of generated file paths
   * @throws IOException if file creation or writing fails
   *
   * <p>Precondition: all arguments are non-null.</p>
   *
   * <p>Postcondition: creates the output directory if needed, writes one file
   * for each record, and returns the paths of the generated files.</p>
   */
  public List<Path> generateFiles(List<CustomerRecord> records,
      String template,
      TemplateProcessor processor,
      Path outputDir,
      String prefix) throws IOException {
    Files.createDirectories(outputDir);

    List<Path> generatedFiles = new ArrayList<>();

    for (int i = 0; i < records.size(); i++) {
      String content = processor.processTemplate(template, records.get(i));
      Path outputFile = outputDir.resolve(prefix + "-" + (i + 1) + ".txt");
      Files.writeString(outputFile, content, StandardCharsets.UTF_8);
      generatedFiles.add(outputFile);
    }

    return generatedFiles;
  }
}
