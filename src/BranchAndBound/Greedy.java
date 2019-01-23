package BranchAndBound;

public class Greedy {


    public int getUpBound(int distance[][]){
        int visited[] = new int[50];
        int minDistance = 0;
        int tempMin = 9999;
        int nextCities = 0;
        visited[0] = 1;
        for(int i=0;i<50;i++){
            tempMin = 9999;
            for(int j=i+1;j<50;j++){
                if(distance[i][j] < tempMin && visited[j] == 0) {
                    tempMin = distance[i][j];
                    nextCities = j;

                }
            }
            minDistance += tempMin;
            i = nextCities;
            visited[i] = 1;
        }
        minDistance += distance[nextCities][49];
        return minDistance;
    }
}
