public class QuadraticReciprocity{
  public static void main(String[] args){
      System.out.print(legendre(643,1003));
  }

  public static boolean isQr(int p, int q){
    if (legendre(p,q)==1){
      return true;
    } else {
      return false;
    }
  }

  public static int legendre(int p, int q){
    if (p==1){
      return 1;
    }
    if (p==2){
      if (q%8==1||q%8==7){
        return 1;
      } else {
        return -1;
      }
    }
    int k = pow2(p);
    if (k!=0){
      int n = 1<<pow2(p);
      if (k%2==0){
        return legendre(p/n,q);
      } else {
        return legendre(2,q)*legendre(p/n,q);
      }
    } else if (p>q) {
      return legendre(p-q*(p/q),q);
    } else {
      if (p%4==3&&q%4==3){
        return -1*legendre(q,p);
      } else {
        return legendre(q,p);
      }
    }
  }

  public static int pow2(int n){
    int count = 0;
    while(n%2==0){
      n/=2;
      count++;
    }
    return count;
  }
}
