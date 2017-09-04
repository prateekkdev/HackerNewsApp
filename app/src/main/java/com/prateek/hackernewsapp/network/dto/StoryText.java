package com.prateek.hackernewsapp.network.dto;

import java.util.List;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class StoryText {

    private String value;
    private String matchLevel;
    private List<String> matchedWords = null;
    private Boolean fullyHighlighted;

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

    public List<String> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(List<String> matchedWords) {
        this.matchedWords = matchedWords;
    }

    public Boolean getFullyHighlighted() {
        return fullyHighlighted;
    }

    public void setFullyHighlighted(Boolean fullyHighlighted) {
        this.fullyHighlighted = fullyHighlighted;
    }

}