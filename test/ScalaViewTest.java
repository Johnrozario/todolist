import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.User;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import views.html.helper.form;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ScalaViewTest {

    @Test
    public void renderTemplate() {
    	User user = new User();
    	user.setId(Long.valueOf(1));
    	user.setEmail("john@juhomi.com");
    	user.setCompany("Juhomi");
    	user.setFullName("JOhn Rozario");
    	Form<User> userForm = Form.form(models.User.class);
    	Content html = views.html.user_update.render(userForm.fill(user));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("JOhn Rozario");
    }

}
