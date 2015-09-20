package new_project_ADV;

import java.io.FileInputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFrek {
	
 private int count = 0;

 public static void main(String args[]) throws Exception {
  String filePath = "C:/work/adv/repo/book.odt";

  // Draw File to byte buffer
  FileInputStream In = new FileInputStream(filePath);
  FileChannel filech = In.getChannel();
  int fileLen = (int) filech.size();
  MappedByteBuffer buf = filech.map(FileChannel.MapMode.READ_ONLY, 0, fileLen);

  // Convert to character buffer
  Charset chars = Charset.forName("ISO-8859-1");
  CharsetDecoder dec = chars.newDecoder();
  CharBuffer charBuf = dec.decode(buf);

  // Create pattern
  Pattern linePatt = Pattern.compile(".*$", Pattern.MULTILINE);
  Pattern wordBrkPatt = Pattern.compile("[\\p{Punct}]");

  // Match pattern to buffer
  Matcher lineM = linePatt.matcher(charBuf);
  Map m = new TreeMap();
  Integer one = new Integer(1);

  // Check line
  while (lineM.find()) {

	CharSequence lineSeq = lineM.group();
	String words[] = wordBrkPatt.split(lineSeq);

	// Check word
	for (int i = 0, n = words.length; i < n; i++)
	{
		if (words[i].length() > 0) {
			Integer frequency = (Integer) m.get(words[i]);
			if (frequency == null) {
			 frequency = one;
				} 
			 else {
				int value = frequency.intValue();
				frequency = new Integer(value + 1);
				}
		m.put(words[i], frequency);
		}
	}
  }
  
  System.out.println(m);
  }
}
