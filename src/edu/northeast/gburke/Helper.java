/**

 * -------------------------------------------------

 * File name: Helper.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Creator's name: Gerald Burke

 * Email: burkeg@goldmail.etsu.edu

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */

package edu.northeast.gburke;

/**

 * <b>Purpose: Turns strings into ints and doubles so I can do stuff with them

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */

public class Helper
{

    /**
     * Takes a string and parses it. If it works, returns the value, if it doesn't, returns negative 1
     * @param str
     * @return
     */

    public static int validatePositiveInteger(String str)
    {
        int num = -1;

        try
        {
            num = Integer.parseInt(str);
        }
        catch (Exception e)
        {

        }

        return num;
    }

    /**
     * Takes a string and parses it. If it works, returns the value, if it doesn't, returns negative 1
     * @param str
     * @return
     */

    public static double validatePositiveDouble(String str)
    {
        double num = -1.0;

        try
        {
            num = Double.parseDouble(str);
        }
        catch (Exception e)
        {

        }
        return  num;
    }
}
