import java.io.*;
import java.net.*;
public class Main {
    void start() {
        try {
            ServerSocket server = new ServerSocket(8998);
            System.out.println("ServerSocket创建成功");
            while (true){
                System.out.println("等待连接中……");
                Socket client = server.accept();
                System.out.println("连接完成");
                BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
                while (true){
                    String message=reader.readLine();
                    if (message.equals("#exit")) {
                        System.out.println("对方已退出");
                        break;
                    }
                    System.out.println(message);
                }
                reader.close();
                client.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().start();
    }
}