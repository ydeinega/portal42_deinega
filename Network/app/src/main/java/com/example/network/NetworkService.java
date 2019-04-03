package com.example.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import com.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService mInstance;
    //private static final String BASE_URL = "https://api.intra.42.fr";
    public static final String BASE_URL = "https://api.intra.42.fr";
    public static final String BASE_DOWNLOAD_URL = "https://profile.intra.42.fr";
    public static final String UID = "2e120f4810813f0538e9579eebb7d07e0a3c5ff29d156e7a531f9b4ad3d7f800";
    public static final String SECRET = "2fb0d2cec13aa3e0a14c57446055fc35b1eb05b0dbee3b1f847a560c5238045d";
    public static Token oauthToken = null;
    public static String TOKEN = null;

    private Retrofit mRetrofit;
    private Retrofit newRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public Intra42Api getIntra42Api() {
        return mRetrofit.create(Intra42Api.class);
    }

    public Api42 getApi42() {
        return newRetrofit.create(Api42.class);
    }

    public void initToken(Token token) {
        NetworkService.oauthToken = token;
        NetworkService.TOKEN = oauthToken.getAccessToken();

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + NetworkService.TOKEN)
                        .build();

                return chain.proceed(newRequest);
            }
        }).build();

        newRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {

                //URL url = new URL(BASE_DOWNLOAD_URL + urls[0]);
                Log.i("URL", BASE_DOWNLOAD_URL + urls[0]);
                URL url = new URL(urls[0]);
                //InputStream in = new java.net.URL(urls[0]).openStream();


                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.connect();
                InputStream in = httpURLConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                //in.close();
                return bitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public Bitmap downloadImage(String url) {

        ImageDownloader task = new ImageDownloader();
        Bitmap bitmap;
        try {
            bitmap = task.execute(url).get();
            return bitmap;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

/*
    private class SvgImageDownloader extends AsyncTask<String, Void, Drawable> {

        @Override
        protected Drawable doInBackground(String... urls) {

            Log.i("URL", BASE_DOWNLOAD_URL + urls[0]);

            try {
                URL url = new URL(BASE_DOWNLOAD_URL + urls[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.connect();
                InputStream in = httpURLConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                SVG svg = SVGParser.getSVGFromInputStream(in);
                Drawable drawable = svg.createPictureDrawable();
                return drawable;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public Drawable downloadSvgImage(String url) {

        SvgImageDownloader task = new SvgImageDownloader();

        try {
            Drawable drawable = task.execute(url).get();
            return drawable;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
    */





















}
