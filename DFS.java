import java.util.*;

class DFS{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int v = scan.nextInt();
		int mat[][] = new int[v][v];
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				mat[i][j] = scan.nextInt();
			}
		}
		dfs(mat,v);
	}

	static void dfs(int mat[][], int v){
		boolean visited[] = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();
		visited[0] = true;
		stack.add(0);
		int node = stack.pop();
		System.out.print(node+" ");
		while(true){
			for(int i=0;i<v;i++){
				if(mat[node][i]==1 && visited[i]){
					stack.push(i);
					visited[i] = true;
				}
			}

			if(stack.size()==0){
				break;
			}else{
				node = stack.pop();
				System.out.print(node+" ");
			}
		}
	}
}