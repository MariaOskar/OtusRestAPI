package ru.yandex.dictionary.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DictionaryLookupResponse {
    @SerializedName("head")
    private Object head;
    @SerializedName("def")
    private List<DictionaryDefinition> definition;

    public Object getHead() {
        return head;
    }

    public DictionaryLookupResponse setHead(Object head) {
        this.head = head;
        return this;
    }

    public List<DictionaryDefinition> getDefinition() {
        return definition;
    }

    public DictionaryLookupResponse setDefinition(List<DictionaryDefinition> definition) {
        this.definition = definition;
        return this;
    }
}