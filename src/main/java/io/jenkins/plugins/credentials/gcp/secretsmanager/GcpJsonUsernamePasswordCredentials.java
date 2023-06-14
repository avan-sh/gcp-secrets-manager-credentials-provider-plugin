package io.jenkins.plugins.credentials.gcp.secretsmanager;

import java.util.function.Supplier;

import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import java.util.Map;

import hudson.util.Secret;

public class GcpJsonUsernamePasswordCredentials extends BaseStandardCredentials
        implements StandardUsernamePasswordCredentials {

    private final Supplier<Secret> jsonSecret;
    private final String username;
    private final String password;

    public GcpJsonUsernamePasswordCredentials(String id, String description, Supplier<Secret> jsonSecret) {
        super(id, description);
        this.jsonSecret = jsonSecret;
        this.username = parseUsernamePassword(jsonSecret)[0];
        this.password = parseUsernamePassword(jsonSecret)[1];

    }

    // function to parse Json string and return username and password
    // as key value pair, or as a map
    public String[] parseUsernamePassword(Supplier<Secret> jsonString) {
        String[] usernamePassword = new String[2];
        // ObjectMapper mapper = new ObjectMapper();
        // String json = "{\"username\":\"anshul\",\"password\":\"29\"}";

        // String json = jsonString.get().getPlainText();
        // try {
        // Map<String, Object> map = mapper.readValue(json, Map.class);
        // } catch (JsonProcessingException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // for (String s : json) {
        // if (s.contains("username")) {
        // usernamePassword[0] = s.split(":")[1].replaceAll("\"", "");
        // }
        // if (s.contains("password")) {
        // usernamePassword[1] = s.split(":")[1].replaceAll("\"", "");
        // }
        // }
        usernamePassword[0] = "uname";
        usernamePassword[1] = "pswrd";
        return usernamePassword;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Secret getPassword() {
        return Secret.fromString(password);
        // return jsonSecret.get();
    }

}
