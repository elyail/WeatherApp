package com.example.gabdullinae.wheatherapplication.mainactivity.citylist;

/**
 * Created by Elvira Gabdullina
 * on 25.08.17, 14:18.
 */

class CityListPresenter {
    private CityListView view;

    CityListPresenter(CityListView view) {
        this.view = view;
    }

    void getCities() {
        view.getCities();
    }
}
