package RSA;

import java.util.Scanner;
public class RsaMain {
    public static void main(String[] args) {
        int p,q;
        Scanner in=new Scanner(System.in);
        System.out.print("请输入一个质数p：");
        p=in.nextInt();
        System.out.print("请输入一个质数q：");
        q=in.nextInt();
        int r=p*q;
        int e=(p-1)*(q-1);
        int pk=new gcd().getk(e);
        int sk=0 ,x=0;
        found:for(sk=0;sk<r;sk++){
            for(x=0;x<r;x++){
                if(pk*sk==(x*e+1)){
                    break found;
                }
            }
        }
        System.out.println("公钥为：{"+pk+","+r+"}");
        System.out.println("私钥为：{"+sk+","+r+"}");

        //加密
        System.out.println("请输入明文：");
        int P1=in.nextInt();
        int C1=(int)((Math.pow(P1, pk))%r);
        System.out.println("加密后的密文为："+C1);

        //解密
        double m=Math.pow(C1,sk);
        int _P1=(int)((Math.pow(C1,sk))%r);
        System.out.println("解密后的密文为："+_P1);
    }
}
