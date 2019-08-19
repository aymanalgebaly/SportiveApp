package sportiveapp.compubase.com.sportiveapp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

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
public class HomeFragment extends Fragment implements OnMapReadyCallback {



    @BindView(R.id.edite_search_center)
    EditText editeSearchCenter;
    @BindView(R.id.lin_one_home)
    LinearLayout linOneHome;
    @BindView(R.id.map_frame)
    FrameLayout mapFrame;
    @BindView(R.id.rcv_home)
    RecyclerView rcvHome;
    Unbinder unbinder;

    private SupportMapFragment supportMapFragment;
    GoogleMap mgoogleMap;
    private CentersAdapter adapter;
    private int[] img;
    private String[]num,name;
    private int i;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);
        if (supportMapFragment == null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            supportMapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.frg,supportMapFragment).commit();

        }
        supportMapFragment.getMapAsync(this);

        setupRecycler();
        fetchData();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgoogleMap = googleMap;
    }

    private void setupRecycler() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvHome.setLayoutManager(linearLayoutManager);
        adapter = new CentersAdapter(getActivity());
        rcvHome.setAdapter(adapter);
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
}
