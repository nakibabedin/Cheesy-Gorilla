/*
Anthony Sun + Corn, Nakib Abedin + Joker;
APCS
HW48 - search methods
2021-12-15
Time spent: 1 hr
DISCOS:
0. for x.compareTo(y), x and y must be comparables
QCC:
0. Is it possible to abridge iArr3, as it is very long?
1. What does a "raw comparable" mean? Java doesn't seem to like our implemetations.
/**
   class BinSearch
   Binary search on array of Comparables
**/

public class BinSearch
{

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( Comparable[] a, Comparable target )
  {
    //uncomment exactly 1 of the 2 stmts below:

    // return binSearchIter( a, target, 0, a.length-1 );
    return binSearchRec( a, target, 0, a.length-1 );
  }


  public static int binSearchRec( Comparable[] a, Comparable target, int lo, int hi )
  {

    int tPos = -1;
    if (hi-lo ==0) {
      if (a[lo] == target) { // base case
        tPos=lo;
      }
      return tPos;
    }

    int m = (lo + hi) / 2; //init mid pos var

    if (a[m].compareTo(target)==0){
      return m;
    }

    // value at mid index higher than target

    if (a[m].compareTo(target) > 0){
      hi = m - 1;
    }

    // value at mid index lower than target
    if (a[m].compareTo(target) < 0){
      lo = m + 1;
    }

    return binSearchRec(a, target, lo, hi);

  }//end binSearchRec


  public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1
    int m; //init mid pos var

    while( hi > lo ) { // run until lo & hi cross

      //update mid pos var

      m = (lo + hi)/2;

      // target found

      if (a[m].compareTo(target)==0){
        tPos = m;
        return tPos;
      }

      // value at mid index higher than target

      if (a[m].compareTo(target) > 0){
        hi = m - 1;
      }

      // value at mid index lower than target
      if (a[m].compareTo(target) < 0){
        lo = m + 1;
      }

    }

    // lo = hi
    if (a[lo] == target) {
      tPos = lo;
    }
    return tPos;
  }//end binSearchIter



  //tell whether an array is sorted in ascending order
  private static boolean isSorted( Comparable[] arr )
  {

    boolean retBoo = true; //init to true, assume array is sorted

    //Q: Why would a FOREACH loop not suffice here?
    //A: A FOREACH loop does not come with an in-bulit system for indexing. We can use it, but it opens up room for errors.
    for( int i=0; i < arr.length-1; i++ ) {
      if ( ( arr[i].compareTo(arr[i+1]) > 0 ) ) {
        return false;
      }
    }
    return retBoo; //if entire array was traversed, it must be sorted
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Comparable[] arr ) {
    String output = "[ ";

    for( Comparable c : arr )
	    output += c + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }



  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing binSearch on Comparable array...");

    //Declare and initialize array of Comparables
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );
    System.out.println( "iArr1 sorted? -- " + isSorted(iArr) );

    Comparable[] iArr2 = { 2, 4, 6, 8, 13, 42 };
    printArray( iArr2 );
    System.out.println( "iArr2 sorted? -- " + isSorted(iArr2) );

    Comparable[] iArr3 = new Integer[10000];
    for( int i = 0; i < iArr3.length; i++ ) {
    iArr3[i] = i * 2;
    }

    printArray( iArr3 );
    System.out.println( "iArr3 sorted? -- " + isSorted(iArr3) );

    //search for 6 in array
    System.out.println( binSearch(iArr2,2) );
    System.out.println( binSearch(iArr2,4) );
    System.out.println( binSearch(iArr2,6) );
    System.out.println( binSearch(iArr2,8) );
    System.out.println( binSearch(iArr2,13) );
    System.out.println( binSearch(iArr2,42) );

    //search for 43 in array
    System.out.println( binSearch(iArr2,43) );

    System.out.println( "now testing binSearch on iArr3..." );
    System.out.println( binSearch(iArr3,4) );
    System.out.println( binSearch(iArr3,8) );
    System.out.println( binSearch(iArr3,5) );

    //search for 43 in array
    System.out.println( binSearch(iArr3,43) );

    /*----------------------------------------------------
    ====================================================*/


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class BinSearch2
