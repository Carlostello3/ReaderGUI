package application;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class Reader {
	
	@FXML private Label titleText;
	@FXML private Text instruText, instruText2, authorID, exampleText, example1;
	@FXML private TextField urlField;
	@FXML private Button goButton;
	@FXML private TextArea resultsField;
	
	
	//VARIABLES AND METHODS
	
	
	
	public void getURL() throws IOException {
		
		String tempURL = urlField.getText();
		readPage(tempURL);
	}
	
	
	public void readPage(String urlPage) throws IOException {
		
		URL url = new URL(urlPage);
		
		String wordHold = null;
		
		int wordCount = 1;
		
		HashMap <String, Integer> wordList = new HashMap <String, Integer>();
		
		Scanner sc = new Scanner(url.openStream());
		
		//Iterate via scanner and removed undesired characters
		while (sc.hasNext()) {
			wordCount = 1;
			wordHold = sc.next().replaceAll("[0-9, , ,\\s+ ,<$>, /*, . , =, ;, :, !, ', NAME]", "");
			
			
			if (wordList.isEmpty()) {
				wordList.put(wordHold, wordCount);
			} else {
				if (wordList.containsKey(wordHold)) {
					wordCount = wordList.get(wordHold);
					wordCount++;
					wordList.put(wordHold, wordCount);
				} else {
					wordList.put(wordHold, wordCount);
				}
			}
			
			
		}//end of while
		
		//Call method to sort HashMap	
		Map<String, Integer> wordSorted = sortByValue(wordList);
		wordSorted.remove("");
		
		int counter = 0;
		
		//Print map with sorted words
		resultsField.clear();
		for (Map.Entry<String, Integer> lastWordBank : wordSorted.entrySet()) {
			
			if(counter < 20) {
				resultsField.appendText(lastWordBank.getKey() + " = " + lastWordBank.getValue() + "\n");
				counter++;
				}
			
			}
	}//end of readPage

public static HashMap<String, Integer> sortByValue (HashMap<String, Integer> wordList){
		
		//Create new List to hold data
		List<Map.Entry<String, Integer> > List = new LinkedList<Map.Entry<String, Integer>>(wordList.entrySet());
		
		
		//Sort Data
		Collections.sort(List, new Comparator<Map.Entry<String, Integer>> (){
			public int compare (Map.Entry<String, Integer> obj1,
					Map.Entry<String, Integer> obj2)
			{
				return(obj2.getValue()).compareTo(obj1.getValue());
			}
			
		});
		
		//Create new HashMap to hold sorted data
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa: List) {
			temp.put(aa.getKey(),aa.getValue());
		}
		
		//Return map
		return temp;
		
	}
	
}
