import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Singleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925501569986912540L;
	/**
	 * 
	 */
	protected static Singleton uniqueInstance;
	private List<String> outcontents = new ArrayList<String>();
	private String fcontents = "";
	private String fname = "";
	// other useful instance variables here
 
	protected Singleton() {}
 
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	public void createNewLog() {
	      FileWriter writer;
		try {
			writer = new FileWriter(this.fname, false);
			BufferedWriter bw = new BufferedWriter(writer);
		    bw.write("LOG"+System.lineSeparator());
		    bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addLine(String line) {
		this.outcontents.add(line);
	}
	public void setfname(String fname) {
		this.fname = fname;
	}
	public String getfcontents() {
		return this.fcontents;
	}
	public void clearfcontents() {
		this.fcontents = "";
	}
	public String readEntireLog() {
		String str = "";
		try {
			  FileReader freader = new FileReader(this.fname);
			  int c;
			  c = freader.read();
			  while(c != -1) {
				  str += Character.toString((char) c);
				  c = freader.read();			  
			  }
			  freader.close();
			  return str;
		} catch(Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return str;
	}
	public void writeToLogandFlush() {
		try {
		  File f = new File(fname);
		  
		  if(f.exists()) {
			  FileReader freader = new FileReader(this.fname);
			  String str = "";
			  int c;
			  c = freader.read();
			  while(c != -1) {
				  str += Character.toString((char) c);
				  c = freader.read();			  
			  }
			  freader.close();
			  this.fcontents += str;
		  }

	      FileWriter writer = new FileWriter(this.fname, true);
	      BufferedWriter bw = new BufferedWriter(writer);
	      
	      for(String s: this.outcontents) {
	    	  String w = s + System.lineSeparator();
	    	  bw.write(w);
	    	  this.fcontents += w; 
	      }
	      bw.close();
	      //writer.write(s);
	      //outcontents
	      //writer.close();
	      this.outcontents.clear();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
