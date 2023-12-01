package aleena; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling{
	public static void main(String[]args) {
		char[]data = new char[60];
		FileReader input = null;
		FileWriter output = null;
		String value = "Hi , my name is Baina");
		FileWriter info = null;
		
	
	try
	{ 
		info = newFileWriter("input.txt");
		info.write(value);
		info.flush();
		info.close();
		input = new FileReader("input.txt");
		int bytes = input.read(data);
		input.close();
		output = new FileWriter("output.txt");
		output.write(data, 0 , bytes);
		output.flush();
		output.close(); } 
