/**
 *  https://www.hackerrank.com/challenges/jesse-and-cookies/submissions/code/384825202
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
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
    public static int cookies(int k, List<Integer> A) {
    // Write your code here
        //Create the queue:
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        //Populate the queue:
        qu.addAll(A);
        //Mix:
        int i=0;
        while(qu.peek() < k) {
            Integer a = qu.poll();
            Integer b = qu.poll();
            if(a == null || b == null) {
                return -1;
            }
            qu.add(a + 2 * b);
            i++;
        }
        return i;
    }
}

/*

    k = 9
    A = [2,3,4,6,6,7]

    i = 0;
    
    A = [4,6,6,7,8]
    i = 1;
    
    A = [6,7,8,16]
    i = 2;
    
    A = [8,16,20]
    i = 3;

    A = [20,40]
    i = 4;
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
