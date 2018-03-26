import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DataScienceBot {
	int wordCount;
	int totalLineCount;
	
	boolean detectWord(String linetoAnalyze, String word, int option) {
		String lineToAnalyzeLowerCase=linetoAnalyze.toLowerCase();
		if (lineToAnalyzeLowerCase.contains(word)) {
			if (option == 1) {
				System.out.println("Detected " + word);
			}
			
			wordCount++;
			return true;
		} else {
			return false;
		}
	}
	void readRedditFile(String fileToRead, String word, int option) {
		try {
			FileReader myFileReader = new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line = null;
			while ((line = myBufferReader.readLine()) != null) {
				if (detectWord(line, word, option) == true) {
					if (option == 1) {
						System.out.println("Line: " + line);
					}
				}
				
				totalLineCount++;
			}
						
			if (option == 1 || option == 2) {
				System.out.println("Total number of lines where the word " + word + " was detected = " + wordCount);
			}
			
			if (option == 2) {
				double percent = (wordCount * 100.0d) / totalLineCount;
				String percentString = new DecimalFormat("##.##").format(percent);
				System.out.println("Total number of lines in the file = " + totalLineCount);
				System.out.println("Your word or phrase was found in " + percentString + "% of the total lines in the data set");
			}
			
			// reset counters so that the next iteration will not accumulate to the previous search
			wordCount = 0;
			totalLineCount = 0;
		} catch (Exception ex) {
			System.out.println("File not found");
		}
	}
}
