package exp.privatebank.common;

import android.app.Fragment;

public abstract class BaseFragment extends Fragment{
    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((IHasComponent<T>)getActivity()).getComponent());
    }
}
