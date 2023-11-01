#include <iostream>
#include <vector>
#include "Comparable.cpp"

using namespace std;

template <typename T, size_t a_size>
class ManejadorArreglosGenerico : Comparable<int>{
public:
    static int biggest(T (&array)[a_size], int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(array[i] > array[answer])
                answer = i;

        return answer;
    }

    static int biggestFrom(T (&array)[a_size], int size, int start){
        int answer = 0;

        for(int i = start; i < size; i++)
            if(array[i] > array[answer])
                answer = i;

        return answer;
    }

    static int smallest(T (&array)[a_size], int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(array[i] < array[answer])
                answer = i;

        return answer;
    }

    static int smallestFrom(T (&array)[a_size], int size, int start){
        int answer = 0;

        for(int i = start; i < size; i++)
            if(array[i] < array[answer])
                answer = i;

        return answer;
    }

    static int manyBiggerThan(T (&array)[a_size], int size, T object){
        int answer = 0;

        for(int i = 0; i < size; i++)
            if(array[i] > array[answer])
                answer++;

        return answer;
    }

    static int manySmallerThan(T (&array)[a_size], int size, T object){
        int answer = 0;

        for(int i = 0; i < size; i++)
            if(array[i] < array[answer])
                answer++;

        return answer;
    }

    static vector<int> whichBiggerThan(T (&array)[a_size], int size, T object){
        vector<int> answer;

        for(int i = 0; i < size; i++)
            if(array[i] > array[answer])
                vector.push_back(i);

        return answer;
    }

    static vector<int> whichSmallerThan(T (&array)[a_size], int size, T object){
        vector<int> answer;

        for(int i = 0; i < size; i++)
            if(array[i] < array[answer])
                vector.push_back(i);

        return answer;
    }

    static void swap(T (&array)[a_size], int initalPosition, int changedPosition){
        T aux = array[initialPosition];

        array[initalPosition] = array[changedPosition];
        array[changedPosition] = aux;
    }

    static void invertArray(T (&array)[a_size], int size){
        int j = size - 1;

        for(int i = 0; i < size/2; i++){
            swap(array, i, j);
            j--;
        }
    }

    static void kIndexSwapsRight(T (&array)[a_size], int size, int noMoves){
        for(int i = 1; i<=noMoves;i++)
            for (int j = size-1; j >= 0; j--)
                array[j+1] = array[j];

        array[0] = NULL;
    }

    static void kIndexSwapsLeft(T (&array)[a_size], int size, int noMoves){
        for(int i = 1; i<=noMoves;i++)
            for(int j = 1; j<=size; j++)
                array[j-1] = array[j];

        array[size] = NULL;
    }
};