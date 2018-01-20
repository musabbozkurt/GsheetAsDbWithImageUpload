package alabs.gsheetwithimage;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class UserListAdapter extends ArrayAdapter<String> {
    private String[] uId;
    private String[] uNames;
    private String[] uImages;
    private Activity context;

    public UserListAdapter(Activity context, String[] uId, String[] uNames, String[] uImages) {
        super(context, R.layout.bildirim_list_row, uId);
        this.context = context;
        this.uId = uId;
        this.uNames = uNames;
        this.uImages = uImages;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.bildirim_list_row, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.tv_uid);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.tv_uname);
        ImageView iv = (ImageView)listViewItem.findViewById(R.id.imageView3);


        textViewId.setText(uId[position]);
        textViewName.setText(uNames[position]);
       // Uri uri = Uri.parse(uImages[position]);
        //Uri uri = Uri.parse("https://drive.google.com/uc?id=0B___GhMLUVtOY09SbDU5cDU2T1U");
       // draweeView.setImageURI(uri);

        Picasso.with(context).load(uImages[position]).into(iv);

        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ShowUser.class);
                intent.putExtra("id",uId[position]);
                intent.putExtra("message",uNames[position]);
                intent.putExtra("picture",uImages[position]);
                context.startActivity(intent);
            }
        });
        return listViewItem;
    }
}