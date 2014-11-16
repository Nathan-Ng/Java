import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import zen.core.Zen;


public class WorldCloud {
	
	public static void main(String[] args) throws FileNotFoundException{
		ArrayList <String> words = new ArrayList<String>();
		HashMap <String, Integer> count = new HashMap <String, Integer> ();
		// How to read a file 101
		//1. make a file object and a scanner with that that file.
		File f = new File("text");
		Scanner s=new Scanner(f);
		String font="Times New Roman";
		int color;
		int r=Zen.getRandomNumber(1,9);
		Zen.create(800, 800);
		//ArrayList <String> words = new ArrayList <String> ();
		words.add("Nathan");
		
		while (s.hasNext()){
			String word=s.next();
			word=word.toLowerCase();
			word=word.replaceAll("[^a-z]","");
			words.add(word);
			//there are two cases (in mapping or not)
			if (count.containsKey(word)){
				int current = count.get(word);
				count.put(word, current + 1);
			}else{
				count.put(word, 1);
			}
		}
		
		for (String word: count.keySet()){
				System.out.println(word);
			Zen.setFont(font, count.get(word)*8);
			Zen.setColor("white");
			Zen.drawText(word, Zen.getRandomNumber(0, 800), Zen.getRandomNumber(0, 800));
		
		}
	}
	
}
