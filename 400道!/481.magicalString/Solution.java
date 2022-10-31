public class Solution {

    public int magicalString(int n) {
        int[] str = new int[100001];
        str[0] = 1;
        str[1] = 2;
        int i=1,j=1;
        int flag = 1;
        while(i<100001){
            int num = str[j];
            for (int k=0;k<num;k++){
                str[i++] = 1+flag;
            }
            flag = flag==1?0:1;
            j++;
        }
    }
}