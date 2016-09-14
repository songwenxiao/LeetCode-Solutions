public class Solution {//DFS
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
		return;
	if (board.length < 2 || board[0].length < 2)
		return;
	int m = board.length, n = board[0].length;
	//Any 'O' connected to a boundary can't be turned to 'X', so ...
	//Start from first and last column, turn 'O' to '*'.
	for (int i = 0; i < m; i++) {
		if (board[i][0] == 'O')
			boundaryDFS(board, i, 0);
		if (board[i][n-1] == 'O')
			boundaryDFS(board, i, n-1);	
	}
	//Start from first and last row, turn '0' to '*'
	for (int j = 0; j < n; j++) {
		if (board[0][j] == 'O')
			boundaryDFS(board, 0, j);
		if (board[m-1][j] == 'O')
			boundaryDFS(board, m-1, j);	
	}
	//post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j] == 'O')
				board[i][j] = 'X';
			else if (board[i][j] == '*')
				board[i][j] = 'O';
		}
	}
}
//Use DFS algo to turn internal however boundary-connected 'O' to '*';


private void boundaryDFS(char[][] board, int i, int j) {//BFS
	if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
		return;
	if (board[i][j] == 'O')
		board[i][j] = '*';
	if (i > 1 && board[i-1][j] == 'O')
		boundaryDFS(board, i-1, j);
	if (i < board.length - 2 && board[i+1][j] == 'O')
		boundaryDFS(board, i+1, j);
	if (j > 1 && board[i][j-1] == 'O')
		boundaryDFS(board, i, j-1);
	if (j < board[i].length - 2 && board[i][j+1] == 'O' )
		boundaryDFS(board, i, j+1);
}
    
}

public class Solution {
    public void solve(char[][] board) {
        int rown = board.length;
        if(rown==0)return;
        int coln = board[0].length;
        for(int row = 0;row<rown;++row){
            for(int col = 0;col<coln;col++){
                if(row==0||row==rown-1||col==0||col==coln-1){
                    if(board[row][col]=='O'){
                        Queue<Integer> q = new LinkedList<>();
                        board[row][col] = '1';
                        q.add(row*coln+col);
                        while(!q.isEmpty()){
                            int cur = q.poll();
                            int x = cur/coln;
                            int y = cur%coln;
                            if(y+1<coln&&board[x][y+1]=='O'){
                                q.add(cur+1);
                                board[x][y+1]='1';
                            }
                            if (x+1<rown && board[x+1][y]=='O') {
                                q.add(cur+coln);
                                board[x+1][y] = '1';
                            }
                            if (y-1>=0 && board[x][y-1]=='O') {
                                q.add(cur-1);
                                board[x][y-1] = '1';
                            }
                            if (x-1>=0 && board[x-1][y]=='O') {
                                q.add(cur-coln);
                                board[x-1][y] = '1';
                            }
                        }
                    }
                }
            }
        }
         for (int i=0; i<rown; ++i) {
            for (int j=0; j<coln; ++j) {
                if (board[i][j]=='O') {
                    board[i][j]='X';
                } else if (board[i][j]=='1') {
                    board[i][j]='O';
                }
            }
        }
    }
}