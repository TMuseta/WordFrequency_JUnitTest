import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This program reads an input file, parses it into word tokens, count the
 * number of occurrence of each word and print them in descending order.
 */
public class WordFrequencyProcessor {

	// Map to store the word and count in key,value pairs
	private Map<String, Integer> wordMap;

	// Default constructor
	public WordFrequencyProcessor() {
		// initializing map
		wordMap = new HashMap<>();
	}

	/**
	 * This function reads file line by line, parse each line to get word tokens and
	 * put token into map.
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public void readFile(String fileName) throws IOException {
		try {

			// Using buffered reader to read the file.
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line;

			// Looping through line by line till file has a line in it.
			while ((line = reader.readLine()) != null) {
				// Converting each line into lower case letters
				line = line.toLowerCase();
				// Removing all characters other than space, a-z or A-Z
				line = line.replaceAll("[^\\sa-zA-Z]", "");
				// Replacing all whitespaces occurring more than once into single space,
				// then trimming whitespaces from left, right side of the line
				line = line.replaceAll("\\s+", " ").trim();

				// If line is not empty
				if (!line.isEmpty()) {
					// splitting line into words considering space as the delimiter
					String[] s = line.split(" ");
					// For each word in array s, putting it into map
					for (String token : s) {
						// If word is already present, incrementing its count
						if (wordMap.containsKey(token)) {
							Integer count = wordMap.get(token);
							wordMap.put(token, count + 1);
						} else {
							// Otherwise, creating an entry in the map.
							wordMap.put(token, 1);
						}
					} // for
				} // if
			} // while

			reader.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("File not found: " + ex.getMessage());
			throw ex;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occurred: " + e.getMessage());
			throw e;
		}
	}

	//Returns the list of WordFrequency
	public List<WordFrequency> getFrequency() {

		// Creating an linked list to store all entry set
		List<Map.Entry<String, Integer>> linkedMap = new LinkedList<>(wordMap.entrySet());

		// Then linked list is sorted on the basis of value of each entry set, using
		// comparator
		// interface.
		Collections.sort(linkedMap, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return -1 * o1.getValue().compareTo(o2.getValue());
			}
		});

		int num = 1;

		List<WordFrequency> list = new ArrayList<WordFrequency>();
		for (Map.Entry<String, Integer> wordFreq : linkedMap) {
			list.add(new WordFrequency(num, wordFreq.getKey(), wordFreq.getValue()));
			num++;
		}

		return list;
	}
}
