package net.fachtnaroe.co2_mobileapp_red2;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.TextBox;

public class MainActivity extends Form implements HandlesEventDispatching {
    private
    Button Menu;
    HorizontalArrangement Main;
    HorizontalArrangement HBlock;
    VerticalArrangement VBlock1;
    VerticalArrangement VBlock2;
    Label Labl;
    TextBox TextCo2;
    TextBox TextTemp;

    protected void $define() {
        this.Sizing("Responsive");

        Main = new HorizontalArrangement(this);
        Main.BackgroundColor(COLOR_BLACK);
        Main.HeightPercent(100);
        Main.WidthPercent(100);
        Main.Image("background.png");
        //
        HBlock = new HorizontalArrangement(Main);
        HBlock.HeightPercent(100);
        HBlock.WidthPercent(15);
        //
        VBlock1 = new VerticalArrangement(Main);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(20);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(3);
        HBlock.WidthPercent(30);
        HBlock.Image("ForTexts.png");
        Labl = new Label(HBlock);
        Labl.Text("        CO2 Levels");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(2);
        //
        TextCo2 = new TextBox(VBlock1);
        TextCo2.HeightPercent(16);
        TextCo2.Text("437");
        TextCo2.TextAlignment(ALIGNMENT_CENTER);
        TextCo2.FontSize(20);
        TextCo2.TextColor(COLOR_GREEN);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(2);
        //
        Labl = new Label(VBlock1);
        Labl.HeightPercent(6);
        Labl.Text("Temperature");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(2);
        //
        TextTemp = new TextBox(VBlock1);
        TextTemp.HeightPercent(16);
        TextTemp.Text("24");
        TextTemp.TextAlignment(ALIGNMENT_CENTER);
        TextTemp.FontSize(20);
        TextTemp.TextColor(COLOR_GREEN);
        //
        VBlock2 = new VerticalArrangement(Main);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(32);
        //
        Labl = new Label(VBlock2);
        Labl.HeightPercent(8);
        Labl.Text("PPM");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(17);
        //
        Labl = new Label(VBlock2);
        Labl.HeightPercent(8);
        Labl.Text("Degrees Celsius");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(10);
        //
        HBlock = new HorizontalArrangement(Main);
        HBlock.HeightPercent(100);
        HBlock.WidthPercent(6);
        //
        Menu = new Button(VBlock2);
        Menu.HeightPercent(14);
        Menu.WidthPercent(30);
        Menu.TextColor(COLOR_ORANGE);
        Menu.Image("cog.png");


    }
}
