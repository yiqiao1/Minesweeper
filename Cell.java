import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.grid.Location;

public class Cell
{
    /* The minefield the cell is located in. */
    private MineField field;
    /* The location on the minefield this cell occupies. */
    private Location loc;
    
    /* True if the cell is a mine, false if not. */
    private boolean isMine; 
    /* True if the cell has been selected and revealed, false if user has not yet interacted with it. */
    private boolean selected = false;

    /**
     * Initializes cell, determines if it's a mine using a random number generator
     *
     * @param mfield the MineField the cell is on
     * @param cellLoc the location of the cell on the MineField
     */
    public Cell(MineField mfield, Location cellLoc)
    {
        field = mfield;
        loc = cellLoc;
        
        if (Math.random() > 0.75) 
        {
            isMine = true;
        } 
        else 
        {
            isMine = false;
        }
    }
    
    /**
     * Returns true if this cell is a mine, returns false if it is not
     *
     * @return the boolean isMine which determines whether or not the cell is a mine
     */
    public boolean isMine()
    {
        return isMine;
    }
    
    /**
     * Returns true if this cell has been selected, false if is has not been 
     *
     * @return the boolean selected which determines whether or not the cell has been selected
     */
    public boolean isSelected() 
    {
        return selected;
    }
    
    /**
     * Sets the instance variable selected to true, activating getText() and getColor(). Also calls gameOver is the selected cell is a mine.
     *
     */
    public void select() 
    {
        selected = true;
        
        if (isMine) 
        {
            field.gameOver(false);
        }
    }
    
    /**
     * Returns the location of the cell
     *
     * @return the location of the cell
     */
    public Location getLocation() 
    {
        return loc;
    }
    
    /**
     * Returns a String that is displayed on the cell: blank for an unselected cell, X for a selected mine, 
     * or the number of adjacent mines for a selected empty cell
     *
     * @return a String that determines what text is shown on the cell
     */
    public String getText()
    {
        if (selected && !isMine) 
        {
            int count = 0;
            ArrayList<Cell> neighbors = field.getGrid().getNeighbors(getLocation());
            
            for (int i = 0; i < neighbors.size(); i++) 
            {
                if (neighbors.get(i).isMine()) 
                {
                    count++;
                }
            }
            
            return String.valueOf(count);
        } 
        else if (selected && isMine) 
        {
            return "X";
        } 
        else 
        {
            return "";
        }
    }
    
    /**
     * Determines the color of the cell: white if the cell is unselected, green if it is selected and empty, red if it is selected and a mine
     *
     * @return the color of the cell
     */
    public Color getColor()
    {
        if (selected && isMine) 
        {
            return Color.RED;
        } 
        else if (selected && !isMine)
        {
            return Color.GREEN;
        } 
        else
        {
            return Color.WHITE;
        }
    }
}