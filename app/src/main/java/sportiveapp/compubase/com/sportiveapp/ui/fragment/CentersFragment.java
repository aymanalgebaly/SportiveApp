package sportiveapp.compubase.com.sportiveapp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import sportiveapp.compubase.com.sportiveapp.ui.adapter.CentersAdapter;
import sportiveapp.compubase.com.sportiveapp.ui.model.CentersModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CentersFragment extends Fragment {


    @BindView(R.id.rcv_centers)
    RecyclerView rcvCenters;
    Unbinder unbinder;
    private CentersAdapter adapter;
    private int[] img;
    private String[] num,name;
    private int i;

    public CentersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_centers, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupRecycler();
        fetchData();
        return view;
    }

    private void setupRecycler() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvCenters.setLayoutManager(linearLayoutManager);
        adapter = new CentersAdapter(getActivity());
        rcvCenters.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<CentersModel> centersModels = new ArrayList<>();

        img = new int[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        num = new String[]{"40 km", "50 km", "60 km", "30 km", "20 km", "10 km", "5 km", "70 km", "80 km"};
        name = new String[]{"name 1", "name 2", "name 3", "name 4", "name 5", "name 6", "name 7", "name 8", "name 9"};

        for ( i = 0; i <img.length ; i++) {
            centersModels.add(new CentersModel(img[i],num[i],name[i]));

//            ratingBar.setRating(num[i]);
        }

        adapter.setData(centersModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
