import java.util.*;

public class Sorts {

    public static void insertionSort(int[]data) {
	for (int i = 1; i < data.length; i++) {
	    int k;
	    int value = data[i];
	    for (k = i - 1; k >= 0 && data[k] > value; k--) {
		data[k+1] = data[k];		
	    }
	    data[k+1] = value;
	}
    }

    public static void selectionSort(int[]data) {
	int start = 0;
	int lowestIndex = 0;
	while (start < data.length-1) {
	    int lowest = data[start];
	    for (int i = start; i < data.length; i++) {
		if (data[i] < lowest) {
		    lowest = data[i];
		    lowestIndex = i;
		}
	    }
	    data[lowestIndex] = data[start];
	    data[start] = lowest;
	    start++;
	}
    }

    public static void bubbleSort(int[]data) {
	int end = data.length;
	while (end > 0) {
	    for (int i = 0; i < end-1; i++) {
		int toSwap;
		if (data[i+1] < data[i]) {
		    toSwap = data[i];
		    data[i] = data[i+1];
		    data[i+1] = toSwap;
		}
	    }
	    end--;
	}
    }

    public static void  printArray(int[]data) {
	String print = "[";
	for (int i = 0; i < data.length; i++) {
	    if (i == data.length-1) {
		print += data[i];
	    }
	    else {
		print += data[i] + ",";
	    }
	}
	print += "]";
	System.out.println(print);
    }
    

    public static void fillRandom(int[]data) {
	Random generator = new Random();
	for (int i = 0; i < data.length; i++) { 
	    int sign = 1;
	    if ((int)(Math.random()*2) == 0) {
		sign = -1;
	    }
	    data[i] = sign * generator.nextInt(100);
	}
    }

    public static void main(String[]a) {
	/*int [] o = {10};
	insertionSort(o);
	int [] one = {10,8};
	insertionSort(one);
	int [] two = {10,8,9};
	insertionSort(two);
	int [] tw = {10,8,9,7};
        insertionSort(tw);
	int [] twoy = {10,8,9,-1};
        insertionSort(twoy);
	int [] twoa = {10,8,9,-1,43};
        insertionSort(twoa);
	int [] twoat = {10,8,9,-1,43,4};
        insertionSort(twoat);*/
	int [] stwoa = {10,8,9,0,-1,43,4,6};
        //insertionSort(stwoa);
	//selectionSort(stwoa);
	//bubbleSort(stwoa);
	//printArray(stwoa);

	int[]testArray = new int[(int)(Math.random()*10+1)];
	fillRandom(testArray);
	int[]copy = Arrays.copyOf(testArray,testArray.length);
	Arrays.sort(copy);
	printArray(copy);
	//insertionSort(testArray);
	//selectionSort(testArray);
	bubbleSort(testArray);
	printArray(testArray);

	//test cases using random seed arrays
    }
    
}
