package ducku.com.moneyhappy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class IconAdapter extends BaseAdapter {
    private Context mContext;
    private Integer []mThumbIds;
    public IconAdapter(Context c){
        mContext=c;
    }
    public IconAdapter(Context c,Integer []arrIds){
        mContext=c;
        mThumbIds=arrIds;
    }
    public int getCount()
    {
        return mThumbIds.length;
    }
    public Object getItem(int arg0)
    {
        return null;
    }
    public long getItemId(int arg0)
    {
        return 0;
    }
    /**
     * Cần override lại hàm này để hiển thị hình ảnh
     */
    public View getView(int arg0, View convertView, ViewGroup arg2) {
        ImageView imgView;
        if(convertView==null){
            imgView=new ImageView(mContext);
            imgView.setLayoutParams(new GridView.LayoutParams(185, 185));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8, 8, 8, 8);
        }else{
            imgView=(ImageView) convertView;
        }
        //lấy đúng vị trí hình ảnh được chọn
        //gán lại ImageResource
        imgView.setImageResource(mThumbIds[arg0]);
        return imgView;
    }
}
