package com.jacky.DSAndDM.UnionFind;

/*
 * Social network connectivity. 
 * Given a social network containing N members and a log file containing M timestamps 
 * 		at which times pairs of members formed friendships, design an algorithm to determine the earliest time 
 * 		at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). 
 * 		Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. 
 * 		The running time of your algorithm should be MlogN or better and use extra space proportional to N.
 * 
 * Solution:
 * 		When we need to know if nodes in a vast network are connected which means there exist a path without
 * 		needing to know what the exact path is, we will use union-find algorithm.
 * 		Union-find algorithm has different variants. The basic union find takes n^2.
 * 		The fastest union find which is weighted union find which takes logn that's why it is a best suit
 * 		To make weighted union find have a complexity of m * logn, we just need to keep logn and add extra steps that is
 * 		constant => what could it be? well, keep tract of the total root in the network. If all users in a network connect
 * 		that means there is only 1 super root in a network.
 */
public class SocialNetworkConnectivity {
	
	int[] socialNetwork;
	int[] socialNetworkSize;
	int count;
	
	public SocialNetworkConnectivity(int totalUsers) {
		socialNetwork = new int[totalUsers];
		socialNetworkSize = new int[totalUsers];
		count = totalUsers;
		for(int i = 0; i < totalUsers; i++) {
			socialNetwork[i] = i;
			socialNetworkSize[i] = 1;
		}
	}
	
	public int findRoot(int user) {
		while(socialNetwork[user] != user) {
			user = socialNetwork[user];
		}
		
		return user;
	}
	
	public void connectUser(int user1, int user2) {
		int root1 = findRoot(user1);
		int root2 = findRoot(user2);
		
		if(root1 == root2) return; //if 2 users already connect to each other, ignore it
		
		count--; //we merge 2 tree so the count should be decremented
		
		if(socialNetworkSize[root1] < socialNetworkSize[root2]) {
			socialNetwork[root1] = root2;
			socialNetworkSize[root2] += socialNetworkSize[root1];
		}
		else {
			socialNetwork[root2] = root1;
			socialNetworkSize[root1] += socialNetworkSize[root2];
		}
	}
	
	//if all connect, the count should be 1 which means there is only 1 super root
	public boolean allConnect(){
		return count == 1;
	}
	
	public boolean connected(int user1, int user2) {
		int root1 = findRoot(user1);
		int root2 = findRoot(user2);
		return root1 == root2;
	}
	
	public void clientTest() {
		SocialNetworkConnectivity snc = new SocialNetworkConnectivity(6);
		int user1 = 0;
		int user2 = 5;
		snc.connectUser(user1, user2);
		System.out.printf("%d => %d\n", user1, user2);
		System.out.printf("all connected? => %s\n", snc.allConnect());

		user1 = 1;
		user2 = 5;
		snc.connectUser(user1, user2);
		System.out.printf("%d => %d\n", user1, user2);
		System.out.printf("all connected? => %s\n", snc.allConnect());

		user1 = 2;
		user2 = 0;
		snc.connectUser(user1, user2);
		System.out.printf("%d => %d\n", user1, user2);
		System.out.printf("all connected? => %s\n", snc.allConnect());

		user1 = 3;
		user2 = 4;
		snc.connectUser(user1, user2);
		System.out.printf("%d => %d\n", user1, user2);
		System.out.printf("all connected? => %s\n", snc.allConnect());

		user1 = 3;
		user2 = 0;
		snc.connectUser(user1, user2);
		System.out.printf("%d => %d\n", user1, user2);
		System.out.printf("all connected? => %s\n", snc.allConnect());
	}
	
}
