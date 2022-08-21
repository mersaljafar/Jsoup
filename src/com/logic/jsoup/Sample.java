package com.logic.jsoup;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Sample {
    public static void main(String[] args) {
        try {
            HashMap<String, List<String>> metaData = new HashMap<String,List<String>>();
            Document siteData = Jsoup.connect("https://www.indiatoday.in/")
            .get();
            metaData.put("SiteHeader", getSiteHeader(siteData));
            metaData.put("FlashNews",getFlashNews(siteData));
            metaData.put("TopStories",getTopStories(siteData));
            FileWriter myWriter = new FileWriter("WebContent\\Index.html");
            myWriter.write(siteData.html());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getSiteHeader (Document data){
        Elements content = data.getElementsByClass("top-hed-menu");
        Elements values = content.first().getElementsByTag("a");
        return values.eachText();
    }
    public static List<String> getFlashNews (Document data){
        Elements content = data.getElementsByClass("featured-news");
        Elements values = content.first().getElementsByTag("a");
        return values.eachText();
    }
    public static List<String> getTopStories (Document data){
        Elements content = data.getElementsByClass("widget-wrapper top_stories_ordering");
        Elements values = content.first().getElementsByTag("a");
        return values.eachText();
    }
}
