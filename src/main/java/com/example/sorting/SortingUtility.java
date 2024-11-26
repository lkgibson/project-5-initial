package com.example.sorting;

public class SortingUtility
{

    public static <T extends Comparable<T>> void gnomeSort(T[] data)
    {
        int pos = 0;
        while (pos < data.length)
        {
            if (pos == 0 || data[pos].compareTo(data[pos - 1]) >= 0)
            {
                pos++;
            }
            else
            {
                swap(data, pos, pos - 1);
                pos--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data)
    {
        boolean swapped;
        int start = 0;
        int end = data.length;

        do
        {
            swapped = false;
            for (int i = start; i < end - 1; i++)
            {
                if (data[i].compareTo(data[i + 1]) > 0)
                {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;

            swapped = false;
            end--;

            for (int i = end - 1; i >= start; i--)
            {
                if (data[i].compareTo(data[i + 1]) > 0)
                {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
            start++;
        } while (swapped);
    }


    public static <T extends Comparable<T>> void shellSort(T[] data)
    {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        int n = data.length;

        for (int gap : gaps)
        {
            for (int i = gap; i < n; i++)
            {
                T temp = data[i];
                int j;
                for (j = i; j >= gap && data[j - gap].compareTo(temp) > 0; j -= gap)
                {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}





