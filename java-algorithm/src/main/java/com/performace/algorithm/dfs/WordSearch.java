package com.performace.algorithm.dfs;

import java.util.HashSet;

/**
 * 二维数组矩阵查找单词
 * @author xiaoxiong
 */
public class WordSearch {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (hasPath(0, i, j, word, board, visited))
                    return true;
            }
        }
        return false;
    }
    public boolean hasPath(int pos, int x, int y, String word, char[][] board, HashSet<Integer> visited) {
        if (pos == word.length() - 1) {
            if (board[x][y] == word.charAt(pos))
                return true;
            else
                return false;
        }
        else {
            char target = word.charAt(pos);
            if (target == board[x][y]) {
                visited.add(x * board[0].length + y);
                int[] dirx = {0, 0, 1, -1};
                int[] diry = {1, -1, 0, 0};
                for (int i = 0; i < 4; i++) {
                    int newx = x + dirx[i];
                    int newy = y + diry[i];
                    if (isValid(newx, newy, board) && !visited.contains(newx * board[0].length + newy)) {
                        if (hasPath(pos + 1, newx, newy, word, board, visited))
                            return true;
                    }
                }
                visited.remove(x * board[0].length + y);
                return false;
            }
            else {
                return false;
            }
        }
    }
    public boolean isValid(int x, int y, char[][] board) {
        if (x >= 0 && x <= board.length - 1 && y >= 0 && y <= board[0].length - 1)
            return true;
        else
            return false;
    }
}
