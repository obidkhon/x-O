import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Game {
    static ArrayList<Integer>playerPosition=new ArrayList<Integer>();
    static ArrayList<Integer>cpuPosition=new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        // 1- ish
        printGameBoard(gameBoard);
//3 ish

        //10
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter your placement (1-9)");
            int playerpos = scan.nextInt();
            while (playerPosition.contains(playerpos) || cpuPosition.contains(playerPosition)) {

                playerpos = scan.nextInt();
            }


            //System.out.println(pos);
            //7.1
            placePiece(gameBoard, playerpos, "player");
            //8

            Random rand = new Random();
            //9
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPosition.contains(cpuPos) ||cpuPosition.contains(cpuPos)){
                System.out.println("position taken! enter a correct position");
              cpuPos = rand.nextInt(9)+1;
        }
            //7.2
            placePiece(gameBoard, cpuPos, "cpu");


            printGameBoard(gameBoard);

            String result=checkwinner();
            if (result.length()>0){
                System.out.println(result);
                break;
            }



        }
    }

        // 2- ish
        public static void printGameBoard ( char[][] gameBoard){
            for (char[] row : gameBoard) {
                for (char c : row) {
                    System.out.print(c);

                }
                System.out.println();
            }

            }

//5- ish
        public static void placePiece (char[][] gameBoard, int pos,String user){
            char symbol=' ';
            //6
                if (user.equals("player")) {
                    symbol = 'x';
                    playerPosition.add(pos);
                }
                else if (user.equals("cpu")){
                    symbol='o';
                    cpuPosition.add(pos);
                }
            //4- ish
            switch (pos) {
                case 1:
                    gameBoard[0][0] = symbol;
                    break;

                case 2:
                    gameBoard[0][2] = symbol;
                    break;
                case 3:
                    gameBoard[0][4] = symbol;
                    break;

                case 4:
                    gameBoard[2][0] = symbol;
                    break;
                case 5:
                    gameBoard[2][2] = symbol;
                    break;
                case 6:
                    gameBoard[2][4] = symbol;
                    break;
                case 7:
                    gameBoard[4][0] = symbol;
                    break;
                case 8:
                    gameBoard[4][2] = symbol;
                    break;
                case 9:
                    gameBoard[4][4] = symbol;
                    break;
                default:

            }
// 4



    }//sss
    public static String checkwinner(){
        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List bodRow= Arrays.asList(7,8,9);

        List leftCol= Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List rightCol= Arrays.asList(3,6,9);

        List cros1= Arrays.asList(1,5,9);
        List cros2= Arrays.asList(7,5,3);


List<List> wining=new ArrayList<List>();
wining.add(topRow);
wining.add(midRow);
wining.add(bodRow);

wining.add(leftCol);
wining.add(midCol);
wining.add(rightCol);

wining.add(cros1);
wining.add(cros2);

for (List l: wining){
    if (playerPosition.containsAll(l)){

        return "congratulation you are won";
    }
    else if (cpuPosition.containsAll(l)){
        return "oh sorry cpu win ";
    }else if (playerPosition.size() +cpuPosition.size()==9){
        return "CAT";
    }
}


return "";
    }

            }//yv


