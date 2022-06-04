package Modele;

public class Board {
    private final boolean[][] grid;

    public Board(int x, int y){
        this.grid = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.grid[i][j] = false;
            }
        }
    }

    // line to inverse a case : this.setGrid(i,j,!this.getGrid(x,y));
    public void  evolve(){
        int x =this.getXlength();
        int y =this.getYlength();

        for (int i = 0; i < x-1 ; i++) {
            for (int j = 0; j < y-1; j++) {
                
            }
        }
    }

    public int getXlength(){
        return this.grid.length;
    }

    public int getYlength(){
        return this.grid[0].length;
    }

    public boolean getGrid(int x, int y){
        return this.grid[x][y];
    }

    public void setGrid(int x, int y,boolean b){
        this.grid[x][y] = b;
    }
}
