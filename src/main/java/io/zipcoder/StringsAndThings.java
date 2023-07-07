package io.zipcoder;


/**
 * @author tariq
 */

public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        // count all the sentence that end with y or z
        int count=0;
        String[] sentence = input.split(" ");
         for (String phrase: sentence){
           int size = phrase.length() - 1;
           char ending = phrase.charAt(size);
           if (ending == 'y' || ending =='z'){count++;}
            }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        if (base == null || remove == null || base.isEmpty() || remove.isEmpty()) {
            return base;
        }
        StringBuilder result = new StringBuilder();
        int startIndex = 0;
        int endIndex;
        while ((endIndex = base.indexOf(remove, startIndex)) != -1) {
            result.append(base.substring(startIndex, endIndex));
            startIndex = endIndex + remove.length();
        }
        result.append(base.substring(startIndex));
        return result.toString();
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        if (input == null || input.isEmpty()) {
            return false;
        }
        int countIs = 0;
        int countNot = 0;
        int index = 0;
        while (index < input.length()) {
            int nextIs = input.indexOf("is", index);
            if (nextIs != -1) {
                countIs++;
                index = nextIs + 2; // Move index to the end of the current "is" substring
            } else {
                break; // Exit the loop if no more "is" substrings found
            }
        }
        index = 0;
        while (index < input.length()) {
            int nextNot = input.indexOf("not", index);
            if (nextNot != -1) {
                countNot++;
                index = nextNot + 3; // Move index to the end of the current "not" substring
            } else {
                break; // Exit the loop if no more "not" substrings found
            }
        }
        return countIs == countNot;
    }
    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'g') {
                // Check if adjacent characters are not 'g' and 'g' is not the first or last character
                if ((i > 0 && input.charAt(i - 1) != 'g') && (i < input.length() - 1 && input.charAt(i + 1) != 'g')) {
                    return false;
                }
            }
        }
        return true;
    }



    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        if (input == null || input.length() < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < input.length() - 2; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == input.charAt(i + 1) && currentChar == input.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }
}
