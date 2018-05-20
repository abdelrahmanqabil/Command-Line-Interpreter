import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class cli {
	String current_directory="D:";
	
	public void clear(){
		for(int i=0;i<10;i++)
		System.out.println(" ");
	}
	public  void copy(String fname,String path) throws IOException {
	      FileReader in = null;
	      FileWriter out = null;

	      try {int index = 0;
	         in = new FileReader(fname);
	         for(int i=fname.length()-1 ; i>=0 ; i--) if(fname.charAt(i) == '/') index = i;
	        String tname= fname.substring(index+1 , fname.length());
	         String fullpath=path+'/'+tname;
	         out = new FileWriter(fullpath);
	         int c;
	         while ((c = in.read()) != -1) {
	            out.write(c);
	         }
	      }finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	      }
	   }
	
	
	
	public  void move(String fname,String path) throws IOException {
	      FileReader in = null;
	      FileWriter out = null;

	      try {int index = 0;
	         in = new FileReader(fname);
	         for(int i=fname.length()-1 ; i>=0 ; i--) if(fname.charAt(i) == '/') index = i;
	        String tname= fname.substring(index+1 , fname.length());
	         String fullpath=path+'/'+tname;
	         out = new FileWriter(fullpath);
	         int c;
	         while ((c = in.read()) != -1) {
	            out.write(c);
	         }
	      }finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	      }
	      File f=new File(fname);
	      f.delete();
	      
	   }


	
		 
		public  void mkdir(String path) {
			
			File file = new File(path);		

			
				file.mkdir();
			
		
	}
	
	public void remove(String path){
		File f=new File(path);
		f.delete();
	}
	public boolean rmv_folder(File path){
		if(path.isDirectory()){
			String[] list=path.list();
			for(int i=0;i<list.length;i++){
				boolean deleted=rmv_folder(new File(path,list[i]));
				if(!deleted)return false;
			}
		}
		return path.delete();
	}
	
	public void cat(String path)throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			}
	}
	public void cd(String path){
		current_directory=path;
	}
	
	public void ls(String path){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      
		        System.out.println( listOfFiles[i].getName());
		    }}
	
	
	
	public void pwd(){
		System.out.println(current_directory);
	}
	
		
		
		public void date(){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
		}


		public static void help()
		  {
			  System.out.println("Clear ! Ex: $clear ---> This command can be called to clear the current terminal screen and it can be redirected to clear the screen of some other terminal. ");
			  System.out.println("Cd    ! Ex: $cd //home ---> This command changes the current directory to another one.");
			  System.out.println(">>    ! Ex:$ls >> myfile.txt ;will append the list of files into this file instead of the screen--->Redirect the output to be written to a file using the redirect >> create/append to file operator.");
			  System.out.println("date  ! Ex:$date||$date 20/12/2008--->To display or to set the date and time of the system.");
		          System.out.println("Ls    ! Ex: $ls || $ls –a ; to display all information about the listed files||$man ls ; to display the manual for ls to know another options. ---> These programs list each given file or directory name. Directory contents are sorted alphabetically. For ls, files are by default listed in columns, sorted vertically, if the standard output is a terminal; otherwise, they are listed one per line.");
			  System.out.println("Cp    ! Ex: $cp //home//myfile.txt //root//myfile.txt--->If the last argument names an existing directory, cp copies each other given file into a file with the same name in that directory. Otherwise, if only two files are given, it copies the first onto the second. It is an error if the last argument is not a directory and more than two files are given. By default, it does not copy directories.");
			  System.out.println("mkdir ! Ex:$mkdir //home//mydir--->mkdir creates a directory with each given name. By default, the mode of created directories is 0777 minus the bits set in the umask.");
			  System.out.println("rmdir ! Ex:$rmdir //home//mydir--->rmdir removes each given empty directory. If any nonoption argument does not refer to an existing empty directory, it is an error.");
		          System.out.println("more  ! Ex:$ls | more ;display the files in pages||$more myfile.txt--->Let us display and scroll down the output in one direction only. You can scroll page by page or line by line.");
			  System.out.println("cat   ! Ex:$cat myfile.txt ;to display the content of this file--->Concatenate files and print on the standard output.");
			  System.out.println(">     ! Ex: $ls > myfiles.txt ;will overwrite the list of files into this file instead of the screen--->Redirect the output to be written to a file using the redirect > create/replace file operator.");
			  System.out.println("rm    ! Ex:$rm *.txt--->rm removes each specified file. By default, it does not remove directories. If a file is unwritable, the standard input is a tty, and the -f or --force option is not given, rm prompts the user for whether to remove the file. If the response does not begin with y or Y, the file is skipped.");
			  System.out.println("Mv    ! Ex:$mv //home//myfile.txt //root//myfile.txt||$mv //home//myfile.txt //root//myNewFile.txt ;operate as renaming file--->If the last argument names an existing directory, mv moves each other given file into a file with the same name in that directory. Otherwise, if only two files are given, it moves the first onto the second. It is an error if the last argument is not a directory and more than two files are given. It can move only regular files across file systems. If a destination file is unwritable, the standard input is a tty, and the –f or --force option is not given, mv prompts the user for whether to overwrite the file. If the response does not begin with y or Y, the file is skipped.");
			  System.out.println("mkdir ! Ex:$mkdir //home//mydir--->mkdir creates a directory with each given name. By default, the mode of created directories is 0777 minus the bits set in the umask.");
			  System.out.println("rmdir ! Ex:$rmdir //home//mydir--->rmdir removes each given empty directory. If any nonoption argument does not refer to an existing empty directory, it is an error.");
			 
		  }
		     public static void help1(String command)
		  {     
		      if(command.equals("clear"))
			  System.out.println("Clear ! Ex: $clear ---> This command can be called to clear the current terminal screen and it can be redirected to clear the screen of some other terminal. ");
		     
		      else if(command.equals("cd"))
		          System.out.println("Cd    ! Ex: $cd //home ---> This command changes the current directory to another one.");
			  
		      else if(command.equals(">>"))    
		          System.out.println(">>    ! Ex:$ls >> myfile.txt ;will append the list of files into this file instead of the screen--->Redirect the output to be written to a file using the redirect >> create/append to file operator.");
			  
		      else if(command.equals("date"))   
		          System.out.println("date  ! Ex:$date||$date 20/12/2008--->To display or to set the date and time of the system.");
		          
		      else if(command.equals("ls"))   
		          System.out.println("Ls    ! Ex: $ls || $ls –a ; to display all information about the listed files||$man ls ; to display the manual for ls to know another options. ---> These programs list each given file or directory name. Directory contents are sorted alphabetically. For ls, files are by default listed in columns, sorted vertically, if the standard output is a terminal; otherwise, they are listed one per line.");
			  
		      else if(command.equals("cp"))  
		          System.out.println("Cp    ! Ex: $cp //home//myfile.txt //root//myfile.txt--->If the last argument names an existing directory, cp copies each other given file into a file with the same name in that directory. Otherwise, if only two files are given, it copies the first onto the second. It is an error if the last argument is not a directory and more than two files are given. By default, it does not copy directories.");
			  
		      else if(command.equals("mkdir"))    
		          System.out.println("mkdir ! Ex:$mkdir //home//mydir--->mkdir creates a directory with each given name. By default, the mode of created directories is 0777 minus the bits set in the umask.");
			  
		      else if(command.equals("rmdir"))    
		          System.out.println("rmdir ! Ex:$rmdir //home//mydir--->rmdir removes each given empty directory. If any nonoption argument does not refer to an existing empty directory, it is an error.");
		          
		      else if(command.equals("mor"))    
		          System.out.println("more  ! Ex:$ls | more ;display the files in pages||$more myfile.txt--->Let us display and scroll down the output in one direction only. You can scroll page by page or line by line.");
			  
		      else if(command.equals("cat"))    
		          System.out.println("cat   ! Ex:$cat myfile.txt ;to display the content of this file--->Concatenate files and print on the standard output.");
			  
		      else if(command.equals(">"))    
		          System.out.println(">     ! Ex: $ls > myfiles.txt ;will overwrite the list of files into this file instead of the screen--->Redirect the output to be written to a file using the redirect > create/replace file operator.");
			  
		      else if(command.equals("rm"))    
		          System.out.println("rm    ! Ex:$rm *.txt--->rm removes each specified file. By default, it does not remove directories. If a file is unwritable, the standard input is a tty, and the -f or --force option is not given, rm prompts the user for whether to remove the file. If the response does not begin with y or Y, the file is skipped.");
			  
		      else if(command.equals("mv"))    
		          System.out.println("Mv    ! Ex:$mv //home//myfile.txt //root//myfile.txt||$mv //home//myfile.txt //root//myNewFile.txt ;operate as renaming file--->If the last argument names an existing directory, mv moves each other given file into a file with the same name in that directory. Otherwise, if only two files are given, it moves the first onto the second. It is an error if the last argument is not a directory and more than two files are given. It can move only regular files across file systems. If a destination file is unwritable, the standard input is a tty, and the –f or --force option is not given, mv prompts the user for whether to overwrite the file. If the response does not begin with y or Y, the file is skipped.");
			  
		      else if(command.equals("mkdir"))   
		          System.out.println("mkdir ! Ex:$mkdir //home//mydir--->mkdir creates a directory with each given name. By default, the mode of created directories is 0777 minus the bits set in the umask.");
			  
		      else if(command.equals("rmdir"))    
		          System.out.println("rmdir ! Ex:$rmdir //home//mydir--->rmdir removes each given empty directory. If any nonoption argument does not refer to an existing empty directory, it is an error.");
			 
		  }
		     public void Args() { 
				System.out.println("Command Name                    Arguments                         ");
				System.out.println("   date                          [NONE]                           ");
		                System.out.println("   clear                         [NONE]                           ");
				System.out.println("    cd                        [directory name or path]                    ");
				System.out.println("   pwd                            [NONE]                          ");
		                System.out.println("    ls                            [NONE]                          ");
				System.out.println("    ls >>                       [file name]                       ");
				System.out.println("    ls >                        (file name)                       ");
				System.out.println("    cp                      [file name,The directory path or name]             ");
				System.out.println("    mv                      [file name,The directory path or name]             ");
				System.out.println("    rm                           [file name]                      ");
				System.out.println("   mkdir                         [Folder name]                    ");
				System.out.println("   rmdir                         [folder name]                    ");
				System.out.println("   more                          [file name]                      ");
				System.out.println("   less                          [file name]                      ");
				System.out.println("   cat                          [file name]                       ");
		                
		     }
		     
public void more(String path)throws IOException{
	Scanner s=new Scanner(System.in);
	
	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		   String line = null;
		   int c=0;
		   while ((line = br.readLine()) != null) {
			   if(c==10) {c=0;
			   String input=s.nextLine();

			   }
		       System.out.println(line);
		       c++;
		   }
		}
}
}

		
		



