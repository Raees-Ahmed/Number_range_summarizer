package numberrangesummarizer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Collection;

public class ImplementationTest {
	
	private final NumberRangeSummarizer summarizer = new Implementation();
	
	@Test
    public void testSummarizeCollection_SingleValue() {
        Collection<Integer> input = summarizer.collect("5");
        String output = summarizer.summarizeCollection(input);
        assertEquals("5", output);
    }
	
	
	@Test
    public void testSummarizeCollection_Multiplevaues_noRanges() {
        Collection<Integer> input = summarizer.collect("5,9,13,17,22");
        String output = summarizer.summarizeCollection(input);
        assertEquals("5,9,13,17,22", output);
    }
	
	@Test
    public void testSummarizeCollection_SingleRnage() {
        Collection<Integer> input = summarizer.collect("1,2,3,4,5,6");
        String output = summarizer.summarizeCollection(input);
        assertEquals("1-6", output);
    }
	
	@Test
    public void testSummarizeCollection_MultipleRanges() {
        Collection<Integer> input = summarizer.collect("5,6,7,8,9,13,15,17,22,23,24");
        String output = summarizer.summarizeCollection(input);
        assertEquals("5-9,13,15,17,22-24", output);
    }
	@Test
    public void testSummarizeCollection_Emptyinput() {
        Collection<Integer> input = summarizer.collect("");
        String output = summarizer.summarizeCollection(input);
        assertEquals("", output);
    }
	
	@Test
    public void testSummarizeCollection_Negative_and_positiveRanges() {
        Collection<Integer> input = summarizer.collect("-22,-21,-20,-19,-18,-12,-9,-8,-7,-6,0,1,2,3,4,7,9,13,14,15,16");
        String output = summarizer.summarizeCollection(input);
        assertEquals("-22--18,-12,-9--6,0-4,7,9,13-16", output);
    }

}
