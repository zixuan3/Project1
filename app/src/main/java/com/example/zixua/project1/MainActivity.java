package com.example.zixua.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//public class MainActivity extends AppCompatActivity {
//    private static final String TAG = "FinalProject:Main";
//    /**
//     * dfdfdfdfdf.
//     */
////    private static final String STR = "faa727bab1930c706d60e0e7abfb625a";
//    private static final String STR = " b016ae9dde8191e7272cf40829a7f841";
//    /** Request queue for our API requests. */
//    private static RequestQueue requestQueue;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        final ImageButton startProject = findViewById(R.id.imageButton);
//        startProject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "imageButtonClicked");
//                startAPICall();
//            }
//        });
//        setContentView(R.layout.activity_main);
//    }
//    /**
//     * Make a call to the weather API.
//     */
//    void startAPICall() {
//        try {
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                    Request.Method.GET,
//                    "https://yesno.wtf/api",
//                    null,
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(final JSONObject response) {
//                            try {
//                                Log.d(TAG, response.toString(2));
//                                TextView tv = (TextView) findViewById(R.id.textView);
//                                tv.setText(response.toString(2));
//                            } catch (JSONException ignored) { }
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(final VolleyError error) {
//                    Log.e(TAG, error.toString());
//                }
//            });
//            requestQueue.add(jsonObjectRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
public final class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Lab12:Main";
    /**
     * dfdfdfdfdf.
     */
//    private static final String STR = "faa727bab1930c706d60e0e7abfb625a";
    private static final String STR = " b016ae9dde8191e7272cf40829a7f841";
    /** Request queue for our API requests. */
    private static RequestQueue requestQueue;

    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up the queue for our API requests
        requestQueue = Volley.newRequestQueue(this);

        setContentView(R.layout.activity_main);

        final Button openFile = findViewById(R.id.button);
        openFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "button clicked");
//                Toast.makeText(getApplicationContext(), "Problem taking photo",
//                        Toast.LENGTH_LONG).show();
                startAPICall();
            }
        });
    }

    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Make a call to the weather API.
     */
    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://yesno.wtf/api",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            try {
                                Log.d(TAG, response.toString(2));
//                                TextView tv = (TextView) findViewById(R.id.textView);
//                                tv.setText(response.toString(2));
//                                tv.setText("text------");
                                WebView wv = (WebView) findViewById(R.id.webview);
                                wv.loadUrl(parseJson(response));
                            } catch (JSONException ignored) { }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.e(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String parseJson(JSONObject response) {
        String str = response.toString();
        JsonParser parser = new JsonParser();
        JsonObject ret = parser.parse(str).getAsJsonObject();
//        String answer = ret.get("answer").getAsString();
//        String forced = ret.get("forced").getAsString();
        String image = ret.get("image").getAsString();
        return image;
    }
}
