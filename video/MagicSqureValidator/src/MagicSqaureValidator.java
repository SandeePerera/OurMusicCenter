//UOW ID-W1714852
//Chamal Perera
//MagicSqaure Assignment
import java.util.Scanner;
import java.io.*;

public class MagicSqaureValidator {

    public static int numberOfRows = 0;
    public static int totalNumbersInSqare = 0;

    public static void main(String[] args) {

        //get user inputs
        int[][] inputArrry = getUserInput();

        System.out.println();

        //Calculate total horizontally
        for(int i=0;i<numberOfRows;i++){
            int total = 0;
            for(int j=0;j<numberOfRows;j++){
                System.out.print(inputArrry[i][j]+" ");
                total = total+inputArrry[i][j];
            }

            System.out.print(total);
            System.out.println();
        }



        //Calculate total vertically
        for(int i=0;i<numberOfRows;i++){
            int total = 0;
            for(int j=0;j<numberOfRows;j++){
                total = total+inputArrry[j][i];
            }

            System.out.print(total+" ");
        }


        boolean isMagicSquare = checkMagicSquareValidity(inputArrry);
        boolean isLoShuSquare = checkLoShuValidity(inputArrry);

        System.out.println();
        System.out.println();

        System.out.println("Is Magic square status "+ isMagicSquare);
        System.out.println("Is Lo Shu Magic square status "+ isLoShuSquare);
        retry();
    }

    public static void retry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Do you want to enter a new square? (y/n) ");

        String val = scanner.next();

        if(val.trim().equals("y")){
            System.out.println();
            String[] args = {};
            main(args);
        }else{
            System.exit(0);
        }
    }

    public static boolean checkMagicSquareValidity(int[][] inputArray){
        boolean isPrevTotalMatchTotal = true;

        int prevTotal = 0;
        int total = 0;

        for(int i=0;i<numberOfRows;i++){

            for(int j=0;j<numberOfRows;j++){
                total = total+inputArray[i][j];
            }

            if(i > 0){
                if(prevTotal != total)
                    isPrevTotalMatchTotal = false;
            }

            //System.out.println("Prev Total : "+ prevTotal +" Total = "+total+" Status = "+isPrevTotalMatchTotal);

            prevTotal = total;

            total = 0;
        }

        if(isPrevTotalMatchTotal){

            for(int i=0;i<numberOfRows;i++){

                for(int j=0;j<numberOfRows;j++){
                    total = total+inputArray[j][i];
                }

                if(i > 0){
                    if(prevTotal != total)
                        isPrevTotalMatchTotal = false;
                }

                //System.out.println("Prev Total : "+ prevTotal +" Total = "+total+" Status = "+isPrevTotalMatchTotal);

                prevTotal = total;

                total = 0;
            }

        }

        return isPrevTotalMatchTotal;

    }


    public static  boolean checkLoShuValidity(int[][] inputArray){

        boolean isLoShuSquare = true;


        for(int i=0;i<numberOfRows;i++){

            for(int j=0;j<numberOfRows;j++){
                if(inputArray[i][j] > 9){
                    isLoShuSquare = false;
                }else{
                    int repeatCounter = countNumberRepeat(inputArray[i][j],inputArray);
                    if(repeatCounter > 1)
                        isLoShuSquare = false;
                }
            }
        }

        return isLoShuSquare;
    }

    public static int countNumberRepeat(int val,int[][] inputArray){
        int count = 0;

        for(int i=0;i<numberOfRows;i++){
            for(int j=0;j<numberOfRows;j++){
                if(inputArray[i][j] == val){
                    count++;
                }
            }
        }

        return count;
    }

    public static int[][] getUserInput(){
        Scanner scanner = new Scanner(System.in);

        int inputCounter = 0;

        System.out.print("Enter number of rows to countinue: ");
        String numberOfRowsIn = scanner.next();
        numberOfRows = Integer.parseInt(numberOfRowsIn);

        totalNumbersInSqare =  (int)Math.pow(numberOfRows, 2);

        int[] inputArray = new int[totalNumbersInSqare];
        int[][] multiDimArray = new int[numberOfRows][numberOfRows];


        while(inputCounter<totalNumbersInSqare){
            System.out.print("Enter Number "+(inputCounter+1)+" :");

            String val = scanner.next();
            if(isNumeric(val)){
                int intVal = (int) Double.parseDouble(val);
                inputArray[inputCounter] = intVal;
                inputCounter++;
            }else{
                System.out.println("Invalid input, value should be an integer");
            }

        }

        int counter = 0;

        for(int i=0;i<numberOfRows;i++){

            for(int j=0;j<numberOfRows;j++){
                multiDimArray[i][j] = inputArray[counter];
                counter++;
            }
        }

        return multiDimArray;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}
