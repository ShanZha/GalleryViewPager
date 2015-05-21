package it.moondroid.galleryviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DummyFragment extends Fragment {

    private static final String ARG_TEXT = "ARG_TEXT";
    private String mText;

    public static DummyFragment newInstance(String text) {
        DummyFragment fragment = new DummyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    public DummyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && !TextUtils.isEmpty(getArguments().getString(ARG_TEXT))) {
            mText = getArguments().getString(ARG_TEXT);
        } else {
            mText = "";
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dummy, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.text);
        textView.setText(mText);

        return rootView;
    }


}
