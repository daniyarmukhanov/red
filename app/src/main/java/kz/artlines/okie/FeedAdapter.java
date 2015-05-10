package kz.artlines.okie;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Doszhan on 05.02.2015.
 */
public class FeedAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp = new HashMap<String, String>();
    RelativeLayout relativeLayout;
    LinearLayout greyer;
    String type;
    ImageLoader imageLoader;

    public FeedAdapter(Context context, ArrayList<HashMap<String, String>> arrayList, String type) {
        this.context = context;
        data = arrayList;
        this.type = type;
        imageLoader=new ImageLoader(context);
    }

    @Override
    public int getCount() {
        return data.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView name, age, todo, address, time;
        final ImageView image;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.feed_layout_little, parent, false);

        resultp = data.get(position);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.white);
        name=(TextView)itemView.findViewById(R.id.name);
        age=(TextView)itemView.findViewById(R.id.age);
        todo=(TextView)itemView.findViewById(R.id.todo);
        address=(TextView)itemView.findViewById(R.id.address);
        time=(TextView)itemView.findViewById(R.id.time);
        name.setText(resultp.get("name")+", ");
        age.setText(resultp.get("age")+" лет");
        todo.setText(resultp.get("todo"));
        address.setText(resultp.get("address"));
        time.setText(resultp.get("time"));



        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resultp = data.get(position);
//                Intent intent = new Intent(context, NewsViewer.class);
//                intent.putExtra("id", resultp.get("text"));
//                intent.putExtra("title", resultp.get("title"));
//                intent.putExtra("photo", resultp.get("photo"));
//                intent.putExtra("res_id", resultp.get("source"));
//
//                String resource_id = resultp.get("source");
//                intent.putExtra("source", resource_id);
//                intent.putExtra("date", resultp.get("date"));
//                intent.putExtra("type", type);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        });
        return itemView;
    }
}