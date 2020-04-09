package com.ck.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 类    名: Main </br>
 * 创建时间: 2018/6/16 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("asdasd");
        File file = new File("D:\\微信数据\\WXWORK\\WXWork\\1688850095307248\\Cache\\File\\2019-09\\android-876-1568684533757.txt");
        File file1 = new File("D:\\微信数据\\WXWORK\\WXWork\\1688850095307248\\Cache\\File\\2019-09\\压缩后.txt");
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(file1);
//        LoganParser.getInstance().parse(is, os);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
        String line = null;
        String lastLog = null;
        int count = 0;
        int allcount = 0;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("\\bid='.{36}:\\d:', ", "")
                    .replaceAll("\\bmessageId=\\d+, ", "")
                    .replaceAll("message=null, ", "")
                    .replaceAll("conversationTitle='',", "")
                    .replaceAll("\\bconversationId:[\\s\\S]*?msg:", "")
                    .replaceAll("@[a-zA-Z0-9]*?,", ",")
                    .replaceAll("com.abcpen.im.core.message.plug.", "")
                    .replaceAll("com.jk.imlib.extmsg.model.", "")
                    .replaceAll("\\bportraitUrl=[\\s\\S]*?, ", "")
                    .replaceAll("\\bsenderUserId=.*?, senderUserName=.*?, isTop=(true|false), mentioneds=[\\s\\S]*?, ", "")
                    .replaceAll("\\\\\"couponReceive\\\\\":\\d*?,\\\\\"couponReceiveAskId\\\\\":\\\\\"\\d*?\\\\\",", "")
                    .replaceAll(",\\\\\"senderExtInfo\\\\\"[\\s\\S]*?conversationType=PRIVATE", "}'");
            if (line.startsWith("{\"c\":\"[ABCConversation")) {
                allcount++;
                if (!line.equals(lastLog)) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    lastLog = line;
                    count++;
                    System.out.println(line);
                }
            } else {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                System.out.println(line);
            }
        }

        br.close();
        System.out.println("allcount:" +allcount);
        System.out.println("count:" +count);


//        try {
//            // 1、创建客户端Socket，指定服务器地址和端口
//             Socket socket=new Socket("193.112.223.129",5200);
////            Socket socket = new Socket("192.168.1.115", 5209);
//            System.out.println("客户端启动成功");
//            // 2、获取输出流，向服务器端发送信息
//            // 向本机的52000端口发出客户请求
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            // 由系统标准输入设备构造BufferedReader对象
//            PrintWriter write = new PrintWriter(socket.getOutputStream());
//            // 由Socket对象得到输出流，并构造PrintWriter对象
//            //3、获取输入流，并读取服务器端的响应信息
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            // 由Socket对象得到输入流，并构造相应的BufferedReader对象
//            String readline = br.readLine();
////            readline = br.readLine(); // 从系统标准输入读入一字符串
//            while (true) {
//                // 若从标准输入读入的字符串为 "end"则停止循环
//                write.println(readline);
//                // 将从系统标准输入读入的字符串输出到Server
//                write.flush();
//                // 刷新输出流，使Server马上收到该字符串
//
//                System.out.println("Client:" + readline);
//                readline = br.readLine();
//                if ("end".equals(readline)) {
//                    break;
//                }
//                // 在系统标准输出上打印读入的字符串
//                System.out.println("Server:" + in.readLine());
//                // 从Server读入一字符串，并打印到标准输出上
////                readline = br.readLine(); // 从系统标准输入读入一字符串
//            } // 继续循环
//            //4、关闭资源
//            write.close(); // 关闭Socket输出流
//            in.close(); // 关闭Socket输入流
//            socket.close(); // 关闭Socket
//        } catch (Exception e) {
//            System.out.println("can not listen to:" + e);// 出错，打印出错信息
//        }
    }
}
