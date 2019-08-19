package sportiveapp.compubase.com.sportiveapp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sportiveapp.compubase.com.sportiveapp.R;
import sportiveapp.compubase.com.sportiveapp.ui.adapter.ActivitiesAdapter;
import sportiveapp.compubase.com.sportiveapp.ui.adapter.CentersAdapter;
import sportiveapp.compubase.com.sportiveapp.ui.model.ActivitesModel;
import sportiveapp.compubase.com.sportiveapp.ui.model.CentersModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitiesFragment extends Fragment {


    @BindView(R.id.rcv_activities)
    RecyclerView rcvActivities;
    Unbinder unbinder;
    private ActivitiesAdapter adapter;
    private int[] img;
    private String [] txt,name,title;
    private int i;

    public ActivitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupRecycler();
        fetchData();
        return view;
    }

    private void setupRecycler() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvActivities.setLayoutManager(linearLayoutManager);
        adapter = new ActivitiesAdapter(getActivity());
        rcvActivities.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void fetchData() {
        List<ActivitesModel> activitesModels = new ArrayList<>();

        img = new int[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        txt = new String[]{"40 km", "50 km", "60 km", "30 km", "20 km", "10 km", "5 km", "70 km", "80 km"};
        name = new String[]{"name 1", "name 2", "name 3", "name 4", "name 5", "name 6", "name 7", "name 8", "name 9"};
        title = new String[]{"update", "message", "rating", "rating", "rating", "rating", "rating", "rating", "rating"};

        for (i = 0; i < img.length; i++) {
            activitesModels.add(new ActivitesModel(img[i], txt[i], name[i],title[i]));

//            ratingBar.setRating(num[i]);
        }

        adapter.setData(activitesModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
