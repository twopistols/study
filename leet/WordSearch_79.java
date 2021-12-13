// 79. Word Search
// Medium
//
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
// The same letter cell may not be used more than once.

class WordSearch_79 {

    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        int wordPos = 0;

        boolean[][] visited = new boolean[row][col];
        // Stack stack = new Stack();

        if (board.length == 1 && word.length() == 1)
            return board[0][0] == word.charAt(0);


        boolean res = false;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                // System.out.println("start");

                res |= dig(visited, board, word, wordPos, r, c);

            }
        }

        return res;
    }


    boolean dig(boolean[][] visited, char[][] board, String word, int wordPos, int r, int c) {

        if (visited[r][c] == true) {
            // System.out.println("Visited "+r+","+c);
            return false;
        }

//         System.out.println("1");

//         System.out.println("dig r="+r
//                            +", c=" +c
//                            +"; boardChar=" + board[r][c]
//                            +"; wordChar=" + word.charAt(wordPos)
//                            +"; wordPos=" + wordPos);


        boolean res = false;

        if (board[r][c] == word.charAt(wordPos)) {

            if (wordPos + 1 == word.length()) {
                return true;
            }

            // System.out.println("2");

            // stack.push(board[r][c]);
            visited[r][c] = true;

            if (c + 1 < board[r].length) {
                // System.out.println("c+1");
                res |= dig(visited, board, word, wordPos + 1, r, c + 1);
            }

            if (c - 1 >= 0) {
                // System.out.println("c-1");
                res |= dig(visited, board, word, wordPos + 1, r, c - 1);
            }

            if (r + 1 < board.length) {
                // System.out.println("r+1");
                res |= dig(visited, board, word, wordPos + 1, r + 1, c);
            }

            if (r - 1 >= 0) {
                // System.out.println("r-1");
                res |= dig(visited, board, word, wordPos + 1, r - 1, c);
            }

            if (!res) {
                visited[r][c] = false;
                // stack.pop();
            }

        } else {
            // System.out.println("wrong char");
        }

        return res;
    }
}
