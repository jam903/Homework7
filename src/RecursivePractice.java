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
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        }else{
            return (2 * n - 1) * multiplyOdds(n - 1);
        }
    }
    // permutation() - Given two integers n and r, compute the number of unique permutations of r items from a group of n items.

    public static double permutation(int n, int r) {
        if (n < 0 || r < 0 || n < r) {
            throw new IllegalArgumentException();
        }
        if (r == 0) {
            return 1;
        }
        return n * permutation(n - 1, r - 1);
    }

}
