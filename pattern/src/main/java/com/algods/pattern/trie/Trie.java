package com.algods.pattern.trie;

import java.util.Arrays;
import java.util.List;

public class Trie {
	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public static String repeat(String str, int pValue) {
		String out = "";
		for (int i = 0; i < pValue; i++) {
			out += str;
		}
		return out;
	}

	public static String printWithMarkers(String word, int index) {
		String out = "";
		for (int i = 0; i < word.length(); i++) {
			if (i == index) {
				out += "«";
				out += String.valueOf(word.charAt(i)) + "» ";
			} else
				out += String.valueOf(word.charAt(i)) + " ";
		}
		return out;
	}

	// inserting string in trie
	public void insert(String word) {
		TrieNode trieNode = this.root;
		// adding string characters in the tree
		System.out.println("\n\tAdding string characters to the trie");
		int j = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			System.out.println("\tLoop index " + j);
			System.out.println("\t\t" + printWithMarkers(word, j));
			j += 1;
			System.out.println("\t\tcharacter: " + c);
			if (!trieNode.children.containsKey(c)) {
				System.out.println("\t\t\t" + c + " is not in the trie, creating a new node");
				trieNode.children.put(c, new TrieNode());
			} else {
				System.out.println("\t\t\t" + c + " is already in the trie, hence we move to the next character");
			}
			System.out.println("\t\t\tCurrent state of trie");
			Print.printState(this.root, "\n\t\t\t");
			System.out.println();
			trieNode = trieNode.children.get(c);
		}
		j = 0;
		System.out.println("\n\t\t\tThe word is complete, setting the isWord variable to true");
		trieNode.isWord = true;
		System.out.println("\t\t\t\tisWord: " + trieNode.isWord);
		Print.printState(this.root, "\n\t\t\t");
	}

	// searching for a string
	public boolean search(String word) {
		System.out.println("\n\tSearching for a string");
		TrieNode trieNode = this.root;
		int j = 0;
		// iterate over the string characters and check in the node's children
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			System.out.println("\tLoop index " + j);
			System.out.println("\t\t" + printWithMarkers(word, j));
			System.out.println("\t\tcharacter: " + c);
			if (j == 0)
				System.out.println("\t\tRoot's children: " + trieNode.children.keySet());
			else
				System.out.println("\t\tNode " + word.charAt(j - 1) + "'s children: " + trieNode.children.keySet());
			if (!trieNode.children.containsKey(c)) {
				System.out.println("\t\tCharacter '" + c + "' is not present in the node's children, returning False");
				return false;
			} else
				System.out.println(
						"\t\tCharacter '" + c + "' is present in the node's children, moving to the next character.");
			trieNode = trieNode.children.get(c); // update the node since as we're moving to the next character
			j += 1;
		}
		if (trieNode.isWord) {
			System.out.println("\tAll characters are present in the trie and isWord: " + trieNode.isWord);
			System.out.println("\tWord found!");
		} else {
			System.out.println("\tAll characters are found, however, isWord: " + trieNode.isWord);
			System.out.println("\tWord not found!");
		}
		return trieNode.isWord; // if isWord is true, the string exists
	}

	public boolean searchPrefix(String prefix) {
		System.out.println("\n\tSearching for a prefix");
		TrieNode trieNode = this.root;
		int j = 0;
		// iterate over the string characters and check in the node's children
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			System.out.println("\tLoop index " + j);
			System.out.println("\t\t" + printWithMarkers(prefix, j));
			System.out.println("\t\tcharacter: " + c);
			if (j == 0)
				System.out.println("\t\tRoot's children: " + trieNode.children.keySet());
			else
				System.out.println("\t\tNode " + prefix.charAt(j - 1) + "'s children: " + trieNode.children.keySet());
			if (!trieNode.children.containsKey(c)) {
				System.out.println("\t\tCharacter '" + c + "' is not present in the node's children, returning False");
				return false;
			} else
				System.out.println(
						"\t\tCharacter '" + c + "' is present in the node's children, moving to the next character.");
			trieNode = trieNode.children.get(c); // update the node since as we're moving to the next character
			j += 1;
		}
		System.out.println("\tPrefix found!");
		return true;

	}

	public static void main(String args[]) {
		List<String> keys = Arrays.asList("the", "a", "there", "answer");
		Trie trieOfKeys = new Trie();
		int num = 1;
		for (String x : keys) {
			System.out.println(num + ".\tInserting key: " + x);
			trieOfKeys.insert(x);
			num += 1;
			System.out.println();
			System.out.println(repeat("-", 100));
		}

		List<String> search = Arrays.asList("a", "answer", "xyz", "an");
		for (String y : search) {
			System.out.println(num + ".\tSearching key: " + y);
			System.out.println("\t" + trieOfKeys.search(y));
			num += 1;
			System.out.println(repeat("-", 100));
		}
		
		
		List < String > searchPrefix = Arrays.asList("b", "an");
	    for (String z: searchPrefix) {
	      System.out.println(num + ".\tSearching prefix: " + z);
	      System.out.println("\t" + trieOfKeys.searchPrefix(z));
	      num += 1;
	      System.out.println(repeat("-", 100));
	    }
	}
}
