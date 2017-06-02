package com.lxy.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(8080);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = "";
		while((info = br.readLine())!=null){
			System.out.println("Hello,我是服务器，客户端说："+info);
		}
		socket.shutdownInput();
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("Hello World！");
		pw.flush();
		pw.close();
		os.close();
		br.close();
		isr.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
}