/**
 *  https://www.hackerrank.com/challenges/the-quickest-way-up/submissions/code/384837597
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
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY ladders
     *  2. 2D_INTEGER_ARRAY snakes
     */

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        HashMap<Integer, Integer> lMap = new HashMap<>();
        HashMap<Integer, Integer> sMap = new HashMap<>();
        LinkedList<Integer> visitQueue = new LinkedList<>();
        HashSet<Integer> visitedSquares = new HashSet<>();
        for(List<Integer> l : ladders) {
            lMap.put(l.get(0),l.get(1));
        }
        for(List<Integer> s : snakes) {
            sMap.put(s.get(0),s.get(1));
        }
        visitQueue.add(1);
        int currentMoves = 0;
        while(!visitQueue.isEmpty()) {
            int visitLength = visitQueue.size();
            //System.err.println();
            //System.err.println(visitQueue);
            while(visitLength-- > 0) {
                int currentSquare = visitQueue.poll();
                //System.err.print(currentSquare + "|" + currentMoves + " ");
                if(currentSquare > 100) {
                    continue;
                }
                if(currentSquare == 100) {
                    return currentMoves;
                }
                if(visitedSquares.contains(currentSquare)) {
                    continue;
                }
                visitedSquares.add(currentSquare);
                if(lMap.containsKey(currentSquare)) {
                    currentSquare = lMap.get(currentSquare);
                    if(currentSquare == 100) {
                        return currentMoves;
                    }
                }
                if(sMap.containsKey(currentSquare)) {
                    currentSquare = sMap.get(currentSquare);
                }
                for(int i=1;i<7;i++) {
                    visitQueue.add(i+currentSquare);
                }
            }
            currentMoves++;
        }
        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.quickestWayUp(ladders, snakes);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
