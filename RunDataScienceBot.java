import java.util.Scanner;

public class RunDataScienceBot {
	public static void main(String[] args) {
		DataScienceBot myReader = new DataScienceBot();
		String word = null;
		int option = 0;
		int i = 3;
		
		while (i != option) {
			try {
				System.out.println("Please enter a word or phrase that you would like to find in the Reddit Posts Data Set:");
				Scanner userInput = new Scanner(System.in);
				word = userInput.nextLine();
				System.out.println("Now that you entered '" + word + "' you can select the following questions to run data analytics:");
				System.out.println("Enter 1 to find the occureneces where '" + word + "' was detected in the data set");
				System.out.println("Enter 2 to find the percentage of occureneces where '" + word + "' was detected out of the total lines in the data set");
				System.out.println("Enter 3 to Exit Program");
				option = userInput.nextInt();
				System.out.println();
				myReader.readRedditFile("redditPosts.txt", word, option);
				System.out.println();
			} catch (Exception e) {
				System.out.println("Please enter a valid value: exception = " + e.toString());
			}
		}
	}
}
