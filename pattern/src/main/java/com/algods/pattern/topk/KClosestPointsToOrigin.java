package com.algods.pattern.topk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Given an array of points in a 2D plane, find ‘K’ closest points to the origin.
 * The Euclidean distance of a point P(x,y) from the origin can be calculated through the following formula:
	sqrt{x^2 + y^2}

 * @author tarini
 *
 */
public class KClosestPointsToOrigin {

	public static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int distanceFromOrigin() {
			// ignoring sqrt
			return (x*x) + (y*y);
		}
	}
	
	public static List<Point> findClosestPoints(Point[] pts, int k){
		PriorityQueue<Point> maxHeap = new PriorityQueue<>((a,b) -> b.distanceFromOrigin() - a.distanceFromOrigin());
		
		// put first 'k' points in the max heap
		for(int i=0; i<k; i++) {
			maxHeap.add(pts[i]);
		}
		
	    // go through the remaining points of the input array, if a point is closer to the origin than the top point 
	    // of the max-heap, remove the top point from heap and add the point from the input array
		for(int i=k; i<pts.length; i++) {
			if(pts[i].distanceFromOrigin() < maxHeap.peek().distanceFromOrigin()) {
				maxHeap.poll();
				maxHeap.add(pts[i]);
			}
		}
		return new ArrayList<>(maxHeap);
	}
	
	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
	    List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
	    System.out.print("Here are the k points closest the origin: ");
	    for (Point p : result)
	      System.out.print("[" + p.x + " , " + p.y + "] ");
	}
}
