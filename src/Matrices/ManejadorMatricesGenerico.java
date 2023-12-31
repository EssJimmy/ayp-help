package Matrices;

public class ManejadorMatricesGenerico {

    public static <T extends Comparable<T>> int largestInColumn(T[][] matrix, int column, int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[answer][column].compareTo(matrix[i][column]) < 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int smallestInColumn(T[][] matrix, int column, int size){
        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[answer][column].compareTo(matrix[i][column]) > 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int largestInRow(T[][] matrix, int row, int size){
        // return ManejadorArreglosGenerico.posMayor(mat[ren], m);

        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[row][i].compareTo(matrix[row][answer]) > 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int smallestInRow(T[][] matrix, int row, int size){
        // return ManejadorArreglosGenerico.posMenor(mat[ren], m);

        int answer = 0;

        for(int i = 1; i < size; i++)
            if(matrix[row][i].compareTo(matrix[row][answer]) < 0)
                answer = i;

        return answer;
    }

    public static <T extends Comparable<T>> int[] biggestInMatrix(T[][] matrix, int rowSize, int columnSize){
        int row = 0;
        int column = 0;

        for(int i = 0; i < rowSize; i++)
            for(int j = 0; j < columnSize; j++)
                if(matrix[row][column].compareTo(matrix[i][j]) < 0){
                    row = i;
                    column = j;
                }

        return new int[]{row, column};
    }

    public static <T extends Comparable<T>> int[] smallestInMatrix(T[][] matrix, int rowSize, int columnSize){
        int row = 0;
        int column = 0;

        for(int i = 0; i < rowSize; i++)
            for(int j = 0; j < columnSize; j++)
                if(matrix[row][column].compareTo(matrix[i][j]) > 0){
                    row = i;
                    column = j;
                }

        return new int[]{row, column};
    }

    //must try this since it should work but not sure
    public static <T> boolean symmetrical(T[][] matrix, int rowSize, int columnSize){
        boolean answer = true; boolean flag1, flag2;
        int i = 0; int j = 0;

        flag1 = i < columnSize && i < rowSize;
        flag2 = j < columnSize && j < rowSize;

        while(answer && flag2){
            while(answer && flag1){
                if(matrix[i][j].equals(matrix[j][i]))
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

    public static <T> int rowSearch(T[][] matrix, int column, int size, T search){
        int i = 0;

        while(!matrix[column][i].equals(search) && i < size)
            i++;

        if(i == size)
            i = -1;

        return i;
    }

    public static <T> int columnSearch(T[][] matrix, int row, int size, T search){
        int i = 0;

        while(i < size && !matrix[i][row].equals(search))
            i++;

        if(i == size)
            i = -1;

        return i;
    }

    public static <T> int[] nonSortedSearch(T[][] matrix, int columnSize, int rowSize, T search){
        int[] answer = {-1, -1};
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
}
