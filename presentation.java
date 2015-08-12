package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import service.Service;
import user_excpetion.UserException;
import database_access_object.DAO;

public class Presentation {

	public int matterId;
	public String matterName;
	public String matterDescription;
	public boolean matterStatus;
	static public Service srv = new Service();
	static public DAO doa = new DAO();

	public static void main(String[] args) {
		int choice = 0;
		
		Scanner input = new Scanner(System.in);
		try {
			String uwc = "n";
			srv.OpenConnectionToDatabase();
			do {
				
				System.out.println("1) Enter New Matter");
				System.out.println("2) Get all Matters");
				System.out.println("3) Search Matter by Matter Id");
				System.out.println("4) Delete Matter by Matter Id");
				System.out.println("Enter your operation: ");
				choice = input.nextInt();
				switch (choice) {
				case 1:
					srv.GetnValidateData();
					break;
				case 2:
					srv.getAllData();
					break;
				case 3:
					System.out
							.println("Enter the Matter Id for the Matter Details..");
					int matteridsearch = 0;
					matteridsearch = input.nextInt();
					srv.getSpecificData(matteridsearch);
				case 4:
					System.out
							.println("Enter the Matter Id delete Matter Details..");
					int deleteid = 0;
					deleteid = input.nextInt();
					srv.deleteSpecificData(deleteid);
					break;
				default:
					System.out.println("Enter a vaild option..");
					break;
				}
				System.out.println("Do you want to continue..?(y/n)");
				uwc = input.next();
				
			} while (uwc.equals("y"));
			input.close();
			System.out.println(uwc);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e2) {
			System.out.println(e2.getMessage());
		} catch (IOException e4) {
			System.out.println(e4.getMessage());
		} finally {

		}

	}
}
