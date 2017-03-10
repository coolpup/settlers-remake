package jsettlers.main.android.gameplay.presenters;

import android.app.Activity;

import jsettlers.main.android.core.GameManager;
import jsettlers.main.android.core.controls.ControlsAdapter;
import jsettlers.main.android.core.utils.Dispatcher;
import jsettlers.main.android.gameplay.navigation.MenuNavigatorProvider;
import jsettlers.main.android.gameplay.navigation.MenuNavigator;
import jsettlers.main.android.gameplay.ui.views.SettlersSoldiersView;

/**
 * Created by tompr on 10/03/2017.
 */

public class MenuFactory {
    private final ControlsAdapter controlsAdapter;
    private final MenuNavigator menuNavigator;

    public MenuFactory(Activity activity) {
        this.controlsAdapter = ((GameManager)activity.getApplication()).getControlsAdapter();
        this.menuNavigator = ((MenuNavigatorProvider)activity).getMenuNavigator();
    }

    public BuildingsMenu buildingsMenu() {
        return new BuildingsMenu(controlsAdapter, menuNavigator);
    }

    public SettlersSoldiersMenu settlersSoldiersMenu(SettlersSoldiersView view) {
        return new SettlersSoldiersMenu(view, controlsAdapter, controlsAdapter, controlsAdapter.getInGamePlayer(), new Dispatcher());
    }
}
