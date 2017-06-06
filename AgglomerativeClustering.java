import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Arrays;

//Reference : http://home.deib.polimi.it/matteucc/Clustering/tutorial_html/hierarchical.html

public class AgglomerativeClustering
{
	

	public static void main(String[] args){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
		String line = br.readLine();
		String[] pair;
		int id = 0;
		HashMap<Integer,ArrayList<Integer>> listOfClusters = new HashMap<Integer,ArrayList<Integer>>();
		HashMap<Integer,Coordinate> map = new HashMap<Integer,Coordinate>();
		ArrayList<Integer> currentNode;
		
		while(!line.trim().equals("")){
			pair = line.split(",");
			map.put(id,new Coordinate(Double.parseDouble(pair[0].trim()),Double.parseDouble(pair[1].trim())));
			currentNode = new ArrayList<Integer>();
			currentNode.add(id);
			listOfClusters.put(id,currentNode);
			id++;
			line = br.readLine();
		}
		double[][] distanceMatrix = new double[id][id];
		for(int i = 0; i < id ; i++){
			for(int j = i; j < id ; j++){
				if(i == j)
					distanceMatrix[i][j] = 0;
				else if(distanceMatrix[j][i] != 0)
					distanceMatrix[i][j] = distanceMatrix[j][i];
				else
					distanceMatrix[i][j] = getEuclideanDistance(i,j,map);
			}
		}
		int[] trackIndex = new int[id];
		//Arrays.fill(trackIndex, -1);
		for(int i = 0; i < id ; i++){
			trackIndex[i] = i; 
		}
		//System.out.println(Arrays.deepToString(distanceMatrix));
		while(listOfClusters.size() > 1){
			//System.out.println("size of map"+listOfClusters.size());
			Coordinate minCor = findMinDistanceMatrix(distanceMatrix); 
			int parentIndex = (int) minCor.getX();
			int childIndex = (int) minCor.getY();
			System.out.println(minCor.toString());
			trackIndex[parentIndex] = parentIndex;
			trackIndex[childIndex] = parentIndex;
			ArrayList<Integer> list = listOfClusters.get(parentIndex);
			System.out.println(Arrays.toString(trackIndex));
			list.addAll(listOfClusters.get(childIndex));
			listOfClusters.put(parentIndex,list);
			listOfClusters.remove(childIndex);
			distanceMatrix = updateDistanceMatrix(distanceMatrix, minCor);
			System.out.println(Arrays.deepToString(distanceMatrix));
			System.out.println("************************************");
			for(Entry<Integer,ArrayList<Integer>> element : listOfClusters.entrySet()){
				System.out.println("#############");
				for(int val : element.getValue()){
					System.out.println(val+1);
				}
				System.out.println("#############");
			}
			System.out.println("************************************");
		}
		//System.out.println("completed clustering");
		//System.out.println("size of map"+listOfClusters.size());
		for(Entry<Integer,ArrayList<Integer>> element : listOfClusters.entrySet()){
			for(int val : element.getValue()){
				System.out.println(val+1);
			}
		}
		
		}
		catch(IOException e){
			
		}
	}
	
	public static double[][] updateDistanceMatrix(double[][] distanceMatrix, Coordinate minCor){
		double[][] newDistanceMatrix = null;
		int parentIndex = (int)minCor.getX();
		int childIndex = (int)minCor.getY();
		int len = distanceMatrix.length;
		for(int i = 0; i < len; i++){
			if(distanceMatrix[parentIndex][i] != 0 && distanceMatrix[childIndex][i] !=0){
			distanceMatrix[parentIndex][i] = Math.min(distanceMatrix[parentIndex][i],distanceMatrix[childIndex][i]);
			//distanceMatrix[childIndex][i] = distanceMatrix[parentIndex][i];
			distanceMatrix[childIndex][i] = Double.MAX_VALUE;
			}
		}
		distanceMatrix[parentIndex][childIndex] = Double.MAX_VALUE;
		newDistanceMatrix = distanceMatrix;
		return newDistanceMatrix;
	}
	
	public static Coordinate findMinDistanceMatrix(double[][] distanceMatrix){
		Coordinate retVal = null;
		double min = Double.MAX_VALUE;
		int len = distanceMatrix.length;
		
		for(int i = 0; i < len; i++){
			for(int j = i + 1; j < len ; j++){
				if(i == j){
					continue;
				}
				System.out.println("distanceMatrix["+ i + j +"] "+distanceMatrix[i][j]);
				if(distanceMatrix[i][j] < min){
					min = distanceMatrix[i][j];
					retVal = new Coordinate(i,j);
				}
			}
		}
		return retVal;
	}
	
	public static double getEuclideanDistance(int i,int j, HashMap<Integer,Coordinate> map){
		Coordinate c1= map.get(i);
		Coordinate c2= map.get(j);
		double distance = 0;
		double x = Math.abs(c1.getX() - c2.getX());
		double y = Math.abs(c1.getY() - c2.getY());
		distance = Math.sqrt(x*x + y*y);
		return distance;
	}
		
	private static class Cluster{
		int id;
		public Cluster(int id){
			this.id=id;
		}
	}	

	private static class Coordinate{
		double x;
		double y;
		
		public Coordinate(double x, double y){
			this.x=x;
			this.y=y;
		}
		
		public double getX(){
			return this.x;
		}
		
		public double getY(){
			return this.y;
		}
		@Override
		public String toString(){
			return "x is "+this.getX()+" y is "+this.getY();
		}
	}
	
	private static class IdToCoordinate{
		int id;
		Coordinate val;
	
		public IdToCoordinate(int id, Coordinate val){
			this.id=id;
			this.val=val;
		}
	}

}
