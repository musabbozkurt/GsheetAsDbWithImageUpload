package alabs.gsheetwithimage;

/**
 * Created by ADJ on 8/7/2017.
 */


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class ShowUser extends AppCompatActivity {

    String id,message,picture;
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildirim_show_user);

        id = getIntent().getExtras().getString("id");
        message = getIntent().getExtras().getString("message");
        picture = getIntent().getExtras().getString("picture");

        getView2(id,message,picture);

    }
    public void getView2(String string, String userName,String pic){
        setContentView(R.layout.bildirim_show_user);
        TextView id  = (TextView) findViewById(R.id.id);
        TextView message  = (TextView) findViewById(R.id.message);
        WebView webView  = (WebView) findViewById(R.id.webview);

        id.setText(string);
        message.setText(userName);
        webView.setVerticalScrollBarEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        webView.loadUrl(pic);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        webView.setLongClickable(false);
    }
}