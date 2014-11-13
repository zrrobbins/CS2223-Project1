CS2223-Project1
===============

Project 1 for CS2223

Group: Zachary Robbins & Fiona Heaney

PURPOSE:Simulate the trading activity of a single stock buy making a buy and sell request priority queue. Users input a sequence of buy and sell orders which the program then processes by having most expensive transactions go first. After queues empty or tansactions can no loner be made, all remaining buy and sell requests are printed. 

HOW TO USE: Users can input buy/sell orders by inputting <"buy" or "sell"> <price> <qty> [enter] or using a text file in the form Trading < data.txt

DESCRIPTION
BuyOrder class: prints all buy requests
SellOrder class: prints all sell requests
Launcher class: creates a new instance of a trading market, takes in all inputs, and then makes all trades
Order class: sets price and quanity of item, and contains comparable override
Trading class: creates a max priority queue for buy requests and a min priority queue the sell requests. 
               parses through all of lines and pulls out data for BuyOrder and SellOrder methods
               makes trades until one of the queues is empty or the max BuyOrder becomes greater than or equal to minimum SellOrder
               contains method for making single trade
                  -if buy order is greater than available sell order, take all available shares for sale, remove sell request from queue, subtract sold shares from buy request, and requeue buy request
                  -if sell order is greater, remove buy order from queue, subtract number of purchased shares from sell request, and requeue sell request
                  -if sell and buy are equal, dequeue both items
                prints any remaining requests that could not be fulfilled before termination
