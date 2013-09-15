package ttl.client.layout.widgets;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BodyWidget extends VLayout
{
	public static final int INITIALWIDGET = 0;
	public static final int CHATTABSWIDGET = 1;
	public static final int SETTINGSWIDGET = 2;

	public BodyWidget()
	{
		this.setAnimateTime(400);
		this.setAnimateFadeTime(150);		
		this.setWidth("*");
			// middle_1
	    	HLayout middle_1 = new HLayout();
	    	middle_1.setBackgroundImage("Row_Middle_1.png");
	    	//middle_1.setBackgroundRepeat(BkgndRepeat.NO_REPEAT);
	    	middle_1.setHeight("16px");
	    	middle_1.setWidth("1024px");
    	this.addMember(middle_1);
	    	// middle_2
	    	HLayout middle_2 = new HLayout();
	    	middle_2.setAlign(Alignment.CENTER);
	    	middle_2.setBackgroundImage("Row_Middle_2.png");
	    	//middle_2.setBackgroundRepeat(BkgndRepeat.REPEAT_Y);
	    	middle_2.setPadding(15);
	    	middle_2.setWidth("1024px");
    	
		    	// Content Here
//	    		initialWidget = new InitialWidget();
//	    		initialWidget.setAnimateFadeTime(150);
//	    	middle_2.addMember(initialWidget);
//	    		
//		    	chatTabsWidget = new ChatTabsWidget();
//	        	chatTabsWidget.setAnimateFadeTime(150);
//	        	chatTabsWidget.hide();
//        	middle_2.addMember(chatTabsWidget);
//        	
//	        	settingsWidget = new SettingsWidget();
//	        	settingsWidget.setAnimateFadeTime(150);
//	        	settingsWidget.hide();
//	    	middle_2.addMember(settingsWidget);
	    	
    	this.addMember(middle_2);
	    	// middle_3
	    	HLayout middle_3 = new HLayout();
	    	middle_3.setBackgroundImage("Row_Middle_3.png");
	    	middle_3.setHeight("21px");
	    	middle_3.setWidth("1024px");
	    	this.addMember(middle_3);
	}
	
	// must be given an instance of this object's own contents
	public void setContents(int type)
	{
//		final Layout contents = getContent(type);
//		if(contents != currentContents)
//		{
//			final Layout container = this;
//			container.animateFade(0, new AnimationCallback(){
//				@Override
//				public void execute(boolean earlyFinish) 
//				{
//					currentContents.hide();
//					contents.show();
//					currentContents = contents;
//					container.animateFade(100);
//				}
//			});
//		}
	}

	
}
