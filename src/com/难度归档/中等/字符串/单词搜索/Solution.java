package com.难度归档.中等.字符串.单词搜索;

class Solution {
    public boolean exist(char[][] board, String word) {

        boolean flag=false;
        char[] charAry = word.toCharArray();
        // ij 为坐标
        int index=1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if( charAry[0] ==board[i][j]){
                    char[] charList = new char[word.length()];
                    charList[0] = board[i][j];
                    int str = findStr(board, charAry, charList, index, i, j,"");
                    if(str==charAry.length) {
                        flag=true;
                        break;
                    }
                }
            }
        }

        return flag;
    }

    int findStr(char[][] board,char[] charAry,char[] charList, int index,int x,int y,String type){
        if(index==charAry.length) return index;
        char target= charAry[index];
        int ylimit = board[x].length-1;
        int xlimit = board.length-1;


        if(y<ylimit&&type!="left"){
            if(board[x][y+1]==target){
                index++;
                index = findStr(board, charAry, charList, index, x,y+1,"right");
            }
        }
        if(index==charAry.length) return index;
        if(y>0&&type!="right"){
            if(board[x][y-1]==target){
                index++;
                index = findStr(board,charAry,charList,index,x ,y-1,"left");
            }
        }
        if(index==charAry.length) return index;
        if(x<xlimit&&type!="top"){
            if(board[x+1][y]==target){
                index++;
                index =  findStr(board,charAry,charList,index,x+1,y,"down");
            }
        }
        if(index==charAry.length) return index;
        if(x>0&&type!="down"){
            if(board[x-1][y]==target){
                index++;
                index =  findStr(board,charAry,charList,index,x-1 ,y,"top");
            }
        }

        return index;
    }

    public static void main(String[] args) {
        char b[][]={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};

        String word ="ABCEFSADEESE";

        Solution solution = new Solution();
        boolean exist = solution.exist(b, word);
        System.out.println(exist);
    }
}