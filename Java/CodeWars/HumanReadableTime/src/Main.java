public class Main {
    public static int hourCounter = 0;
    public static int minuteCounter = 0;
    public static int secondCounter = 0;

    public static void main(String[] args) {
        System.out.println(makeReadable(45296));
    }
    public static String makeReadable(int seconds) {

        if(seconds % 60 == 0 && seconds < 3600) {
            minuteCounter = seconds / 60;
            if(minuteCounter < 10) {
                return "00:0" + minuteCounter +":00";
            } else {
                return "00:" + minuteCounter +":00";
            }
        }
        minutesCounter(seconds);
        minuteCounter = seconds/60;
        secondCounter = seconds - (minuteCounter * 60);
        if(minuteCounter >= 60) {
            if(minuteCounter % 60 == 0) {
                hourCounter = minuteCounter/60;
            } else {
                hoursCounter(minuteCounter);
            }
        }
        if (hourCounter > 0) {
            minuteCounter -= hourCounter * 60;
        }
        String RhourCounter = "";
        String RminuteCounter = "";
        String RsecondCounter = "";

        if(secondCounter < 10) {
            RsecondCounter += "0" + secondCounter;
        } else {
            RsecondCounter += secondCounter;
        }
        if(minuteCounter < 10) {
            RminuteCounter += "0" + minuteCounter;
        } else {
            RminuteCounter += minuteCounter;
        }
        if(hourCounter < 10) {
            RhourCounter += "0" + hourCounter;
        } else {
            RhourCounter += hourCounter;
        }

        return (RhourCounter + ":" + RminuteCounter + ":" + RsecondCounter);
    }
    public static int minutesCounter(int seconds) {

        if(seconds % 60 < 1) {
            minuteCounter--;
            return 0;
        }
            minuteCounter++;
            minutesCounter(seconds-60);

            return minuteCounter;
    }
    public static int hoursCounter(int minutes) {
        if(minutes % 60 < 1) {
            hourCounter--;
            return 0;
        }
        hoursCounter(minutes-60);
        hourCounter++;
        return hourCounter;
    }

}
