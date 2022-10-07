package Utilities;

import java.io.File;

public class DirectoryCreation {


    public static void CreateScreenshotdir(){

        File screenshotdir = new File("Screenshots");

        if (screenshotdir.exists()) {


        } else {
            screenshotdir.mkdir();
        }


    }

    public static void CreateDatadir(){

        File datadir = new File("C:\\Onboarding datas");

        if (datadir.exists()) {

        } else {
            datadir.mkdir();
        }


    }

    public static void CreateAadharFrontdir(){

        File Aadharfrontdir = new File("C:\\Onboarding Aadhar Front");

        if (Aadharfrontdir.exists()) {

        } else {
            Aadharfrontdir.mkdir();
        }


    }

    public static void CreateAadharBackdir(){

        File Aadharfrontdir = new File("C:\\Onboarding Aadhar Back");

        if (Aadharfrontdir.exists()) {

        } else {
            Aadharfrontdir.mkdir();
        }


    }

    public static void createResumedir(){

        File Resumedir = new File("C:\\Onboarding Resume Datas");

        if (Resumedir.exists()) {

        } else {
            Resumedir.mkdir();
        }


    }

    public static void createBankdir(){

        File Bankdir = new File("C:\\Onboarding Bank Images");

        if (Bankdir.exists()) {

        } else {
            Bankdir.mkdir();
        }



    }



}
