package firstproject;

import java.awt.TextField;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class UserPage extends WebPage {

	private User user = new User();
	private String nickname;

	public UserPage(final PageParameters parameters) {
		
		add(new FeedbackPanel("feedback"));
		
		final TextField<String> tName = new TextField<String>("name",
				new PropertyModel<String>(user, "name"));
				
		final TextField<Integer> tAge = new TextField<Integer>("age",
				new PropertyModel<Integer>(user, "age"));
		
		final TextField<String> tNickname = new TextField<String>("nickname",
				new PropertyModel<String>(this, "nickname"));
		
		Form<?> form = new Form<Void>("userForm") {
			
		protected void onSubmit() {
			
			PageParameters pageParameters = new PageParameters();
			pageParameters.add("name", user.getName());
			pageParameters.add("age", Integer.toString(user.getAge()));
			pageParameters.add("nickname", nickname);
			
			setResponsePage(SuccessPage.class, pageParameters);
			
			
			}

		};
	}
}