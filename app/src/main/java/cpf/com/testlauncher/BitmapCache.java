package cpf.com.testlauncher;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2017/2/28.
 */
public class BitmapCache implements ImageLoader.ImageCache {

    private int maxSize = 4*1024*1024;

    private LruCache<String,Bitmap> mLruche;

    public BitmapCache() {
        mLruche = new LruCache<String,Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return mLruche.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        if(bitmap != null){
            mLruche.put(url,bitmap);
        }
    }
}
