package io.jenkins.plugins.credentials.gcp.secretsmanager;

import java.util.function.Supplier;

import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.logging.Logger;

import hudson.util.Secret;

public class GcpJsonUsernamePasswordCredentials extends BaseStandardCredentials
        implements StandardUsernamePasswordCredentials {

    private static final Logger LOGGER = Logger.getLogger(GcpJsonUsernamePasswordCredentials.class.getName());

    private final String username;
    private final String password;

    public GcpJsonUsernamePasswordCredentials(String id, String description, Supplier<Secret> jsonSecret) {
        super(id, description);
        this.username = parseUsernamePassword(jsonSecret)[0];
        this.password = parseUsernamePassword(jsonSecret)[1];
    }

    public String[] parseUsernamePassword(Supplier<Secret> jsonString) {
        String[] usernamePassword = new String[2];
        ObjectMapper mapper = new ObjectMapper();

        String json = jsonString.get().getPlainText();
        try {
            Map<String, Object> map = mapper.readValue(json, Map.class);
            usernamePassword[0] = map.get("username").toString();
            usernamePassword[1] = map.get("password").toString();
            LOGGER.info("Successfully parsed Json string");
        } catch (JsonProcessingException e) {
            LOGGER.warning("Error parsing secret string, expecting Json with username and password keys");
            throw new RuntimeException(e);
        }

        return usernamePassword;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Secret getPassword() {
        return Secret.fromString(password);
    }

}
