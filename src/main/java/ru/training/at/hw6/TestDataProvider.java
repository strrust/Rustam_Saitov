package ru.training.at.hw6;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;
import ru.training.at.hw6.entities.MetalsColorsTestData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataProvider {
    private MetalsColorsTestData[] getMetalsColorsJsonData(String filePath)
            throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(filePath));
        GsonBuilder builder = new GsonBuilder();
        Type type = new TypeToken<Map<String, MetalsColorsTestData>>() {}.getType();
        Map<String, MetalsColorsTestData> map = builder.create().fromJson(reader, type);
        return map.values().toArray(new MetalsColorsTestData[0]);
    }

    @DataProvider
    public Object[][] getMetalsColorsData() throws FileNotFoundException {
        String filePath = "src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json";
        List<Object[]> result = new ArrayList<>();
        MetalsColorsTestData[] metalsColorsData = getMetalsColorsJsonData(filePath);
        for (MetalsColorsTestData item : metalsColorsData) {
            result.add(new Object[]{item});
        }
        return result.toArray(new Object[0][0]);
    }
}
