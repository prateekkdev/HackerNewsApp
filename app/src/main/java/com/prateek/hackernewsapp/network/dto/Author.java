package com.prateek.hackernewsapp.network.dto;

import java.util.List;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class Author {

    private String value;
    private String matchLevel;
    private List<Object> matchedWords = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }

    public List<Object> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(List<Object> matchedWords) {
        this.matchedWords = matchedWords;
    }

}