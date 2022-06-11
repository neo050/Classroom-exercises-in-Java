import java.util.Scanner;

public class Sortarrays {
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
        System.out.println(array);
    }
    static public int[] bubbleSort(final int []array)
    {
        int temp;
        int[] bubbleSort=new int[array.length];
        for (int i=0;i< array.length;++i)
            for (int j=0;j< array.length-1-i;++j)
                if (array[j]>array[j+1])
                {
                    temp =bubbleSort[j];
                    bubbleSort[j]=bubbleSort[j+1];
                    bubbleSort[j+1]=temp;
                }


        return bubbleSort;
    }
    private static void mergeSort(int[] array) {

        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for(; i < length; i++) {
            if(i < middle) {
                leftArray[i] = array[i];
            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while(l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}

