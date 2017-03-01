import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class Reformat {

	  public static void main(String[] args) throws Exception {
		  
		    if (args.length != 1) {
		      System.out.println("Usage: java reformat file");
		      System.exit(1);
		    }
		    
		    File something = new File(args[0]);
		    StringBuilder somethingElse = new StringBuilder();
		    Scanner cat = new Scanner(something);

		    while (cat.hasNext()) {
		      String a = cat.nextLine();
		      String b = a.trim();
		      if (b.charAt(0) == '{') {
		    	  somethingElse.append(" {");
		        if (b.length() > 1) somethingElse.append("\r\n" + a.replace('{', ' '));
		      }
		      else
		    	  somethingElse.append("\r\n" + a);
		    }

		    cat.close();

		    PrintWriter p = new PrintWriter(something);
		    p.print(somethingElse.toString());
		    p.close();
		  }

}
