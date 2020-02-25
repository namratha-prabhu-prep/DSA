package Tries;

import java.util.Arrays;

public class Trie {
    class TrieNode {
        int noOfStrings = 0;
        TrieNode[] trieNodes = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    public void insert(String s) {
        TrieNode current = root;
        // Going through the characters in the string s,
        // checking if the parent node has a pointer to
        // that character
        for(int i = 0; i < s.length(); i++) {
            if(current.trieNodes[s.charAt(i) - 'a'] == null){
                current.trieNodes[s.charAt(i) - 'a'] = new TrieNode();
            }
            current = current.trieNodes[s.charAt(i) - 'a'];
        }
        current.noOfStrings++;
    }

    public boolean search(String s) {
        TrieNode current = root;
        for(int i = 0; i < s.length(); i++) {
            if (current == null || current.trieNodes[s.charAt(i) - 'a'] == null) {
                return false;
            }
            current = current.trieNodes[s.charAt(i) - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("top");
        trie.insert("tap");
        System.out.println(Arrays.toString(trie.root.trieNodes[19].trieNodes));
        System.out.println("Search " + trie.search("tp"));
    }
}
