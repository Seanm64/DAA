/**
 * @author Sean McKay
 * Solver Class, will solve and return the model of the Sudoku
 */

package org.example;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

import java.io.IOException;

public class Solver {
    private ISolver solver = SolverFactory.newDefault();
    private DimacsReader reader1 = new DimacsReader(solver);
    private IProblem problem;
    private int decoder;
    private int[] model;
    private int[][] sudokuArray;

    public Solver()
    {

    }
    public Solver(int[][] container, int decoder) throws ContradictionException, IOException, ParseFormatException
    {
        solver.setTimeout((3600));
        problem = reader1.parseInstance("sudoku.cnf");
        setDecoder(decoder);
        sudokuArray = container;
    }

    public void setDecoder(int decoder) {
        this.decoder = decoder;
    }

    public int[][] getModel() {
        //Decode and return array of correct sudoku
        //Need a for loop to iterate through every variable
        for (int variable : problem.model()) {
            //Every non-negative variable will be an accepted state for the sudoku, dissect it
            if (variable > 0) {
                //Decode the dissected members and add them to the sudokuArray
                int i, j, k;
                k = variable % decoder;
                j = variable / decoder % decoder;
                i = variable / decoder / decoder % decoder;

                sudokuArray[i - 1][j - 1] = k;
            }
        }
        return sudokuArray;
    }


    public boolean solvable()
    {
        try {
            return problem.isSatisfiable();
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
