public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0){
            return false;
        }
        if(word==null||word.length()==0){
            return false;
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(DFS(board,word,0,i,j)) return true;
            }
        }
        return false;
    }
    
    public boolean DFS(char[][] board, String word, int pos, int x, int y){
        if(pos==word.length()){
            return true;
        }
        if(x<0||x==board.length||y<0||y==board[0].length){
            return false;
        }
        if(word.charAt(pos)!=board[x][y]){ return false;}
        
            char c = board[x][y];
            board[x][y] = '*';
            boolean b = DFS(board,word,pos+1,x+1,y)||DFS(board,word,pos+1,x-1,y)||DFS(board,word,pos+1,x,y+1)||DFS(board,word,pos+1,x,y-1);
            board[x][y] = c;
            return b;
        
    }
}