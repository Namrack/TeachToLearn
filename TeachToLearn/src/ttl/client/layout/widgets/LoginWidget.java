package ttl.client.layout.widgets;

import com.smartgwt.client.types.KeyNames;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;

public class LoginWidget extends VLayout
{
	/*
	 * 	VLayout contains Form item
	 */
	private DynamicForm loginForm;
		private TextItem usernameInput;
		private PasswordItem passwordInput;
		private ButtonItem submitButton;
		private LinkItem registerItem;
		private LinkItem forgotPasswordItem;
		private CheckboxItem rememberMeItem;
		private RegisterWidget registerWidget;
	private DynamicForm logoutForm;
		private LinkItem logoutItem;
	
	public LoginWidget()
	{
		this.setWidth("300px");
		this.setHeight("100px");
		//this.setLayoutAlign(VerticalAlignment.CENTER);
		
		// logoutForm
		logoutForm = new DynamicForm();
			logoutItem = new LinkItem();
				logoutItem.setLinkTitle("Logout");
				logoutItem.setShowTitle(false);
				logoutItem.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						//AJAXCall.doLogout();
					}
				});
				logoutForm.setFields(new FormItem[]{logoutItem});
		logoutForm.hide(); // Initially not shown until user logs in
		this.addMember(logoutForm);
		
		// loginForm: User/Pass input form
		loginForm = new DynamicForm();
			usernameInput = new TextItem();
				usernameInput.setTitle("E-Mail");
				usernameInput.setRequired(true);
				usernameInput.addKeyPressHandler(new KeyPressHandler(){
					@Override
					public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
						if(event.getKeyName().equals(KeyNames.ENTER))
							doSubmit();
					}
				});
			passwordInput = new PasswordItem();
				passwordInput.setTitle("Password");
				passwordInput.setRequired(true);
				passwordInput.addKeyPressHandler(new KeyPressHandler(){
					@Override
					public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
						if(event.getKeyName().equals(KeyNames.ENTER))
							doSubmit();
					}
				});
				
			submitButton = new ButtonItem("submitButton", "Sign In");
			submitButton.setStartRow(false);
			submitButton.setVAlign(VerticalAlignment.BOTTOM);
			submitButton.addClickHandler(new ClickHandler(){
				@Override
				public void onClick(ClickEvent event) {
					doSubmit();
				}
			});
				
			registerItem = new LinkItem();
				registerItem.setLinkTitle("Register");
				registerItem.setShowTitle(false); // LinkTitle and Title are different, this doesn't hide "Register"
				registerItem.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						registerWidget = new RegisterWidget();
						registerWidget.show();
					}
				});
			
			rememberMeItem = new CheckboxItem();  
		        //rememberMeItem.setName("setCookie");  
		        rememberMeItem.setTitle("Remember me!");
		        rememberMeItem.setShowTitle(false); //Still will display the "label" of "Remember me!"
		        rememberMeItem.setRedrawOnChange(false);  
		        //rememberMeItem.setWidth(50);
		        rememberMeItem.setValue(false); 
		        rememberMeItem.addKeyPressHandler(new KeyPressHandler(){
					@Override
					public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
						if(event.getKeyName().equals(KeyNames.ENTER))
							doSubmit();
					}
				});
			
	        /*forgotPasswordItem = new LinkItem();
				forgotPasswordItem.setLinkTitle("Forgot Password?");
				forgotPasswordItem.setShowTitle(false);
				forgotPasswordItem.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						Window.alert("Forgot Password functionality not yet implemented.");
					}
				});*/
				
			
			//form.setLayoutAlign(VerticalAlignment.BOTTOM);
		    loginForm.setNumCols(3);
			loginForm.setFields(new FormItem[]{usernameInput, passwordInput, submitButton, registerItem, rememberMeItem});
			loginForm.setTitleOrientation(TitleOrientation.TOP);
		this.addMember(loginForm);    	
	}
	public String getUsername()
	{
		return usernameInput.getValueAsString();
	}
	public String getPassword()
	{
		return passwordInput.getValueAsString();
	}
	private void doSubmit()
	{
		//AJAXCall.composeLogin(usernameInput.getValueAsString(), passwordInput.getValueAsString(), rememberMeItem.getValueAsBoolean());
		usernameInput.clearValue();
		passwordInput.clearValue();
	}
	public void convertToWelcomeMessage()
	{
		loginForm.hide();
		logoutForm.show();
	}
	public void hideRegisterWidget()
	{
		registerWidget.destroy();
	}
	public void enableRegisterWidget()
	{
		registerWidget.enableForm();
	}

	
}
