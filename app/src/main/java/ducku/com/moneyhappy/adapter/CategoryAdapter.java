package ducku.com.moneyhappy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ducku.com.moneyhappy.R;
import ducku.com.moneyhappy.model.Category;

public class CategoryAdapter extends BaseAdapter {


    private Context context;
    private  int layout;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, int layout, List<Category> categoryList) {
        this.context = context;
        this.layout = layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        ImageView img;
        TextView txtName, txtId;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder holder;
        // get data array
        Category category = categoryList.get(i);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            // select layout Type by parentId
            if(category.get_parentId() == 0) {
                convertView = inflater.inflate(R.layout.custom_listview_category, null);
            }
            else {
                convertView = inflater.inflate(R.layout.custom_listview_subcategory, null);
            }

            holder  =  new ViewHolder();
            // ánh xạ View
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtId = (TextView) convertView.findViewById(R.id.txtId);
            holder.img = (ImageView) convertView.findViewById(R.id.imageviewImg);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }



        // gán giá trị
        holder.txtName.setText(category.get_name());
        holder.txtId.setText(category.get_id()+"");
        holder.img.setImageResource(category.get_img());

        return convertView;
    }

}
