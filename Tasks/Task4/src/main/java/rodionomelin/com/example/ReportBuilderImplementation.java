package rodionomelin.com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ReportBuilderImplementation implements ReportBuilder {

    private Analyzer analyzer;

    @Autowired
    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void buildReport(String filePath) {
        Map<String, Integer> wordCountMap = analyzer.analyze(filePath);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCountMap.entrySet());

        //
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}