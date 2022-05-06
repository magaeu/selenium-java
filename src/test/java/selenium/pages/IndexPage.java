package selenium.pages;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class IndexPage extends BasePage {

    private static final String FILE_PATH = "file://";
    private static final String CSV_FILE = "records.csv";
    private static final String INDEX_FILE = "index.html";
    private static final String TABLE_LOCATOR = ".//tbody/tr";

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void openFile() {
        String path = getPath(INDEX_FILE);
        driver.get(FILE_PATH + path);
    }

    public List<WebElement> getContentList() {
        return driver.findElements(By.xpath(TABLE_LOCATOR));
    }

    public List<String> getRecords() throws IOException, CsvException {
        String path = getPath(CSV_FILE);

        try(CSVReader reader = getReader(path)){
            List<String[]> records = reader.readAll();

            return records.stream()
                    .map(x -> String.join(",", x)
                            .replace("\"", "")
                            .replace(",", "")
                            .replace(" ", ""))
                            .collect(Collectors.toList());
        }

    }
    private String getPath(String targetFile) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Objects.requireNonNull(classLoader.getResource(targetFile)).getPath();
    }

    private CSVReader getReader(String path) throws FileNotFoundException {
        return new CSVReaderBuilder(
                new FileReader(path))
                .withCSVParser(getCsvParser())
                .withSkipLines(1)
                .build();
    }

    private CSVParser getCsvParser() {
        return new CSVParserBuilder()
                .withSeparator(';')
                .build();
    }
}
