import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class run {
	public static void cli_run(String command ,cli c) throws IOException{
		int index=0;
		String temp = "";
		String path = "";
		String path2="";
		for(int i=0 ; i < command.length() ; i++){
			if(command.charAt(i) != ' ') temp+=command.charAt(i);
			else {
				index=i;
				break;
			}
		}
		boolean check=false;
		if(command.length()>1)
			 if(command.charAt(0)=='?'){
				for(int i=2; i < command.length() ; i++){
					if(command.charAt(i) != ' ') path+=command.charAt(i);
					
				}
				c.help1(path);
				 check=true;
			}

		if(check){
return ;
		}
		
		 if(temp.equals("help"))  c.help();
		
		else if(temp.equals("cd")){
			path = command.substring(index+1, command.length());
			c.cd(path);
		}
		else if(temp.equals("cp")){
			for(int i=index+1 ; i < command.length() ; i++){
				if(command.charAt(i) != ' ') path+=command.charAt(i);
				else {
					index=i;
					break;
				}
			}
			for(int i=index+1 ; i < command.length() ; i++){
				if(command.charAt(i) != ' ') path2+=command.charAt(i);
				else {
					index=i;
					break;
				}
			}
			c.copy(path, path2);
			
		}
		 
		else if(temp.equals("ls") && path.equals("")) c.ls(c.current_directory);
		 
		else if(temp.equals("ls")){
			path = command.substring(index+1, command.length());
			c.ls(path);
		}
		else if(temp.equals("mv")){
			for(int i=index+1 ; i < command.length() ; i++){
				if(command.charAt(i) != ' ') path+=command.charAt(i);
				else {
					index=i;
					break;
				}
			}
			for(int i=index+1 ; i < command.length() ; i++){
				if(command.charAt(i) != ' ') path2+=command.charAt(i);
				else {
					index=i;
					break;
				}
			}
			
			c.move(path, path2);
		}
		else if(temp.equals("rm")){
			path = command.substring(index+1, command.length());
			c.remove(path);
		}
		else if(temp.equals("clear")) c.clear();
		else if(temp.equals("args")) c.Args();
		else if(temp.equals("cat")){
			path = command.substring(index+1, command.length());
			c.cat(path);
		}
		else if(temp.equals("more")){
			path = command.substring(index+1, command.length());
			c.more(path);
		}
		else if(temp.equals("mkdir")){
			path = command.substring(index+1, command.length());
			c.mkdir(path);
		}
		else if(temp.equals("pwd")) c.pwd();
		else if(temp.equals("date")) c.date();
		else if(temp.equals("rmdir")){
			path = command.substring(index+1, command.length());
			File f=new File(path);
			c.rmv_folder(f);
		}
		
		
			
		else System.out.println("Command not Found") ;
		
		
		
	}
	
	
	
	
	
	

		public static void main(String args[]) throws IOException {
			
		cli c=new cli();
		Scanner s=new Scanner(System.in);
		String command	=s.nextLine();
		while(!command.equals("exit")){
			int index=0,pipe_index=0;
			String cmd1="",cmd2="";
//		String temp = "";
//		String path = "";
//		String path2="";
		boolean pipe=false;
		int shift=0;
		for(int i=0;i<command.length();i++){
			if(command.charAt(i)=='|') {pipe=true;
			pipe_index=i;
			break;
			}
		}
		for(int i=0;i<command.length();i++){
			if(command.charAt(i)=='>') shift++;
		}
		
		
		if(pipe){
			cmd1=command.substring(0,pipe_index-1);
			cmd2=command.substring(pipe_index+2,command.length());
			cli_run(cmd1,c);
			cli_run(cmd2,c);
			
		}
		
		else cli_run(command,c);
		
		
		command	=s.nextLine();	
		

		
		
		
		
			
			
		
			
		
		
			


		}
		}
		}
