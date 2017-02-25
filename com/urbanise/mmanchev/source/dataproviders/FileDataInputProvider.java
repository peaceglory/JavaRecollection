package com.urbanise.mmanchev.source.dataproviders;

import com.urbanise.mmanchev.source.exceptions.DataSourceNotFound;
import com.urbanise.mmanchev.source.utils.PrintUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by mman on 25.02.17.
 */
public class FileDataInputProvider implements DataInputProvider {
    private List<String> data;

    public FileDataInputProvider(String fileName) throws DataSourceNotFound {
        Path filePath = Paths.get(fileName).toAbsolutePath();
        if (!Files.exists(filePath)) {
            throw new DataSourceNotFound("NO such file: " + fileName);
        }
        try {
            data = Files.readAllLines(filePath);
            PrintUtils.printLine("Reading data from: " + fileName);
            data.forEach(PrintUtils::printLine);
            PrintUtils.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // TODO Do something better
        }
    }

    @Override
    public String provide() {
        StringBuilder sb = new StringBuilder();
        data.forEach(line -> {
            sb.append(line);
            sb.append(PrintUtils.NL);
        });
        return sb.toString();
    }
}
