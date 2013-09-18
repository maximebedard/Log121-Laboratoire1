
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DecodeurForme 
{
	
	private int noSeq;
	private TypeForme type;
	private int[] coordonnes;
	
	public DecodeurForme(String input)
	{
		if(input == null) 
			throw new IllegalArgumentException("input");
		
		if(!isValidInput(input)) 
			throw new IllegalArgumentException(String.format("Format attendu : %s", validRegex));
		
		noSeq = parseNoSeq(input);
		type = parseTypeForme(input);
		coordonnes = parseCoordonnes(input, type);
		
	}
	
	private static final String validRegex = "\\d <(.*)>(.*)</\\1>";
	private static final String tagRegex = "<(.*)>(.*)</\\1>";
	
	//private static final Pattern validPattern = Pattern.compile(validRegex);
	private static final Pattern tagPattern = Pattern.compile(tagRegex);
	
	
	private boolean isValidInput(String input)
	{
		return input.matches(validRegex);
	}
	
	private static int parseNoSeq(String input)
	{
		return Integer.parseInt(input.substring(0, input.indexOf(" ")));
	}
	
	private static TypeForme parseTypeForme(String input)
	{
		Matcher m = tagPattern.matcher(input);
		m.find();
		String tag = m.group(0);
		return TypeForme.valueOf(tag.substring(tag.indexOf("<") + 1, tag.indexOf(">")));
	}
	
	private static int[] parseCoordonnes(String input, TypeForme type)
	{
		String begin = "<" + type.toString() + ">";
		String end = "</" + type.toString() + ">";
		
		String data = input.substring(begin.length(), input.length() - end.length());
		
		String[] cStrs = data.split(" ");
		int[] cInts = new int[cStrs.length];
		for(int i = 0; i < cStrs.length; i++)
		{
			cInts[i] = Integer.parseInt(cStrs[i]);
		}
		
		return cInts;
	}
	
	public int getNoSeq()
	{
		return noSeq;
	}
	
	public TypeForme getType()
	{
		return type;
	}
	
	public int[] getCoordonnes()
	{
		return coordonnes;
	}

}
