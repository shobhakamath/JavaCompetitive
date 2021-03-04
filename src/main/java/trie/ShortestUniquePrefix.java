package trie;

import static junit.framework.TestCase.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ShortestUniquePrefix {
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        for (String str : strs) {
            root.insert(str);
        }
        return root.returnCommonCharacters();
    }

    @Test
    public void findLongestCommonPrefix() {
        String[] words = { "flower", "flow", "flight" };
        assertEquals(longestCommonPrefix(words),"fl");

    }
    @Test
    public void emptyLongestCommonPRefix(){
        String[] words = {"dog","racecar","car" };
        assertEquals(longestCommonPrefix(words),"");
    }
}

class Trie {
    Map<Character, Trie> children  = new HashMap<>();
    int                  frequency = 0;
    boolean              isEnd     = false;

    public void insert(String str) {
        Trie current = this;
        for (Character c : str.toCharArray()) {
            current.children.putIfAbsent(c, new Trie());
            current.children.get(c).frequency = ++current.children.get(c).frequency;
            current = current.children.get(c);
        }
        current.isEnd = true;
    }

    public String returnCommonCharacters() {
        String commonChar = "";
        int maxOccurence = -1;
        Trie current = this;
        while (current != null && !current.isEnd && current.children.size()==1 && current.children.size()==1) {
            for (Map.Entry<Character, Trie> characterTrieEntry : current.children.entrySet()) {

                if (characterTrieEntry.getValue().frequency > maxOccurence) {
                    commonChar = characterTrieEntry.getKey().toString();
                    maxOccurence = characterTrieEntry.getValue().frequency;
                } else if (characterTrieEntry.getValue().frequency == maxOccurence) {
                    commonChar += characterTrieEntry.getKey();
                }
                current = characterTrieEntry.getValue();
            }

        }
        return commonChar;

    }
}

