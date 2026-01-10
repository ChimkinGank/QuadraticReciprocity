public class QuadraticReciprocity{
  public static void main(String[] args){
      System.out.print(jacobi(13,3));
  }

  public static int jacobi(int p, int q){
    if (p%q==0){
      return 0;
    }
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
        return jacobi(p/n,q);
      } else {
        return jacobi(2,q)*jacobi(p/n,q);
      }
    } else if (p>q) {
      return jacobi(p-q*(p/q),q);
    } else {
      if (p%4==3&&q%4==3){
        return -1*jacobi(q,p);
      } else {
        return jacobi(q,p);
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
