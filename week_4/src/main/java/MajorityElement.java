
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {

//        System.out.println(a.length);
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here

        int mid = (left+right)/2;
//        System.out.println(mid);
        int leftMaj = getMajorityElement(a, left,mid);
        int rightMaj = getMajorityElement(a,mid,right);

        int leftCount=0;
        int rightCount=0;

        //check if both the leftMajority and Right Majority are the same
        if(leftMaj==rightMaj)
            return leftMaj;
        else{
            //If there's no left Majority, check if the right Majority is Majority in the entire set and Vice Versa
            if(leftMaj==-1){
                rightCount = getCout(a,rightMaj,left,right);
                if(rightCount>(right-left)/2){
                    return rightMaj;
                }
                else
                    return -1;
            }
            else if(rightMaj==-1){
                leftCount = getCout(a,leftMaj,left,right);
                if(leftCount>(right-left)/2){
                    return leftMaj;
                }
                else
                    return -1;
            }
            //If both left and right recurrences has a majority and are not same, check the majority on the entire set.
            else {
                leftCount = getCout(a,leftMaj,left,right);
                rightCount = getCout(a,rightMaj,left,right);
            }

            if(leftCount>rightCount)
                return leftMaj;
            else if(leftCount<rightCount)
                return rightMaj;
            else
                return -1;
        }
//        return -1;
    }

    private static int getCout(int[] a, int leftMaj, int left, int right) {
        int count=0;
        for (int i=left;i<right;i++){
            if (a[i]==leftMaj)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

