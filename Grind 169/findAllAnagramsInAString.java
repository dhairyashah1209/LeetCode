import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean isAnagram(int stringChars[], int anagramChars[]) {
        for (int i = 0; i < 26; i++) {
            if (stringChars[i] != anagramChars[i])
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int strLength = s.length();
        int anagramLength = p.length();

        List<Integer> res = new ArrayList<>();
        if (strLength < anagramLength)
            return res;
        int stringMatchedChars[] = new int[26];
        int anagramMatchedChars[] = new int[26];

        for (int i = 0; i < anagramLength; i++) {
            stringMatchedChars[s.charAt(i) - 'a']++;
            anagramMatchedChars[p.charAt(i) - 'a']++;
        }
        if (isAnagram(stringMatchedChars, anagramMatchedChars))
            res.add(0);

        for (int i = anagramLength; i < strLength; i++) {
            stringMatchedChars[s.charAt(i) - 'a']++;
            stringMatchedChars[s.charAt(i - anagramLength) - 'a']--;
            if (isAnagram(stringMatchedChars, anagramMatchedChars))
                res.add(i - anagramLength + 1);
        }
        return res;
    }
}