package ttl.client.layout;


import ttl.client.Settings;
import ttl.client.layout.widgets.BodyWidget;
import ttl.client.layout.widgets.ContainerWidget;
import ttl.client.layout.widgets.LoginWidget;
import ttl.client.layout.widgets.NavigationPanelWidget;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;  
import com.smartgwt.client.widgets.layout.VLayout;  

public class MainLayout extends Canvas
{
	/* LAYOUT STRUCTURE:
	 * 	mainLayout (Vertical)
	 * 		TopBar (HLayout)		-> Row_Top.png<Repeat-x>
	 * 			<Logo Widget>
	 * 			<Title Widget> 
	 * 			<Login Widget>
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
			private Img logo;
		private HLayout middleBar;
			private HLayout helloWorld;
			private NavigationPanelWidget linkPanelWidget;
			private HLayout body;
		private HLayout bottomBar;
	
	private int CURRENT_VIEW;
		
	public MainLayout()
	{
		this.setAnimateFadeTime(Settings.DEFAULT_ANIMATION_FADE_TIME);
		// mainLayout
		mainLayout = new VLayout();  
        mainLayout.setWidth100();  
        mainLayout.setHeight100();  
        mainLayout.setMembersMargin(10);
        
	        // topBar
	        createTopBar();
        mainLayout.addMember(topBar);
	  
	        // middleBar
        	createMiddleBar();
    	mainLayout.addMember(middleBar);
        
	        // bottomBar
	        createBottomBar();
        mainLayout.addMember(bottomBar);
        
    }
	
	private void createTopBar()
	{
		topBar = new HLayout();
        topBar.setWidth100(); 
        topBar.setAlign(Alignment.CENTER);
        topBar.setHeight("70px");
        topBar.setStyleName("topbar");
        //topBar.setBackgroundImage("Row_Top.png");
        //topBar.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
	     	
        	// Logo
        	logo = new Img("Logo_200.png");
        	logo.setWidth("150px");
        	logo.setHeight("43px");
        	logo.setAlign(Alignment.CENTER);
        	
    	topBar.addMember(logo);
        	
    		// TODO: Title
    		HLayout title = new HLayout();
    		title.setWidth("*");
    		
    	
    	topBar.addMember(title);
    	
        	// Login Form
        	loginWidget = new LoginWidget();
        	
    	topBar.addMember(loginWidget);
	}
	
	private void createMiddleBar()
	{
		middleBar = new HLayout();  
        middleBar.setAlign(Alignment.CENTER);
        	////////////////////
        	// Anonymous View //
        	////////////////////
        	helloWorld = new HLayout();
        	helloWorld.setStyleName("beveled");
        	helloWorld.setSize("650px","450px");
        	helloWorld.setLayoutAlign(Alignment.CENTER); // Center vertically
        	helloWorld.setAnimateFadeTime(Settings.DEFAULT_ANIMATION_FADE_TIME);
        	helloWorld.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					helloWorld.animateFade(0, new AnimationCallback(){
						@Override
						public void execute(boolean earlyFinish) {
							helloWorld.hide();
							linkPanelWidget.show();
							body.show();
							linkPanelWidget.animateFade(100);
							body.animateFade(100);
						}
					});
				}
        	});
        middleBar.addMember(helloWorld);
        
        	//////////////////
        	// Welcome View //
        	//////////////////
        	linkPanelWidget = new NavigationPanelWidget();
        	// Initially not shown
        	linkPanelWidget.setOpacity(0);
        	linkPanelWidget.hide();
        	linkPanelWidget.setAnimateFadeTime(Settings.DEFAULT_ANIMATION_FADE_TIME);
        		// Left-Panel Links
        		linkPanelWidget.addLink("My Stuff", new ClickHandler(){
        			@Override
        			public void onClick(ClickEvent evt){
        				Window.alert("My Stuff not yet implemented.");
        			}
        		});
        		linkPanelWidget.addLink("Others' Stuff", new ClickHandler(){
        			@Override
        			public void onClick(ClickEvent evt){
        				body.animateFade(0, new AnimationCallback(){
							@Override
							public void execute(boolean earlyFinish) {
								body.hide();
							}
        				});
        			}
        		});
        		linkPanelWidget.addLink("Account", new ClickHandler(){
        			@Override
        			public void onClick(ClickEvent evt){
        				//Window.alert("Account not yet implemented.");
        				body.show();
        				body.animateFade(100);
        			}
        		});
        middleBar.addMember(linkPanelWidget);
        	//////////
        	// Body //
        	//////////
        	body = new HLayout();
        	body.setStyleName("beveled");
        	body.setAnimateFadeTime(Settings.DEFAULT_ANIMATION_FADE_TIME);
        	// Initially not shown
        	body.setOpacity(0);
        	body.hide();
        	
        middleBar.addMember(body);
        
        	
	}
	
	private void createBottomBar()
	{
		bottomBar = new HLayout();
        bottomBar.setShowEdges(false);
        bottomBar.setWidth100();
        bottomBar.setHeight("70px");
        bottomBar.setStyleName("bottombar");
        //bottomBar.setBackgroundImage("Row_Bottom.png");
        //bottomBar.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
        	// Legal
        	// Misc
	}
	
	
	public void draw()
	{
		mainLayout.draw();
	}
	
	public void setView(int view)
	{
		// First: Animate Fade to 0% all visible middle row elements
		// Second: Animate Fade to 100% all applicable middle row elements 
		switch(view)
		{
			case Settings.ANONYMOUS_VIEW:
				break;
			case Settings.WELCOME_VIEW:
				break;
			case Settings.ACCOUNT_VIEW:
				break;
		}
			
	}
	
}
