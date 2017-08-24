package testing.harris.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Apath on 8/24/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mItemList;

    public static class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView mItemTextView;

        public RecyclerItemViewHolder(final View parent, TextView mItemTextView) {
            super(parent);
            this.mItemTextView = mItemTextView;
        }

        public static RecyclerItemViewHolder newInstance(View parent) {
            TextView itemTextView = (TextView) parent.findViewById(R.id.itemTextView);
            return new RecyclerItemViewHolder(parent, itemTextView);
        }

        public void setmItemTextView(CharSequence text) {
            mItemTextView.setText(text);
        }
    }

    public RecyclerAdapter(List<String> itemList) {
        mItemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return RecyclerItemViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerItemViewHolder mHolder = (RecyclerItemViewHolder) holder;
        String itemText = mItemList.get(position);
        mHolder.setmItemTextView(itemText);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }
}
