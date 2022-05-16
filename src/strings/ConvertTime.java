package strings;

/*
You are given two strings current and correct representing two 24-hour times.
24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.
Return the minimum number of operations needed to convert current to correct.
Example 1:
Input: current = "02:30", correct = "04:35"
Output: 3
Explanation:
We can convert current to correct in 3 operations as follows:
- Add 60 minutes to current. current becomes "03:30".
- Add 60 minutes to current. current becomes "04:30".
- Add 5 minutes to current. current becomes "04:35".
It can be proven that it is not possible to convert current to correct in fewer than 3 operations.
Example 2:
Input: current = "11:00", correct = "11:01"
Output: 1
Explanation: We only have to add one minute to current, so the minimum number of operations needed is 1.
Constraints:
current and correct are in the format "HH:MM"
current <= correct
 */
public class ConvertTime {
    public static int convertTime(String current, String correct) {
        int curTime = 60 * Integer.parseInt(current.substring(0,2)) + Integer.parseInt(current.substring(3,5));;
        int corrTime = 60 * Integer.parseInt(correct.substring(0,2)) + Integer.parseInt(correct.substring(3,5));;
        int diff = Math.abs(curTime - corrTime);
        int result = 0;
        while(diff!=0){
            System.out.println("curent diff is : " + diff);
            if(diff >= 60){
                result += diff/60;
                diff = diff%60;
            }
            else {
                if(diff >= 15){
                    result += diff/15;
                    diff = diff%15;
                }else{
                    if(diff >= 5 ){
                        result += diff/5;
                        diff = diff%5;
                    }else{
                        result += diff;
                        break;
                    }
                }
            }
        }
        return result;
    }
    private static int convertToNumber(String time){
//        String[] timeParts = time.split(":");
        //we can do without splitting
//        int hours = Integer.parseInt(time.substring(0,1));
//        int hours = Integer.parseInt(timeParts[0]);
//        int minutes = Integer.parseInt(time.substring(3,4));
//        int minutes = Integer.parseInt(timeParts[1]);
//        int result = (60*hours + minutes);
//        int result = 60 * Integer.parseInt(time.substring(0,2)) + Integer.parseInt(time.substring(3,5));
//        System.out.println(String.format("Converted number for time : %s is %d", time,result ));
        return 60 * Integer.parseInt(time.substring(0,2)) + Integer.parseInt(time.substring(3,5));
    }

    public static void main(String[] args) {
        int testResult1 = convertTime("02:30", "04:35");
        System.out.println(testResult1);
    }
}
