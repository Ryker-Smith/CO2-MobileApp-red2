package net.fachtnaroe.co2_mobileapp_red2;

import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Label;

public class Sploosh extends Form implements HandlesEventDispatching {
    private
    VerticalArrangement Main;
    HorizontalArrangement HBlock;
    VerticalArrangement VBlock;
    Clock Tim;
    Label labl;

    protected void $define() {
        this.Sizing("Responsive");

        Main = new VerticalArrangement(this);
        Main.HeightPercent(100);
        Main.WidthPercent(100);
        Main.Image("backgroundMain.png");
        //
        HBlock = new HorizontalArrangement(Main);
        HBlock.WidthPercent(100);
        HBlock.HeightPercent(20);

        //
        HBlock = new HorizontalArrangement(Main);
        HBlock.WidthPercent(100);
        HBlock.HeightPercent(40);

        //
        HBlock = new HorizontalArrangement(Main);
        HBlock.WidthPercent(100);
        HBlock.HeightPercent(20);

        //
        HBlock = new HorizontalArrangement(HBlock);
        HBlock.WidthPercent(100);
        HBlock.HeightPercent(20);
        //
        labl = new Label(HBlock);
        labl.Text("Loading...");
        labl.FontSize(50);
        labl.TextAlignment(ALIGNMENT_CENTER);
        labl.WidthPercent(100);
        labl.HeightPercent(100);
        //

    }
}