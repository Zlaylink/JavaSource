package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zlayl on 11.09.2016.
 * Zlaylink@gmail.com
 */
public class HtmlView implements View
{
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";

    private Controller controller;

    protected Document getDocument() throws IOException
    {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() throws IOException
    {
        controller.onCitySelect("Днепропетровск");
    }


    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {
        Document document = getDocument();
        Element element = document.getElementsByClass("template").first();

        Element pattern = element.clone();

        pattern.removeAttr("style");
        pattern.removeClass("template");

        document.getElementsByAttributeValue("class", "vacancy").remove();

        for (Vacancy vacancy : vacancies)
        {
            Element vacancyPatter = pattern.clone();
            vacancyPatter.getElementsByClass("city").get(0).text(vacancy.getCity());
            vacancyPatter.getElementsByClass("companyName").get(0).text(vacancy.getCompanyName());
            vacancyPatter.getElementsByClass("salary").get(0).text(vacancy.getSalary());
            vacancyPatter.getElementsByTag("a").get(0).attr("href", vacancy.getUrl()).text(vacancy.getTitle());
            element.before(vacancyPatter.outerHtml());
        }
        return document.html();
    }

    private void updateFile(String data) throws IOException
    {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(data);
        fileWriter.close();
    }
}
