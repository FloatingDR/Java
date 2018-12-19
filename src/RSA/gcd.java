package RSA;

public class gcd {
    public int getGcd(int a,int e){
        int i;
        if(a>e){
            i=e;
        }else{
            i=a;
        }
        while(a%i!=0||e%i!=0){
            i--;
        }
        return i;
    }
    public int getk(int e){
        int k;
        for (k=2;k<e;k++){
            if(getGcd(k,e)==1){
                break;
            }
        }
        return k;
    }
}
