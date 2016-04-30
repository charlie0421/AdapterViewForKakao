package com.ironlove.adapterviewforkakao;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by lineplay on 16. 4. 30..
 */
public class ImageParseFromGettyImageTask extends AsyncTask<String, Void, ArrayList<GettyImage>> {

    ProgressDialog progress;
    private BaseActivity activity;

    public ImageParseFromGettyImageTask(BaseActivity activity) {
        this.activity = activity;
        progress = new ProgressDialog(activity);
        progress.setMessage("파싱중");

    }

    public void onPreExecute() {
        progress.show();
    }

    @Override
    protected ArrayList<GettyImage> doInBackground(String... strings) {

        ArrayList<GettyImage> list = new ArrayList<GettyImage>();

        try {
            Document doc = Jsoup.connect(strings[0]).get();
            Uri uri = Uri.parse(strings[0]);
            String path = uri.getScheme() + "://" + uri.getHost();
            String title = doc.title();
            Log.d(ListView01Activity.TAG, "Title [" + title + "]");

            Elements elements = doc.select(".gallery-item-group.exitemrepeater");
            for (Element element : elements) {
                GettyImage item = new GettyImage();
                Element ePicture = element.select("a .picture").first();
                Element eCaption = element.select(".gallery-item-caption > p > a").first();
                item.strURL = path + ePicture.attr("src");
                item.strCaption = eCaption.text();
                list.add(item);

            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        Log.d(ListView01Activity.TAG, "파싱완료");

        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<GettyImage> list) {
        super.onPostExecute(list);
        progress.dismiss();
        Toast.makeText(activity, "HTML 파싱 완료", Toast.LENGTH_SHORT).show();
        activity.mListData.addAll(list);
        activity.mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        progress.dismiss();
    }
}
