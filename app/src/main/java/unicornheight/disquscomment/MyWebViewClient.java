package unicornheight.disquscomment;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by deboajagbe on 1/9/18.
 */

public class MyWebViewClient extends WebViewClient{

    private String html_comments, sType, obj, sMyURL;


    public MyWebViewClient(String htmlComments, String string, String object, String URL) {
        // TODO Auto-generated constructor stub
        html_comments=htmlComments;
        sType=string;
        obj=object;
        sMyURL=URL;
    }
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Log.i("page started", url);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Log.i("disqus error", "failed: " + failingUrl + ", error code: " + errorCode + " [" + description + "]");
    }

    public void onPageFinished(WebView view, String url) {
        if(url.indexOf("logout")>-1 || url.indexOf("disqus.com/next/login-success")>-1 ){
            view.loadData(html_comments, sType, obj);

        }
        if(url.indexOf("disqus.com/_ax/twitter/complete")>-1||url.indexOf("disqus.com/_ax/facebook/complete")>-1||url.indexOf("disqus.com/_ax/google/complete")>-1){
            view.loadData(html_comments, sType, obj);

        }
        if(url.indexOf(sMyURL+"/login.php")>-1){
            view.loadData(html_comments,sType, obj);
        }
    }
}

