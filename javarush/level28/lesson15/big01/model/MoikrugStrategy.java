package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlayl on 11.09.2016.
 * Zlaylink@gmail.com
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://moikrug.ru/vacancies?page=%d&q=java+%s";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36";
    private static final String REFERRER = "";
    //private static final int TIMEOUT = 5000;

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException
    {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        try
        {
            while (true)
            {
                Document document = getDocument(searchString, page);
                Elements elements = document.select("[class=job]");
                if (elements.isEmpty()) break;

                for (Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.select("[class=title]").text());
                    vacancy.setCity(element.select("[class=location]").text());
                    Element companyName = element.select("[class=company_name]").select("a").first();
                    vacancy.setCompanyName(companyName != null ? companyName.text() : "");
                    vacancy.setSiteName("http://moikrug.ru");
                    vacancy.setUrl("http://moikrug.ru" + element.select("[class=title").select("a").attr("href"));
                    Element salary = element.select("[class=salary]").first();
                    vacancy.setSalary(salary != null ? salary.text() : "");

                    vacancies.add(vacancy);
                }
                page++;
            }
        }
        catch (IOException ignored)
        {
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {

        String URL = String.format(URL_FORMAT, page, URLEncoder.encode(searchString, "UTF-8"));
        return Jsoup.connect(URL).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}
