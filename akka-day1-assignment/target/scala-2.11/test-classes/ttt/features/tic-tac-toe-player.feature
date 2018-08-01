Feature: Players should play tic-tac-toe against each other

#  The Tic Tac Toe Map Game map is a one dimensional array which is internally represented as
#  3X3 2d array. Initially the places are filled with zero to represent empty spaces.
#
#  | 0   0   0 |
#  | 0   0   0 |
#  | 0   0   0 |

#  As Game Proceeds, e.g. Player X plays one step with index 5, the tic tac toe maps changes its
#  state as below:

#  | 0   0   0 |
#  | 0   X   0 |
#  | 0   0   0 |

  Scenario: As a Tic Tac Toe Player, I should be able to change the state of tic tac toe map after
    a valid step.

    Given A the below tic tac toe map as one dimensional array
          | Tic Tac Toe Map     |
          | [0,0,0,0,0,0,0,0,0] |

    When A Player plays a tic tac toe step 1

    Then The Tic tac toe should be in the following state
          | Tic Tac Toe Map     |
          | [1,0,0,0,0,0,0,0,0] |



