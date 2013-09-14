package ttl.client.layout.widgets;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;

public class NavigationPanelWidget extends VLayout
{
	/*			Middle_1 (HLayout) 	-> Row_Middle_1.png
	 * 			Middle_2 (VLayout) 	-> Row_Middle_2.png<Repeat-y>
	 * 				Links
	 * 			Middle_3 (HLayout) 	-> Row_Middle_3.png
	 */
	private HLayout middle_1;
	private VLayout middle_2;
	private HLayout middle_3;
	
	public NavigationPanelWidget()
	{
		this.setWidth("240px");
		
			// middle_1
	    	middle_1 = new HLayout();
	    	middle_1.setBackgroundImage("Row_Middle_1_240px.png");
	    	middle_1.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
	    	middle_1.setHeight("16px");
	    	middle_1.setWidth("240px");
    	this.addMember(middle_1);
	    	// middle_2
	    	middle_2 = new VLayout();
	    	//middle_2.setAlign(Alignment.CENTER);
	    	middle_2.setBackgroundImage("Row_Middle_2_240px.png");
	    	middle_2.setBackgroundRepeat(BackgroundRepeat.REPEAT_Y);
	    	middle_2.setWidth("240px");
    	
	    		// Links Here
		    	NavigationPanelLink link_0 = new NavigationPanelLink("Chat");
				link_0.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						// TODO: Create enum rather than using hard-coded numbers
					}
				});
	    		NavigationPanelLink link_1 = new NavigationPanelLink("Account Settings");
	    		link_1.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						// TODO: Create enum rather than using hard-coded numbers
					}
	    		});
	    		NavigationPanelLink link_2 = new NavigationPanelLink("Messages");
	    		link_2.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						Window.alert("Messages Clicked");
						// TODO: Create enum rather than using hard-coded numbers
					}
	    		});
	    		NavigationPanelLink link_3 = new NavigationPanelLink("Colleagues");
	    		link_3.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						Window.alert("Colleagues Clicked");
						// TODO: Create enum rather than using hard-coded numbers
					}
	    		});
	    		NavigationPanelLink link_4 = new NavigationPanelLink("Conversations");
	    		link_4.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						Window.alert("Conversations Clicked");
						// TODO: Create enum rather than using hard-coded numbers
					}
	    		});
	    		NavigationPanelLink link_5 = new NavigationPanelLink("Files");
	    		link_5.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						Window.alert("Files Clicked");
						// TODO: Create enum rather than using hard-coded numbers
					}
	    		});
	    		
    		middle_2.addMember(link_0);
    		middle_2.addMember(link_1);
    		middle_2.addMember(link_2);
    		middle_2.addMember(link_3);
    		middle_2.addMember(link_4);
    		middle_2.addMember(link_5);

    	this.addMember(middle_2);
    	
	    	// middle_3
	    	middle_3 = new HLayout();
	    	middle_3.setBackgroundImage("Row_Middle_3_240px.png");
	    	middle_3.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
	    	middle_3.setHeight("21px");
	    	middle_3.setWidth("240px");
    	this.addMember(middle_3);
	}
	
	
	// Navigation Panel Link objects only used for this widget, thus an internal and private class
	private class NavigationPanelLink extends HLayout
	{
		private DynamicForm linkForm;
		private LinkItem linkItem;
		
		public NavigationPanelLink(String link)
		{
			// Aligns it to be centered horizontally
			this.setAlign(Alignment.CENTER);
			
	        // Create the Form
	        linkForm = new DynamicForm();
	        
	        // Create the Link
	        linkItem = new LinkItem();
			linkItem.setLinkTitle(link);
			linkItem.setShowTitle(false);
			linkItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler(){
				@Override
				public void onClick(
						com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
					doClick(); // Send the click to the parent.
					
				}
			});
			// TODO: OnHover: change the text to look like it's being hovered
			
	        // Add Link to Form
			linkForm.setFields(new FormItem[]{linkItem});
			
			// Define Form attributes
			linkForm.setContents(link);
			linkForm.setWidth(200);
			linkForm.setHeight(20);
	        linkForm.setPadding(5);
	        linkForm.setLeft("20px");
	        linkForm.setBackgroundColor("white");  
	        linkForm.setBorder("1px solid #c0c0c0");    
	        linkForm.setShowShadow(true);  
	        linkForm.setShadowSoftness(2);  
	        linkForm.setShadowOffset(1);
	        linkForm.addMouseOverHandler(new MouseOverHandler(){
				@Override
				public void onMouseOver(MouseOverEvent event) {
					linkForm.setBackgroundColor("#EEEEEE");
				}
	        });
	        linkForm.addMouseOutHandler(new MouseOutHandler(){
				@Override
				public void onMouseOut(MouseOutEvent event) {
					linkForm.setBackgroundColor("white");
				}
	        });
	        
	        // Define container attributes
	        this.setHeight(linkForm.getHeight());
	        
	        // Add form to container
	        this.addMember(linkForm);
	        
		}
		
		private void doClick()
		{
			this.fireEvent(new com.smartgwt.client.widgets.events.ClickEvent(config));
		}
		
	}
	
}


