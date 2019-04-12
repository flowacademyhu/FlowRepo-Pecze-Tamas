import java.util.Arrays;

public class Map {
    char[][] array;
    Turtle turtle;

    public Map(int a, int b) {
        this.array = new char[a][b];
        this.turtle = new Turtle(a, b);
        for (char[] row : this.array)
            Arrays.fill(row, ' ');
        this.array[0][0] = '$';
    }
    public void drawMap() {
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                System.out.print(String.valueOf(this.array[i][j]));
            }
            System.out.println();
        }
    }
    public void doCommand (String command) {
        if(command.equals("start drawing")){
            turtle.changePen(true);
        } else if (command.equals("stop drawing")){
            turtle.changePen(false);
        } else if (command.equals("earse")) {
            for (int i = 0; i < this.array.length; i++){
                for (int j = 0; j < this.array.length; j++){
                    if (array[i][j] == '#' ) {
                        array[i][j] = ' ';
                    }
                }
            }
        } else if (command.startsWith("up ")) {
            moveDirection(command);
        } else if (command.startsWith("down ")) {
            moveDirection(command);
        } else if (command.startsWith("right ")) {
            moveDirection(command);
        } else if (command.startsWith("left ")) {
            moveDirection(command);
        }
    }

    public void moveDirection(String command) {
            String[] str = command.split(" ");
            int n = Integer.parseInt(str[1]);
            for (int i = 0; i < n; i++) {
                int x = this.turtle.getPositionA();
                int y = this.turtle.getPositionB();
                if (turtle.isTollStatus()) {
                    this.array[x][y] = '#';
                } else {
                    this.array[x][y] = ' ';
                }
                turtle.move(str[0]);
                this.array[turtle.getPositionA()][turtle.getPositionB()] = '$';
        }
    }
}
