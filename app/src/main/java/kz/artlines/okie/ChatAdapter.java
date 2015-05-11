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
public class ChatAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp = new HashMap<String, String>();
    RelativeLayout relativeLayout;
    LinearLayout greyer;
    ImageLoader imageLoader;

    public ChatAdapter(Context context, ArrayList<HashMap<String, String>> arrayList) {
        this.context = context;
        data = arrayList;
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
        RelativeLayout white;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.chat_layout_little, parent, false);

        resultp = data.get(position);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.white);
        name=(TextView)itemView.findViewById(R.id.name);
        age=(TextView)itemView.findViewById(R.id.date);
        todo=(TextView)itemView.findViewById(R.id.last);
        address=(TextView)itemView.findViewById(R.id.status);
        white=(RelativeLayout)itemView.findViewById(R.id.white);
        if(position%2==1)
            white.setBackgroundColor(context.getResources().getColor(R.color.background));
        name.setText(resultp.get("name"));
        age.setText(resultp.get("day"));
        todo.setText(resultp.get("lastmsg"));
        if(Integer.parseInt(resultp.get("status"))==1)
            address.setVisibility(View.INVISIBLE);



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