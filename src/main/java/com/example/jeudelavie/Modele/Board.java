package com.example.jeudelavie.Modele;

import com.example.jeudelavie.Constantes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Board {
    private boolean[][] grid;
    private int nbIter;

    public Board(int x, int y) {
        this.grid = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.grid[i][j] = false;
            }
        }
    }

    public void clear(){
        for (int i = 0; i < getXlength(); i++) {
            for (int j = 0; j < getYlength(); j++) {
                this.grid[i][j] = false;
            }
        }
        nbIter = 0;
    }


    // line to inverse a case : this.setGrid(i,j,!this.getGrid(x,y));
    public void evolve() {
        int x = this.getXlength();
        int y = this.getYlength();
        boolean[][] newGrid = new boolean[x][y];
        int nb;
        // neighbour calculator
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
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
                if (j < y - 1 && i > 0 && this.grid[i - 1][j + 1])
                    nb += 1;

                // application of Conway model
                // une cellule morte possédant exactement trois cellules voisines vivantes devient vivante
                if (!this.grid[i][j]) {
                    newGrid[i][j] = nb == 3;
                }
                // une cellule vivante possédant deux ou trois cellules voisines vivantes le reste, sinon elle meurt
                else {
                    newGrid[i][j] = nb == 2 || nb == 3;
                }
            }
        }
        this.grid = newGrid;
        nbIter++;
    }

    public void random() {
        int prob;
        Random random = new Random();
        for (int i = 0; i < getXlength(); i++) {
            for (int j = 0; j < getYlength(); j++) {
                prob = random.nextInt(1, Constantes.PROB + 1);
                this.grid[i][j] = prob == 1;
            }
        }
        this.nbIter = 0;
    }

    public void chargerCanon(String nom) throws IOException {

        //ouverture des flux de lecture du fichier contenant le labyrinthe
        BufferedReader br = new BufferedReader(new FileReader(nom));
        int x = Integer.parseInt(br.readLine()); //nombre de colonnes
        int y = Integer.parseInt(br.readLine()); //nombre de lignes

        //initialisation des variables du labyrinthe rendu
        for (int i = 0; i < x; i++) {
            String ligne = br.readLine();
            for (int j = 0; j < y; j++) {
                char c = ligne.charAt(j);
                if (c == 'o')
                    this.grid[i][j] = true;
            }
        }
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

    public int getNbIter() {
        return nbIter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getXlength(); i++) {
            for (int j = 0; j < getYlength(); j++) {
                if (this.grid[j][i])
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
