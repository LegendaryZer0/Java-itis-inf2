package ru.itis.site;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        int port = 80;
        try{
            URL u = new URL("https://www.youtube.com/watch?v=pEHa9UMgIZs");
            if(u.getPort()!=-1)port =u.getPort();
            Socket socket = new Socket(u.getHost(),port);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream,false);
            pw.println("GET" + u.getFile() +"HTTP/1.0\r\n");
            pw.println("Accept: text/plain,text/html,text/*\r\n");
            pw.println("\r\n");
            pw.flush();
            InputStream in = socket.getInputStream();
           InputStreamReader inputStreamReader = new InputStreamReader(in);
           BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
           String response = bufferedReader.lines().collect(Collectors.joining("\n"));
           if(response.contains("HTTP/1.0 200 OK")) System.out.println(response);



            in.close();
            inputStreamReader.close();
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
