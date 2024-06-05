/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudriven;
import java. util. Scanner;
import java.sql.ResultSet;
/**
 *
 * @author swapn
 */
public class MenuDriven {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SqlUtilForMenuDriven.connectDb();

        while (true) {
            System.out.println("\nCRUD Operations Menu:");
            System.out.println("1. Create (Insert)");
            System.out.println("2. Read (Fetch)");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
               String qry;
            switch (choice) {
                case 1:
                    qry = "insert into products values(6,'earphones',5200)";
                    int insertResult = SqlUtilForMenuDriven.insert(qry);
                    System.out.println("Rows affected: " + insertResult);
                    break;

                case 2:
                    
                    try {
                         qry = "select * from products";
                        ResultSet rs = SqlUtilForMenuDriven.fetch(qry);
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            float price = rs.getFloat("price");
                            System.out.println(id + " " + name + " " + price);
                        }
                    } catch (Exception e) {
                        System.out.println("Error fetching data: " + e.getMessage());
                    }
                    break;

                case 3:
                   qry = "UPDATE products SET price = 6000 WHERE id = 6";
                    int updateResult = SqlUtilForMenuDriven.insert(qry);
                    System.out.println("Rows affected: " + updateResult);
                    break;

                case 4:
                   qry = "DELETE FROM products WHERE id = 6";
                    int deleteResult = SqlUtilForMenuDriven.delete(qry);
                    System.out.println("Rows affected: " + deleteResult);
                    break;

                case 5:
                    SqlUtilForMenuDriven.close();
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
