CS2223-Project1
===============

Project 1 for CS2223

Group: Zachary Robbins & Fiona Heaney

PURPOSE: Simulate the trading activity of a single stock by making a buy and sell request priority queue. Users input a sequence of buy and sell orders which the program then processes by pairing the most expensive buy order with the least expensive sell order. After either of the queues are empty or transactions can no longer be made, all remaining buy and sell requests are printed, and the program terminates.

HOW TO USE: Users can input buy/sell orders by inputting <"buy" or "sell"> <price> <qty> [enter] or using a text file in the form Trading < data.txt. If using standard in, use the EOF character to stop inputting.

DESCRIPTION: 
Order class: (abstract) contains a price and quantity, and is implemented as either a BuyOrder or SellOrder. Implements the Comparable interface for use in priority queues.
BuyOrder class: subclass of Order class
SellOrder class: subclass of Order class
Launcher class: exists to contain the main method and run the simulation

Trading class: object will contain a max priority queue for buy requests and a min priority queue the sell requests. 
               parses through all of the input lines and constructs buy and sell orders, and inserts them in the proper queue
               makes trades until one of the queues is empty or the max BuyOrder becomes greater than or equal to the minimum SellOrder
               contains method for making single trade
                  -if buy order is greater than available sell order, take all available shares for sale, remove sell request from queue, subtract sold shares from buy request, and requeue buy request
                  -if sell order is greater, remove buy order from queue, subtract number of purchased shares from sell request, and requeue sell request
                  -if sell and buy are equal, dequeue both items
                prints any remaining requests that could not be fulfilled before termination
