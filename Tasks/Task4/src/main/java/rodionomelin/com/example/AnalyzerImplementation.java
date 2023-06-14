package rodionomelin.com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

        Map<String, Integer> wordCountMap = new TreeMap<>();

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }
}