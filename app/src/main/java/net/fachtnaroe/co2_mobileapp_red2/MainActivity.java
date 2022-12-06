package net.fachtnaroe.co2_mobileapp_red2;

import static java.lang.Thread.sleep;

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
import com.google.appinventor.components.runtime.WebViewer;
import com.google.appinventor.components.runtime.Clock;
//
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends Form implements HandlesEventDispatching {
    private
    Button Menu, Fetch;
    HorizontalArrangement Main;
    HorizontalArrangement HBlock;
    VerticalArrangement VBlock;
    VerticalArrangement VBlock1;
    VerticalArrangement VBlock2;
    Label Labl;
    Label TextCo2;
    Label TextTemp;
    Web SpiderWebCo2, SpiderWebTemp;
    TextBox servernameBox1, servernameBox2;
    WebViewer SpiderSea;
    Clock Tim;

    protected void $define() {
        this.Sizing("Responsive");

        Main = new HorizontalArrangement(this);
        Main.BackgroundColor(COLOR_BLACK);
        Main.HeightPercent(100);
        Main.WidthPercent(100);
        Main.Image("background.png");
        //
        SpiderWebCo2 = new Web(Main);
        SpiderWebTemp = new Web(Main);
        //
        Tim = new Clock(Main);
        Tim.TimerEnabled(false);
        Tim.TimerAlwaysFires(false);
        //
        servernameBox1 = new TextBox(Main);
        servernameBox1.FontSize(12);
        servernameBox1.Text("https://fachtnaroe.net/qndco2?device=KRIS-CO2-62-42&sensor=CO2");
        servernameBox1.Enabled(true);
        servernameBox1.FontTypeface(Component.TYPEFACE_MONOSPACE);
        servernameBox1.Visible(false);
        //
        servernameBox2 = new TextBox(Main);
        servernameBox2.FontSize(12);
        servernameBox2.Text("https://fachtnaroe.net/qndco2?device=KRIS-CO2-62-42&sensor=CELCIUS");
        servernameBox2.Enabled(true);
        servernameBox2.FontTypeface(Component.TYPEFACE_MONOSPACE);
        servernameBox2.Visible(false);
        //
        HBlock = new HorizontalArrangement(Main);
        HBlock.HeightPercent(100);
        HBlock.WidthPercent(12);
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
        VBlock = new VerticalArrangement(VBlock1);
        VBlock.HeightPercent(16);
        VBlock.WidthPercent(45);
        VBlock.Image("ForTexts.png");
        TextCo2 = new Label(VBlock);
        TextCo2.WidthPercent(39);
        TextCo2.HeightPercent(12);
        TextCo2.Text("Press the plane to request data!");
        TextCo2.TextAlignment(ALIGNMENT_CENTER);
        TextCo2.FontSize(27);
        TextCo2.TextColor(COLOR_GREEN);
        TextCo2.HTMLFormat(true);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(2);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(3);
        HBlock.WidthPercent(30);
        HBlock.Image("ForTexts.png");
        Labl = new Label(HBlock);
        Labl.Text("      Temperature");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(2);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(16);
        HBlock.WidthPercent(45);
        HBlock.Image("ForTexts.png");
        TextTemp = new Label(HBlock);
        TextTemp.WidthPercent(39);
        TextTemp.HeightPercent(12);
        TextTemp.Text("Press the plane to request data!");
        TextTemp.TextAlignment(ALIGNMENT_CENTER);
        TextTemp.FontSize(27);
        TextTemp.TextColor(COLOR_GREEN);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(5);
        //
        Fetch = new Button(VBlock1);
        /* Using percentages for button/image size is more
        likely to yield an image out of proportion.
        Using pixel sizes maintains proportions, does not add to alignment
        issues, and can be made easier with a variable for square button images.
        Fetch.HeightPercent(14);
        Fetch.WidthPercent(30); */
        int FetchPngSize=128;
        Fetch.Width(FetchPngSize);
        Fetch.Height(FetchPngSize);
        Fetch.TextColor(COLOR_ORANGE);
        Fetch.Image("Fetch.png");
        Fetch.Shape(BUTTON_SHAPE_ROUNDED);
        //
        VBlock2 = new VerticalArrangement(Main);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(32);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(4);
        HBlock.WidthPercent(38);
        HBlock.Image("ForTexts.png");
        Labl = new Label(HBlock);
        //Labl.HeightPercent(8);
        Labl.Text("             PPM");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        Labl.FontSize(18);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(17);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(4);
        HBlock.WidthPercent(38);
        HBlock.Image("ForTexts.png");
        Labl = new Label(HBlock);
        Labl.HeightPercent(8);
        Labl.Text("   Degrees Celsius");
        Labl.TextAlignment(ALIGNMENT_CENTER);
        Labl.FontSize(18);
        //
        HBlock = new HorizontalArrangement(VBlock2);
        HBlock.HeightPercent(11);
        //
        HBlock = new HorizontalArrangement(Main);
        HBlock.HeightPercent(100);
        HBlock.WidthPercent(6);
        //
        Menu = new Button(VBlock2);
        /* Menu.HeightPercent(14);
        Menu.WidthPercent(30); */
        // keep button sizes the same for better appearance, but with option to change
        int CogsPngSize=96; // FetchPngSize;
        Menu.Width(CogsPngSize);
        Menu.Height(CogsPngSize);
        Menu.TextColor(COLOR_ORANGE);
        Menu.Image("cog_squaredoff.png");
        Menu.Shape(BUTTON_SHAPE_ROUNDED);
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
            if (component.equals(Fetch)) {
                Tim.TimerInterval(6000);
                TextCo2.TextColor(COLOR_ORANGE);
                TextCo2.FontBold(true);
                TextTemp.TextColor(COLOR_ORANGE);
                TextTemp.FontBold(true);
                SpiderWebCo2.Url(servernameBox1.Text());
                SpiderWebTemp.Url(servernameBox2.Text());
                TextCo2.Text(SpiderWebCo2.Url());
                TextCo2.Text("Connecting..");
                TextCo2.TextColor(COLOR_GREEN);
                TextCo2.FontBold(false);
                TextTemp.Text(SpiderWebTemp.Url());
                TextTemp.Text("Connecting..");
                TextTemp.TextColor(COLOR_GREEN);
                TextTemp.FontBold(false);
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
                TextCo2.Text("Formatting\n");
                TextCo2.FontSize(50);
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
//                dbg("Calling function to process response");
                handleWebResponse(component, status, textOfResponse);
//                dbg("Finished and returned");
                return true;
            }
            else if (component.equals(SpiderWebTemp)) {
//                dbg("My web component");
                TextTemp.Text("Formatting\n");
                TextTemp.FontSize(50);
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
                    TextCo2.Text(parser.getString("value"));
                    Tim.TimerEnabled(true);
                }
                else if (c.equals(SpiderWebTemp)) {
                    TextTemp.Text(parser.getString("value"));
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