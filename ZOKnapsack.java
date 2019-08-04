import java.util.*;
import java.io.*;

class ZOKnapsack{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = new PrintStream(System.out);

        //taking inputs of no. of items 
        ps.println("Enter the no. of items and maximum weight!");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        //declaring weight and profit array
        int weight[] = new int[n];
        int profit[] = new int[n];

        ps.println("Enter the elements of the weight array!");
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        ps.println("Enter the elements of the values array!");
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            profit[i] = Integer.parseInt(st.nextToken());
        }

        //Declaring knapsack array
        int knapsack[][] = new int[n+1][max+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=max;j++){
                if(i==0 || j==0)
                    knapsack[i][j] = 0;
                else if(j>=weight[i-1])
                    knapsack[i][j] = Math.max(knapsack[i-1][j], knapsack[i-1][j-weight[i-1]]+profit[i-1]);
                else 
                    knapsack[i][j] = knapsack[i-1][j];
            }
        }

        System.out.println("Maximum profit will be "+ knapsack[n][max]);
        int j=max;
        int v = knapsack[n][j]; 

        //printing profit of the elements which will be taken
        for(int i=n;i>0 && v>0;i--){
            if(knapsack[i-1][j]==v)
                continue;
            else{
                ps.print(profit[i-1]+" ");
                v=v-profit[i-1];
                j=j-weight[i-1];
            }
        }ps.println();
    }
}