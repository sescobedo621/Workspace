package pigLatin;

import java.util.regex.*;

public class PigLatin {
	private String wordToTranslate;
	private String wordTranslated;
	private Pattern pattern;
	private Matcher match;

	public PigLatin(String word)
	{
		wordToTranslate = word;
	}

	public String getWordToTranslate()
	{
		return wordToTranslate;
	}

	public void setWordToTranslate(String wordToTranslate)
	{
		this.wordToTranslate = wordToTranslate;
	}

	public String vowelTranslate(String word)
	{
		String vowels = "^[AEIOUYaeiouy]*";
		pattern = Pattern.compile(vowels);
		match = pattern.matcher(word);
		if (match.find()) {
			wordTranslated = word + "WAY";
			return wordTranslated;
		}
		return null;
	}

	public String consonantTranslate(String word)
	{
		String consonant = "^[^AEIOUYaeiouy]*";

		pattern = Pattern.compile(consonant);
		match = pattern.matcher(word);
		if (match.find()) {
			int index = match.start();
			int index2 = match.end();
			String mix = word.substring(index2, word.length());
			String firstPart = word.substring(index, index2);

			wordTranslated = mix + firstPart + "AY";
			return wordTranslated;

		}
		return null;
	}

	public String translate(String word)
	{
		pattern = Pattern.compile("^[AEIOUYaeiouy]");
		match = pattern.matcher(word);
		if (match.find()) {
			wordTranslated = vowelTranslate(word);
		} else {
			wordTranslated = consonantTranslate(word);

		}
		return wordTranslated;
	}

	public void translatePhrase()
	{
		
		String[] placeholder = wordToTranslate.split("\\s");
		wordTranslated = "";
		
		for (String wordTranslated : placeholder) {
			pattern = Pattern.compile("\\d+");
			match = pattern.matcher(wordTranslated);
			
			if (match.find()) {
				this.wordTranslated += wordTranslated + " ";
			}
			else{
				this.wordTranslated += translate(wordTranslated) + " ";
				
				
			}
		}
	}
	
	public String toString(){
		return wordTranslated.trim();
	}
}
