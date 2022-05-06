package selenium.tests;

import com.opencsv.exceptions.CsvException;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import selenium.pages.IndexPage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class IndexFileTests extends BaseTest {

    @Test
    public void checkListContentTest() throws IOException, URISyntaxException, CsvException {
        IndexPage indexPage = openIndexFile();
        List<WebElement> indexContentElements = indexPage.getContentList();
        List<String> indexContent = getContent(indexContentElements);
        Collections.sort(indexContent);
        List<String> records = indexPage.getRecords();
        Collections.sort(records);
        assertEquals(records, indexContent);
    }

    private IndexPage openIndexFile() {
        IndexPage indexFile = new IndexPage(driver);
        indexFile.openFile();
        return indexFile;
    }

    private List<String> getContent(List<WebElement> indexContentElements) {
        return indexContentElements.stream().map(WebElement::getText).map(x->x.replace(" ", "")).collect(Collectors.toList());
    }
}
