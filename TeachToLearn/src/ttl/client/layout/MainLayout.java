package ttl.client.layout;


import ttl.client.layout.widgets.LoginWidget;
import ttl.client.layout.widgets.NavigationPanelWidget;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;  
import com.smartgwt.client.widgets.layout.VLayout;  

public class MainLayout extends Canvas
{
	/* LAYOUT STRUCTURE:
	 * 	mainLayout (Vertical)
	 * 		TopBar (HLayout)		-> Row_Top.png<Repeat-x>
	 * 		MiddleBar (HLayout)
	 * 			<LinksWidget>
	 * 			<ChatTabsWidget>
	 * 		BottomBar (HLayout)		-> Row_Bottom.png<Repeat-x>
	 * 		
	 * The chatTabsWdiget is open by default, but as users click on links, this widget
	 * will fade into the other widgets.
	 * 		0 = ChatTabsWidget
	 * 		1 = AccountWidget
	 * 
	 * Animation Behavior:
	 * 	If I call "show()" for any Canvas, subsequent fade animations are ignored (they are
	 * run instantly, going from opacity zero to opacity 100%. To circumvent this, I call show(),
	 * then I create a timer that delays an arbitrary low number of milliseconds before running
	 * the fade animation. Not sure why this works but it does. TODO: figure out a more efficient
	 * and less hack-y method of getting fades to work.
	 */
	
	private VLayout mainLayout;
		private HLayout topBar;
			private LoginWidget loginWidget;
		private HLayout middleBar;
			// Default Widget: chatTabsWidget
			private NavigationPanelWidget linkPanelWidget;
			//private ContentWidget contentWidget;
		private HLayout bottomBar;
	
	public MainLayout()
	{
		this.setAnimateFadeTime(1200);
		// mainLayout
		mainLayout = new VLayout();  
        mainLayout.setWidth100();  
        mainLayout.setHeight100();  
        mainLayout.setMembersMargin(10);
        
	        // topBar
	        topBar = new HLayout();
	        topBar.setWidth100(); 
	        topBar.setAlign(Alignment.CENTER);
	        topBar.setHeight("100px");
	        topBar.setBackgroundImage("Row_Top.png");
	        topBar.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
	        	// Logo
//	        	final Img logo = new Img("Logo_200.png");
//	        	logo.setWidth("150px");
//	        	logo.setHeight("43px");
//	        	logo.setAlign(Alignment.CENTER);
//	        	topBar.addMember(logo);
//	        	
	        	// Login Widget
	        	loginWidget = new LoginWidget();
	        	
        	topBar.addMember(loginWidget);

        mainLayout.addMember(topBar);
	  
	        // middleBar
	        middleBar = new HLayout();  
	        middleBar.setShowEdges(false);
	        middleBar.setWidth100();
	        middleBar.setAlign(Alignment.LEFT);
	        
	        	// Left-Panel Navigation
	        	linkPanelWidget = new NavigationPanelWidget();
	        middleBar.addMember(linkPanelWidget);
	        
    	mainLayout.addMember(middleBar);
        
	        // bottomBar
	        bottomBar = new HLayout();
	        bottomBar.setShowEdges(false);
	        bottomBar.setWidth100();
	        bottomBar.setHeight("100px");
	        bottomBar.setBackgroundImage("Row_Bottom.png");
	        bottomBar.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
	        	// Legal
	        	// Misc
        mainLayout.addMember(bottomBar);
        
    }
	
	public void draw()
	{
		mainLayout.draw();
	}
	
}
