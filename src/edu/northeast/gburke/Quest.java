/**

 * -------------------------------------------------

 * File name: Quest.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Creator's name: Gerald Burke

 * Email: burkeg@goldmail.etsu.edu

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */
package edu.northeast.gburke;

import edu.northeast.gburke.items.Item;
import edu.northeast.gburke.items.QuestItem;

import java.util.ArrayList;

/**

 * <b>Purpose: Quest are embarked on in stages. Most of the logic for the quests are handled in the driver, but the logic gates are stored here.

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Quest
{
    private boolean isStarted = false;
    private boolean isComplete = false;
    private String name;
    private String intro;
    private String conclusion;
    private QuestItem reward;
    private int value;

    public Quest()
    {
    }

    public Quest(String name, String intro, String conclusion, int value, QuestItem reward)
    {
        this.name = name;
        this.intro = intro;
        this.conclusion = conclusion;
        this.value = value;
        this.reward = reward;
    }

    public void setStarted (boolean isStarted)
    {
        this.isStarted = isStarted;
    }

    public void setComplete (boolean isComplete)
    {
        this.isComplete = isComplete;
    }

    public boolean isStarted () { return isStarted; }

    public boolean isComplete() { return isComplete; }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    public String getConclusion() {
        return conclusion;
    }

    public QuestItem getReward() {
        return reward;
    }

    public int getValue() {
        return value;
    }
}
