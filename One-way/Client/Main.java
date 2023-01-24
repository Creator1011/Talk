import java.net.Socket;
import java.io.*;
import java.util.Scanner;
public class Main {
    private PrintWriter writer;
    public Main() {
        connect();
        Scanner sc=new Scanner(System.in);
        while (true) {
            String message=sc.nextLine();
            writer.println(message.trim());
            if (message.equals("#exit")) {
                break;
            }
        }
    }
    private void connect() {
        System.out.println("连接中……");
        try {
            Socket socket=new Socket("192.168.1.148",8998);
            writer=new PrintWriter(socket.getOutputStream(), true);
            System.out.println("连接完成");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}