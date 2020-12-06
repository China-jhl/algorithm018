package com.most.av.videoapp.algorithm;


public class Trie {
    private boolean isEnd;
    private Trie[] nodes;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        isEnd = false;
        nodes = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() <= 0) return;
        Trie trie = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            int idx = w[i] - 'a';
            if (trie.nodes[idx] == null) {
                trie.nodes[idx] = new Trie();
            }
            trie = trie.nodes[idx];
        }
        trie.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        return trie != null;
    }

    private Trie searchPrefix(String word) {
        if (word == null || word.length() <= 0) return null;
        Trie trie = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            trie = trie.nodes[w[i] - 'a'];
            if (trie == null) return null;
        }
        return trie;
    }
}
