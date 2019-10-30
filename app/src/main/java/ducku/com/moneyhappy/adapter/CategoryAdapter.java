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

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // get data array
        Category category = categoryList.get(i);

        // select layout Type by parentId
        if(category.get_parentId() == 0) {
            convertView = inflater.inflate(R.layout.custom_listview_category, null);
        }
        else {
            convertView = inflater.inflate(R.layout.custom_listview_subcategory, null);
        }

        // ánh xạ View
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtId = (TextView) convertView.findViewById(R.id.txtId);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageviewImg);


        // gán giá trị
        txtName.setText(category.get_name());
        txtId.setText(category.get_id()+"");
        img.setImageResource(category.get_img());

        return convertView;
    }

}
