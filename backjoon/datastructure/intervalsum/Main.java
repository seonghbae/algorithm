import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	
	static long init(long[] arr, int begin, int end, int node) {
		if(begin==end) return tree[node] = arr[begin];
		int mid = (begin+end)/2;
		return tree[node] = init(arr, begin, mid, node*2) + init(arr, mid+1, end, node*2+1);
	}
	
	static long sum(int node, int begin, int end, int left, int right) {
		if(left>end||right<begin) return 0;
		if(left<=begin&&end<=right) return tree[node];
		int mid = (begin+end)/2;
		return sum(node*2, begin, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
	}
	
	static void update(int node, int begin, int end, int index, long diff) {
		if(index<begin||end<index) return;
		tree[node] += diff;
		if(begin==end) return;
		int mid = (begin+end)/2;
		update(node*2, begin, mid, index, diff);
		update(node*2+1, mid+1, end, index, diff);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int log = (int)Math.ceil(Math.log10(N)/Math.log10(2));
		int exp = (int)Math.pow(2, log);
		long[] lazy = new long[N];
		for(int i=0; i<N; i++) {
			lazy[i] = Long.parseLong(br.readLine());
		}
		tree = new long[2*exp+1];
		init(lazy, 0, N-1, 1);
		while(M+K-->0) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			long c = Long.parseLong(st2.nextToken());
			if(a==1) {
				long diff = c-lazy[b-1];
				lazy[b-1] = c;
				update(1, 0, N-1, b-1, diff);
			}
			else if(a==2) {
				long sum = sum(1, 0, N-1, b-1, (int)c-1);
				System.out.println(sum);
			}
		}
	}
}
