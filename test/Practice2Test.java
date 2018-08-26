import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Practice2Test {

    @Test
    public void TestByteMethod() {
        String source = "ИВАнов иВан  иваНОВИЧ...ИВАнов иВан иваНОВИЧ. . . ";
        String result = "Иванов Иван  Иванович...Иванов Иван Иванович. . . ";
        assertThat(Practice2.firstLetterOfEveryWordHaveToBeBigThroughCharAnalysis(source), is(result));
    }

    @Test
    public void TestStringBuilderMethod() {
//        String source = "ИВАнов иВан иваНОВИЧ...ИВАнов иВан иваНОВИЧ. . . ";
        String source = "ИВАнов иВан иваНОВИЧ.";
        String result = "Иванов Иван Иванович.";
        assertThat(Practice2.firstLetterOfEveryWordHaveToBeBigThroughStringSplit(source), is(result));
    }

}
