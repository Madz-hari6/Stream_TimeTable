package JavaFiles;
import java.sql.Connection;
import java.sql.DriverManager;

class Connector {
   static Connection connection = null;

   static {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/auction", "hariharasudhan", "Hari1000");
      } catch (Exception var1) {
         System.out.println(var1);
      }

   }

   Connector() {
   }

   public static Connection getConnection() {
      return connection;
   }

   public static void closeConnection() {
      try {
         connection.close();
      } catch (Exception var1) {
         System.out.println(var1.getMessage());
      }

   }
}
