package me.simbachain.healthspace.simba_android;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import org.apache.commons.logging.Log;

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
        RelativeLayout parentLayout;

        SimbaViewHolder(View v) {
            super(v);
            mView = v;

            hashId = mView.findViewById(R.id.hashId);
            auditor = mView.findViewById(R.id.auditor);
            parentLayout = v.findViewById(R.id.parent_layout);
        }
    }

    @Override
    public SimbaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new SimbaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SimbaViewHolder holder, final int position) {
        holder.hashId.setText("Audit No. " + data.get(position).getHashIdInString());
        holder.auditor.setText("Poster ID: " + data.get(position).getAuditor());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AuditGalleryActivity.class);
                intent.putExtra("audit_no", data.get(position).getHashId());
                intent.putExtra("ipfc", data.get(position).getHash());
                intent.putExtra("verified", data.get(position).getVerified());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
