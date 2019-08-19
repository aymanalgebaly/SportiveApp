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
import sportiveapp.compubase.com.sportiveapp.ui.model.CentersModel;

public class CentersAdapter extends RecyclerView.Adapter<CentersAdapter.ViewHolderCenters> {

    private Context context;
    private List<CentersModel>centersModelList;

    public CentersAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderCenters onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.centers_rcv_design, viewGroup, false);
        return new ViewHolderCenters(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCenters viewHolderCenters, int i) {

        CentersModel centersModel = centersModelList.get(i);

        viewHolderCenters.name.setText(centersModel.getName());
        viewHolderCenters.km.setText(centersModel.getKm());

//        Picasso.get().load(centersModel.getImg()).into(viewHolderCenters.imageView);
    }

    @Override
    public int getItemCount() {
        return centersModelList != null ? centersModelList.size():0;
    }

    public void setData(List<CentersModel> centersModels) {
        this.centersModelList = centersModels;
    }

    public class ViewHolderCenters extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,km;
        public ViewHolderCenters(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_centers_design);
            km = itemView.findViewById(R.id.txt_km);
            name = itemView.findViewById(R.id.txt_name_of_center);

        }
    }
}
