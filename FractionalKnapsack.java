import java.util.*;
import java.io.*;

class Item{
    double weight;
    double profit;
    Double cost;
    Item(double weight, double profit){
        this.weight = weight;
        this.profit = profit;
        cost = new Double(profit/weight);
    }
}

class FractionalKnapsack{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = new PrintStream(System.out);

        //taking inputs of no. of items 
        ps.println("Enter the no. of items and maximum weight!");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double capacity = Double.parseDouble(st.nextToken());

        double weight[] = new double[n];
        double profit[] = new double[n];

        ps.println("Enter the elements of the weight array!");
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            weight[i] = Double.parseDouble(st.nextToken());
        }

        ps.println("Enter the elements of the profit array!");
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            profit[i] = Double.parseDouble(st.nextToken());
        }

        Item item[] = new Item[n];
        for(int i=0;i<n;i++){
            item[i] = new Item(weight[i], profit[i]);
        }

        //Sorting the Item class
        Arrays.sort(item, (o1, o2) -> o2.cost.compareTo(o1.cost));
        int tProfit = 0;
        for(Item i : item){

            int cWeight = (int)i.weight;
            int cProfit = (int)i.profit;

            if(cWeight <= capacity){
                tProfit = tProfit + cProfit;
                capacity = capacity - cWeight;
            }else{
                double fraction = capacity/i.weight;
                tProfit = (int) (tProfit + fraction * cProfit);
                capacity = capacity - cWeight*fraction;
                break;
            }
        }

        ps.println("The maximum profit will be : "+ tProfit);

        
    }
}