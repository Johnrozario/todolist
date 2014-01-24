import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

import org.junit.Test;

import play.libs.WS;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ServerTest {

	@Test
	public void testInServer() {
	  running(testServer(9091), new Runnable() {
	      public void run() {
	         assertThat(
	           WS.url("http://localhost:9091/registration").get().get().getStatus()
	         ).isEqualTo(OK);
	      }
	  });
	}

}
