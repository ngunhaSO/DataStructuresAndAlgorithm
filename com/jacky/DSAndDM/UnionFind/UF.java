package com.jacky.DSAndDM.UnionFind;


public class UF {
	
	private int[] sz; //size of components for roots
	public int[] id; //access to component id (site indexed)
	private int count; //number of components
	
	public UF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return findWeightedQuickUnion(p)== findWeightedQuickUnion(q);
	}
	
	//
	// find return the entry value of index in the array
	//
	
	//================== Quick Find ====================================/
	/*
	 * The Quick Find:
	 * 	find() is fast because it get the component of p immediate
	 * 	but the union() is slow because the big O is n^2 (quadratic)
	 */
	public int findQuickFind(int p) {
		return id[p];
	}
	
	public void unionQuickFind(int p, int q) {
		if (connected(p, q)) return;
        int pid = id[p];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = id[q]; 
        count--;
	}
	//================== End Quick Find ====================================/
	
	
	//================== Quick Union ====================================/
	/*
	 * Quick Union: the idea is to make a site has a link to itself
	 */
	public int findQuickUnion(int p) {
		while(p != id[p]) {
			p = id[p];
		}
		return p; //in final, we return the entry value of the id
	}
	
	public void unionQuickUnion(int p, int q) {
		int pRoot = findQuickUnion(p);
		int qRoot= findQuickUnion(q);
		//if they are already in the same component, do nothing
		if(pRoot == qRoot){
			return;
		}
		//change the value of the first one to the second one
		id[pRoot] = qRoot; //the reason for using id[pRoot] is to have site to link to itself
		count--;
	}
	//================== End Quick Union ====================================/

	//================== Weighted Quick Union ====================================/
	public int findWeightedQuickUnion(int p) {
		while (id[p] != p)
			p = id[p];
		return p;
	}
	
	public void unionWeightedQuickUnion(int p, int q) {
		int i = findWeightedQuickUnion(p);
		int j = findWeightedQuickUnion(q);
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	//================== End Weighted Quick Union ====================================/
	
	
	public void showResult() {
		System.out.println("WEIGHTED UNION");
		int N = 10;
        UF q1 = new UF(N);
        q1.unionWeightedQuickUnion(4, 3);
        q1.unionWeightedQuickUnion(3, 8);
        q1.unionWeightedQuickUnion(6, 5);
        q1.unionWeightedQuickUnion(9, 4);
        q1.unionWeightedQuickUnion(2, 1);
        q1.unionWeightedQuickUnion(5, 0);
        q1.unionWeightedQuickUnion(7, 2);              
        for (int i = 0; i < N; i++)
            System.out.print(q1.id[i] + " ");
	}


}
