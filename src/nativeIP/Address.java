package nativeIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Address {
    public static void main(String[] args) {
        InetAddress ip;                                    //声明InetAddress对象
        try{
            ip=InetAddress.getLocalHost();                 //实例化InetAddress对象
            String localname=ip.getHostName();             //获取本地主机名
            String localIp=ip.getHostAddress();            //获取本机IP地址
            System.out.println("本机主机名："+localname);
            System.out.println("本机IP地址："+localIp);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
