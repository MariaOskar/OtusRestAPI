package ru.yandex.dictionary.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DictionaryDefinition {
    @SerializedName("pos")
    private String partOfSpeech;
    @SerializedName("text")
    private String text;
    @SerializedName("tr")
    private List<DictionaryTranslation> translation;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public DictionaryDefinition setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
        return this;
    }

    public String getText() {
        return text;
    }

    public DictionaryDefinition setText(String text) {
        this.text = text;
        return this;
    }

    public List<DictionaryTranslation> getTranslation() {
        return translation;
    }

    public DictionaryDefinition setTranslation(List<DictionaryTranslation> translation) {
        this.translation = translation;
        return this;
    }
}