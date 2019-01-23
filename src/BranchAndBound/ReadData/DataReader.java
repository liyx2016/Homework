package BranchAndBound.ReadData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public int[][] readData(int type){
        int data[][] = new int[50][50];
        String filePath;
        if(type == 0)
            filePath = "E:\\学习\\算法分析与设计\\作业\\Assignment_2\\m1.txt";
        else
            filePath = "E:\\学习\\算法分析与设计\\作业\\Assignment_2\\m2.txt";
        int lineCount = 0;
        String readLine;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            readLine = new String();
            int dataColumn;
            while((readLine = br.readLine()) != null){
                String []temp = readLine.split("\t");

                dataColumn = 0;
                while(dataColumn < temp.length) {
                    data[lineCount][dataColumn] = Integer.parseInt(temp[dataColumn]);
                    dataColumn++;
                }
                lineCount++;
            }
            br.close();
            fr.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return data;
    }

    public void printData(int data[][]){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data.length;j++)
                System.out.print(data[i][j] + " ");
            System.out.println();
        }
    }
}
