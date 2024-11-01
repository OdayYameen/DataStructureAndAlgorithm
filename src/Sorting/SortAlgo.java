package Sorting;

import java.util.Arrays;
import java.util.Random;

public class SortAlgo
{

    private void bubbleSort(int [] a)
    {
        int n = a.length;
        for (int i = 0; i< n-1 ; i++)
        {
            boolean noSwapDone = false;
            for (int j = 0;j < n-1-i; j++)
            {
                if (a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    noSwapDone = true;
                }
            }
            if (!noSwapDone)
            {
                break;
            }
        }
    }

    private void insertionSort(int []a)
    {
        int n = a.length;
        for (int i = 1; i < n; i++)
        {
            int temp = a[i];
            int j = i-1;
            while (j >=0 && a[j] > temp)
            {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }

    private void selectionSort(int []a)
    {
        int n = a.length;
        for (int i = 0 ; i < n-1; i++)
        {
            int minValue = i;
            for (int j = i+1; j < n; j++)
            {
                if (a[j] < a[minValue])
                {
                   minValue = j;
                }
            }
            if (minValue != i)
            {
                int temp = a[minValue];
                a[minValue] = a[i];
                a[i] = temp;
            }
        }
    }
    private int QuickPartition(int []a, int lB , int uB)
    {
        //select pivot randomly and swap it with last element
        int pivotIndex = new Random().nextInt(uB - lB) + lB;
        int pivot = a[pivotIndex];
        int x = a[pivotIndex];
        a[pivotIndex] = a[uB];
        a[uB] = x;


        int start = lB;
        int end = uB;
        while (start < end)
        {

            while (a[start] <= pivot && start < end)
            {
                start++;
            }
            while (a[end] >= pivot && start < end)
            {
                end--;
            }
            if (start < end)
            {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        int temp = a[uB];
        a[uB] = a[start];
        a[start] = temp;
        return start;
    }

    private void quickSort(int []a, int lB, int uB)
    {
        if (lB < uB)
        {
            int location = QuickPartition(a,lB,uB);
            quickSort(a,lB,location-1);
            quickSort(a,location +1,uB);
        }
    }

    private void merge(int []a , int lb, int mid, int ub)
    {
        int i = lb;
        int j = mid +1;
        int k = lb;
        int b[] = new int[ub+1];
        while (i <= mid && j <= ub)
        {
            if (a[i] <= a[j])
            {
                b[k] = a[i];
                i++;
            }
            else
            {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= mid)
        {
            b[k] = a[i];
            i++; k++;
        }
        while (j <= ub)
        {
            b[k] = a[j];
            j++; k++;
        }
        for (k = lb; k<= ub; k++)
        {
            a[k] = b[k];
        }
    }

    private void mergeSort(int a[], int lb, int ub)
    {
        if (lb < ub)
        {
            int mid = (lb + ub)/2;
            mergeSort(a,lb,mid);
            mergeSort(a,mid+1,ub);
            merge(a,lb,mid,ub);
        }
    }

    private void shellSort(int []a)
    {
        int n = a.length;
        for (int gap = n/2 ; gap >=1; gap = gap/2)
        {
            for (int j = gap; j < n; j++)
            {
                for (int i = j - gap; i >= 0; i = i-gap)
                {
                    if (a[i+gap] > a[i])
                    {
                        break;
                    }
                    else
                    {
                        int temp = a[i+gap];
                        a[i+gap] = a[i];
                        a[i] = temp;
                    }
                }
            }
        }
    }


    /**
     * count sort drawback
     * 1.rang-able number like 0,99999,10,55(different digits), in this case
     * Radix is preferred
     * 2.k should be simeller to size of array, because may be
     * size = 100 and k (max) = 10000, then a lot of memory
     * indexes will allocate without benefits
     * this method work on 1 digit array element
     * @param a array to sort
     * @param k max element in array a, called distinct key
     *          0 <= a[i] <= k
     *          a[i] is integer
     * @return sorted array
     */
    private void countSort(int []a,int k)
    {
        int n = a.length;
        int []count = new int[k+1];
        int []b = new int[n];
        for (int i = 0; i< n; i++)
        {
            ++count[a[i]];
        }
        for (int i = 1; i <= k; i++)
        {
            count[i] = count[i] + count[i-1];
        }
        for (int i = n-1; i>= 0; i--)
        {
            b[--count[a[i]]] = a[i];
        }
        for (int i = 0; i< n; i++)
        {
            a[i] = b[i];
        }
    }
    private int getMax(int [] a)
    {
        int max = a[0];
        for (int i= 1; i< a.length; i++)
        {
            if (a[i] > max)
            {
                max = a[i];
            }
        }
        return max;
    }

    private void radixSortByCountSort(int []a)
    {
        int max = getMax(a);
        for (int pos = 1; max/pos > 0; pos = pos*10)
        {
           radixContSort(a,pos);
        }
    }

    private void radixContSort(int[] a, int pos)
    {
        int []count = new int[10];
        int n = a.length;
        int []b = new int[n];
        for (int i=0;i<n;i++)
        {
            ++count[(a[i]/pos)%10];
        }
        for (int i=1; i <count.length; i++)
        {
            count[i] = count[i] + count[i-1];
        }
        for (int i = n-1; i>=0; i--)
        {
            b[--count[(a[i]/pos)%10]] = a[i];
        }
        for (int i=0; i<n;i++)
        {
            a[i]= b[i];
        }
    }

    private void printArray(int []a,String sortAlgoName)
    {
        System.out.println("*** "+sortAlgoName+" *** ==>  ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }
        System.out.println();
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    public void heapSort(int arr[])
    {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    public static void main(String[] args) {
        int []a = {20,17,16,12,7,20,10,8,15,14,5,2,7,1,0,0,21};
        SortAlgo sortAlgo = new SortAlgo();
        int []bubble = Arrays.copyOf(a,a.length);
        sortAlgo.bubbleSort(bubble);
        sortAlgo.printArray(bubble,"BubbleSort");
        ////
        int []insertion = Arrays.copyOf(a,a.length);
        sortAlgo.insertionSort(insertion);
        sortAlgo.printArray(insertion,"insertionSort");
        ////
        int []selection = Arrays.copyOf(a,a.length);
        sortAlgo.selectionSort(selection);
        sortAlgo.printArray(selection,"selectionSort");
        ////
        int []merge = Arrays.copyOf(a,a.length);
        sortAlgo.mergeSort(merge,0, merge.length-1);
        sortAlgo.printArray(merge,"mergeSort");
        ////
        int []shell = Arrays.copyOf(a,a.length);
        sortAlgo.shellSort(shell);
        sortAlgo.printArray(shell,"shellSort");
        ////
        int []counting = {9,5,4,3,7,8,1,5,0,5,9,4,7,2,0,6,6};
        sortAlgo.countSort(counting, sortAlgo.getMax(counting));
        sortAlgo.printArray(counting,"countingSort");
        ////
        int []radix = {9,98,997,54,12,57,36};
        sortAlgo.radixSortByCountSort(radix);
        sortAlgo.printArray(radix,"radixSort");
        ////
        int []quick = Arrays.copyOf(a,a.length);
        sortAlgo.quickSort(quick,0,quick.length-1);
        sortAlgo.printArray(quick,"quickSort");
        ////
        int []heap =  Arrays.copyOf(a,a.length);
        sortAlgo.heapSort(heap);
        sortAlgo.printArray(heap,"heapSort");
    }
}
