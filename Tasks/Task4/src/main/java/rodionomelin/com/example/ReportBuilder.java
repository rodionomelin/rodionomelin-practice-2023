package rodionomelin.com.example;

import java.io.IOException;

public interface ReportBuilder {
    void buildReport(String filePath) throws IOException;
}