// dummy hash with higher probability of false positive
class SimpleRollingHash {
  public SimpleRollingHash() {
  }

  public static int hash(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      sum += s.codePointAt(i);
    }
    return sum;
  }  

  public static int roll(String s, int prev_hash, int prev_char, int new_char) {
    return prev_hash - s.codePointAt(prev_char) + s.codePointAt(new_char);
  }

}


class SimpleSearch {
  public SimpleSearch() {
  } 

  public static int search(String s, String pattern) {
    int p_hash = SimpleRollingHash.hash(pattern);
    int len = pattern.length();
    int l = 0;
    int s_hash = SimpleRollingHash.hash(s.substring(l, l+len));
    if (s_hash == p_hash){
      if (pattern.equals(s.substring(l, l+len))) {
        return l;
      }
    }
    l++;
    while (l+len <= s.length()) {
      s_hash = SimpleRollingHash.roll(s, s_hash, l-1, l+len-1);
      if (p_hash == s_hash) {
        if (pattern.equals(s.substring(l, l+len))) {
          return l;  
        }
      }
      l++;
    }
    return -1;
  }
}
