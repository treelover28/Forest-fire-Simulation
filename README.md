# Forest-fire-Simulation

This simple program uses Monte Carlo simulation to compute the maximum denstiy of trees in a forest, such that a forest fire has a low probability of spreading.

A forest with density 0.0 contains no tree ( every cell is empty with 100% probability.

A forest with density 0.5 has roughly half of its cells filled with trees (each cell contains a tree with 50% probability).

A forest with density 1.0 has every cell occupied by a tree (every cell contains a tree with 100% probability).

We model a forest fire by setting trees in the top row of our forest on fire. The fire then tries to spread to neighboring trees (left, right, up, and down). We say a forest fire spread if it manages to reach the bottom of the forest. 

![Two forest board which one where the fire spread to the bottom and the other where the fire doesn't spread to the bottom] (C:\Users\Khai\git\Forest-fire-Simulation\forestfire.png? raw=true "Forest Fire")
