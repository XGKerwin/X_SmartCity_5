package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.Fragment.fuwu.Fragment_fuwu_bashi;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.BusList;
import com.example.x_smartcity_5.bean.BusStationById;

import java.util.List;
import java.util.Map;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  10:30
 */
public class Fuwu_bashi_Eadaper extends BaseExpandableListAdapter {
    private Map<BusList, List<BusStationById>> map;
    private List<BusList> busLists;
    private FragmentActivity activity;

    public Fuwu_bashi_Eadaper(Map<BusList, List<BusStationById>> map, List<BusList> busLists, FragmentActivity activity) {
        this.map = map;
        this.busLists = busLists;
        this.activity = activity;
    }

    @Override
    public int getGroupCount() {
        return busLists.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderFu holderFu;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_bashi, parent, false);
            holderFu = new ViewHolderFu(convertView);
            convertView.setTag(holderFu);
        } else {
            holderFu = (ViewHolderFu) convertView.getTag();
        }
        BusList busTitle = busLists.get(groupPosition);
        holderFu.itemName.setText(busTitle.getPathName());
        holderFu.itemLine.setText(busTitle.getStartSite() + "--" + busTitle.getEndSite());
        holderFu.itemMsg.setText("票价：￥" + busTitle.getPrice() + ".0    里程：" + busTitle.getMileage() + ".0km");
        holderFu.itemStart.setText(busTitle.getRunTime1());
        holderFu.itemEnd.setText(busTitle.getRunTime2());
        if (isExpanded){
            holderFu.itemIv.setImageResource(R.drawable.xiajiantou);
        }else {
            holderFu.itemIv.setImageResource(R.drawable.youjiantou);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_bashi_zi, parent, false);
        TextView itemName = convertView.findViewById(R.id.item_name);
        List<BusStationById> busDetails = map.get(busLists.get(groupPosition));
        String str = "";
        for (int i = 0; i < busDetails.size(); i++) {
            if (i == 0) {
                str = busDetails.get(i).getSiteName();
            } else {
                str += "\r\n" + busDetails.get(i).getSiteName();
            }
        }
        itemName.setText(str);

        itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_bashi1(busLists.get(groupPosition)));
            }
        });


        return convertView;
    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home,fragment).commit();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    class ViewHolderFu {
        private TextView itemName;
        private TextView itemLine;
        private TextView itemMsg;
        private TextView itemStart;
        private TextView itemEnd;
        private ImageView itemIv;

        public ViewHolderFu(View view) {
            itemName = view.findViewById(R.id.item_name);
            itemLine = view.findViewById(R.id.item_line);
            itemMsg = view.findViewById(R.id.item_msg);
            itemStart = view.findViewById(R.id.item_start);
            itemEnd = view.findViewById(R.id.item_end);
            itemIv = view.findViewById(R.id.item_iv);
        }
    }
}
