package com.algods.pattern.topk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are given a list of tasks that need to be run, in any order, on a server.
 * Each task will take one CPU interval to execute but once a task has finished,
 * it has a cooling period during which it can’t be run again. If the cooling
 * period for all tasks is ‘K’ intervals, find the minimum number of CPU
 * intervals that the server needs to finish all tasks.
 * 
 * @author tarini
 *
 */
public class TaskScheduler {
	
	/**
	 * The time complexity of the above algorithm is O(N*logN)
	 * Space complexity O(N)
	 * @param tasks
	 * @param k
	 * @return
	 */
	public static int scheduleTasks(char[] tasks, int k) {
		int intervalCount = 0;
		Map<Character, Integer> taskFreqMap = new HashMap<>();
		
		for(char t: tasks) {
			taskFreqMap.put(t, taskFreqMap.getOrDefault(t, 0)+1);
		}
			
		PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());
		
		maxHeap.addAll(taskFreqMap.entrySet());
		
		while(!maxHeap.isEmpty()) {
			List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
			
			int n = k+1;
			
			for(; n>0 && !maxHeap.isEmpty(); n--) {
				intervalCount++;
				Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
				if(currentEntry.getValue() > 1) {
					currentEntry.setValue(currentEntry.getValue() - 1 );
					waitList.add(currentEntry);
				}
			}
			
			maxHeap.addAll(waitList);
			if(!maxHeap.isEmpty()) {
				intervalCount += n;
			}
		}
		
		
		return intervalCount;
	}
	
	public static void main(String[] args) {
		char[] tasks = new char[] {'a', 'a', 'a', 'b', 'c', 'c'};
		System.out.println("Minimum interval needed to complete all tasks :"+ TaskScheduler.scheduleTasks(tasks, 2));
		
		tasks = new char[] { 'a', 'b', 'a' };
	    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
		
	}
}
