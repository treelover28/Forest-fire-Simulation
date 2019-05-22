# Forest-fire-Simulation

This simple program uses Monte Carlo simulation to compute the maximum denstiy of trees in a forest, such that a forest fire has a low probability of spreading.

## Basic Rules/Assumptions
A forest with density 0.0 contains no tree ( every cell is empty with 100% probability.

A forest with density 0.5 has roughly half of its cells filled with trees (each cell contains a tree with 50% probability).

A forest with density 1.0 has every cell occupied by a tree (every cell contains a tree with 100% probability).

We model a forest fire by setting trees in the top row of our forest on fire. The fire then tries to spread to neighboring trees (left, right, up, and down). We say a forest fire spread if it manages to reach the bottom of the forest. 

<img width="587" alt="forest fire" src="https://user-images.githubusercontent.com/50902696/58205367-99958980-7c9b-11e9-8e05-10d05e745eb0.png">

The following program consider a low probability of firespreading to be p < 0.5, thus our original problem cannot be restated as:

Find the maximum density d, such that the probability of fire spreading in a forest of density d is less than 0.5
 



