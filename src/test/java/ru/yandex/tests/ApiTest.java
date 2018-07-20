package ru.yandex.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.yandex.dictionary.api.DictionaryService;
import ru.yandex.dictionary.models.DictionaryLookupResponse;

import ru.yandex.dictionary.models.DictionaryResponseItem;
import ru.yandex.dictionary.models.DictionaryTranslation;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class ApiTest extends BaseTest{


    @Test
    public void dictionaryLangTest() {

        getLangsResponse()
                .then()
                .statusCode(200)
                .body(".", hasItem("it-it"));
    }

    @Test
    public void lookupTest() {
        Response response = getLookupResponse("ru-ru", "безнадёга");

        getJsonPath(response).prettyPrint();

        response
                .then()
                .statusCode(200)
                .body("def[0].tr[0].syn[1].text", equalTo("безвыходность"))
                .body("def[0].tr[0].syn[2].text", equalTo("отчаянность"))
                .body("def[0].tr[0].syn[0].text", equalTo("беспросветность"))
                .body("def[0].tr[0].syn.text", hasItem("отчаянность"))
        ;
    }


    @Test
    public void compareSynonymsTest() {

        Response responseOnHopelessness = getLookupResponse("en-ru","hopelessness");
        JsonPath jsonPath1 = getJsonPath(responseOnHopelessness);
        jsonPath1.prettyPrint();

        Response responseOnHelplessness = getLookupResponse("en-ru","helplessness");
        JsonPath jsonPath2 = getJsonPath(responseOnHelplessness);
        jsonPath2.prettyPrint();

        DictionaryLookupResponse dictionaryLookupResponse = jsonPath1.getObject(".", DictionaryLookupResponse.class);

        DictionaryTranslation translation = jsonPath2.getObject("def[0].tr[1]",DictionaryTranslation.class);

        assertThat(dictionaryLookupResponse.getDefinition().get(0).getTranslation().get(0).getSynonyms())
                .containsAnyElementsOf(translation.getSynonyms());

    }

    @Test
    public void retrofitTest() throws IOException {

        DictionaryService service = getRetrofit().create(DictionaryService.class);

        DictionaryLookupResponse response = service.lookup(DICT_API_KEY,"hopelessness","en-ru").execute().body();

        List<DictionaryResponseItem> synonyms = response.getDefinition().get(0).getTranslation().get(0).getSynonyms();

        assertThat(synonyms).allMatch( (item) -> { return item.getText()!=null;});

        assertThat(synonyms).extracting("text")
                .contains("безысходность","безвыходность","отчаяние","бесперспективность","обреченность","беспомощность")
                .doesNotContain("радость", "счастье", "везение", "удача", "смысл", "пощада", "выход");

    }


}