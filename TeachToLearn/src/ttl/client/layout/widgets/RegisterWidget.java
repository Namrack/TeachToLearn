package ttl.client.layout.widgets;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourcePasswordField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.FormErrorOrientation;
import com.smartgwt.client.types.KeyNames;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;  
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;
import com.smartgwt.client.widgets.form.validator.MatchesFieldValidator;
import com.smartgwt.client.widgets.form.validator.RegExpValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
/*
 * 	layout (HLayout)
 * 		formContainer (VLayout)
 * 			Form
 * 			buttonsContainer (HLayout)
 * 				Register Button
 * 				Cancel Button
 */
public class RegisterWidget extends Window
{
	HLayout layout;
		DynamicForm form;
			TextItem firstNameInput;
			TextItem lastNameInput;
			TextItem emailInput;
			PasswordItem passwordInput;
			PasswordItem passwordVerify;
			ButtonItem registerButton;
			ButtonItem cancelButton;
	
	public RegisterWidget()
	{
		this.setTitle("Register a UniChat Account");
		this.setWidth("50%");  
        this.setHeight("50%"); 
        this.setShowMinimizeButton(false);  
        this.setIsModal(true);
        this.setShowModalMask(true);  
        this.centerInPage();
        this.setAlign(Alignment.CENTER);
        
        layout = new HLayout();
        layout.setShowEdges(true);
        layout.setMargin(10);
        layout.setWidth100();
        layout.setHeight100();
        layout.setLayoutAlign(Alignment.CENTER);

        // Form
        form = new DynamicForm();
	        //form.setShowEdges(true);
	        //form.setWidth("50%");
	        form.setAlign(Alignment.CENTER);
	        form.setLayoutAlign(Alignment.CENTER);
	        form.setTitleOrientation(TitleOrientation.LEFT);
	        form.setErrorOrientation(FormErrorOrientation.RIGHT);
	        form.setMargin(5);
	        
	        // First Name input
	        firstNameInput = new TextItem();
	        firstNameInput.setTitle("First Name");
	        firstNameInput.setRequired(true);
	        firstNameInput.addKeyPressHandler(new KeyPressHandler(){
				@Override
				public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
					if(event.getKeyName().equals(KeyNames.ENTER))
						doSubmit();
				}
			});
	        
	        // Last Name input
	        lastNameInput = new TextItem();
	        lastNameInput.setTitle("Last Name");
	        lastNameInput.setRequired(true);
	        lastNameInput.addKeyPressHandler(new KeyPressHandler(){
				@Override
				public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
					if(event.getKeyName().equals(KeyNames.ENTER))
						doSubmit();
				}
			});
	        
	        // E-Mail input
	        emailInput = new TextItem();
	        emailInput.setTitle("E-Mail");
	        emailInput.setRequired(true);
	        RegExpValidator emailValidator = new RegExpValidator();
	        emailValidator.setErrorMessage("Invalid email address");
	        emailValidator.setExpression("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$");
	        emailInput.setValidators(emailValidator);
	        emailInput.addKeyPressHandler(new KeyPressHandler(){
				@Override
				public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
					if(event.getKeyName().equals(KeyNames.ENTER))
						doSubmit();
				}
			});
	        
	        // Password input
	        passwordInput = new PasswordItem();  
	        passwordInput.setTitle("Password");
	        passwordInput.setName("Password");
	        passwordInput.setRequired(true);
	        passwordInput.addKeyPressHandler(new KeyPressHandler(){
				@Override
				public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
					if(event.getKeyName().equals(KeyNames.ENTER))
						doSubmit();
				}
			});
	        
	        // Password input #2
	        passwordVerify = new PasswordItem();  
	        passwordVerify.setTitle("Verify Password");  
	        passwordVerify.setRequired(true);  
	        passwordVerify.setType("password");
	        passwordVerify.addKeyPressHandler(new KeyPressHandler(){
				@Override
				public void onKeyPress(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent event) {
					if(event.getKeyName().equals(KeyNames.ENTER))
						doSubmit();
				}
			});
	        
	        // Password validators
	        	// Passwords match
		        MatchesFieldValidator matchValidator = new MatchesFieldValidator();
		        matchValidator.setOtherField("Password");
		        matchValidator.setErrorMessage("Passwords do not match");
		        // Passwords of minimum length
		        LengthRangeValidator lengthValidator = new LengthRangeValidator();
		        lengthValidator.setMin(6);
		        lengthValidator.setMax(20);
		        lengthValidator.setErrorMessage("Password must be between 6 and 20 characters long");
		    passwordInput.setValidators(lengthValidator);
	        passwordVerify.setValidators(matchValidator, lengthValidator);
	        
	        // Buttons
	        // Register Button
	        registerButton = new ButtonItem("Register");
	        //registerButton.setWidth("100%");
	        registerButton.setEndRow(false);
	        registerButton.addClickHandler(new ClickHandler(){
				@Override
				public void onClick(ClickEvent event) {
					doSubmit();
				}
	        });
	        
	        // Cancel Button
	        cancelButton = new ButtonItem("Cancel");
	        //cancelButton.setWidth("100%");
	        final Window thisWidget = this;
	        cancelButton.setStartRow(false);
	        cancelButton.addClickHandler(new ClickHandler(){
				@Override
				public void onClick(ClickEvent event) {
					thisWidget.destroy();
				}
	        });
	        
	        form.setFields(new FormItem[] {firstNameInput, lastNameInput, emailInput, passwordInput, passwordVerify, registerButton, cancelButton});
        layout.addMember(form);
        this.addItem(layout);
	}
	
	private void doSubmit()
	{
		if(form.validate())
		{
			//AJAXCall.composeRegister(emailInput.getValueAsString(), passwordInput.getValueAsString(), 
			//						firstNameInput.getValueAsString(), lastNameInput.getValueAsString());
			form.setDisabled(true);
		}
	}
	public void enableForm()
	{
		form.setDisabled(false);
	}
}
