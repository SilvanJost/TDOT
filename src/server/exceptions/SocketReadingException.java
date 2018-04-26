package server.exceptions;

public class SocketReadingException extends Exception{

	
	public SocketReadingException(){
		super("An error occured while trying to read a socket's inputstream and interpret is as a packet");
	}
}
