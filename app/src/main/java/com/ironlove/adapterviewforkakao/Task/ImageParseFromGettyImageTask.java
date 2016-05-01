package com.ironlove.adapterviewforkakao.Task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.ironlove.adapterviewforkakao.Activity.AdapterViewBaseActivity;
import com.ironlove.adapterviewforkakao.Activity.RecylerViewBaseActivity;
import com.ironlove.adapterviewforkakao.Item.GettyImage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ImageParseFromGettyImageTask extends AsyncTask<String, Void, ArrayList<GettyImage>> {
    private final String TAG = getClass().getName();
    private final ProgressDialog progress;
    private final Activity activity;

    public ImageParseFromGettyImageTask(AdapterViewBaseActivity activity) {
        this.activity = activity;
        progress = new ProgressDialog(activity);
        progress.setMessage("파싱중");

    }

    public ImageParseFromGettyImageTask(RecylerViewBaseActivity activity) {
        this.activity = activity;
        progress = new ProgressDialog(activity);
        progress.setMessage("파싱중");

    }

    public void onPreExecute() {
        progress.show();
    }

    @Override
    protected ArrayList<GettyImage> doInBackground(String... strings) {

        ArrayList<GettyImage> list = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(strings[0]).get();
            Uri uri = Uri.parse(strings[0]);
            String path = uri.getScheme() + "://" + uri.getHost();
            String title = doc.title();
            Log.d(TAG, "Title [" + title + "]");

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
        Log.d(TAG, "파싱완료");

        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<GettyImage> list) {
        super.onPostExecute(list);
        progress.dismiss();
        Toast.makeText(activity, "HTML 파싱 완료", Toast.LENGTH_SHORT).show();
        if (activity instanceof AdapterViewBaseActivity) {
            ((AdapterViewBaseActivity) activity).mListData.clear();
            ((AdapterViewBaseActivity) activity).mListData.addAll(list);
            ((AdapterViewBaseActivity) activity).mArrayAdapter.notifyDataSetChanged();
        } else if (activity instanceof RecylerViewBaseActivity) {
            ((RecylerViewBaseActivity) activity).mListData.clear();
            ((RecylerViewBaseActivity) activity).mListData.addAll(list);
            ((RecylerViewBaseActivity) activity).mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        progress.dismiss();
    }
}
