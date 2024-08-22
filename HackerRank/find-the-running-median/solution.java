/**
 *  https://www.hackerrank.com/challenges/find-the-running-median/submissions/code/384827381
**/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian_slow(List<Integer> a) {    //O((n^2)Logn)
        ArrayList<Integer> iList = new ArrayList<>();
        ArrayList<Double> rList = new ArrayList<>();
        int i = 0;
        for(int aa : a) {    //O(n)
            iList.add(aa);
            Collections.sort(iList);    //O(nLog(n))
            i++;
            if(i % 2 != 0) {
                rList.add((double)iList.get((int)(i/2)));
            }
            else {
                int t = (int)(i/2);
                rList.add((double)(iList.get(t-1) + iList.get(t))/2);
            }
        }
        return rList;
    }
    
    public static List<Double> runningMedian(List<Integer> a) {        //O(nLogn)
        PriorityQueue<Integer> minQu = new PriorityQueue<>();
        PriorityQueue<Integer> maxQu = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Double> rList = new ArrayList<>();
        int i = 0;
        for(int aa : a) {    //O(n)
            //Add the value to the correct side:
            if(minQu.size() == 0 || aa >= minQu.peek()) {
                minQu.add(aa);    //O(Logn)
            }
            else {
                maxQu.add(aa);
            }
            //Balance the sides:
            int t = minQu.size() - maxQu.size();
            if(t < -1) {
                minQu.add(maxQu.poll());    //O(Logn)
            }
            else if(t > 1) {
                maxQu.add(minQu.poll());
            }
            //Get and store the median:
            if(t%2 == 0) {
                rList.add((double)(minQu.peek() + maxQu.peek()) / 2);
            }
            else if(t > 0) {
                rList.add((double)minQu.peek());
            }
            else {
                rList.add((double)maxQu.peek());
            }
        }
        return rList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
