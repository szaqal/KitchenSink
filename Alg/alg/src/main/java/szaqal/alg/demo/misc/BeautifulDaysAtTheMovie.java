package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem?isFullScreen=true
 */
public class BeautifulDaysAtTheMovie {

  //  difference between a number and its reverse

  public static int beautifulDays(
      int startingDay,
      int endingDay,
      int divisor ) {

    int result = 0;
    for (int i = startingDay; i <= endingDay; i++) {
      int reversed = Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());

      if(Math.abs(i - reversed) % divisor ==0) {
        result++;
      }

    } return result;
  }

}
