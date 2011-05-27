/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frames;


/**
 *
 * @author daniel
 */
public class SudokuSolver {
    private Integer sudoku[][];
    private Boolean linha[][];
    private Boolean coluna[][];
    private Boolean bloco[][];
    private Integer sudokucopy[][];



public SudokuSolver(Integer m[][]){
    sudoku = new Integer[9][9];
    sudoku = m;
    initVectors();
}

private void initVectors(){
    linha = new Boolean[9][9];
    coluna = new Boolean[9][9];
    bloco = new Boolean[9][9];

    for (int i = 0 ; i < 9 ; i++){
        for (int j = 0 ; j<9 ; j++){
            linha[i][j] = true;
            coluna[i][j] = true;
            bloco[i][j] = true;
        }
    }
    for (int i = 0 ; i < 9 ; i++){
        for (int j = 0 ; j<9 ; j++){
            // seta vetores boleanos para o fowarding checking
            if(sudoku[i][j]!=0) {
                linha[i][sudoku[i][j]-1]=false;
                coluna[j][sudoku[i][j]-1]=false;
                bloco[(i/3)*3 + j/3][sudoku[i][j]-1]=false;
            }
        }
    }


}

public Integer[][] getSudoku(){
    return sudokucopy;
}

public void solver(int lin, int col){
    int l = lin;
    int c = col;
    
    if(c == 9){
        c = 0;
        l++;
    }
    System.out.println("coluna" + c);
    System.out.println("linha" + l);
    if (l == 9){
        sudokucopy = new Integer[9][9];

        System.out.println("retornou " + l);
        System.out.println("Solution ");
       //copia manual mesmo uehueh

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(sudoku[i][j] != 0)
                    sudokucopy[i][j] = sudoku[i][j] ;
            }
        }
        //return ;
    }else{
        if(sudoku[l][c] != 0){
               //System.out.println(" vai chamar a funcao solver");
               solver(l, c+1);
        }else{
            for (int k = 0 ; k < 9 ; k++){
                //System.out.println(" tah aqui ");
                if(linha[l][k]==true && coluna[c][k] == true && bloco[(l/3)*3 + c/3][k]==true){
                    linha[l][k]=false;
                    coluna[c][k]=false;
                    bloco[(l/3)*3 + c/3][k]=false;
                    sudoku[l][c]= k+1;
                    System.out.println(sudoku[l][c]);
                    solver(l,c+1);
                    linha[l][k]=true;
                    coluna[c][k]=true;
                    bloco[(l/3)*3 + c/3][k]=true;
                    sudoku[l][c]=0;
                }
            }  System.out.println("retornou " );
        }

    }



}

}


