package BranchAndBound.Model;

import java.util.Arrays;

public class RoadData {
    private int distanceMatrix[][];
    private int costMatrix[][];

    public RoadData(){
        distanceMatrix = new int [50][50];
        costMatrix = new int [50][50];
    }
    public void setDistanceMatrixElement(int distance[][]){
        for(int i=0;i<50;i++){
            this.distanceMatrix[i] = distance[i].clone();
        }
    }
    public void setCostMatrixElement(int cost[][]){
        for(int i=0;i<50;i++){
            this.costMatrix[i] = cost[i].clone();
        }
    }

    public int getTwoCitiesDistance(int cites_1, int cites_2){
        return distanceMatrix[cites_1][cites_2];

    }
    public int getTwoCitesCost(int cites_1, int cites_2){
        return costMatrix[cites_1][cites_2];
    }
    public void printDistance(){
        for(int i=0;i<this.distanceMatrix.length;i++)
            System.out.println(Arrays.toString(this.distanceMatrix[i]));
    }
    public void printCost(){
        for(int i=0;i<this.costMatrix.length;i++)
            System.out.println(Arrays.toString(this.costMatrix[i]));
    }

    public int [][] getDistanceMatrix(){
        return this.distanceMatrix;
    }
}
