package BranchAndBound;

import BranchAndBound.Model.MinMatrix;
import BranchAndBound.ReadData.DataReader;
import BranchAndBound.Model.RoadData;

public class MainClass {
    public static void main(String[] args) {
        RoadData roadData = new RoadData();
        DataReader dataReader = new DataReader();
        roadData.setDistanceMatrixElement(dataReader.readData(0));
        roadData.setCostMatrixElement(dataReader.readData(1));
        MinMatrix minMatrix = new MinMatrix();
        minMatrix.setMinDistMatrix(roadData);
        minMatrix.setMinCostMatrix(roadData);
        minMatrix.calMinDist();
        minMatrix.calMinCost();
        BranchAndBound branchAndBound = new BranchAndBound();
        branchAndBound.search(roadData,minMatrix);
        //Greedy greedy = new Greedy();
        //System.out.println("Hello");
        //System.out.println(greedy.getUpBound(roadData.getDistanceMatrix()));

    }
}
