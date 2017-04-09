package exp.privatebank.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import exp.privatebank.R;

public class WorkTimeAdapter extends RecyclerView.Adapter<WorkTimeAdapter.ViewHolder> {

    private List<String> mWorkTimeList;

    public WorkTimeAdapter(List<String> mWorkTimeList) {
        this.mWorkTimeList = mWorkTimeList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        ViewHolder(final View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_of_week_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        TextView dayName = (TextView) holder.view.findViewById(R.id.dayName);
        TextView workTime = (TextView) holder.view.findViewById(R.id.workTime);

        switch (position) {
            case 0:
                dayName.setText(holder.view.getResources().getString(R.string.mon));
                workTime.setText(mWorkTimeList.get(0));
                break;
            case 1:
                dayName.setText(holder.view.getResources().getString(R.string.tue));
                workTime.setText(mWorkTimeList.get(1));
                break;
            case 2:
                dayName.setText(holder.view.getResources().getString(R.string.wed));
                workTime.setText(mWorkTimeList.get(2));
                break;
            case 3:
                dayName.setText(holder.view.getResources().getString(R.string.thu));
                workTime.setText(mWorkTimeList.get(3));
                break;
            case 4:
                dayName.setText(holder.view.getResources().getString(R.string.fri));
                workTime.setText(mWorkTimeList.get(4));
                break;
            case 5:
                dayName.setText(holder.view.getResources().getString(R.string.sat));
                workTime.setText(mWorkTimeList.get(5));
                break;
            case 6:
                dayName.setText(holder.view.getResources().getString(R.string.sun));
                workTime.setText(mWorkTimeList.get(6));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mWorkTimeList.size();
    }
}
