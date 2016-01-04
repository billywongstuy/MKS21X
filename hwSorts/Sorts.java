public class Sorts {

    public static void insertionSort(int[]data) {
	for (int i = 1; i < data.length; i++) {
	    int push = 0;
	    int value = data[i];
	    for (int j = i-1; j >= 0; j--) {
		if (value < data[j]) {
		    push += 1;
		}
	    }
	    int position = i;
	    for (int k = push; k > 0; k--) {
		data[position] = data[position-1];
		position -= 1;
	    }
	    data[i-push] = value;
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
	    //printArray(data);
	    start++;
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
	selectionSort(stwoa);
	printArray(stwoa);
    }
    
}
