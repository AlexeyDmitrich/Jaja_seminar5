import java.util.Random;

public class HomeTask3 {
    //    На шахматной доске расставить 8 ферзей так,
//    чтобы они не били друг друга. И вывести Доску.
//0x000000
//0000x000
//00x00000
    public static void main(String[] args) {
        int counter = 0;
        int workingTimeIter = 0;
        int workingTime = 0;
        do {
            long start = System.currentTimeMillis();
            init();
            long finish = System.currentTimeMillis();
            workingTime = (int) (finish - start);
            System.out.printf("Время выполнения: %d \n", workingTime);
            counter++;
            workingTimeIter+=workingTime;
        } while (counter<10);
        System.out.printf("Среднее время работы: %d сек.", (workingTimeIter/counter)/1000);
    }

    public static void init() {
        int size = 8;//input.Int("Задайте размер поля");
        printBoard(table(size));
//        String[][] first = topography(table(size));
//        printBoard(first);
//        System.out.println();
//        String[][] res = nextQuin(first, 1);
        String[][] res = rndQuin(table(size));
        printBoard(res);

    }

    public static String[][] table(int size) {
        String[][] chessBoard = new String[size][size];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                    chessBoard[i][j] = "o";
            }
        }
        return chessBoard;
    }

    public static void printBoard(String[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                System.out.printf("%s ", board[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }

//    public static String[][] topography(String[][] board) {
//        String[][] filledBoardFirst = board;
//        filledBoardFirst[0][1] = "x";
//        return filledBoardFirst;
//    }

//    public static String[][] nextQuin(String[][] board, int counter){
//        int startPoint = 0;
//        int loopReset = 8;
//            while (counter<8) {
//                if (loopReset == 0) {
//                    loopReset = 8;
//                    startPoint++;
//                    if (startPoint > 7){
//                        startPoint = 0;
//                    }
//                }
//                int jLast = 0;
//                for (int i = 0; i < board.length; i++) {
//                    for (int j = startPoint; j < board[i].length; j ++) {
//                        if (jLast < j) {
////                            System.out.printf("проверяем... x: %d y: %d\n", i, j);
//                            if (freeCell(board, i, j)) {
//                                board[i][j] = "x";
//                                counter++;
//                                printBoard(board);
//                                System.out.println();
//                                jLast++;
//                                if (jLast == 7) {
//                                    jLast = 0;
//                                }
//                            }
//                        } else System.out.println("FALSE");
//                    }
//                    loopReset--;
////                    startPoint++;
//                }
//            }
//        return board;
//    }

    public static String[][] rndQuin (String[][] board){
        String[][] fillBoard = board;
        Random rnd = new Random();
        int counter = 0;
        while (counter<8){
            int x = rnd.nextInt(8);
            int y = rnd.nextInt(8);
            if (freeCell(fillBoard, x, y)){
                fillBoard[x][y] = "x";
                counter++;
//                printBoard(fillBoard);
//                System.out.println(counter);
            }
            else {
                if (counter>4) {
                    int free = 0;
                    for (int i = 0; i < fillBoard.length; i++) {
                        for (int j = 0; j < fillBoard[i].length; j++) {
                            if (!freeCell(fillBoard, i, j)) {
                                fillBoard = table(fillBoard.length);
//                                printBoard(fillBoard);
                                counter = 0;
                            } else continue;
                        }
                    }
                }
            }
        }
        return fillBoard;
    }

    /**
     * Этот метод нужен для проверки битого поля
     * @param board
     * @param x
     * @param y
     * @return возвращает True если на поле можно поставить фигуру.
     */
    public static boolean freeCell (String[][] board, int x, int y){
        if (board[x][y].equals("x")) return false;
        for (int i = 0; i < board.length; i++) {
            if (board[x][i].equals("x") ||
                    board[i][y].equals("x") ||
                    board[x][y].equals("x")) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if ((x+i < board.length && y+i< board.length)) {
                if (board[x + i][y + i].equals("x")) return false;
            }
            if ((x-i >= 0 && y-i >= 0)) {
                if (board[x - i][y - i].equals("x")) return false;
            }
            if ((x+i < board.length && y-i >= 0)) {
                if (board[x + i][y - i].equals("x")) return false;
            }
            if ((x-i >= 0 && y+i < board.length)) {
                if (board[x - i][y + i].equals("x")) return false;
            }
        }
        return true;
    }

}