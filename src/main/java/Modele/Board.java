package Modele;

public class Board {
    private boolean[][] grid;

    public Board(int x, int y) {
        this.grid = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.grid[i][j] = false;
            }
        }
    }

    // line to inverse a case : this.setGrid(i,j,!this.getGrid(x,y));
    public void evolve() {
        int x = this.getXlength();
        int y = this.getYlength();
        boolean[][] newGrid = new boolean[x][y];
        int nb;
        // neighbour calculator
        for (int i = 0; i < x - 1; i++) {
            for (int j = 0; j < y - 1; j++) {
                nb = 0;
                //left
                if (i > 0 && this.grid[i - 1][j])
                    nb += 1;
                // up left
                if (i > 0 && j > 0 && this.grid[i - 1][j - 1])
                    nb += 1;
                // up
                if (j > 0 && this.grid[i][j - 1])
                    nb += 1;
                // up right
                if (j > 0 && i < x - 1 && this.grid[i + 1][j - 1])
                    nb += 1;
                // right
                if (i < x - 1 && this.grid[i + 1][j])
                    nb += 1;
                // down right
                if (i < x - 1 && j < y - 1 && this.grid[i + 1][j + 1])
                    nb += 1;
                // down
                if (j < y - 1 && this.grid[i][j + 1])
                    nb += 1;
                // down left
                if (j < y-1 && i > 0 && this.grid[i-1][j+1])
                    nb += 1;

                // application of Conway model
                // une cellule morte possédant exactement trois cellules voisines vivantes devient vivante
                if (!this.grid[i][j]){
                    newGrid[i][j] = nb == 3;
                }
                // une cellule vivante possédant deux ou trois cellules voisines vivantes le reste, sinon elle meurt
                else{
                    newGrid[i][j] = nb == 2 || nb == 3;
                }
            }
        }
        this.grid = newGrid;


    }

    public int getXlength() {
        return this.grid.length;
    }

    public int getYlength() {
        return this.grid[0].length;
    }

    public boolean getGrid(int x, int y) {
        return this.grid[x][y];
    }

    public void setGrid(int x, int y, boolean b) {
        this.grid[x][y] = b;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getXlength(); i++) {
            for (int j = 0; j < getYlength(); j++) {
                if(this.grid[j][i])
                    sb.append('o');
                else
                    sb.append('x');
                sb.append(' ');
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
