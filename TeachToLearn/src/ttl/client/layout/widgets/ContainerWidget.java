package ttl.client.layout.widgets;

import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ContainerWidget extends VLayout
{
	private HLayout top;
		private Img TL_Corner;
		private HLayout topBar;
		private Img TR_Corner;
	private HLayout middle;
		private VLayout L_Column;
		private VLayout body;
		private VLayout R_Column;
	private HLayout bottom;
		private Img BL_Corner;
		private HLayout bottomBar;
		private Img BR_Corner;
	
	public ContainerWidget()
	{
			top = new HLayout();
			top.setHeight("16px");
				TL_Corner = new Img("Container/TL_Corner_14_16.png",14,16);
			top.addMember(TL_Corner);
				topBar = new HLayout();
				topBar.setBackgroundImage("Container/Top_Row_1_16.png");
				topBar.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
				topBar.setSize("*", "16px");
			top.addMember(topBar);
				TR_Corner = new Img("Container/TR_Corner_18_16.png",18,16);
			top.addMember(TR_Corner);
		this.addMember(top);
			middle = new HLayout();
			//middle.setSize("*", "*");
				L_Column = new VLayout();
				L_Column.setWidth("14px");
				L_Column.setBackgroundImage("Container/Left_Column_14_1.png");
				L_Column.setBackgroundRepeat(BackgroundRepeat.REPEAT_Y);
			middle.addMember(L_Column);
				body = new VLayout();
				body.setBackgroundColor("white");
				//body.setSize("*", "*");
			middle.addMember(body);
				R_Column = new VLayout();
				R_Column.setWidth("18px");
				R_Column.setBackgroundImage("Container/Right_Column_18_1.png");
				R_Column.setBackgroundRepeat(BackgroundRepeat.REPEAT_Y);
			middle.addMember(R_Column);
		this.addMember(middle);
			bottom = new HLayout();
			bottom.setHeight("18px");
				BL_Corner = new Img("Container/BL_Corner_14_18.png",14,18);
			bottom.addMember(BL_Corner);
				bottomBar = new HLayout();
				bottomBar.setSize("*","18px");
				bottomBar.setBackgroundImage("Container/Bottom_Row_1_18.png");
				bottomBar.setBackgroundRepeat(BackgroundRepeat.REPEAT_X);
			bottom.addMember(bottomBar);
				BR_Corner = new Img("Container/BR_Corner_18_18.png",18,18);
			bottom.addMember(BR_Corner);
		this.addMember(bottom);
	}
	
	public void addToBody(Canvas component)
	{
		body.addMember(component);
	}
	
	
}
