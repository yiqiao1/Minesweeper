import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.grid.Location;

public class Cell
{
    private MineField field;
    private Location loc;
    private Color color;
    
    private boolean isMine; 
    private boolean selected = false;

    /**
     * Initializes cell, determines if it's a mine using a random number generator
     *
     * @param mfield A parameter
     * @param cellLoc A parameter
     * @param col A parameter
     */
    public Cell(MineField mfield, Location cellLoc, Color col)
    {
        field = mfield;
        loc = cellLoc;
        color = col;
        
        if (Math.random() > 0.8) 
        {
            isMine = true;
        } 
        else 
        {
            isMine = false;
        }
    }
    
    //Returns true if this tile is a mine
    public boolean isMine()
    {
        return isMine;
    }
    
    //Returns true if cell has be clicked
    public boolean isSelected() 
    {
        return selected;
    }
    
    //Sets shown to true allowing getText to do it's job, if it's a mine we call the gameOver() method
    public void select() 
    {
        selected = true;
        
        if (isMine) 
        {
            field.gameOver(false);
        }
    }
    
    //Returns location of mine
    public Location getLocation() 
    {
        return loc;
    }
    
    //Determines what the tile should say
    //If the tile is a mine, we set the text to XX. If it hasn't been clicked we set it to an
    //asterisk. If it has been clicked and isn't a mine, we determine how many mines are around it.
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
    
    public Color getColor()
    {
        if (selected && isMine) 
        {
            return Color.RED;
        } 
        else 
        {
            return Color.GREEN;
        } 
    }
}