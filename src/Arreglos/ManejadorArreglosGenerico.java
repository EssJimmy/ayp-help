package Arreglos;

import java.util.ArrayList;

public class ManejadorArreglosGenerico {

    public static <T extends Comparable<T>> int biggest(T[] array, int size) {
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(array[i].compareTo(array[answer]) > 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int biggestFrom(T[] array, int size, int start) {
        int answer = 0;

        for(int i = start; i < size; i++)
            if(array[i].compareTo(array[answer]) > 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int smallest(T[] array, int size) {
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(array[i].compareTo(array[answer]) < 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int smallestFrom(T[] array, int size, int start) {
        int answer = 0;

        for(int i = start; i < size; i++)
            if(array[i].compareTo(array[answer]) < 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int manyBiggerThan(T[] array, int size, T comparable) {
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(array[i].compareTo(comparable) > 0)
                answer++;


        return answer;
    }

    public static <T extends Comparable<T>> int manySmallerThan(T[] array, int size, T comparable) {
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(array[i].compareTo(comparable) < 0)
                answer++;


        return answer;
    }

    public static <T extends Comparable<T>> ArrayList<Integer> whichBiggerThan(T[] array, int size, T comparable){
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < size; i++)
            if(array[i].compareTo(comparable) > 0)
                answer.add(i);

        return answer;
    }

    public static <T extends Comparable<T>> ArrayList<Integer> whichSmallerThan(T[] array, int size, T comparable){
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < size; i++)
            if(array[i].compareTo(comparable) < 0)
                answer.add(i);

        return answer;
    }

    public static <T> void swap(T[] array, int initialPosition, int changedPosition){
        T aux = array[initialPosition];

        array[initialPosition] = array[changedPosition];
        array[changedPosition] = aux;
    }

    public static <T> void invertArray(T[] array, int size){
        int j = size - 1;

        for(int i = 0; i < size/2; i++){
            swap(array, i, j);
            j--;
        }
    }

    public static <T> void kIndexSwapsRight(T[] array, int size, int noMoves){
        for(int i = 1; i<=noMoves;i++)
            for (int j = size-1; j >= 0; j--)
                array[j+1] = array[j];

        array[0] = null;
    }

    public static <T> void kIndexSwapsLeft(T[] array, int size, int noMoves){
        for(int i = 1; i<=noMoves;i++)
            for(int j = 1; j<=size; j++)
                array[j-1] = array[j];
        array[size] = null;
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array, int size){
        int minPosition;

        for(int i = 0; i < size; i++){
            minPosition = smallestFrom(array, size, i);
            swap(array, minPosition, i);
        }
    }

    public static <T> int unorderedSearch(T[] array, int size, T object){
        int i = 0;

        while(i < size && !array[i].equals(object))
            i++;

        if(i == size)
            i = -1;

        return i;
    }

    public static <T extends Comparable<T>> int orderedSearch(T[] array, int size, T object){
        int i = 0;

        while(array[i].compareTo(object) < 0)
            i++;

        if(i == size || !array[i].equals(object))
            i = -i-1;

        return i;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, int size, T object){
        int answer;
        int start = 0;
        int end = size - 1;

        answer = (start + end)/2;

        while(start < end && !array[answer].equals(object)){
            if(array[answer].compareTo(object) < 0)
                start = answer + 1;
            else
                end = answer - 1;

            answer = (start + end)/2;
        }

        if(!array[answer].equals(object))
            answer = start - 1;

        return answer;
    }

    public static <T> void indexedLeftSwaps(T[] array, int size, int initialPosition){
        for(int i = initialPosition; i < size - 1; i++)
            array[i] = array[i+1];
    }

    public static <T> void indexedRightSwaps(T[] array, int size, int initialPosition){
        for(int i = initialPosition; i < size - 1; i++)
            array[i] = array[i-1];
    }

    public static <T> int remove(T[] array, int size, int position){
        if(position >= 0 && position < size){
            indexedLeftSwaps(array, size, position);
            size--;
            array[size] = null;
        }

        return size;
    }

    public static <T extends Comparable<T>> int deleteUnordered(T[] array, int size, T object){
        return remove(array, size, unorderedSearch(array, size, object));
    }

    public static <T extends Comparable<T>> int deleteOrdered(T[] array, int size, T object){
        return remove(array, size, binarySearch(array, size, object));
    }

    public static <T extends Comparable<T>> int orderedInsert(T[] array, int size, T object){
        int position;

        if(array.length > size){
            position = binarySearch(array, size, object);

            if(position < 0){
                position = -position-1;
                indexedRightSwaps(array, size, position);
                array[position] = object;
                size++;
            }
        }

        return size;
    }

    public static <T> int insertInto(T[] array, int size, int position, T object){
        if(position < size && position > 0) {
            indexedRightSwaps(array, size, position);
            size++;
            array[position] = object;
        }

        return size;
    }

    public static <T> int insert(T[] array, int size, T object){
        if(array.length > size){
            array[size] = object;
            size++;
        }

        return size;
    }
}
