/**
 * @author      Bonan Cao <bonanc@andrew.cmu.edu>
 * @Andrew ID   bonanc
 * @Date 		Sept. 22. 2015
 */
package client;

import java.io.*;
import java.net.*;
import java.util.*;

import exception.AutoException;
import model.Automotive;
import util.*;

public class CarModelOptionsIO {
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	public CarModelOptionsIO(ObjectOutputStream out, ObjectInputStream in, Socket socket) {
		this.out = out;
		this.in = in;
		this.socket = socket;
	}
	public boolean readProperties(String fileName){
		FileIO fileIO = new FileIO();
		Properties props = fileIO.readPropertiesFile(fileName);
		if(props != null){
			try{
				sendOutput(props);
			}
			catch(IOException e){
				return false;
			}
			return true;
		}
		return false;
	}
	public void sendOutput(Object object) throws IOException{
		out.writeObject(object);
		out.flush();
	}
	public Object handleInput() throws IOException, ClassNotFoundException{
		Object object = in.readObject();
		return object;
	}
	public Automotive buildAutomobile(String fileName, String fileType) throws AutoException{
		FileIO fileIO = new FileIO();
		Automotive auto = new Automotive();
		if(fileType.equals("txt")){
			
			fileIO.readFile(fileName, auto);
			return auto;
		}
		else if(fileType.toLowerCase().equals("properties")){
			Properties props = fileIO.readPropertiesFile(fileName);
			fileIO.parseProperties(props);
			return auto;
		}
		return null;
	}
}
