# Smartphone Lock Screen Implementation

This project involves finding possible smartphone lock screens using the Depth First Search (DFS) algorithm. The lock screen consists of nodes (letters) connected by lines, and the goal is to generate lock screens with a specified starting point and length.

## Introduction

The lock screen is represented as a graph with nodes (A, B, C, D, E, F, G, H, and I) and connections between them. The structure of the graph is provided in the form of an adjacency list, available in the `adjacency_list` HashMap.

## Implementation

The main task is to implement the `possible_locks` method, which returns all possible lock screens with a given starting point and length. This method uses the DFS algorithm to explore the graph and generate lock screens.

### Input Validation

The input `length` must be a positive integer, or `null` will be returned. An invalid `length` can lead to non-meaningful results.

### DFS Algorithm

The DFS algorithm starts from the specified starting point and recursively explores neighboring nodes, adding them to the lock screen path. It continues until the desired length is reached. All valid lock screens are added to the result list.

## Conclusion

This project demonstrates the implementation of smartphone lock screens using the Depth First Search (DFS) algorithm. It efficiently explores the graph structure to find possible lock screens based on the starting point and length.

