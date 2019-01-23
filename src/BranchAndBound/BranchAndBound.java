package BranchAndBound;

import BranchAndBound.Model.MinMatrix;
import BranchAndBound.Model.RoadData;

public class BranchAndBound {



    public void search(RoadData roadData, MinMatrix minMatrix){
        int queue[] = new int[52];
        int p = 0; //队列指针
        queue[p] = 0;
        queue[p+1] = 0;
        int visited[] = new int[52];
        visited[0] = 1;
        int count = 0;
        int currentCity = 0, nextCity; //分别表示当前所处城市以及下一个城市
        int curentDist = 0, currentCost = 0; //分别表示从甲城市到当前所处城市的路径长度和路费

        //Greedy greedy = new Greedy();


        int distBound = 9999, costBound = 1500;
        int bestPath[] = new int[50]; //记录最优解路径
        int bestCitiesNum = 0; //记录最优解中城市的个数
        int minDist = 0, minCost = 0; //记录最优解的距离长度和费用
        int i,j;
        while(p>=0){
            currentCity = queue[p];
            nextCity = queue[p+1];
            for(i=nextCity+1;i<50;i++){
                //如果从甲城市到当前所处城市的路径长度加上从该城市到达乙城市的最小距离大于距离上界
                //如果从甲城市到当前所处城市的路费加上从该城市到达乙城市的最低路费大于路费上界
                //如果当前城市不与下一个城市有通路
                //如果下个城市已经访问过
                //则剪枝
                if((curentDist + minMatrix.getMinDist(currentCity,49)) >= distBound
                || currentCost + minMatrix.getMinCost(currentCity,49) > costBound
                || roadData.getTwoCitiesDistance(currentCity,i) == 9999
                || visited[i] == 1){
                    continue;
                }
                //当找到一个可行结点时终止循环
                else
                    break;
            }
            //判断循环结束是否是因为找到可行结点
            //如果不是因为找到可行结点，则回溯
            if(i==50){

                p--;
                curentDist -= roadData.getTwoCitiesDistance(queue[p],queue[p+1]);
                currentCost -= roadData.getTwoCitesCost(queue[p],queue[p+1]);
                visited[queue[p+1]] = 0;


            }
            //找到可行结点，即找到当前城市的一个邻近城市
            else{
                curentDist += roadData.getTwoCitiesDistance(queue[p],i);
                currentCost += roadData.getTwoCitesCost(queue[p],i);
                p++;
                queue[p] = i; //将当前城市加入队列中
                queue[p+1] = 0;
                visited[i] = 1; //该城市被访问

                //找到一个可行解
                if(i == 49){
                    for(j=0;j<=p;j++)
                        bestPath[j] = queue[j];
                    bestCitiesNum = p;

                    //更新界，只要找到可行解，则一定为从甲到乙的最短距离
                    distBound = curentDist;

                    //记录最短距离和最小费用的值
                    minDist = curentDist;
                    minCost = currentCost;
                    if(minCost>1500)
                        continue;
                    bestPath[bestCitiesNum] = 49;
                    System.out.println("最优解的路径为");
                    for(int k=0;k<bestCitiesNum;k++)
                        System.out.print(bestPath[k] + " ");
                    System.out.println();
                    System.out.println("最短路径为: " + minDist + ", 此时的费用为: " + minCost);


                    p--; //进行回溯，寻找其他可行解
                    curentDist -= roadData.getTwoCitiesDistance(queue[p],queue[p+1]);
                    currentCost -= roadData.getTwoCitesCost(queue[p],queue[p+1]);
                    visited[queue[p+1]] = 0;

                    p--;
                    curentDist -= roadData.getTwoCitiesDistance(queue[p],queue[p+1]);
                    currentCost -= roadData.getTwoCitesCost(queue[p],queue[p+1]);
                    visited[queue[p+1]] = 0;

                }
            }
        }

    }
}
