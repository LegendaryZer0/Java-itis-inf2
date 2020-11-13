package ru.itis.color;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Starting client");
        try {
            Socket s = new Socket(InetAddress.getLocalHost(),11885);
            OutputStream out = s.getOutputStream();
            while (true){
                Thread.sleep(1000);
                System.out.println("Cin 3 number between 0 exclude and 255 exclude");
                int r = in.nextInt();
                int g = in.nextInt();
                int b = in.nextInt();
                if(r>255) r =255;
                else if(r<0)r=0;
                if(g>255) g =255;
                else if(g<0)r=0;
                if(b>255) b =255;
                else if(b<0)r=0;
                ByteBuffer buf = ByteBuffer.allocate(12);
                buf.putInt(r).putInt(g).putInt(b);
                out.write(buf.array());
                out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
