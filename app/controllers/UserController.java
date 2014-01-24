package controllers;

import java.util.List;

import models.User;
import play.api.Routes;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

	public static Result create() {
		Form<models.User> userForm = Form.form(models.User.class);
		return ok(views.html.registration.render(userForm));
	}

	public static Result save() {
		Form<models.User> filledForm = Form.form(models.User.class).bindFromRequest();
		
		if (filledForm.hasErrors()) {
			return badRequest(views.html.registration.render(filledForm));
		}
		else {
			User.save(filledForm.get());
		}
		return redirect(routes.UserController.all());
	}
	
	public static Result userUpdate(Long id) {
		Form<models.User> userForm = Form.form(models.User.class);
		User user = User.get(id);
		return ok(views.html.user_update.render(userForm.fill(user)));

	}
	
	public static Result update() {
		Form<models.User> filledForm = Form.form(models.User.class).bindFromRequest();
		
		if (filledForm.hasErrors()) {
			return badRequest(views.html.registration.render(filledForm));
		}
		else {
			User.update(filledForm.get());
		}
		return redirect(routes.UserController.all());
	}

	public static Result all() {
		List<User> users = User.all();		
		return ok(views.html.users_list.render(users));		
	}
	
	public static Result delete(Long id) {
		User.delete(id);
		return redirect(routes.UserController.all());
	}
}
