public class Count8{
  if (n < 10){
    if (n == 8){
      return 1;
    }else{
      return 0;
    }
  }else if (n % 10 == 8){
    if(n % 100 == 88){
      return 2 + count8(n/10);
    }
    return 1 + count8(n/10);
  }else{
    return count8(n/10);
  }
}
