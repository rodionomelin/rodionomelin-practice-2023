package rodionomelin.com.example;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FileParserImplementation implements FileParser {

    @Override
    public List<String> parseFile(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filePath)), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.addAll(Arrays.asList(line.toLowerCase().split("\\s+")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}