package AnalizadorDOsCero;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class archive {

	  FileReader fr = null;
      LineNumberReader lnr = null;
      int i;
      
	      public archive (String pat) throws IOException {
	    
		      try {
			         // create new reader
			         fr = new FileReader(pat);
			         lnr = new LineNumberReader(fr);
			       
			         // get the current line number
			         i = lnr.getLineNumber();
			         
			         // print the current line number
			         System.out.print("Current line number: "+i);
			         
			      } catch(Exception e) {
			         // if any error occurs
			         e.printStackTrace();
			      } finally {
			         // closes the stream and releases system resources
			         if(fr!=null)
			            fr.close();
			         if(lnr!=null)
			            lnr.close();
			      }  
	      }

}
