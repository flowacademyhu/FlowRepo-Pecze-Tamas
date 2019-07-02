public class Main {
    public static void main(String[] args) {
        System.out.println(formatDuration(146194020));
    }

    public static String formatDuration(int seconds) {
        if(seconds == 0) {
            return "now";
        }
        int minutes = seconds / 60;
        int hours = seconds / 3600;
        minutes -= hours * 60;
        int days = hours / 24;
        hours -= days * 24;
        int years = days / 365;
        days -= years * 365;
        int sec = seconds - ((minutes * 60) + (hours * 3600) + (days * 86400) + (years * 31536000));
        String ReturnSec = " seconds";
        String ReturnMin = " minutes";
        String ReturnHour = " hours";
        String ReturnDay = " days";
        String ReturnYear = " years";
        if(sec == 0 || sec == 1) {
            ReturnSec = " second";
        }
        if(minutes == 0 || minutes == 1) {
            ReturnMin = " minute";
        }
        if(hours == 0 || hours == 1) {
            ReturnHour = " hour";
        }
        if(days == 0 || days == 1) {
            ReturnDay = " day";
        }
        if(years == 0 || years == 1){
            ReturnYear = " year";
        }
        if(years == 0 && days == 0 && hours == 0 && minutes == 0) {
            return sec + ReturnSec;
        } else if(years == 0 && days == 0 && hours == 0) {
            if(sec == 0) {
                return minutes + ReturnMin;
            }
            return minutes + ReturnMin + " and " + sec + ReturnSec;
        } else if(years == 0 && days == 0) {
            if(sec == 0 && minutes == 0) {
                return hours + ReturnHour;
            } else if(sec == 0) {
                return hours + ReturnHour + ", " +  minutes + ReturnMin;
            }
            return hours + ReturnHour + ", " +  minutes + ReturnMin + " and " +  sec + ReturnSec;
        } else if( years == 0) {
            if(sec == 0 && minutes == 0 && hours == 0) {
                return days + ReturnDay;
            } else if(sec == 0 && minutes == 0) {
                return hours + ReturnHour;
            } else if(sec == 0) {
                return hours + ReturnHour + ", " +  minutes + ReturnMin;
            }
            return days + ReturnDay + ", " + hours + ReturnHour + ", " + minutes + ReturnMin + " and " +  sec + ReturnSec;
        } else {
            if(sec == 0 && minutes == 0 && hours == 0 && days == 0) {
                return years + ReturnYear;
            } else if(sec == 0 && minutes == 0 && hours == 0) {
                return years + ReturnYear + ", " +  days + ReturnDay;
            } else if(sec == 0 && minutes == 0) {
                return years + ReturnYear + ", " +  days + ReturnDay + ", " + hours + ReturnHour;
            } else if(sec == 0) {
                return years + ReturnYear + ", " +  days + ReturnDay + ", " + hours + ReturnHour + ", " + minutes + ReturnMin;
            }
            return years + ReturnYear + ", " +  days + ReturnDay + ", " +  hours + ReturnHour + ", " +  minutes + ReturnMin + " and " +  sec + ReturnSec;
        }
    }
}
