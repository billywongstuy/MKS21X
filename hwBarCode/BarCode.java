public class BarCode implements Comparable{
    // instance variables
    private String _zip;
    private int _checkDigit;

    private static final String[]bars = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

    // constructors
    //precondtion: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //                zip and  checkDigit are initialized.
    public BarCode(String zip) {
	try {
	    for (int i = 0; i < zip.length(); i++) {
		Integer.parseInt(zip.substring(i,i+1));
	    }
	    if (zip.length() == 5) {
		_zip = zip;
		_checkDigit = checkSum();
		_zip += _checkDigit;
	    }
	    else {
		throw new IllegalArgumentException("Please make sure your input has a length of exactly 5!");
	    }
	}
	catch (NumberFormatException e) {
	    throw new NumberFormatException("Please make sure that your string only contains numbers!"); 
	}
    }

    // postcondition: Creates a copy of a bar code.
    public BarCode(BarCode x){
	_zip = x._zip;
	_checkDigit = x._checkDigit;
    }


    //post: computes and returns the check sum for zip
    private int checkSum(){
	int sum = 0;
	for (int i = 0; i < _zip.length(); i++) {
	    sum += Integer.parseInt(_zip.substring(i,i+1));
	}
	return sum%10;
    }

    //postcondition: format zip + check digit + barcode 
    //ex. "084518 |||:::|::|::|::|:|:|::::|||::|:|" 
    public String toString(){
	String barz = "|";
	for (int i = 0; i < _zip.length(); i++) {
	    barz += bars[Integer.parseInt(_zip.substring(i,i+1))] + "";
	}
	return barz + "|";
    }


    public boolean equals(Object other){
	return this == other || (other instanceof BarCode && _zip.equals(((BarCode)other)._zip));
    } 

    //compare tostring
    public int compareTo(Object other){
	return toString().compareTo(other.toString());
    }


    public static void main(String[]args) {
	BarCode a = new BarCode("08451");
	System.out.println(a);
	System.out.println(a.equals(a));
	
	BarCode b = new BarCode(a);
	System.out.println(a.equals(b));
	
	BarCode c = new BarCode("97480");
	System.out.println(a.equals(c));

	BarCode d = new BarCode("08451");
	System.out.println(a.equals(d));

	//BarCode e = new BarCode("93894795");

	//BarCode f = new BarCode("abcde");
	
    }
}
