import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import java.util.ArrayList;

public class MineField extends World<Cell>
{
    private boolean gameOver = false;

    /**
     * MineField Constructor
     *
     * @param field a BoundedGrid<Cell>
     */
    public MineField(BoundedGrid<Cell> field)
    {
        super(field);
        populateGame();
    }

    /**
     * When a mine cell is clicked, this method calls its select method and checks if the game is won.
     *
     * @param loc the location of the cell clicked
     * @return always returns true if the world consumes the click
     */
    public boolean locationClicked(Location loc)
    {
        Cell c = (Cell)this.getGrid().get(loc);
        
        if (!gameOver) 
        {
            c.select();
            checkWin();
        }
        
        return true;
    }

    /**
     * Adds a cell with a random chance of being a mine to each location of the minefield
     *
     */
    public void populateGame()
    {
        for (int r = 0; r < this.getGrid().getNumRows(); r++) 
        {
            for (int c = 0; c < this.getGrid().getNumCols(); c++) 
            {
                Location temp = new Location(r, c);
                this.add(temp, new Cell(this, temp));
            }
        }
    }
    
    /**
     * Checks if the player has won.
     *
     */
    public void checkWin() 
    {
        ArrayList<Location> mines = this.getGrid().getOccupiedLocations();
        int notMines = 0;
        int selectedCells = 0;
        
        for (Location loc : mines) 
        {
            Cell c = (Cell)this.getGrid().get(loc);
            
            if (c.isSelected() && !c.isMine()) 
            {
                selectedCells++;
            }
            if (!c.isMine()) 
            {
                notMines++;
            }
        }
        
        if (selectedCells == notMines) 
        {
            gameOver(true);
        }
    }

    /**
     * Ends game by revealing the state of all cells and displaying message saying whether user has won or lost.
     *
     * @param win a boolean that means user has won the game if true and means user has lost the game if false
     */
    public void gameOver(boolean win) 
    {
        // if gameOver == false return nothing and end method
        if (gameOver) 
        {
            return;
        }
        // win game
        else if (!gameOver && win) 
        {
            setMessage("GAME OVER! You win!");
        }
        // lose game
        else if (!(gameOver || win))
        {
            setMessage("GAME OVER! You lose!");
        }
        gameOver = true;
        
        ArrayList<Location> locations = this.getGrid().getOccupiedLocations();
        for (Location loc : locations) 
        {
            Cell cell = (Cell)this.getGrid().get(loc);
            cell.select();
        }
    }
    
    /**
     * Creates a new 10x10 minefield, starts the game
     *
     */
    public static void main()
    {
        MineField field = new MineField(new BoundedGrid<Cell>(10, 10));
        field.setMessage("Welcome to Minesweeper! Please click on a cell."); 
        field.show();
    }
}