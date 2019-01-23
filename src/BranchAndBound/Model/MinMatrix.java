package BranchAndBound.Model;
import BranchAndBound.BranchAndBound;
import BranchAndBound.Model.RoadData;

import java.util.Arrays;

public class MinMatrix {
    private int minDistMatrix[][];
    private int minCostMatrix[][];

    public MinMatrix(){
        minDistMatrix = new int[50][50];
        minCostMatrix = new int[50][50];
    }

    public void setMinDistMatrix(RoadData roadData){
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++)
                minDistMatrix[i][j] = roadData.getTwoCitiesDistance(i,j);
        }
        for(int j=0;j<50;j++){
            minDistMatrix[j][j] = 9999;
        }
    }

    public void setMinCostMatrix(RoadData roadData){
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++)
                minCostMatrix[i][j] = roadData.getTwoCitesCost(i,j);
        }
        for(int j=0;j<50;j++){
            minCostMatrix[j][j] = 0;
        }
    }
    //求解两个城市间的最小距离，使用Floyd算法
    public void calMinDist(){
        floyd(this.minDistMatrix);
    }
    //求解两个城市间的最低费用，使用Floyd算法
    public void calMinCost(){
        floyd(this.minCostMatrix);
    }

    /**
     * Floyd算法求解两个城市间的最小距离和最低费用
     * @param data
     */
    public void floyd(int data[][]){
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                for(int k=0;k<50;k++){
                    if(data[j][i] + data[i][k] < data[j][k])
                        data[j][k] = data[j][i] + data[i][k];
                }

            }
        }
    }


    public int getMinDist(int city1, int city2){
        return this.minDistMatrix[city1][city2];
    }

    public int getMinCost(int city1, int city2){
        return this.minCostMatrix[city1][city2];
    }

    public void printMinMatrix(){
        for(int i=0;i<this.minDistMatrix.length;i++)
            System.out.println(Arrays.toString(this.minDistMatrix[i]));
        for(int i=0;i<this.minCostMatrix.length;i++)
            System.out.println(Arrays.toString(this.minCostMatrix[i]));
    }
}
