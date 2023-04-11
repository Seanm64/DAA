package org.example;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.core.VecInt;
import org.sat4j.specs.TimeoutException;

import java.io.File;
import java.util.List;

public class Solver {
    private ISolver solver = SolverFactory.newDefault();
    File file = new File("sudoku.cnf");

    public Solver()
    {
        solver.setTimeout(3600);
//        solver.(file);
    }

    public void updateSolver()
    {

    }


}
