class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.charAt(0) >= 65 && word.charAt(0) <= 90){
            return func(word.substring(1),true);
        }
        else {
            return func(word.substring(1),false);
        }
    }
    boolean func(String word,boolean check){
        if(check){
            return word.toUpperCase().equals(word) || word.toLowerCase().equals(word);
        }
        else {
            return word.toLowerCase().equals(word);
        }
    }
}