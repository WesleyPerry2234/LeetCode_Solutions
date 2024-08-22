/**
 * https://leetcode.com/problems/number-of-provinces/submissions/1271757584
 * submitted at May 29, 2024 12:37
**/

class Solution {
    private int[][] isConnected;
    private Boolean[] visited;
    private void dfs(int node) {
        this.visited[node] = true;
        for(int i=0;i<this.isConnected.length;i++) {
            if(this.visited[i] == null && this.isConnected[node][i] == 1) {
                dfs(i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        this.visited = new Boolean[isConnected.length];
        this.isConnected = isConnected;
        int provinces = 0;
        for(int i=0;i<this.isConnected.length;i++) {
            if(this.visited[i] != null) continue;
            dfs(i);
            provinces++;
        }
        return provinces;
    }

    public int findCircleNum_slow(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = n;
        ArrayList<Integer> parents = new ArrayList<>();
        for(int i=0;i<n;i++) {
            parents.add(i);
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(j==i) {
                    continue;
                }
                if(isConnected[i][j] == 1) {
                    if(parents.get(j) == parents.get(i)) continue;
                    else {
                        for(int k=0;k<n;k++) {
                            if(k==j) continue;
                            if(parents.get(k) == parents.get(j)) {
                                parents.set(k, parents.get(i));
                            }
                        }
                        parents.set(j, parents.get(i));
                        provinces--;
                    }
                }
            }
        }
        return provinces;
    }
}
/*
  0 1 2 3
0[1,0,0,1]
1[0,1,1,0]
2[0,1,1,1]
3[1,0,1,1]
parents = [1,1,1,1]
provinces = 1




   0 1 2
0 [1,1,0]
1 [1,1,0]
2 [0,0,1]

parents = [0,0,2]

provinces = 2


*/
