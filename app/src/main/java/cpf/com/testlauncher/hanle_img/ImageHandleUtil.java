package cpf.com.testlauncher.hanle_img;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * 图像处理工具类
 */

public class ImageHandleUtil {

    /**
     * 使用API处理图像的色调。饱和度、亮度
     * @param bitmap 待处理图片
     * @param hue 色调值
     * @param stuation 饱和度值
     * @param lum 亮度值
     * @return 处理完成的图片
     */
    public static Bitmap apiHanleImag(Bitmap bitmap,float hue,float stuation,float lum){

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueColorMatrix = new ColorMatrix();
        hueColorMatrix.setRotate(0,hue);//0代表红色
        hueColorMatrix.setRotate(1,hue);//1代表绿色
        hueColorMatrix.setRotate(2,hue);//0代表蓝色

        ColorMatrix stuationColorMatrix = new ColorMatrix();
        stuationColorMatrix.setSaturation(stuation);

        ColorMatrix lumColorMatrix = new ColorMatrix();
        lumColorMatrix.setScale(lum,lum,lum,1);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.postConcat(hueColorMatrix);
        colorMatrix.postConcat(stuationColorMatrix);
        colorMatrix.postConcat(lumColorMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bitmap,0,0,paint);

        return bmp;

    }

    /**
     * 使用图像矩阵处理图像
     * @param bitmap 待处理图片
     * @param values 矩阵值
     * @return 处理完成的图片
     */
    public static Bitmap matrixHanleImag(Bitmap bitmap,float[] values){

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix colorMatrix = new ColorMatrix();

        colorMatrix.set(values);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bitmap,0,0,paint);

        return bmp;
    }

    /**
     * 实现图片的底片效果
     * @param bitmap 图片
     * @return 底片效果
     */
    public static Bitmap pixelHandleImgToDiPian(Bitmap bitmap){

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        int color;

        int r,g,b,a;

        int oldPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        int newPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        bitmap.getPixels(oldPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        for(int i = 0; i < oldPixels.length; i ++){
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //图片底片效果的算法
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
            if(r > 255){
                r = 255;
            }
            if(g > 255){
                g = 255;
            }
            if(b > 255){
                b = 255;
            }
            //合成新的像素
            newPixels[i] = Color.argb(a,r,g,b);
        }

        bmp.setPixels(newPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        return bmp;

    }

    /**
     * 实现图片的老照片效果
     * @param bitmap 图片
     * @return 老照片效果
     */
    public static Bitmap pixelHandleImgTofugu(Bitmap bitmap){

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        int color;

        int r,g,b,a,r1,g1,b1;

        int oldPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        int newPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        bitmap.getPixels(oldPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        for(int i = 0; i < oldPixels.length; i ++){
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //图片底片效果的算法
            r1 = (int)(0.393 * r + 0.769 * g + 0.189 * b);
            g1 = (int)(0.349 * r + 0.686 * g + 0.168 * b);
            b1 = (int)(0.272 * r + 0.534 * g + 0.131 * b);
            if(r1 > 255){
                r1 = 255;
            }
            if(g1 > 255){
                g1 = 255;
            }
            if(b1 > 255){
                b1 = 255;
            }
            //合成新的像素
            newPixels[i] = Color.argb(a,r1,g1,b1);
        }

        bmp.setPixels(newPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        return bmp;

    }

    /**
     * 实现图片的浮雕效果
     * @param bitmap 图片
     * @return 浮雕效果
     */
    public static Bitmap pixelHandleImgTofudiao(Bitmap bitmap){

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        int color,nextcolor;

        int r,g,b,a,nr,ng,nb;

        int oldPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        int newPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        bitmap.getPixels(oldPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        for(int i = 1; i < oldPixels.length; i ++){
            nextcolor = oldPixels[i];
            color = oldPixels[i-1];
            nr = Color.red(nextcolor);
            ng = Color.green(nextcolor);
            nb = Color.blue(nextcolor);
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //图片浮雕效果的算法
            r = (int)(nr - r + 128);
            g = (int)(ng - g + 128);
            b = (int)(nb - b + 128);
            if(r > 255){
                r = 255;
            }
            if(g > 255){
                g = 255;
            }
            if(b > 255){
                b = 255;
            }
            //合成新的像素
            newPixels[i] = Color.argb(a,r,g,b);
        }

        bmp.setPixels(newPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        return bmp;

    }

    /**
     * 实现灰度
     * @param bitmap 图片
     * @return 灰度效果
     */
    public static Bitmap pixelHandleImgToGrey(Bitmap bitmap){

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        int color;

        int r,g,b,a;

        int oldPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        int newPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        bitmap.getPixels(oldPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        for(int i = 0; i < oldPixels.length; i ++){
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //图片灰度效果的算法
            r = (int)(r * 0.3 + g * 0.59 + b * 0.11);
            g = (int)(r * 0.3 + g * 0.59 + b * 0.11);
            b = (int)(r * 0.3 + g * 0.59 + b * 0.11);
            if(r > 255){
                r = 255;
            }
            if(g > 255){
                g = 255;
            }
            if(b > 255){
                b = 255;
            }
            //合成新的像素
            newPixels[i] = Color.argb(a,r,g,b);
        }

        bmp.setPixels(newPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        return bmp;

    }

    /**
     * 实现黑白效果
     * @param bitmap 图片
     * @return 黑白效果
     */
    public static Bitmap pixelHandleImgToBlackWheight(Bitmap bitmap){

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        int color;

        int r,g,b,a;

        int avg;

        int oldPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        int newPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];

        bitmap.getPixels(oldPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        for(int i = 0; i < oldPixels.length; i ++){
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //图片黑白效果的算法
            avg = (r + g + b)/3;//平均值
            if(avg >= 128){ //100位经验值，也可以为128
                r = g = b = 255;
            }else{
                r = g = b = 0;
            }
            //合成新的像素
            newPixels[i] = Color.argb(a,r,g,b);
        }

        bmp.setPixels(newPixels,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

        return bmp;

    }

}
