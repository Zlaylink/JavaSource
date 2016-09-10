package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zlayl on 04.09.2016.
 * Zlaylink@gmail.com
 */
public class Controller
{
    private Provider[] providers;


    public Controller(Provider... providers)
    {
        if (providers.length == 0)
            throw new IllegalArgumentException();

        this.providers = providers;
    }

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() throws IOException
    {
        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider provider : providers){
            for (Vacancy vacancy : provider.getJavaVacancies("Moscow"))
            {
                vacancies.add(vacancy);
            }
        }
        System.out.println(vacancies.size());
    }
}
