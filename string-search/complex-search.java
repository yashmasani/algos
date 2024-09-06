/**
 * Adler-32 hash
 * */
class ComplexRollingHash {

  private static int prime_modulo = 65521;

  public ComplexRollingHash(){}

  // Adler-32(D) = B × 65536 + A
  public static int hash(String s){
    byte[] bs = s.getBytes();
    // A B
    // A -> sum of byte
    // B -> sum of individual steps
    int a = 1;
    int b = 0;
    
    for (int i=0; i < bs.length; i++) {
      a += bs[i];
      b += a;
    }
    a = a % prime_modulo;
    b = b % prime_modulo;
    return (b << 16) | a;
  }
  
  public static int roll(String s, int prev_hash, int prev_char_index, int new_char_index, int pattern_length) {
    int b = prev_hash >> 16;
    int a = prev_hash ^ (b << 16); // maybe and mask faster
    // remove prev char
    a -= s.codePointAt(prev_char_index);
    b = b - (s.codePointAt(prev_char_index) * pattern_length) - 1;
    a += s.codePointAt(new_char_index);
    b += a;
    return (b << 16) | a;
  }  
}

class ComplexSearch {
  public ComplexSearch() {
  } 

  public static int search(String s, String pattern) {
    int p_hash = ComplexRollingHash.hash(pattern);
    int len = pattern.length();
    int l = 0;
    int s_hash = ComplexRollingHash.hash(s.substring(l, l+len));
    if (s_hash == p_hash){
      return l;
    }
    l++;
    while (l+len <= s.length()) {
      s_hash = ComplexRollingHash.roll(s, s_hash, l-1, l+len-1, len);
      if (p_hash == s_hash) {
        return l;  
      }
      l++;
    }
    return -1;
  }
}

