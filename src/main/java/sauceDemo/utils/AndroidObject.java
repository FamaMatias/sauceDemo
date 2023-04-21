package sauceDemo.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import sauceDemo.interactions.waits.WaitFor;

import java.util.Set;

public class AndroidObject {

	public void HideKeyboard(Actor actor) {
		androidDriver(actor).hideKeyboard();
	}


	public void SwipeToElement(Actor actor, String label) {
		androidDriver(actor)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().text(\"" + label + "\"));")
				.click();
	}


	public void UnScrollAbajo(Actor actor) {
		try {
			androidDriver(actor).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()");
		} catch (Exception e) {
		}
	}
	
	public void ScrollHorizontalId(Actor actor, String id) {
		try {
			androidDriver(actor).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceIdMatches(\".*" + id + ".*\").scrollable(true))"
							+ ".setAsHorizontalList().scrollForward()");
		} catch (Exception e) {
			System.out.println("Si se realizó el scroll correctamente, ignorar esta línea. De lo contrario, revisar.");
		}
	}

	public void ScrollHorizontal(Actor actor, String instance, String label) {
		androidDriver(actor).findElementByAndroidUIAutomator(
						"new UiScrollable(new UiSelector().resourceIdMatches(\".*com.clarocolombia.miclaro:id/rvCategories.*\")"
								+ ".childSelector(new UiSelector().instance(" + instance + ").scrollable(true)))"
								+ ".setAsHorizontalList().scrollIntoView(new UiSelector().text(\"" + label + "\"));")
				.click();
	}

	public void ScrollHorizontalFinal(Actor actor, String instance) {
		try {
			androidDriver(actor).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceIdMatches(\".*com.clarocolombia.miclaro:id/rvCategories.*\")"
							+ ".childSelector(new UiSelector().instance(" + instance + ").scrollable(true)))"
							+ ".setAsHorizontalList().scrollForward()");
		} catch (Exception e) {
			System.out.println("Si se realizó el scroll correctamente, ignorar esta línea. De lo contrario, revisar.");
		}

	}

	public void ValidarTexto(Actor actor, String text) {

		androidDriver(actor).findElementByAndroidUIAutomator("new UiSelector().text(\"" + text + "\")")
				.isDisplayed();
	}

	public void ElTextoContiene(Actor actor, String text) {

		androidDriver(actor).findElementByAndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")")
				.isDisplayed();
	}

	public void ScrollVertical(Actor actor, String label) {
		androidDriver(actor)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().text(\"" + label + "\"));");
	}

	public void ClickByText(Actor actor, String text) {
		actor.attemptsTo(WaitFor.aTime(2000));
		androidDriver(actor).findElementByAndroidUIAutomator("new UiSelector().text(\"" + text + "\")")
				.click();
	}
	
	public void Atras(Actor actor) {
		androidDriver(actor).navigate().back();
	}
	



	public void switchToWebView(Actor actor, String web_view) {
		Set<String> contextNames = getAndroidDriver(actor).getContextHandles();

		for (String contextName : contextNames) {
			if (contextName.equals(web_view)) {
				getAndroidDriver(actor).context(web_view);
			}
		}
	}


	public AndroidDriver getAndroidDriver(Actor actor) {
		return androidDriver(actor);
	}

	@SuppressWarnings("unchecked")
	private static AndroidDriver androidDriver(Actor actor) {
		return (AndroidDriver) ((WebDriverFacade) getDriver(actor)).getProxiedDriver();
	}

	private static WebDriverFacade getDriver(Actor actor) {
		return ((WebDriverFacade) BrowseTheWeb.as(actor).getDriver());
	}

	public TouchAction withAction(Actor actor) {
		return new TouchAction(androidDriver(actor));
	}

	public void SwitchtoFrame(Actor actor, int id) {
		androidDriver(actor).switchTo().frame(id);
	}
}

