# The Game of Life
## Introduction 
The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970. It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves. It is Turing complete and can simulate a universal constructor or any other Turing machine. 
I thought it was a good idea to train myself with graphical interfaces and found the algorithm intersting. So decided to code it.
## The Code
The project was made using javaFX (one of the most popular java graphical interface) under java17. I designed the code around a MVC (model - view - controller) structure. 
### controls and installation
To use it you have different options
1. choose the cells you want to be alive then evolve by presing the space-bar
2. use a random configuration and then you can observe the changes when the strucutor evolve (you can configure the odds of cases becoming alive during random initialization by modifing the PROB variable in the `Constant.java` file)
3. import some famous model (I implemend 2 glider launcher) by pressing the respective buttons ![Gosper glider gun](http://www.conwaylife.com/w/images/9/9f/Gosperglidergun.png)![Simkin glider gun](https://conwaylife.com/w/images/5/53/Simkinglidergun.png) 

You can also evolve by pressing enter (I may add a Button soon) 
Every variables (size of the grid, number of cells, odds) are changeable in the `Constant.java` file.

If you want to reset the grid you can press 'R' instead of shutting down and reopening the main.

As I said it before, for the moment no make file were made. So the easiest to satrt it is by using an IDE or manualy compiling `javac *.java` the files and using the command `java Main.java`

### Warning
I had issues with the path to import models of the canon so you may have to manually change the path of the .txt files in the Class `View.java` (when creating the button in the method `InitInfoBox()` line 54 and 57)

I did not take that much time to code the whole things so the border comportement may be a bit bad. But the main program and the Conway rules work perfectly

