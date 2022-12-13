package net.fachtnaroe.co2_mobileapp_red2;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Web;
import com.google.appinventor.components.runtime.Clock;
//
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Form implements HandlesEventDispatching {
    private
    Button but_Settings, but_Fetch;
    HorizontalArrangement   Main, hb_CO2_data, HBlock, pad_HBlock_R2,
                            pad_HBlock_TopLeft, pad_MarginLeft, hb_CO2_head, pad_HBlock_L1,
                            pad_HBlock_TopRight, hb_CO2_units, pad_HBlock_R1, hb_Temp_Units,
                            hb_Temp_Head, hb_Temp_Data, pad_HBlock_L2, pad_HBlock_L3;
    VerticalArrangement vb_Left, vb_Right;
    Label Labl;
    Label label_CO2_data;
    Label label_Temperature_data;
    Web SpiderWebCo2, SpiderWebTemp;
    TextBox servernameBox1, servernameBox2;
    Clock Tim;
    int pad_MarginLeft_Width=10;
    int leftHeadingPaddingValue=2;
    int rightHeadingPaddingValue=2;
    int rightHeadingPercentValue=36;

    protected void $define() {
        this.Sizing("Responsive");

        Main = new HorizontalArrangement(this);
        Main.BackgroundColor(COLOR_BLACK);
        Main.HeightPercent(100);
        Main.WidthPercent(100);
        Main.Image("background.png");
        // non-visible components
        SpiderWebCo2 = new Web(Main);
        SpiderWebTemp = new Web(Main);
        Tim = new Clock(Main);
        Tim.TimerEnabled(false);
        Tim.TimerAlwaysFires(false);
        // hidden (debug) components
        servernameBox1 = new TextBox(Main);
        servernameBox1.FontSize(12);
        servernameBox1.Text("https://fachtnaroe.net/qndco2?device=AirTechC02-Monitor-62-42&sensor=CO2");
        servernameBox1.Enabled(true);
        servernameBox1.FontTypeface(Component.TYPEFACE_MONOSPACE);
        servernameBox1.Visible(false);
        servernameBox2 = new TextBox(Main);
        servernameBox2.FontSize(12);
        servernameBox2.Text("https://fachtnaroe.net/qndco2?device=AirTechC02-Monitor-62-42&sensor=CELCIUS");
        servernameBox2.Enabled(true);
        servernameBox2.FontTypeface(Component.TYPEFACE_MONOSPACE);
        servernameBox2.Visible(false);
        // A margin from LHS of screen
        pad_MarginLeft = new HorizontalArrangement(Main);
        pad_MarginLeft.HeightPercent(100);
        pad_MarginLeft.WidthPercent(pad_MarginLeft_Width);
        //
        // column LEFT
        vb_Left = new VerticalArrangement(Main);
        // put padding to move down screen
        pad_HBlock_TopLeft = new HorizontalArrangement(vb_Left);
        pad_HBlock_TopLeft.HeightPercent(20);
        // first heading, image as bg
        hb_CO2_head = new HorizontalArrangement(vb_Left);
        hb_CO2_head.HeightPercent(4);
        hb_CO2_head.WidthPercent(30);
        hb_CO2_head.Image("ForTexts.png");
        // pad inwards
        Label padding1 = new Label(hb_CO2_head);
        padding1.HeightPercent(3);
        padding1.WidthPercent(leftHeadingPaddingValue);
        Labl = new Label(hb_CO2_head);
        Labl.Text("CO2 Level");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        // vertical padding to next item (data)
        HBlock = new HorizontalArrangement(vb_Left);
        HBlock.HeightPercent(2);
        // first DATA (CO2)
        hb_CO2_data = new HorizontalArrangement(vb_Left);
        hb_CO2_data.HeightPercent(16);
        hb_CO2_data.WidthPercent(45);
        hb_CO2_data.Image("ForTexts.png");
        label_CO2_data = new Label(hb_CO2_data);
        label_CO2_data.WidthPercent(39);
        label_CO2_data.HeightPercent(12);
        label_CO2_data.Text("Press the plane to request data!");
        label_CO2_data.TextAlignment(ALIGNMENT_CENTER);
        label_CO2_data.FontSize(27);
        label_CO2_data.TextColor(COLOR_GREEN);
        label_CO2_data.HTMLFormat(true);
        // padding to next
        pad_HBlock_L1 = new HorizontalArrangement(vb_Left);
        pad_HBlock_L1.HeightPercent(2);
        // heading for temperature
        hb_Temp_Head = new HorizontalArrangement(vb_Left);
        hb_Temp_Head.HeightPercent(4);
        hb_Temp_Head.WidthPercent(30);
        hb_Temp_Head.Image("ForTexts.png");
        Label padding2 = new Label(hb_Temp_Head);
        padding2.HeightPercent(3);
        padding2.WidthPercent(leftHeadingPaddingValue);
        Labl = new Label(hb_Temp_Head);
        Labl.Text("Temperature");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        // vertical padding to next
        pad_HBlock_L2 = new HorizontalArrangement(vb_Left);
        pad_HBlock_L2.HeightPercent(2);
        // Temperature data
        hb_Temp_Data = new HorizontalArrangement(vb_Left);
        hb_Temp_Data.HeightPercent(16);
        hb_Temp_Data.WidthPercent(45);
        hb_Temp_Data.Image("ForTexts.png");
        label_Temperature_data = new Label(hb_Temp_Data);
        label_Temperature_data.WidthPercent(39);
        label_Temperature_data.HeightPercent(12);
        label_Temperature_data.Text("Press the plane to request data!");
        label_Temperature_data.TextAlignment(ALIGNMENT_CENTER);
        label_Temperature_data.FontSize(27);
        label_Temperature_data.TextColor(COLOR_GREEN);
        // padding
        pad_HBlock_L3 = new HorizontalArrangement(vb_Left);
        pad_HBlock_L3.HeightPercent(5);
        // the do-things-now button:
        but_Fetch = new Button(vb_Left);
        /* Using percentages for button/image size is more
        likely to yield an image out of proportion.
        Using pixel sizes maintains proportions, does not add to alignment
        issues, and can be made easier with a variable for square button images.
        Fetch.HeightPercent(14);
        Fetch.WidthPercent(30); */
        int FetchPngSize=128;
        but_Fetch.Width(FetchPngSize);
        but_Fetch.Height(FetchPngSize);
        but_Fetch.TextColor(COLOR_ORANGE);
        but_Fetch.Image("Fetch.png");
        but_Fetch.Shape(BUTTON_SHAPE_ROUNDED);
        //
        // RIGHT Column RIGHT RIGHT RIGHT
        vb_Right = new VerticalArrangement(Main);
        //  padding at top of RIGHT
        pad_HBlock_TopRight = new HorizontalArrangement(vb_Right);
        pad_HBlock_TopRight.HeightPercent(32);
        //
        hb_CO2_units = new HorizontalArrangement(vb_Right);
        hb_CO2_units.HeightPercent(4);
        hb_CO2_units.WidthPercent(rightHeadingPercentValue);
        hb_CO2_units.Image("ForTexts.png");
        Label padding3 = new Label(hb_CO2_units);
        padding3.HeightPercent(3);
        padding3.WidthPercent(rightHeadingPaddingValue);
        Labl = new Label(hb_CO2_units);
        Labl.Text("PPM");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        Labl.FontSize(18);
        // padding to next
        pad_HBlock_R1 = new HorizontalArrangement(vb_Right);
        pad_HBlock_R1.HeightPercent(17);
        //
        hb_Temp_Units = new HorizontalArrangement(vb_Right);
        hb_Temp_Units.HeightPercent(4);
        hb_Temp_Units.WidthPercent(rightHeadingPercentValue);
        hb_Temp_Units.Image("ForTexts.png");
        Label padding4 = new Label(hb_Temp_Units);
        padding4.HeightPercent(3);
        padding4.WidthPercent(rightHeadingPaddingValue);
        Labl = new Label(hb_Temp_Units);
        Labl.HeightPercent(8);
        // use unicodes for degrees symbol
        Labl.Text("\u2103");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        Labl.FontSize(18);
        //  vertical padding to next
        pad_HBlock_R2 = new HorizontalArrangement(vb_Right);
        pad_HBlock_R2.HeightPercent(11);
        // settings button
        but_Settings = new Button(vb_Right);
        // keep button sizes the same for better appearance, but with option to change
        int CogsPngSize=96; // FetchPngSize;
        but_Settings.Width(CogsPngSize);
        but_Settings.Height(CogsPngSize);
        but_Settings.TextColor(COLOR_ORANGE);
        but_Settings.Image("cog_squaredoff.png");
        but_Settings.Shape(BUTTON_SHAPE_ROUNDED);
        //
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "OtherScreenClosed");
        EventDispatcher.registerEventForDelegation(this, formName, "Timer");

    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {

        System.err.print("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            // this would be a great place to do something useful
            return true;
        }
        else if (eventName.equals("Click")) {
            dbg("Ive been pressed!");
            if (component.equals(but_Fetch)) {
                Tim.TimerInterval(6000);
                label_CO2_data.TextColor(COLOR_ORANGE);
                label_CO2_data.FontBold(true);
                label_Temperature_data.TextColor(COLOR_ORANGE);
                label_Temperature_data.FontBold(true);
                SpiderWebCo2.Url(servernameBox1.Text());
                SpiderWebTemp.Url(servernameBox2.Text());
                label_CO2_data.Text(SpiderWebCo2.Url());
                label_CO2_data.Text("Connecting..");
                label_CO2_data.TextColor(COLOR_GREEN);
                label_CO2_data.FontBold(false);
                label_Temperature_data.Text(SpiderWebTemp.Url());
                label_Temperature_data.Text("Connecting..");
                label_Temperature_data.TextColor(COLOR_GREEN);
                label_Temperature_data.FontBold(false);
                dbg("Sending request");
                System.err.print("You pressed the button");
                SpiderWebCo2.Get();
                SpiderWebTemp.Get();
                dbg("Request sent");
                return true;
            }
        }
        else if (eventName.equals("GotText")) {
            dbg("GotText");
            if (component.equals(SpiderWebCo2)) {
//                dbg("My web component");
                label_CO2_data.Text("Formatting\n");
                label_CO2_data.FontSize(50);
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
//                dbg("Calling function to process response");
                handleWebResponse(component, status, textOfResponse);
//                dbg("Finished and returned");
                return true;
            }
            else if (component.equals(SpiderWebTemp)) {
//                dbg("My web component");
                label_Temperature_data.Text("Formatting\n");
                label_Temperature_data.FontSize(50);
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
//                dbg("Calling function to process response");
                handleWebResponse(component, status, textOfResponse);
//                dbg("Finished and returned");
                return true;
            }
        }
        else if (eventName.equals("Timer")) {
            if (component.equals(Tim)) {
                Tim.TimerEnabled(false);
                SpiderWebCo2.Get();
                SpiderWebTemp.Get();
                return true;
            }
        }
        return false;
    }

    public void handleWebResponse(Component c, String status, String textOfResponse) {
        dbg("In function");
        String temp = new String();
        dbg("A");
        if (status.equals("200")) try {
            dbg("B");
            JSONObject parser = new JSONObject(textOfResponse);
            if (parser.getString("Status").equals("OK")) {
                if (c.equals(SpiderWebCo2)) {
                    label_CO2_data.Text(parser.getString("value"));
                    Tim.TimerEnabled(true);
                }
                else if (c.equals(SpiderWebTemp)) {
                    label_Temperature_data.Text(parser.getString("value"));
                }
            }
        }
        catch(JSONException e){
            dbg(textOfResponse);
        }
    }

    public static void dbg(String debugMsg) {
        System.err.print("~~~> " + debugMsg + " <~~~\n");
    }
}
//scrap yard//
//    JSONObject parser = new JSONObject(textOfResponse);
//            if (parser.getInt("link_ID") >= 1) {
//                    messagesPopUp.ShowMessageDialog("Chat has been initiated; now wait for the response", "Information", "OK");
//                    } else {
//                    messagesPopUp.ShowMessageDialog("Could not initiate chat", "Information", "OK");
//                    }
//                    } catch (JSONException e) {
//                    // if an exception occurs, code for it in here
//                    messagesPopUp.ShowMessageDialog("Chat already initiated" + temp, "Information", "OK");
//                    }
//                    else {
//                    messagesPopUp.ShowMessageDialog("Problem connecting with server", "Information", "OK");
//                    }