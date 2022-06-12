import java.util.Scanner;

public class Sortarrays {

    static public void print (String o)
    {
        System.out.println(o);
    }


    static public int[] readArray()
    {
        int sizeofArray;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the size of the integers Array");
        sizeofArray=sc.nextInt();

        int array[]=new int [sizeofArray];
        for (int i =0;i<sizeofArray;++i)
        {
            System.out.println("Enter val "+(i+1)+"to  Array");
            array[i]= sc.nextInt();
        }
        sc.close();
        return array;
    }
    static public void  printArray(int []array)
    {

        System.out.print("[");
        for(int i=0;i< array.length;++i){
            if(i<array.length-1)
                System.out.print(array[i]+",");
            else
                System.out.print(array[i]);
        }
        System.out.println("]");

    }
    static public int[] bubbleSort(final int []array)
    {
        int temp;
        int[] bubbleSort=new int[array.length];
        for (int i=0;i< array.length;++i)

        {
            bubbleSort[i]=array[i];
        }
        for (int i=0;i< bubbleSort.length;++i) {
            for (int j = 0; j < array.length - 1 - i; ++j) {
                if (bubbleSort[j] > bubbleSort[j + 1]) {
                    temp = bubbleSort[j];
                    bubbleSort[j] = bubbleSort[j + 1];
                    bubbleSort[j + 1] = temp;
                }
            }
        }



        return bubbleSort;
    }
    private static void mergeSort(int[] array) {

        if(array.length<=1)
            return;
        int Larray[]=new int[array.length/2];
        int Rarray[]=new int[ array.length-array.length/2];
        int i=0,j=0;
        for (;i< array.length;++i)
        {
            if(i<Larray.length)
                Larray[i]=array[i];
            else {
                Rarray[j] = array[i];
                j++;
            }
        }
        mergeSort(Larray);
        mergeSort(Rarray);
        merge(Larray, Rarray,array);

    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int l=0,r=0,i=0;

                    while (l<leftArray.length&&r<rightArray.length) {
                        if (leftArray[l] <= rightArray[r]) {
                            array[i] = leftArray[l];
                            l++;
                            i++;
                        } else {
                            array[i] = rightArray[r];
                            r++;
                           i++;

                        }

                    }

                    while (l < leftArray.length) {
                            array[i] = leftArray[l];
                            l++;
                            i++;
                    }
                    while (r < rightArray.length) {

                        array[i] = rightArray[r];
                        r++;
                        i++;
                    }

    }
    public static int[] mergeSortAPI( final int  []  array)
    {
       int[] copyArray=new int[array.length];
       for (int i=0;i< array.length;++i)
       {
           copyArray[i]=array[i];
       }
        mergeSort(copyArray);
       return copyArray;
    }
    public static void main(String args[])
    {
        int array[]= {7 ,17 ,11 ,6 ,3 ,25 ,70 ,30 };
        print("mergeSort: ");
        printArray(mergeSortAPI(array));
        print("bubbleSort: ");
        printArray( bubbleSort(array));


    }

}

