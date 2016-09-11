package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

import java.io.IOException;

/**
 * Created by Zlayl on 04.09.2016.
 * Zlaylink@gmail.com
 */
public class Aggregator
{
    private static Provider[] providers = new Provider[]{new Provider(new HHStrategy()), new Provider(new MoikrugStrategy())};
    private static HtmlView htmlView = new HtmlView();
    private static Model model = new Model(htmlView, providers);
    private static Controller controller = new Controller(model);

    public static void main(String[] args) throws IOException
    {
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();
    }
}
