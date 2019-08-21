package sportiveapp.compubase.com.sportiveapp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sportiveapp.compubase.com.sportiveapp.R;
import sportiveapp.compubase.com.sportiveapp.ui.model.ActivitesModel;
import sportiveapp.compubase.com.sportiveapp.ui.model.UserActivity;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolderActities> {

    private Context context;
    private List<ActivitesModel>activitesModelList;
    private List<UserActivity>userActivityList;

    public ActivitiesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderActities onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activites_design, viewGroup, false);
        return new ViewHolderActities(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderActities viewHolderActities, int i) {

        UserActivity userActivity = userActivityList.get(i);

//        viewHolderActities.name.setText(userActivity.());
        viewHolderActities.txt.setText(userActivity.getMessage());
        viewHolderActities.title.setText(userActivity.getType());

//        Picasso.get().load(activitesModel.getImg()).into(viewHolderActities.imageView);
    }

    @Override
    public int getItemCount() {
        return userActivityList != null ? userActivityList.size():0;
    }

    public void setData(List<ActivitesModel> activitesModels) {
        this.activitesModelList = activitesModels;
    }

    public class ViewHolderActities extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,txt,title;
        public ViewHolderActities(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_activity_design);
            name = itemView.findViewById(R.id.name_center_activity);
            txt = itemView.findViewById(R.id.txt_center_activity);
            title = itemView.findViewById(R.id.title_center_activity);
        }
    }
}
