import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException{
		int i = 1;
		int u, v;
		int chk = 0;
		String str = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> tree = new HashMap<Integer, Integer>();
		
		while(true) {
			if(!st.hasMoreTokens()) {
				str = br.readLine();
				if(str.isEmpty()) {
					str = br.readLine();
				}
				st = new StringTokenizer(str);
			}
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			if(u == -1 && v == -1) {
				br.close();
				break;
			}
			else if(u == 0 && v == 0) {
				for(int item : tree.values().stream().distinct().collect(Collectors.toList())) {
					if(!tree.containsKey(item)) {
						chk++;
					}
				}
				if(tree.isEmpty()) {
					chk++;
				}
				if(chk == 1) {
					System.out.printf("Case %d is a tree.\n", i);
				}
				else {
					System.out.printf("Case %d is not a tree.\n", i);
				}
				i++;
				chk = 0;
				tree.clear();
			}
			else if(u == v || tree.containsKey(v)) {
				chk = -1;
			}
			else {
				tree.put(v, u);
			}
		}
	}
}
