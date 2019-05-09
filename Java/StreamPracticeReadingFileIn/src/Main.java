
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = Files.newBufferedReader(Paths.get("src/text.txt"))){
            //new BufferedReader(new FileReader(./resources/data.txt)
            /*br.lines().forEach(a -> {
                String[] barmi = a.split(";");
                System.out.println(barmi[0] + " " +barmi[1]);
            });*/
            /*
            var fourth = bf.lines()
                .map(e-> e.split(;)
                .collect(Collectors.toList());
             */
            List<Point> valami = new ArrayList<>();
            br.lines().forEach(a -> {
                String[] barmi = a.split(";");
                Point p = new Point(Integer.parseInt(barmi[0]),Integer.parseInt(barmi[1]));
                valami.add(p);
            });
            valami.stream().forEach(a -> System.out.println(a.x + " " + a.y));
            //String line;
           /* while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
                String[] parts = sb.toString().split(";");
            }*/
           valami.stream().filter(a -> a.x <= 1).forEach(a -> System.out.println(a.x));
        } catch (IOException e) {
            e.printStackTrace();
        }
       //System.out.println(sb);
        //String[] parts = sb.toString().split(";");
        /*for (String s : parts) {
            System.out.println(s);
        }*/
    }

}
