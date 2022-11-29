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
//
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends Form implements HandlesEventDispatching {
    private
    Button Menu, Fetch;
    HorizontalArrangement Main;
    HorizontalArrangement HBlock;
    VerticalArrangement VBlock1;
    VerticalArrangement VBlock2;
    Label Labl;
    Label TextCo2;
    Label TextTemp;
    Web SpiderWeb;
    TextBox servernameBox, commandBox;
    WebViewer SpiderSea;

    protected void $define() {
        this.Sizing("Responsive");

        Main = new HorizontalArrangement(this);
        Main.BackgroundColor(COLOR_BLACK);
        Main.HeightPercent(100);
        Main.WidthPercent(100);
        Main.Image("background.png");
        //
        SpiderWeb = new Web(Main);
        //
        servernameBox = new TextBox(Main);
        servernameBox.FontSize(12);
        servernameBox.Text("https://fachtnaroe.net/qndco2?");
        servernameBox.Enabled(true);
        servernameBox.FontTypeface(Component.TYPEFACE_MONOSPACE);
        servernameBox.Visible(false);
        //
        commandBox = new TextBox(Main);
        commandBox.FontSize(12);
        commandBox.Text("device=KRIS-CO2-62-42&sensor=CO2");
        commandBox.FontTypeface(Component.TYPEFACE_MONOSPACE);
        commandBox.Visible(false);
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
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(16);
        HBlock.WidthPercent(42);
        HBlock.Image("ForTexts.png");
        TextCo2 = new Label(HBlock);
        TextCo2.WidthPercent(44);
        TextCo2.HeightPercent(12);
        TextCo2.Text(" 8 ");
        TextCo2.TextAlignment(ALIGNMENT_CENTER);
        TextCo2.FontSize(15);
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
        HBlock.WidthPercent(42);
        HBlock.Image("ForTexts.png");
        TextTemp = new Label(HBlock);
        TextTemp.HeightPercent(16);
        TextTemp.Text("    24");
        TextTemp.TextAlignment(ALIGNMENT_CENTER);
        TextTemp.FontSize(50);
        TextTemp.TextColor(COLOR_GREEN);
        //
        HBlock = new HorizontalArrangement(VBlock1);
        HBlock.HeightPercent(5);
        //
        Fetch = new Button(VBlock1);
        Fetch.HeightPercent(14);
        Fetch.WidthPercent(30);
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
        Menu.HeightPercent(14);
        Menu.WidthPercent(30);
        Menu.TextColor(COLOR_ORANGE);
        Menu.Image("cog.png");
        Menu.Shape(BUTTON_SHAPE_ROUNDED);
        //
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "OtherScreenClosed");


    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {

        System.err.print("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            // this would be a great place to do something useful
            return true;
        } else if (eventName.equals("Click")) {
            dbg("Ive been pressed!");
            if (component.equals(Fetch)) {
                SpiderWeb.Url(servernameBox.Text() + commandBox.Text());
                TextCo2.Text(SpiderWeb.Url());
                dbg("Sending request");
                System.err.print("You pressed the button");
                SpiderWeb.Get();
                dbg("Request sent");
                return true;
            }
        } else if (eventName.equals("GotText")) {
            dbg("GotText");
            if (component.equals(SpiderWeb)) {
//                dbg("My web component");
                TextCo2.Text("Formatting\n");

                String status = params[1].toString();
                String textOfResponse = (String) params[3];
//                dbg("Calling function to process response");
                handleWebResponse(status, textOfResponse);
//                dbg("Finished and returned");
                return true;
            }
        }
        return false;
    }

    public void handleWebResponse(String status, String textOfResponse) {
        dbg("In function");
        String temp = new String();
        dbg("A");
        if (status.equals("200")) {
            dbg("B");
            int maxHTML = 8192;
            if (textOfResponse.length() > maxHTML) {
                textOfResponse = (String) textOfResponse.subSequence(0, maxHTML);
            }
            textOfResponse = textOfResponse.replace("\n", "<br>");
            textOfResponse = textOfResponse.replace("<td>", "&nbsp;<td>");
            textOfResponse = textOfResponse.replace("<tr>", "\n<tr>");
            temp = "<html><pre><code>" + textOfResponse + "</code></pre></html>";
//            contentViewer.BackgroundColor(Component.COLOR_BLUE);
            TextCo2.Text(textOfResponse);
//            contentBox.Text(status);
            dbg(textOfResponse);
            dbg("D");
        } else {
            dbg("C");
            TextCo2.Text(status);
        }
        dbg("End of processing function");
    }

    public static void dbg(String debugMsg) {
        System.err.print("~~~> " + debugMsg + " <~~~\n");
    }
}
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

