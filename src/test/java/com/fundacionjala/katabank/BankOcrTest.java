package com.fundacionjala.katabank;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by danielgonzales on 7/7/2016.
 */
public class BankOcrTest {

    @Test
    public void convertStringToNumbers() throws IOException {
        OCR ocr = new OCR ();
        BankOcr bankOcr = new BankOcr ();
        bankOcr.storeInMatrix (bankOcr.readFile ("src/numbers.txt"));
        bankOcr.printArray();
        bankOcr.convertMatrix  ();
        bankOcr.printArrayNum();
        Assert.assertEquals (0, bankOcr.checksumCalculation ());

    }

}