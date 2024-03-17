package com.braulio.demoajax.service;

import com.braulio.demoajax.domain.SocialMetaTag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SocialMetaTagService {

    public SocialMetaTag getOpenGraphByUrl(String url) {
        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozzila").get();
            tag.setTitle(doc.head().select("meta[property=og:title]").attr("content"));
            tag.setSite(doc.head().select("meta[property=og:title]").attr("content"));
            tag.setImage(doc.head().select("meta[property=og:title]").attr("content"));
            tag.setUrl(doc.head().select("meta[property=og:title]").attr("content"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return tag;
    }


}
