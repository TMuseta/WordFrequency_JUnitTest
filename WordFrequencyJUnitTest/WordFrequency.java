//Class containing word and it's frequency
public class WordFrequency {

	private int serialNumber;
	private String word;
	private int count;

	// No args constructor
	public WordFrequency() {

	}

	// Constructor that initializes fields.
	public WordFrequency(int serialNumber, String word, int count) {
		super();
		this.serialNumber = serialNumber;
		this.word = word;
		this.count = count;
	}

	// Getters and Setters
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
