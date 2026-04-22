package Configration_Files;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ReadXclData {	
	Common c= new Common();
	public String[][]  readdata(String sheetname) throws Exception {
		File file = new File("src");
		FileInputStream fs= new FileInputStream(file.getAbsolutePath()+"/test/resources/Datafiles/scriptdata.xls");
		Workbook wb =Workbook.getWorkbook(fs);
		String a[][] = null;	
		Sheet s1=wb.getSheet(sheetname);
		a = new String[(s1.getRows()-1)][s1.getColumns()-1];
		try {
				//System.out.println("Sheet Name  is  "+ s1.getName());
					 for (int j=0;j<s1.getRows()-1;j++){
						 for (int k=0;k<s1.getColumns()-1;k++){
							 if(s1.getCell(k+1,j+1).getContents().isEmpty()){
			                    	continue;	
			                    	}else {
			                    		//System.out.println((j+1)+" and "+(k+1) + "  is"+(j+1)+(k+1));
			                    		a[j][k] = s1.getCell((k+1),(j+1)).getContents();
			                            //System.out.println(j+" and "+k+" "+a[j][k]);//Prints cell content one by one	                            
							 		}
							    }
						   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		wb.close();
		return a;
		}
	public void writereport(int a, int b, String text) {
	    try {
	    	File file = new File("Datafiles");
	        File excelFile = new File(file.getAbsolutePath()+"/scriptdata.xls");
	        WritableWorkbook book;
	        WritableSheet sheet;
	        Workbook existingBook = null;
	        if (!excelFile.exists()) {
	            book = Workbook.createWorkbook(excelFile);
	            sheet = book.createSheet("scriptdata", 0);
	        } else {
	            existingBook = Workbook.getWorkbook(excelFile);
	            book = Workbook.createWorkbook(excelFile, existingBook);
	            sheet = book.getSheet("scriptdata");
	        }
	        Label i = new Label(a, b, text);
	        sheet.addCell(i);
	        book.write();
	        book.close();
	        if (existingBook != null)
	            existingBook.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public String[][]  TestData(String sheetname) throws Exception {
		File file = new File("Datafiles");
		FileInputStream fs= new FileInputStream(file.getAbsolutePath()+"/CallTemplate parameters.xls");
		Workbook wb =Workbook.getWorkbook(fs);
		String a[][] = null;	
		Sheet[] s=wb.getSheets();			
		for(int i=0;i<= s.length-1;i++){
		Sheet s1=wb.getSheet(i);
		if(s1.getName().equals(sheetname)){
		System.out.println("Sheet Number   "+ i +"is  "+ s1.getName());
		 a = new String[10][7];		
			 for (int j=0;j<s1.getColumns();j++){
				 for (int k=0;k<s1.getRows()-1;k++){
					 if(s1.getCell(j, (k+1)).getContents().isEmpty()){
	                    	continue;	
	                    	}else {
	                    		a[j][k] = s1.getCell(j, (k+1)).getContents();
	                            System.out.println(j+" and "+k+" "+a[j][k]);//Prints cell content one by one	                            
							}
	                    }
				 }
			 }
		}
		wb.close();
		return a;
		}
	
	public ArrayList<String>  Read_Excel_Rows(String xlfile,String sheetname,String name) throws Exception {
		ArrayList<String>temp_param= new ArrayList<>();
		File file = new File("src/test/resources/Datafiles");
		FileInputStream fs= new FileInputStream(file.getAbsolutePath()+"/"+xlfile+".xls");
		Workbook wb =Workbook.getWorkbook(fs);
		Sheet s1=wb.getSheet(sheetname);
		try {
				for (int j=0;j<s1.getRows()-1;j++){
					if(s1.getCell(0,j+1).getContents().equals(name)){
						 for (int k=0;k<s1.getColumns()-1;k++){							
							 temp_param.add(s1.getCell((k+1),(j+1)).getContents());
			                    	}
							    }else {
		                    		continue;	                            
						 		}
						   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		wb.close();
		return temp_param;
		}
}