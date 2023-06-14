package rodionomelin.com.example;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
public class ReportBuilderImplementation implements ReportBuilder {

    private Analyzer analyzer;

    @Autowired
    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void buildReport(String filePath) throws IOException {
        Map<String, Integer> wordCountMap = analyzer.analyze(filePath);

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());

        sortedList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        writeTxt(sortedList, "output.txt");
        writeJson(sortedList, "output.json");
        writeXml(sortedList, "output.xml");
        printToConsole(sortedList);
    }

    private void writeTxt(List<Map.Entry<String, Integer>> wordCountList, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<String, Integer> entry : wordCountList) {
            writer.write(entry.getKey() + ": " + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }

    private void writeJson(List<Map.Entry<String, Integer>> wordCountList, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new FileWriter(fileName), wordCountList);
    }

    private void writeXml(List<Map.Entry<String, Integer>> wordCountList, String fileName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new FileWriter(fileName), wordCountList);
    }

    private void printToConsole(List<Map.Entry<String, Integer>> wordCountList) {
        for (Map.Entry<String, Integer> entry : wordCountList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
