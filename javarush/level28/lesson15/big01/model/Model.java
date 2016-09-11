package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlayl on 11.09.2016.
 * Zlaylink@gmail.com
 */
public class Model
{
    private View view;
    private Provider[] providers;

    public Model(View view, Provider[] providers)
    {
        if (providers == null || providers.length == 0 || view == null) throw new IllegalArgumentException();

        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) throws IOException
    {
        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider provider : providers)
        {
            vacancies.addAll(provider.getJavaVacancies(city));
        }

        view.update(vacancies);
    }

}
