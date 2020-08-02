# MyStuff
Some stuff I made

#####  EXPLAINING THE PROBLEM
    The following project is one of my first attempts at the backtracking algorithm.

    The problems if given a board of size NxN, the computer must find a way to place N queens on the board so that no queen is in a position that any other queen.
    A queen is under attack by another queen if, it is in the same column, same row, or same diagonal as another queen 


    A 4x4 board where the computer must place 4 queens that do not attack each other. All the following boards have queens (represented as letters) that are attacking each other:
      | a |   |   |   |    
      |   |   |   |   |     in the same column
      | b |   |   |   |
      |   |   |   |   |

      |   |   |   |   |
      |   |   |   |   |     in the same row
      | a |   | b |   |   
      |   |   |   |   |

      |   | a |   |   |
      | c |   |   |   |     on the same diagonal:
      |   |   |   | b |     a is attacking both b and c, but c is not attacking b
      |   |   |   |   |


      The program will take an integer N, create a board of NxN, and attempt to place N queens on that board. An example solution is given for an 4*4 board below:
      (queens are represented as 1's).

      EXAMPLE SOLUTION:

      |   |   | 1 |   |   
      | 1 |   |   |   |    
      |   |   |   | 1 |    
      |   | 1 |   |   |

      where no queens are on the same diagonal, row, or column. Therefore this is a viable solution
      
##### ANALYSING THE ALGORITHM
      
      The code uses a backtracking algorithm to traverse the board to find a solution. The program will try to place a queen, if the queen is under attack
      we discard it and try the next box in the row, if we get to the end of the row, and no box is available that is valid, then we backtrack a step and try a 
      different placement. The algorithm descends row by row, trying each box allow the row, checking whether the placed queen is attacking any other queen.
      We keep doing this until we reach the final row, where the program can only reach the final row if all the prior queens in all the other 
      rows above it are placed viably, therefore by definition we can only reach the final row if there is a solution, thus when we get to the bottom we have found
      a solution and return the altered board to the user.
      
      This program heavily relies on recursive ideas, the backtracking algorithm will keep going forward until it encounters a problem, wherein it will try other 
      options (different placements along the row), if none of those options work, it will step back and try another option, as you can see this idea relies highly
      on recursion to function, as the same act is being repeated each time. We can infer from this that a solution is not possible if we end up backtracking to the
      beginning, having tried all the squares, having found no solution, at this point the program will return false, and print "NO AVAILABLE SOLUTION". As this is 
      backtracking we have to make sure that upon stepping back we reset the box to empty so that the program does not mistake the square already tread upon, 
      automatically to be a queen.
      
##### WHAT I'VE LEARNED
      
      The backtracking algorithm is fun and has helped me get to grips with the ideas of recursion and how to use it effectively to solve complex goals. Doing this
      small project I have also become familar with the ideas of depth first search, a typical algorithm used for graph theory along with breadth first search, 
      giving me the basic tools to further explore more graph based problems. 
      
      The hardest part of this project was getting to check whether a placement of a queen on a particular board coordinate is valid, and getting the most effective 
      idea for checking that. In that way, doing the knights tour problem was easier, as there were fewer conditions for a move to be valid in that problem. I was 
      able to overcome this problem by simplification and realising that I only need to check if a queen was in the same row or left-diagonals, due to the fact that
      the way the algorithm is designed the algorithm cannot tread on itself when placing right, as the algorithm begins from the left and is always moving further 
      right and only needs to check whether it has tread on any previous placed queens to the left of it.
      
  
