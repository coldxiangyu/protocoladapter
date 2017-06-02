package com.lxy.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("127.0.0.1",8080);
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("用户名：admin；密码：admin");
		pw.flush();
		socket.shutdownOutput();
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while((info=br.readLine()) != null){
		 System.out.println("Hello,我是客户端，服务器说："+info);
		}
		  
		br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	}
}
