package com.fundacionjala.katabank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by danielgonzales on 7/7/2016.
 */
public class BankOcr {

    private int numberLines;
    private OCR myOcr = new OCR();
    private String[][] ocr;
    private int[][] intNumbers;

    public String readFile(String pathFile) throws IOException {
        String numbers = "";
        FileReader f = new FileReader(pathFile);
        BufferedReader b = new BufferedReader(f);

        while (b.ready()) {
            numberLines++;
            numbers = numbers + b.readLine();
        }
        b.close();
        return numbers;
    }

    public void storeInMatrix(String s) {
        ocr = new String[numberLines][27];
        int count = 0;
        for (int i = 0; i < numberLines; i++) {
            for (int j = 0; j < 27; j++) {
                ocr[i][j] = String.valueOf(s.charAt(count));
                count++;
            }
        }
    }

    public void convertMatrix() {
        int fill = numberLines;
        int fill2 = numberLines / 4;
        int column = 27;
        int column2 = 27;
        String myString = "";
        String numberFinal = "";
        int toFill = 0;
        intNumbers = new int[fill2][column2];

        for (int h = 0; h < fill; h = h + 4) {
            for (int k = 0; k < column; k = k + 3) {
                for (int i = h; i < h + 4; i++) {
                    for (int j = k; j < k + 3; j++) {

                        myString = myString + ocr[i][j];

                    }
                }
                numberFinal = numberFinal + String.valueOf(myOcr.parseStringToNumber(myString));
                myString = "";
            }
            intToArray(numberFinal, toFill);
            numberFinal = "";
            toFill++;
        }

    }

    public void intToArray(String numberFinal, int toFill) {
        int column = 27 / 3;
        int count = 0;

        for (int j = 0; j < column; j++) {

            intNumbers[toFill][j] = Character.getNumericValue(numberFinal.charAt(count));
            count++;

        }
    }

    public int checksumCalculation() {
        int fill2 = numberLines / 4;
        int column2 = 27;
        int check = 0;
        int var = 9;
        int checkTotal = 0;

        for (int i = 0; i < fill2; i++) {
            for (int j = 0; j < column2; j++) {

                check = intNumbers[i][j];
                check = check * var;
                var--;

            }
            checkTotal = checkTotal + (check % 11);
        }

        return checkTotal;
    }


    public void printArrayNum() {

        int fill = numberLines / 4;
        int column = 27 / 3;

        for (int i = 0; i < fill; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(intNumbers[i][j]);
            }
            System.out.println();
        }
    }


    public void printArray() {

        for (int i = 0; i < numberLines; i++) {
            for (int j = 0; j < 27; j++) {
                System.out.print(ocr[i][j]);
            }
            System.out.println();
        }

    }

}
