PROJECT TITLE: Minesweeper Game

OVERVIEW: 
This project is a 10x10 minesweeper game created using Gridworld. 
It works like a normal minesweeper game: a random number of mines are scattered randomly throughout 
a 10x10 minefield, and the user interacts with the game by clicking on cells. When clicked, a cell 
will either be a mine, which will end the game, or will reveal how many mines are located in adjacent
cells. The game is won when all of the empty cells have been revealed by the user without triggering 
a mine.

EXPLANATION:
One of the most concepts this project helped me to better understand is how take one task and divide 
it into different classes with various different purposes, which synthesizes ideas from both Unit 2 and Unit 7. 
Initially, I had tried to create only one class for the entire game, an overarching Minesweeper class, but 
I quickly discovered that that was long and ineffective. Every time I wanted to change the state of a single 
cell in the minefield, I would have to iterate through an array list to that specific cell, then iterate 
through several more array lists to find all of the cell's neighbors, etc (although this did help me review array
lists a lot). Instead, I created three classes called MineField, Cell, and Game (I eventually got rid of Game 
because I thought it could be easily incorporated into the MineField class).

For these three classes, I had to figure out what methods and instance variables each should have based on their
purpose in the game. After I started using Gridworld as the base of my project this was easier to determine, 
because after looking at the Gridworld extensions site I could see that the world/game class usually overrided 
the method locationClicked or keyPressed from the original World<Tile> class and had other methods to deal with 
the grid/game as a whole (gameOver, main, etc.), while the tile class got info from the world class like the grid 
and the location of the tile clicked and used that info in methods to change the states of individual tiles. 

One small concept that especially stood out to me while building these classes was the fact that you can't access 
private instance variables of a class from another class without using methods. Although I knew this concept just 
from memorizing it during class, I didn't actually realize how to apply it to the classes I was creating. In my Cell
class, I have an instance variable selected which is a boolean that says if the cell has been clicked or not. I 
spent an embarrassingly long time trying to access and change this variable from the MineField class before realizing
that I needed to actually create two methods to deal with accessing and changing this variable: isSelected() and 
select(). 

As I mentioned before, I had to look at several Gridworld projects online to figure out how Gridworld worked.
I used the color tile game on the Gridworld extensions site you posted to figure out that the main world/game class
could extend World<Tile>, which I modified to World<Cell> with a different Cell class for my own program. Also, I 
learned that I could just pass the grid into the superclass World, which already had a constructor which accepts a 
parameter of a grid object. The most difficult concept I had to research was how to change what each cell in the 
grid displayed, and I found Gridworld already has getText() and getColor() methods, which made everything a lot 
easier. If I had to further extend this game, I would try to add pictures of mines to the cells.

INSTRUCTIONS:
To run the game, use the main method of the MineField class.

NOTES: 
This is very important! I only created a separate Minesweeper repository at the very end of the lab. 
All my work and changes will be found in the unit8RecursionSortsSearches repository in the Minesweeper folder.

