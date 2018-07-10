package smactechnology.net.bestbuyforever;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
WebView webView;
    private InterstitialAd mInterstitialAd;
    CountDownTimer countDownTimer;
class AddTimer extends CountDownTimer{

    public AddTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        Log.d("Add", "Ok.");
    }

    @Override
    public void onTick(long millisUntilFinished) {







    }

    @Override
    public void onFinish() {

    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.loadUrl("http://www.bestbuyforever.com/");
        // new  AddTimer(1000,100);
        MobileAds.initialize(MainActivity.this, "ca-app-pub-3940256099942544~3347511713");


        mInterstitialAd = new InterstitialAd(MainActivity.this);

        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
               // Log.d("Add", "Not Ok.");
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
               // Log.d("Add", "Append.");
            }

            @Override
            public void onAdClicked() {


            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
               // Log.d("Add", "Load.");
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });


        countDownTimer = new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {


            }

            @Override
            public void onFinish() {
               // Log.d("Add", "TikFinished.");
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }


            }


        }.start();
    }

}
