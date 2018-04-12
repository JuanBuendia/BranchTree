package persistence;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

public class FileManager {

	public String[] getFiles(String route) {
		File[] files = new File(route).listFiles();
		String[] data = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			String mymeType = new MimetypesFileTypeMap().getContentType(files[i]);
			if(mymeType.startsWith("image/")){
				data[i] = files[i].getPath();
			}
		}
		return data;
	}
}