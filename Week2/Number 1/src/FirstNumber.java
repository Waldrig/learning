import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Waldrig on 18.07.2017.
 */

/*
Задание 1
Работа с матрицами:
написать функцию для создания матрицы различных розмерностей и заполнения их элементов(ручной ввод, рандомный, с файла (по желанию))
Сделать функцию умножения матрицы на число
Сделать функцию сложения и вычитания двух матриц(если матрицы разной рамерности, то усекать до найменьшей сторон из матриц)
функция транспонирования матрицы
Вывод всех диагональных элементов матрицы (наискось)

Задание по желанию:
Сделать функцию умножения матрицы на матрицу(не забыть проверки размерности сделать, кто не шарит, тот может поюзать гугл, с вопросом как умножаются матрицы)



Дополнительное задание от Макса: вывод диагоналей по его примеру из конфы
 */
public class FirstNumber {
    private static int[][] generatedMatrix;
    private static int[][] resMatrix;

    public static void main(String[] args) {
        int sizeX, sizeY;
        int min, max;
        int choise;
        int number;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("МЕНЮ");
                System.out.println("1. Ввести в матрицу свои числа.");
                System.out.println("2. Ввести в матрицу рандомные.");
                System.out.println("0. Выйти");
                choise = Integer.parseInt(reader.readLine());
                switch (choise) {
                    case 1:
                        System.out.println("Ввести количество строк:");
                        sizeX = Integer.parseInt(reader.readLine());
                        System.out.println("Ввести количество столбцов:");
                        sizeY = Integer.parseInt(reader.readLine());
                        generatedMatrix = userMatrixCreator(sizeX, sizeY);
                        break;
                    case 2:
                        System.out.println("Введите количество строк матрицы: ");
                        sizeX = Integer.parseInt(reader.readLine());
                        System.out.println("Введите количество столбцов матрицы: ");
                        sizeY = Integer.parseInt(reader.readLine());
                        System.out.println("Введите диапазон для генерации");
                        System.out.println("Минимальное число: ");
                        min = Integer.parseInt(reader.readLine());
                        System.out.println("Максимальное число: ");
                        max = Integer.parseInt(reader.readLine());
                        generatedMatrix = rndmMatrixCreator(sizeX, sizeY, min, max);
                        break;
                    case 0:
                        break;
                }
            } while (choise != 0);

            int[][] testingMatrix = {{1, 2, 3, 4}, {4, 5, 6, 6}, {7, 8, 9, 7}, {7, 8, 9, 3}};
            diagonalMatrix(testingMatrix);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /*
    *Написать функцию для создания матрицы различных розмерностей и
    * заполнения их элементов(ручной ввод, рандомный, с файла (по желанию))
     */
    private static int[][] userMatrixCreator(int x, int y) {
        int matrix[][] = new int[x][y];

        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrix[i][j] = Integer.parseInt(r.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < x; i++) {
            System.out.print("\n");
            for (int j = 0; j < y; j++) {
                System.out.print(matrix[i][j] + " " + "\t\t\t");
            }
        }
        return matrix;
    }


    private static int[][] rndmMatrixCreator(int x, int y, int min, int max) {
        int matrix[][] = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = min + (int) (Math.random() * max);
            }
        }
        for (int i = 0; i < x; i++) {
            System.out.print("\n");
            for (int j = 0; j < y; j++) {
                System.out.print(matrix[i][j] + " " + "\t\t\t");
            }
        }
        return matrix;
    }

    /*
*Сделать функцию умножения матрицы на число
 */
    private static void matrixMultiplyOnNumber(int[][] matrix, int number) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = matrix[i][j] * number;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("\n");
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " " + "\t\t\t");
                }
            }
        } else {
            System.out.println("Матрица пуста");
        }
    }

    /*
*Сделать функцию сложения и вычитания двух матриц
* (если матрицы разной рамерности, то усекать до найменьшей сторон из матриц)
 */
    private static void matrixSubstract(int[][] firstMatrix, int[][] secondMatrix) {
        if ((firstMatrix.length + firstMatrix[0].length) >
                (secondMatrix.length + secondMatrix[0].length)) {
            resMatrix = new int[secondMatrix.length][secondMatrix[0].length];
            for (int i = 0; i < secondMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    resMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
                }
            }
        } else {
            resMatrix = new int[firstMatrix.length][firstMatrix[0].length];
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[0].length; j++) {
                    resMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
                }
            }
        }
        for (int i = 0; i < resMatrix.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < resMatrix[0].length; j++) {
                System.out.print(resMatrix[i][j] + " " + "\t\t\t");
            }
        }
    }


    private static void matrixAddition(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length + firstMatrix[0].length >
                secondMatrix.length + secondMatrix[0].length) {
            resMatrix = new int[secondMatrix.length][secondMatrix[0].length];
            for (int i = 0; i < secondMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    resMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                }
            }
        } else {
            resMatrix = new int[firstMatrix.length][secondMatrix[0].length];
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[0].length; j++) {
                    resMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                }
            }
        }
        for (int i = 0; i < resMatrix.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < resMatrix[0].length; j++) {
                System.out.print(resMatrix[i][j] + " " + "\t\t\t");
            }
        }
    }

    /*
*функция транспонирования матрицы
 */
    private static void transposeMatrix(int[][] matrix) {
        resMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                resMatrix[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i < resMatrix.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < resMatrix[0].length; j++) {
                System.out.print(resMatrix[i][j] + " " + "\t\t\t");
            }
        }
    }
     /*
*Вывод всех диагональных элементов матрицы (наискось)
 */

    private static void diagonalMatrix(int[][] matrix) {


        if (matrix.length > matrix[0].length) { //усечение матрицы
            resMatrix = new int[matrix[0].length][matrix[0].length];
            for (int i = 0; i < resMatrix.length; i++) {
                for (int j = 0; j < resMatrix[0].length; j++) {
                    resMatrix[i][j] = matrix[i][j];
                }
            }
        } else {
            resMatrix = new int[matrix.length][matrix.length];
            for (int i = 0; i < resMatrix.length; i++) {
                for (int j = 0; j < resMatrix[0].length; j++) {
                    resMatrix[i][j] = matrix[i][j];
                }

            }
        }


        System.out.print("\n\n");
        System.out.println("Главная диагональ: ");
        for (int i = 0; i < resMatrix.length; i++) { //вывод главной диагонали
            System.out.print("\n");
            for (int j = 0; j < resMatrix[0].length; j++) {
                if (i == j) {
                    System.out.print("[" + resMatrix[i][j] + "]" + "\t\t\t");
                } else {
                    System.out.print(resMatrix[i][j] + "\t\t\t");
                }
            }

        }

        System.out.print("\n\n"); //вывод вектора главной диагонали
        System.out.print("Вектор главной диагонали: " + "[");
        for (int i = 0; i < resMatrix.length; i++) {
            if (i == resMatrix.length - 1) {
                System.out.print(matrix[i][i]);
            } else {
                System.out.print(matrix[i][i] + ", ");
            }
        }
        System.out.println("]");



        System.out.print("\n\n");
        System.out.println("Побочная диагональ: ");
        for (int i = 0; i < resMatrix.length; i++) { //вывод побочной диагонали
            System.out.print("\n");
            for (int j = 0; j < resMatrix[0].length; j++) {
                if ((i + j) == resMatrix[0].length - 1) {
                    System.out.print("[" + resMatrix[i][j] + "]" + "\t\t\t");
                } else {
                    System.out.print(resMatrix[i][j] + "\t\t\t");
                }
            }

        }


        System.out.print("\n\n"); //вывод вектора побочной диагонали
        System.out.print("Вектор побочной диагонали: " + "[");

        for (int i = 0; i < resMatrix.length; i++) {
            for (int j = 0; j < resMatrix[0].length; j++) {
                if ((i + j) == resMatrix[0].length - 1) {
                    if (i == resMatrix.length - 1) {
                        System.out.print(matrix[i][j]);
                    } else {
                        System.out.print(matrix[i][j] + ", ");
                    }
                }
            }
        }
        System.out.println("]");
    }
}

