package com.rafaelsf80.d4w.hotels;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Simple Fragment used to display some meaningful content for each page in the sample's
 * {@link android.support.v4.view.ViewPager}.
 */
public class ContentFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_TOTAL = "total";
    private static final String KEY_AVAILABLE= "available";
    private static final String KEY_ROOMS= "rooms";
    private static final String KEY_INDICATOR_COLOR = "indicator_color";
    private static final String KEY_DIVIDER_COLOR = "divider_color";

    /**
     * @return a new instance of {@link ContentFragment}, adding the parameters into a bundle and
     * setting them as arguments.
     */
    public static ContentFragment newInstance(CharSequence title, CharSequence description, int total, int available, CharSequence rooms, int indicatorColor,
            int dividerColor) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_TITLE, title);
        bundle.putCharSequence(KEY_DESCRIPTION, description);
        bundle.putInt(KEY_TOTAL, total);
        bundle.putInt(KEY_AVAILABLE, available);
        bundle.putCharSequence(KEY_ROOMS, rooms);
        bundle.putInt(KEY_INDICATOR_COLOR, indicatorColor);
        bundle.putInt(KEY_DIVIDER_COLOR, dividerColor);

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
  
            TextView title = (TextView) view.findViewById(R.id.description);
            title.setText(args.getCharSequence(KEY_DESCRIPTION));

            int indicatorColor = args.getInt(KEY_INDICATOR_COLOR);
//            TextView indicatorColorView = (TextView) view.findViewById(R.id.item_indicator_color);
//            indicatorColorView.setText("Indicator: #" + Integer.toHexString(indicatorColor));
//            indicatorColorView.setTextColor(indicatorColor);
            
            int total = args.getInt(KEY_TOTAL);
            TextView totalView = (TextView) view.findViewById(R.id.total);
            totalView.setText("Total: #" + Integer.toString(total));
            totalView.setTextColor(indicatorColor);
            
            int available = args.getInt(KEY_AVAILABLE);
            TextView availableView = (TextView) view.findViewById(R.id.available);
            availableView.setText("Disponibles: #" + Integer.toString(available));
            availableView.setTextColor(indicatorColor);
            
            String rooms = args.getCharSequence(KEY_ROOMS).toString();
            TextView roomsView = (TextView) view.findViewById(R.id.rooms);
            roomsView.setText("Habitaciones: " + rooms);
            roomsView.setTextColor(indicatorColor);
            
            
            int dividerColor = args.getInt(KEY_DIVIDER_COLOR);
//            TextView dividerColorView = (TextView) view.findViewById(R.id.item_divider_color);
//            dividerColorView.setText("Divider: #" + Integer.toHexString(dividerColor));
//            dividerColorView.setTextColor(dividerColor);
            
            
            
            
        }
    }
}
