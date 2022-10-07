package Utilities;

import BaseFunctions.Setup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelCreation extends Setup {

    public static void Createxcelsheet() throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("OnboardDatas");
        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("DivisionName");
        sheet.getRow(0).createCell(1).setCellValue("BranchName");
        sheet.getRow(0).createCell(2).setCellValue("TownName");
        sheet.getRow(0).createCell(3).setCellValue("StateName");
        sheet.getRow(0).createCell(4).setCellValue("Reporting_Manager");
        sheet.getRow(0).createCell(5).setCellValue("Reporting_Manager2");
        sheet.getRow(0).createCell(6).setCellValue("Designation");
        sheet.getRow(0).createCell(7).setCellValue("EmployeeCategory");
        sheet.getRow(0).createCell(8).setCellValue("ClientBranch");
        sheet.getRow(0).createCell(9).setCellValue("Date of Joining");
        sheet.getRow(0).createCell(10).setCellValue("Aadhar front");
        sheet.getRow(0).createCell(11).setCellValue("Aadhar Back");
        sheet.getRow(0).createCell(12).setCellValue("Resume");
        sheet.getRow(0).createCell(13).setCellValue("Date Of Birth");
        sheet.getRow(0).createCell(14).setCellValue("Aadhar_Card_Number");
        sheet.getRow(0).createCell(15).setCellValue("First_Name");
        sheet.getRow(0).createCell(16).setCellValue("EmailId");
        sheet.getRow(0).createCell(17).setCellValue("Mobile_Number");
        sheet.getRow(0).createCell(18).setCellValue("Bank_Acc_No");
        sheet.getRow(0).createCell(19).setCellValue("Bank_IFSC_Code");
        sheet.getRow(0).createCell(20).setCellValue("Bank_Image");

        File file = new File("C:\\Onboarding datas\\OnboardingHSSF.xls");
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();

    }




}