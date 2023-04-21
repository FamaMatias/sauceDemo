package sauceDemo.interactions.scroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ScrollDown implements Interaction {
    private int taps;

    public ScrollDown(int taps) {
        this.taps = taps;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        try {
            Robot robot = new Robot();
//			robot.keyPress(KeyEvebt.VK_END);
            for (int i = 0; i < taps; i++)
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public static ScrollDown on(int taps) {return new ScrollDown(taps);}

}
