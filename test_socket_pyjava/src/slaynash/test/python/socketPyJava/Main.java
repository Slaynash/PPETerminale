package slaynash.test.python.socketPyJava;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
	
	private static final String IP_ADDRESS = "127.0.0.1";
	private static final int PORT = 15555;
	
	private static Socket socket;
	private static BufferedOutputStream out;
	private static BufferedReader in;
	
	private static boolean stayConnected = true;
	
	public static void main(String[] args) {
		startConnection();
		/*
		try {
			Socket s = new Socket("127.0.0.1", 15555);
			BufferedOutputStream bos =
					new BufferedOutputStream(s.getOutputStream());
			Thread.sleep(100);
			
			bos.write("éà$*ù^`@!".getBytes("UTF-8"));
			bos.flush();
			s.close();
		}catch (IOException e) {e.printStackTrace();}
		catch (InterruptedException e) {e.printStackTrace();}
		*/
	}
	
	
	
	//------------------------------------------------------------------
	
	
	
	public static void startConnection(){
		try {
			socket = new Socket(IP_ADDRESS, PORT);
			out = new BufferedOutputStream(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Thread.sleep(100);
			while(stayConnected){
				String s;
				while((s = in.readLine()) != null){
					//TODO COMPLETE POROGRAM
				}
				if(!stayConnected) {
					showAlertNoNetwork();
					//TODO reconnect
				}
			}
		}
		catch (IOException e) {e.printStackTrace();}
		catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public static void closeConnection(){
		try {
			stayConnected = false;
			socket.close();
		} catch (IOException e) {if(stayConnected) e.printStackTrace();}
	}
	
	
	//------------------------------------------------------------------
	
	
	public static void sendMessage(String message){
		try {
			out.write(message.getBytes("UTF-8"));
			out.flush();
		}catch (IOException e) {e.printStackTrace();}
	}
	
	
	//------------------------------------------------------------------
	
	
	public static void showAlertNoNetwork(){
		System.out.println("Appareil déconnecté du réseau !");
	}
	
	public static void showAlertNotification(){
		System.out.println("Intrusion detectée !");
	}
}
