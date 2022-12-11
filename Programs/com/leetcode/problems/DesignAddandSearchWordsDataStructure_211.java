package com.leetcode.problems;

class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();

        // [null,null,null,true,true,false,true,false,false]
        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.search(".")); // true
        System.out.println(wd.search("a")); // true
        System.out.println(wd.search("aa")); // false
        System.out.println(wd.search("a")); // true
        System.out.println(wd.search(".a")); // false
        System.out.println(wd.search("a.")); // false
    }

    public class dict {
        dict[] alp;
        boolean isWord = false;

        public dict(int size) {
            alp = new dict[size];
            for (int i = 0; i < size; i++) {
                alp[i] = null;
            }
            isWord = false;
        }
    }

    dict root = null;

    public WordDictionary() {
        root = new dict(26);
    }

    public void addWord(String word) {
        dict temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.alp[index] == null)
                temp.alp[index] = new dict(26);
            temp = temp.alp[index];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {

        return searchWord(word, 0, root);
    }

    public boolean searchWord(String word, int ind, dict temp) {
        if (ind == word.length())
            return temp.isWord;
        char ch = word.charAt(ind);

        if (ch == '.') {
            for (int i = 0; i < 26; i++)
                if (temp.alp[i] != null && searchWord(word, ind + 1, temp.alp[i]))
                    return true;
        } else {
            if (temp.alp[ind] != null)
                return searchWord(word, ind + 1, temp.alp[ind]);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
