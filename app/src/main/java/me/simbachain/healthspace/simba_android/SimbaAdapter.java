package me.simbachain.healthspace.simba_android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SimbaAdapter extends RecyclerView.Adapter<SimbaAdapter.SimbaViewHolder> {

    private List<GetSimba> data;
    private Context context;

    public SimbaAdapter(Context context, List<GetSimba> data) {
        this.context = context;
        this.data = data;
    }

    class SimbaViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView hashId;
        TextView auditor;

        SimbaViewHolder(View v) {
            super(v);
            mView = v;

            hashId = mView.findViewById(R.id.hashId);
            auditor = mView.findViewById(R.id.auditor);
        }
    }

    @Override
    public SimbaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new SimbaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SimbaViewHolder holder, int position) {
        holder.hashId.setText("Audit No. " + data.get(position).getAsset().getItems());
        holder.auditor.setText("Poster ID: " + data.get(position).getAuditor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
