package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Implementation implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        Collection<Integer> numbers = new ArrayList<>();
        
        for (String numberString : input.split(",")) {
        	if(numberString.length()==0 ) {
        		
        		numbers.clear();
        	}
        	else {
            numbers.add(Integer.parseInt(numberString.trim()));
        	}
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<String> ranges = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return "";
        }

        int numbercounter=0;
        int startRange = input.iterator().next();
        int endRange = startRange;

        for (int current : input) {
            if (current == endRange + 1 || numbercounter==0) {
                endRange = current;
                numbercounter+=1;
            } else {
                ranges.add(getRange(startRange, endRange));
                startRange = current;
                endRange = current;
                numbercounter+=1;
            }
        }

        ranges.add(getRange(startRange, endRange));
        return String.join(",", ranges);
    }

    private static String getRange(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        } else {
            return start + "-" + end;
        }
    }
}
