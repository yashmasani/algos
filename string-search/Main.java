class Main {
  public static void main(String[] args) {
     
    String[][] table = {
      {"apple", "apple"},  // Basic Search
      {"Apple", "apple"},  // Search with Mixed Case Sensitivity
      {"C++", "C++"},  // Search with Special Characters
      {"New York", "New York"},  // Search with Spaces
      {"app", "app"},  // Search for a Substring
      {"", "None"},  // Empty String Search
      //{"pineapple", "None"},  // Search for Non-existent String
      {"ale", "apple, ample"},  // Search with Wildcards
      {"12345", "12345"},  // Search with Numbers
      {"apple orange", "apple and/or orange"},  // Search with Multi-word Input
      {"apple", "apple"},  // Search with Large Dataset
      {"appl", "apple"},  // Search with Fuzzy Matching
      {"the", "the (depending on stopword behavior)"},  // Search for Common Words
      {
          "apple",
          "This is a very long piece of text that starts with several words but eventually contains the pattern apple deep inside the text. You may find that the first few characters such as app appear early on, but the full pattern 'apple' is located much later in the text."
      },
      {
          "apple",
          "This is a very long piece of text that starts with several words but eventually contains the pattern apple deep inside the text. You may find that the first few characters such as app appear early on, but the full pattern 'apple' is located much later in the text."
      },
      {
          "\'apple\'",
          "This is a very long piece of text that starts with several words but eventually contains the pattern apple deep inside the text. You may find that the first few characters such as app appear early on, but the full pattern 'apple' is located much later in the text."
      },
      {
          "contains",
          "This is a very long piece of text that starts with several words but eventually contains the pattern apple deep inside the text. You may find that the first few characters such as app appear early on, but the full pattern 'apple' is located much later in the text."
      },
      {
          "\'apple\'",
          "This is a very long piece of text that starts with several words but eventually contains the pattern apple deep inside the text. You may find that the first few characters such as app appear early on, but the full pattern 'apple' is located much later in the text."
      },
    }; 

    System.out.println("Created Main");   
    for (int i=0; i < table.length; i++) {
      int simple = SimpleSearch.search(table[i][1], table[i][0]);
      int complex = ComplexSearch.search(table[i][1], table[i][0]);
      System.out.println(String.format("Simple: %s, Complex: %s", simple, complex));
    }

  }

}
