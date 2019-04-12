public class DbGenerator {
    public static void main(String[] args) {
      System.out.println(
        String.format("Az en nevem %s, korom %s, anyam neve %s",
        "Peti", "12", "Geza")
        );
        String[] roles = {"admin", "portas", "consuela", "dementor"};
        for(String r: roles) {
          System.out.println(
            String.format("insert into users (role_id) values ('%s');", r)
          );
        }
        int FIX_VALUE = 10;
        String[] email = {"mari@gmail.com", "feri@gmail.com",
          "mar4i@gmail.com", "fe5ri@gmail.com","mari@gmail.com", "fe2ri@gmail.com",
          "m1ari@gmail.com", "f2eri@gmail.com","mar3i@gmail.com", "f54eri@gmail.com"};
        String[] fullnames = {
          "Toth Janos", "Bela", "Armando", "Istvan", "Antal", "Wanda", "Tasi", "Tapsi", "Cobol"
        };
        for(int i = 0; i < FIX_VALUE; ++i) {

        }
    }
}