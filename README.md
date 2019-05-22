# Forest-fire-Simulation

This simple program uses Monte Carlo simulation to compute the maximum denstiy of trees in a forest, such that a forest fire has a low probability of spreading.

## Basic Rules/Assumptions
We model a forst as a 2D array. Each cell can either be occupied by a tree, or can be empty. For a value of d, in range [0.0,1.0], we that a forest has density d if each cell is a tree with probability d, or empty with probability (1-d)

* A forest with density 0.0 contains no tree ( every cell is empty with 100% probability.

* A forest with density 0.5 has roughly half of its cells filled with trees (each cell contains a tree with 50% probability).

* A forest with density 1.0 has every cell occupied by a tree (every cell contains a tree with 100% probability).

We model a forest fire by setting trees in the top row of our forest on fire. The fire then tries to spread to neighboring trees (left, right, up, and down). We say a forest fire spread if it manages to reach the bottom of the forest. 

<img width="587" alt="forest fire" src="https://user-images.githubusercontent.com/50902696/58205367-99958980-7c9b-11e9-8e05-10d05e745eb0.png">

## Problem Restatement
The following program consider a low probability of firespreading to be p < 0.5, thus our original problem can be restated as:

Find the maximum density **d**, such that the probability of fire spreading in a forest of density **d** is less than *0.5*

We use two different algorithms to help determine whether the fire has spread to bottom or not: **Breadth-first Search** and **Depth-first Search**. 
 



