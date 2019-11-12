import java.util.*;

class BFS{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int mat[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				mat[i][j] = scan.nextInt();
			}
		}

		dfs(mat,n);
	}

	static void dfs(int mat[][],int n){
		int visited[] = new int[n];
		LinkedList <Integer> queue = new LinkedList<>(); 
		visited[0]=1;
		queue.add(0);
		int node = (int)queue.poll();
		System.out.print(node+" ");
		while(true){			
			for(int i=0;i<n;i++){
				if(mat[node][i]==1 && visited[i]==0){
					queue.add(i);
					visited[i] = 1;
				}
			}

			if(queue.size()==0){
				break;
			}else{
				node = (int)queue.poll();
				System.out.print(node+" ");
			}
		}
	}
}