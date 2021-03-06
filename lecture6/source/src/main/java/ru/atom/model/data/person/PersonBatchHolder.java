package ru.atom.model.data.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Holder class.
 * Important for client - server data transfer
 */
public class PersonBatchHolder {
    private static final ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

    private List<Person> persons;

    public static PersonBatchHolder of(Person ... ps) {
        return new PersonBatchHolder(Arrays.asList(ps));
    }

    public static PersonBatchHolder of(List<Person> ps) {
        return new PersonBatchHolder(ps);
    }
    public static PersonBatchHolder readJson(String json) throws IOException {
        return mapper.readValue(json, PersonBatchHolder.class);
    }

    public String writeJson() throws JsonProcessingException {
        return mapper.writeValueAsString(this);
    }

    private PersonBatchHolder(List<Person> persons) {
        this.persons = persons;
    }

    /**
     * requested by jackson
     * */
    private PersonBatchHolder() { }

    public List<Person> getPersons() {
        return persons;
    }
}
