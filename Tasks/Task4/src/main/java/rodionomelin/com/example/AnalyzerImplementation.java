package rodionomelin.com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class AnalyzerImplementation implements Analyzer {

    private FileParser parser;

    @Autowired
    public void setParser(FileParser parser) {
        this.parser = parser;
    }

    @Override
    public Map<String, Integer> analyze(String filePath) {
        List<String> words = parser.parseFile(filePath);

        Map<String, Integer> wordCountMap = new TreeMap<>(Comparator.reverseOrder());

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return wordCountMap;
    }
}