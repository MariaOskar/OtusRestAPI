package ru.yandex.dictionary.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DictionaryExample {
    @SerializedName("text")
    private String text;
    @SerializedName("tr")
    private List<DictionaryResponseItem> translation;

    public String getText() {
        return text;
    }

    public DictionaryExample setText(String text) {
        this.text = text;
        return this;
    }

    public List<DictionaryResponseItem> getTranslation() {
        return translation;
    }

    public DictionaryExample setTranslation(List<DictionaryResponseItem> translation) {
        this.translation = translation;
        return this;
    }
}