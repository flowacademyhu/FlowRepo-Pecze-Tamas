public class Main {
    public static void main(String[] args) {
        System.out.println(petals(132));
    }

    private static String petals(int nb_petals) {
        /*int counter = 0;
        while(true) {
            if(nb_petals == 1 + counter) {
                return "I love you";
            } else if(nb_petals == 2 + counter) {
                return "a little";
            } else if(nb_petals == 3 + counter) {
                return "a lot";
            } else if(nb_petals == 4 + counter) {
                    return "passionately";
            } else if(nb_petals == 5 + counter) {
                return "madly";
            } else if(nb_petals == 6 + counter) {
                return "not at all";
            }
            counter=+6;
        }*/
        int counter = 0;
        for( int i = 0; i < 350; i++) {
            if(nb_petals == 1 + counter) {
                return "I love you";
            } else if(nb_petals == 2 + counter) {
                return "a little";
            } else if(nb_petals == 3 + counter) {
                return "a lot";
            } else if(nb_petals == 4 + counter) {
                return "passionately";
            } else if(nb_petals == 5 + counter) {
                return "madly";
            } else if(nb_petals == 6 + counter) {
                return "not at all";
            }
            counter += 6;
        } return "wtf?";
    }
    }
    /*
    smart answer from CodeWars forum:
    switch (nb_petals % 6){
            case 1:
                return "I love you";
            case 2:
                return "a little";
            case 3:
                return "a lot";
            case 4:
                return "passionately";
            case 5:
                return "madly";
            case 0:
                return "not at all";
                default:
                return "";
        }
     */
