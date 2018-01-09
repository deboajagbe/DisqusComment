package unicornheight.disquscomment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by deboajagbe on 1/9/18.
 */

public class Disqus extends AppCompatActivity {

        private WebView webDisqus;
        String disqusId;// this is the unique identification for each post
        String shortNameNow = "YOUR SHORTNAME"; // configure this on disqus.com admin section
        String sMyurl;// the url to your blog or website

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.comments);

            if (getIntent().hasExtra("DISQUS")) {
                disqusId = getIntent().getStringExtra("DISQUS");
            } else {
                Toast.makeText(getApplicationContext(), "NO disqus id", Toast.LENGTH_SHORT).show();
            }
            webDisqus = findViewById(R.id.disqus);
            String htmlComments = getHtmlComment(disqusId, shortNameNow);
            sMyurl="WEBSITE URL";
            webDisqus = findViewById(R.id.disqus);
            // set up disqus
            WebSettings webSettings2 = webDisqus.getSettings();
            webSettings2.setJavaScriptEnabled(true);
            webSettings2.setBuiltInZoomControls(true);
            webDisqus.requestFocusFromTouch();
            webDisqus.setWebViewClient(new MyWebViewClient(htmlComments, "text/html", null, sMyurl));
            webDisqus.setWebChromeClient(new WebChromeClient());
            webDisqus.loadData(htmlComments, "text/html", null);
        }



        public String getHtmlComment(String idPost, String shortName) {
            return "<div id='disqus_thread'></div>"
                    + "<script type='text/javascript'>"
                    + "var disqus_identifier = '"
                    + idPost
                    + "';"
                    + "var disqus_shortname = '"
                    + shortName
                    + "';"
                    + " (function() { var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;"
                    + "dsq.src = 'http://' + disqus_shortname + '.disqus.com/embed.js';"
                    + "(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq); })();"
                    + "</script>";

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.home) {
                finish();
            }
            return true;
        }

    }
