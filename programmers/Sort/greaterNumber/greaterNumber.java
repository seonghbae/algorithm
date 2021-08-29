import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] s = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) s[i] = Integer.toString(numbers[i]);
        Arrays.sort(s, new Comparator<String>(){
           public int compare(String o1, String o2){
               return -(o1+o2).compareTo(o2+o1);
           } 
        });
        if(s[0].compareTo("0")==0) return "0";
        return String.join("", s);
    }
}