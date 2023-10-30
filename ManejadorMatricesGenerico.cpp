#include <iostream>
#include <vector>
#include "Comparable.cpp"

using namespace std;
//Debido a como funciona C, tienes que preparar una clase Comparable para cada tipo, el formato ya te lo dejo hecho, simplemente cambia el int

template<typename T, size_t rows, size_t cols>
class ManejadorMatricesGenerico : Comparable<int> {
public:
    static int largestColumn(T (&matrix)[rows][cols], int column, int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[answer][column] > matrix[i][column])
                answer = i;

        return answer;
    }

    static int smallestColumn(T (&matrix)[rows][cols], int column, int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[answer][column] < matrix[i][column])
                answer = i;

        return answer;
    }

    static int largestInRow(T (&matrix)[rows][cols], int row, int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[row][i] > matrix[row][answer])
                answer = i;

        return answer;
    }
    
    static int smallestInRow(T (&matrix)[rows][cols], int row, int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[row][i] < matrix[row][answer])
                answer = i;

        return answer;
    }

    static vector<int> biggestInMatrix(T (&matrix)[rows][cols], int rowSize, int columnSize){
        int row = 0;
        int column = 0;

        for(int i = 0; i < rowSize; i++)
            for(int j =0; j < columnSize; j++)
                if(matrix[row][column] < matrix[i][j]){
                    row = i;
                    column = j;
                }

        vector<int> answer = {row, column};
        return answer;
    }

    static vector<int> smallestInMatrix(T (&matrix)[rows][cols], int rowSize, int columnSize){
        int row = 0;
        int column = 0;

        for(int i = 0; i < rowSize; i++)
            for(int j =0; j < columnSize; j++)
                if(matrix[row][column] > matrix[i][j]){
                    row = i;
                    column = j;
                }
        
        vector<int> answer = {row, column};
        return answer;
    }

     static bool symmetrical(T (&matrix)[rows][cols], int rowSize, int columnSize){
        bool answer = true; bool flag1, flag2;
        int i = 0; int j = 0;

        flag1 = i < columnSize && i < rowSize;
        flag2 = j < columnSize && j < rowSize;

        while(answer && flag2){
            while(answer && flag1){
                if(matrix[i][j] ==matrix[j][i])
                    i++;
                else
                    answer = false;

                flag1 = i < columnSize && i < rowSize;
            }
            j++;
            i = j;

            flag2 = j < columnSize && j < rowSize;
        }

        return answer;
    }

    static int rowSearch(T (&matrix)[rows][cols], int column, int size, T search){
        int i = 0;

        while(matrix[column][i] != search && i < size)
            i++;

        if(i == size)
            i = -1;

        return i;
    }

    static int columnSearch(T (&matrix)[rows][cols], int row, int size, T search){
        int i = 0;

        while(i < size && matrix[i][row] != search)
            i++;

        if(i == size)
            i = -1;

        return i;
    }

    static vector<int> nonSortedSearch(T (&matrix)[rows][cols], int columnSize, int rowSize, T search){
        vector<int> answer = {-1, -1};
        int i = 0;
        int j = -1;

        while(i < columnSize && j == -1){
            j = columnSearch(matrix, i, rowSize, search);
            i++;
        }

        if(j != -1){
            answer[0] = i-1;
            answer[1] = j;
        }

        return answer;
    }
};