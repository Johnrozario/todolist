import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;
import static play.test.Helpers.running;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.testServer;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.Fluent;
import org.junit.Test;

import play.libs.WS;
import play.libs.F.Callback;
import play.mvc.Content;
import play.test.TestBrowser;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class BrowserTest{

	@Test
	public void browserFill() {
	    running(testServer(9091), HTMLUNIT, new Callback<TestBrowser>() {
	        public void invoke(TestBrowser browser) {
	           browser.goTo("http://localhost:9091/registration");
	           assertThat(browser.$("#title").getTexts().get(0)).isEqualTo("GATHI::Sign Up");
	           browser.fill("#userName").with("John");
	           browser.fill("#userCompany").with("Juhomi");
	           browser.fill("#userEmail").with("john@juhomi.com");
	           browser.fill("#userPassword").with("passsword");
	           browser.click("#createUser");
	           assertThat(browser.url()).isEqualTo("http://localhost:9091/users");	           
	          assertThat(browser.$("#userList").getText()).contains("John");
	          assertThat(browser.$("#userList").getTexts()).contains("John passsword");
	          
	          browser.goTo("http://localhost:9091/registration");
	           browser.fill("#userName").with("Rozario");
	           browser.fill("#userCompany").with("Juhomi");
	           browser.fill("#userEmail").with("rozario@juhomi.com");
	           browser.fill("#userPassword").with("passsword1");
	           browser.click("#createUser");
	           assertThat(browser.url()).isEqualTo("http://localhost:9091/users");	           
	          assertThat(browser.$("#userList").getText()).contains("John");
	          assertThat(browser.$("#userList").getText()).contains("Rozario");
	          assertThat(browser.$("#userList").getText()).contains("passsword");
	          assertThat(browser.$("#userList").getText()).contains("passsword1");
	          System.out.println(browser.$("#userList").getText());
	           }
	    });
	}
	
	@Test
	public void runInBrowser() {
		running(testServer(9091), HTMLUNIT, new Callback<TestBrowser>() {
			public void invoke(TestBrowser browser) {
				browser.goTo("http://localhost:9091/registration");
				assertThat(browser.$("#title").getTexts().get(0)).isEqualTo(
						"GATHI::Sign Up");

				browser.$("#createUser").click();
				assertThat(browser.url()).isEqualTo(
						"http://localhost:9091/registration");
				assertThat(browser.$("#regForm", 0).getText()).contains(
						"This field is required");
			}
		});
	}

	
	public void runInBrowserNegative() {
	    running(testServer(9091), HTMLUNIT, new Callback<TestBrowser>() {
	        public void invoke(TestBrowser browser) {
	           browser.goTo("http://localhost:9091/registration"); 
	           assertThat(browser.$("#title").getTexts().get(0)).isEqualTo("GATHI::Sign Up");
	           assertThat(browser.$("#regForm", 0).getText()).contains("This field is required");
	           
	        }
	    });
	}

}
