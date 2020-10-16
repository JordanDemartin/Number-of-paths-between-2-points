import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        String[] row_array = new String[M];
        int[][] cache = new int[M][N];
        //System.err.println("M = "+M);
        //System.err.println("N = "+N);
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < M; i++) {
            row_array[i] = in.nextLine();
            //System.err.println("ligne "+i+" = "+row_array[i]);
            for(int j = 0; j < N; j++){
                cache[i][j] = -1;
            }
        }

        System.out.println(cheminPossible(0, 0, M, N, row_array, cache));
    }

    static int cheminPossible(int x, int y, int M, int N, String[] row_array, int[][] cache){
        if(x == N || y == M){//je suis sortis du tableau
            //System.err.println("case "+x+","+y+" = retourne 0, sortis tableau");
            return 0;
        }
        if(cache[x][y] == -1){//si le résultat n'est pas dans le cache

            if(x == N-1 && y == M-1){//je suis arrivé
                //System.err.println("case "+x+","+y+" = retourne 1");
                return 1;
            }
            //System.err.println("case "+x+","+y+" = "+row_array[y].charAt(x));
            if(row_array[y].charAt(x) == '1'){//je suis sur un 1
                //System.err.println("case "+x+","+y+" = retourne 0, sur un 1");
                return 0;
            }

            cache[x][y] = cheminPossible(x+1, y, M, N, row_array, cache) + cheminPossible(x, y+1, M, N, row_array, cache);
        }
        return cache[x][y];
    } 
}
