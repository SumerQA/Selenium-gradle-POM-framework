package Configration_Files;


public class checkpr {
	static String s; 
	public static void main(String[] args) {
		
		ReadXclData rd= new ReadXclData();
		try {
			rd.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters","Assign risk code");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	
	for(int i=5;i>0;i--){
			for(int j=i; j <= 5;j++){
				System.out.print(j);
			}
			System.out.println(" ");
		}*/
		// TODO Auto-generated method stub

	}
		
		
	}

