package com.urbanise.mmanchev.source.dataproviders;

import com.urbanise.mmanchev.source.exceptions.DataSourceNotFound;
import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class gathers useful data from a given file, formats it and provides it to interested clients when needed.
 *
 * @author mmanchev, 25.02.17
 */
public class FileDataInputProvider implements DataInputProvider {
    private final String data;

    /**
     * Constructs a FileDataInputProvider with a file from which the data is read.
     *
     * @param fileName the name of the file from which data is read.
     * @throws DataSourceNotFound if the data source (in this case the file) cannot be found.
     * @throws IOException any error during file read.
     */
    public FileDataInputProvider(String fileName) throws DataSourceNotFound, IOException {
        Path filePath = Paths.get(fileName).toAbsolutePath();
        if (!Files.exists(filePath)) {
            throw new DataSourceNotFound("NO such file: " + fileName);
        }
        List<String> allLines = Files.readAllLines(filePath);
        PrintUtils.printLine("Reading data from: " + fileName);
        allLines.forEach(PrintUtils::printLine);
        PrintUtils.newLine();

        this.data = format(allLines);
    }

    @Override
    public String provide() {
        return data;
    }

    private String format(List<String> input) {
        StringBuilder sb = new StringBuilder();
        input.forEach(line -> {
            sb.append(line);
            sb.append(PrintUtils.NL);
        });
        return sb.toString();
    }
}
