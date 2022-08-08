package com.realworld.netflix.grptitle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrpSimilarTitle {

	public static List<List<String>> groupTitles(String[] titles){
		
		if(titles.length == 0) {
			return new ArrayList<List<String>>();
		}
		
		Map<String, List<String>> titleGroup = new HashMap<>();
		
		int[] alphaCount = new int[26];
		
		for(String s : titles) {
			Arrays.fill(alphaCount, 0);
			
			for(char c: s.toCharArray()) {
				int index = c - 'a';
				alphaCount[index]++;
			}
			
			StringBuilder keyBuilder = new StringBuilder("");
			for(int i: alphaCount) {
				//keyBuilder.append("#");
				keyBuilder.append(i);
			}
			
			String key = keyBuilder.toString();
			System.out.println(key);
			if(!titleGroup.containsKey(key)) {
				titleGroup.put(key, new ArrayList<String>());
			}
			
			titleGroup.get(key).add(s);
		}
		
		return new ArrayList<>(titleGroup.values());
	}
	
	public static void main(String[] args) {
		// Driver code
        String titles[] = {"duel","dule","speed","spede","deul","cars"};

        List<List<String>> gt = groupTitles(titles);
        String query = "spede"; 

        // Searching for all titles
        for (List<String> g : gt){
            if (g.contains(query))
                System.out.println(g);
        }
	}
	
}
