package ttl.client.layout.widgets;

import java.util.ArrayList;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BackgroundRepeat;
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


	public NavigationPanelWidget()
	{
		this.setWidth("240px");
		this.setStyleName("beveled");
	}
	
	public void addLink(String text, ClickHandler handler)
	{
		// Create the Link Object
		NavigationPanelLink newLink = new NavigationPanelLink(text);
		// Add OnClick Handler
		newLink.addClickHandler(handler);
		// Add link to display (I believe this also re-renders for us)
		newLink.setStyleName("button");
		this.addMember(newLink);
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
				public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
					doClick(); // Send the click to the parent.
				}
			});
			// TODO: OnHover: change the text to look like it's being hovered
			
	        // Add Link to Form
			linkForm.setFields(new FormItem[]{linkItem});
			
			// Define Form attributes
			linkForm.setContents(link);
			//linkForm.setWidth(200);
			linkForm.setHeight(20);
	        //linkForm.setPadding(5);
	        //linkForm.setLeft("20px");
	        //linkForm.setBackgroundColor("white");  
	        //linkForm.setBorder("1px solid #c0c0c0");    
	        //linkForm.setShowShadow(true);  
	        //linkForm.setShadowSoftness(2);  
	        //linkForm.setShadowOffset(1);
	        linkForm.addMouseOverHandler(new MouseOverHandler(){
				@Override
				public void onMouseOver(MouseOverEvent event) {
					//linkForm.setBackgroundColor("#EEEEEE");
				}
	        });
	        linkForm.addMouseOutHandler(new MouseOutHandler(){
				@Override
				public void onMouseOut(MouseOutEvent event) {
					//linkForm.setBackgroundColor("white");
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


