//============================================================================
// Name        : HashTable.cpp
// Author      : Caroline Wilson
// Version     : 1.0
// Copyright   : Copyright © 2017 SNHU COCE
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <algorithm>
#include <climits>
#include <iostream>
#include <string> // atoi
#include <time.h>

#include "CSVparser.hpp"

using namespace std;

//============================================================================
// Global definitions visible to all methods and classes
//============================================================================

const unsigned int DEFAULT_SIZE = 179;

// forward declarations
double strToDouble(string str, char ch);

// define a structure to hold bid information
struct Bid {
    string bidId; // unique identifier
    string title;
    string fund;
    double amount;
    Bid() {
        amount = 0.0;
    }
};

//============================================================================
// Hash Table class definition
//============================================================================

/**
 * Define a class containing data members and methods to
 * implement a hash table with chaining.
 */
class HashTable {

private:
    // create struct node, intialize bid and define key. CEW 2/2020
	struct Node {
		Bid bid;
		unsigned key;
		Node *next;

		Node () {
			key = UINT_MAX;
			next = nullptr;
		}
		Node (Bid newBid) : Node () {
			bid = newBid;
		}

		Node (Bid newBid, unsigned newKey) : Node(newBid) {
			key = newKey;
		}
	};

	vector<Node> nodes;

	unsigned tableSize = DEFAULT_SIZE;

    unsigned int hash(int key);

public:
    HashTable();
    HashTable(unsigned size);
    virtual ~HashTable();
    void Insert(Bid bid);
    void PrintAll();
    void Remove(string bidId);
    Bid Search(string bidId);
};

/**
 * Default constructor
 */
HashTable::HashTable() {
    // INITIAL STRUCTURE WITH TABLE SIZE USING DEFAULT SIZE
	unsigned tableSize = DEFAULT_SIZE;
}

HashTable::HashTable(unsigned size) {
	this->tableSize = size;
	nodes.resize(tableSize);
}
/**
 * Destructor
 */
HashTable::~HashTable() {
    // Implement logic to free storage when class is destroyed cew 2/2020
	nodes.erase(nodes.begin());
}

/**
 * Calculate the hash value of a given key.
 * Note that key is specifically defined as
 * unsigned int to prevent undefined results
 * of a negative list index.
 *
 * @param key The key to hash
 * @return The calculated hash
 */
unsigned int HashTable::hash(int key) {
    //Implement logic to calculate a hash value, return unsigned integer using modular division
	return key % tableSize;
}

/**
 * Insert a bid
 *
 * @param bid The bid to insert
 */
void HashTable::Insert(Bid bid) {
    // create unsigned int from string, look for node in place, if not create new node, if node is already in place, search until empty is foundCEW 2/2020
	unsigned key = hash(atoi(bid.bidId.c_str()));

	Node *oldNode = &(nodes.at(key));

	if (oldNode == nullptr) {
		Node *newNode = new Node(bid, key);
	    nodes.insert(nodes.begin() + key, (*newNode));
	}
	else{
		if(oldNode-> key == UINT_MAX) {
			oldNode->key = key;
			oldNode-> bid = bid;
			oldNode->next = nullptr;

		}
		else{
			while (oldNode->next != nullptr){
				oldNode = oldNode->next;
			}
			oldNode->next = new Node(bid, key);

		}
	}
}

/**
 * Print all bids
 */
Bid  HashTable::PrintAll(string bidId) {
    // use string to integer to search
	Bid bid;
	unsigned key = hash(atoi(bidId.c_str()));
	return bid;
}

/**
 * Remove a bid
 *
 * @param bidId The bid id to search for
 */
void HashTable::Remove(string bidId) {
    // Use unsigned key to search for string, then use erase to remove the bid
	unsigned key = hash(atoi(bidId.c_str()));
	nodes.erase(nodes.begin() + key);
}

/**
 * Search for the specified bidId
 *
 * @param bidId The bid id to search for
 */
Bid HashTable::Search(string bidId) {
    Bid bid;

    // create compare string to search for nodes, while node is not null pointer return bid
    unsigned key = hash(atoi(bidId.c_str()));
    Node* node = &(nodes.at(key));

    if(node == nullptr || node->key == UINT_MAX) {
    	return bid;
    }
    if (node != nullptr && node->key != UINT_MAX && node->bid.bidId.compare(bidId)== 0) {
    	return node ->bid;
    }
    while (node != nullptr){
    if (node->key != UINT_MAX && node ->bid.bidId.compare(bidId) == 0) {
    	return node->bid;
    }
    node = node->next;
}
    return bid;
}


//============================================================================
// Static methods used for testing
//============================================================================

/**
 * Display the bid information to the console (std::out)
 *
 * @param bid struct containing the bid info
 */
void displayBid(Bid bid) {
    cout << bid.bidId << ": " << bid.title << " | " << bid.amount << " | "
            << bid.fund << endl;
    return;
}

/**
 * Load a CSV file containing bids into a container
 *
 * @param csvPath the path to the CSV file to load
 * @return a container holding all the bids read
 */
void loadBids(string csvPath, HashTable* hashTable) {
    cout << "Loading CSV file " << csvPath << endl;

    // initialize the CSV Parser using the given path
    csv::Parser file = csv::Parser(csvPath);

    // read and display header row - optional
    vector<string> header = file.getHeader();
    for (auto const& c : header) {
        cout << c << " | ";
    }
    cout << "" << endl;

    try {
        // loop to read rows of a CSV file
        for (unsigned int i = 0; i < file.rowCount(); i++) {

            // Create a data structure and add to the collection of bids
            Bid bid;
            bid.bidId = file[i][1];
            bid.title = file[i][0];
            bid.fund = file[i][8];
            bid.amount = strToDouble(file[i][4], '$');

            //cout << "Item: " << bid.title << ", Fund: " << bid.fund << ", Amount: " << bid.amount << endl;

            // push this bid to the end
            hashTable->Insert(bid);
        }
    } catch (csv::Error &e) {
        std::cerr << e.what() << std::endl;
    }
}

/**
 * Simple C function to convert a string to a double
 * after stripping out unwanted char
 *
 * credit: http://stackoverflow.com/a/24875936
 *
 * @param ch The character to strip out
 */
double strToDouble(string str, char ch) {
    str.erase(remove(str.begin(), str.end(), ch), str.end());
    return atof(str.c_str());
}

/**
 * The one and only main() method
 */
int main(int argc, char* argv[]) {

    // process command line arguments
    string csvPath, searchBid;
    switch (argc) {
    case 2:
        csvPath = argv[1];
        searchBid = "98109";
        break;
    case 3:
        csvPath = argv[1];
        searchBid = argv[2];
        break;
    default:
        csvPath = "eBid_Monthly_Sales_Dec_2016.csv";
        searchBid = "98109";
    }

    // Define a timer variable
    clock_t ticks;

    // Define a hash table to hold all the bids
    HashTable* bidTable;

    Bid bid;

    int choice = 0;
    while (choice != 9) {
        cout << "Menu:" << endl;
        cout << "  1. Load Bids" << endl;
        cout << "  2. Display All Bids" << endl;
        cout << "  3. Find Bid" << endl;
        cout << "  4. Remove Bid" << endl;
        cout << "  9. Exit" << endl;
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice) {

        case 1:
            bidTable = new HashTable();

            // Initialize a timer variable before loading bids
            ticks = clock();

            // Complete the method call to load the bids
            loadBids(csvPath, bidTable);

            // Calculate elapsed time and display result
            ticks = clock() - ticks; // current clock ticks minus starting clock ticks
            cout << "time: " << ticks << " clock ticks" << endl;
            cout << "time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;
            break;

        case 2:
            bidTable->PrintAll();
            break;

        case 3:
            ticks = clock();

            bid = bidTable->Search(searchBid);

            ticks = clock() - ticks; // current clock ticks minus starting clock ticks

            if (!bid.bidId.empty()) {
                displayBid(bid);
            } else {
                cout << "Bid Id " << searchBid << " not found." << endl;
            }

            cout << "time: " << ticks << " clock ticks" << endl;
            cout << "time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;
            break;

        case 4:
            bidTable->Remove(searchBid);
            break;
        }
    }

    cout << "Good bye." << endl;

    return 0;
}
