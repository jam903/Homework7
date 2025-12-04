public class RecursivePractice {
    //countSubstrings() - Given a word and a substring, count how many times the substring appears in the word.

    public static int countSubstrings(String word, String substring){
        if(word.length() < substring.length()){
            return 0;
        }
        int countStartSubstring = 0;
        if(word.startsWith(substring)){
            countStartSubstring = 1;
        }
        int countRest = countSubstrings(word.substring(1), substring);
        return countStartSubstring + countRest;
    }
    // digitMatch() - Given two integers x and y, count the number of digits they have in common.

    public static int digitMatch(int x, int y) {
        int matches = 0;
        if (x % 10 == y % 10) {
            matches = 1;
        }
        if (x < 10 || y < 10) {
            return matches;
        }
        return matches + digitMatch(x / 10, y / 10);
    }
    // multiplyOdds() - Given an integer n, return the product of the first n odd integers.

    public static int multiplyOdds(int n) {
        if (n <= 0) {h
            throw new IllegalArgumentException();
        }
        int digit = n % 10;
        if(n < 10){
            if(digit % 2 == 0){
                return 1;
            }else{
                return digit;
            }
        }
        if(digit % 2 != 0){
            return digit * multiplyOdds(n / 10);
        }else{
            return multiplyOdds(n / 10);
        }
        }

}
