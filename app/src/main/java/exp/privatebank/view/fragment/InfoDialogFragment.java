package exp.privatebank.view.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import exp.privatebank.R;
import exp.privatebank.pojo.DevicesPOJO.Device;
import exp.privatebank.view.activity.DetailMapsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoDialogFragment extends DialogFragment {

    public static final String DEVICE = "device";
    public static final String INFO_TAG = "infoTag";
    private Device mDevice;

    private DetailMapsActivity.InfoDetailListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info_dialog, container, false);

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        Bundle bundleArguments = getArguments();
        mDevice = bundleArguments.getParcelable(DEVICE);

        TextView typeAnswer = (TextView) v.findViewById(R.id.typeAnswer);
        typeAnswer.setText(mDevice.getType());
        TextView cityAnswer = (TextView) v.findViewById(R.id.cityAnswer);
        cityAnswer.setText(mDevice.getCityRU());
        TextView placeAnswer = (TextView) v.findViewById(R.id.placeAnswer);
        placeAnswer.setText(mDevice.getPlaceRu());
        TextView addressAnswer = (TextView) v.findViewById(R.id.addressAnswer);
        addressAnswer.setText(mDevice.getFullAddressRu());

        Button cancelBtn = (Button) v.findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        Button confirmBtn = (Button) v.findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mListener.routeConfirm(mDevice);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                dismiss();
            }
        });

        return v;
    }

    public void setListener(DetailMapsActivity.InfoDetailListener mListener) {
        this.mListener = mListener;
    }
}
